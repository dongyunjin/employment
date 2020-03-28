package com.cn.employment.framework.aop;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cn.employment.framework.util.HttpContextUtil;
import com.cn.employment.framework.log.LogManager;
import com.cn.employment.framework.annotion.BussinessLog;
import com.cn.employment.framework.log.factory.LogTaskFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * 日志记录
 *
 * @ClassName: LogAop
 */
@Aspect
@Component
public class LogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String LOG_CONTENT = "[类名]:%s <br/>[方法]:%s <br>[参数]:%s <br/>";

    @Pointcut(value = "@annotation(com.cn.employment.framework.annotion.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        // 先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {

        // 获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        // 如果当前用户未登录，不做日志
//        ShiroUser user = ShiroKit.getUser();
//        if (null == user) {
//            return;
//        }

        // 获取拦截方法的参数
        String className = point.getTarget().getClass().getName();

        // 获取操作名称
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();

        HttpServletRequest request = HttpContextUtil.getRequest();

        HttpSession session = request.getSession();

        Integer userId = (Integer) session.getAttribute("userId");

        String content = buildeContent(point, methodName, request);

        LogManager.me()
                .executeLog(LogTaskFactory.bussinessLog(userId, bussinessName, className, methodName, content));
    }

    /**
     * 日志内容
     *
     * @param joinPoint
     * @param methodName
     * @param request
     * @return
     */
    public String buildeContent(ProceedingJoinPoint joinPoint, String methodName, HttpServletRequest request) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        StringBuffer bf = new StringBuffer();
        if (params != null && params.length > 0) {
            Enumeration<String> paraNames = request.getParameterNames();
            while (paraNames.hasMoreElements()) {
                String key = paraNames.nextElement();
                bf.append(key).append("=");
                bf.append(request.getParameter(key)).append("&");
            }
            if (StringUtils.isBlank(bf.toString())) {
                bf.append(request.getQueryString());
            }
        }
        log.info("REQUEST PARAMS :" + bf.toString());
        return String.format(LOG_CONTENT, className, methodName, bf.toString());
    }
}