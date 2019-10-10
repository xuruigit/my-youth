package com.xurui.youth.exception;

import com.xurui.youth.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 服务层异常处理器
 * <p>
 *
 * @author XuRui
 * @date 2018/5/28
 */
@Component
@Aspect
@Slf4j
public class ServiceExceptionHandle {

    /**
     * 返回值类型为Response的Service
     */
    @Pointcut(value = "execution(public com.xurui.youth.model.Response com.xurui.youth..*Service*.*(..))")
    private void servicePointcut() {
    }

    /**
     * 任何持有@Transactional注解的方法
     */
    @Pointcut(value = "@annotation(org.springframework.transaction.annotation.Transactional)")
    private void transactionalPointcut() {
    }

    /**
     * 异常处理切面
     * 将异常包装为Response，避免dubbo进行包装
     *
     * @param pjp 处理点
     * @return Object
     */
    @Around("servicePointcut() && !transactionalPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        try {
            return pjp.proceed();
        } catch (ServiceException e) { // 业务自定义异常
            processException(pjp, args, e);
            return Response.fail(e.getMessage());
        } catch (Exception e) {
            processException(pjp, args, e);
            return Response.fail("服务调用失败");
        } catch (Throwable throwable) {
            processException(pjp, args, throwable);
            return Response.fail("系统异常");
        }
    }

    /**
     * 任何持有@Transactional注解的方法异常处理切面
     * 将自定义的业务异常转为RuntimeException:
     * 1.规避dubbo的包装，让customer可以正常获取message
     * 2.抛出RuntimeException使事务可以正确回滚
     * 其他异常不处理
     *
     * @param pjp 处理点
     * @return Object
     */
    @Around("servicePointcut() && transactionalPointcut()")
    public Object doTransactionalAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (ServiceException e) {
            // dubbo会将异常捕获进行打印，这里就不打印了
            // processException(pjp, args, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 处理异常
     *
     * @param joinPoint 切点
     * @param args      参数
     * @param throwable 异常
     */
    private void processException(final ProceedingJoinPoint joinPoint, final Object[] args, Throwable throwable) {
        String inputParam = "";
        if (args != null && args.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
                sb.append(",");
                sb.append(arg);
            }
            inputParam = sb.toString().substring(1);
        }
        log.warn(String.format("\n 方法: %s \n 入参: %s \n", joinPoint.toLongString(), inputParam), throwable);
    }
}