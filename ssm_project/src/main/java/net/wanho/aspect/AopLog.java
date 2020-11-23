package net.wanho.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import net.wanho.async.AsyncFactory;
import net.wanho.async.AsyncTask;
import net.wanho.mapper.sys.OperLogMapper;
import net.wanho.po.sys.OperLog;
import net.wanho.util.ServletUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopLog {

   @Autowired
   private OperLogMapper operLogMapper;

   //@Pointcut("execution(public * net.wanho.controller..*.add*(..)) || execution(public * net.wanho.controller..*.delete*(..))")
   @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)"
           + "||@annotation(org.springframework.web.bind.annotation.PostMapping)"
           + "||@annotation(org.springframework.web.bind.annotation.PutMapping)")
   public void log() {
   }


   @Around("log()")
   public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
      OperLog operLog = new OperLog();

      // 方法名称
      operLog.setMethod(joinPoint.getSignature().getName());
      // 请求参数
      operLog.setOperParam(JSONUtil.toJsonStr(joinPoint.getArgs()));

      Object res= null;
      try {
         // 调用核心业务
         res = joinPoint.proceed();

         // 返回参数
         operLog.setJsonResult(JSONUtil.toJsonStr(res));
         // 成功状态
         operLog.setStatus(0);

         // 记录操作的成功信息
         AsyncFactory.getInstance().schedule(AsyncTask.recordOperInfor(ServletUtils.getRequest(),operLog));


      } catch (Throwable e) {
         log.error(e.getMessage());

         // 错误消息
         operLog.setErrorMsg(e.getMessage());
         // 失败状态
         operLog.setStatus(1);
         // 记录操作的失败信息
         AsyncFactory.getInstance().schedule(AsyncTask.recordOperInfor(ServletUtils.getRequest(),operLog));
            throw e;
      }
      return  res;
   }
}
