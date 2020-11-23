package net.wanho.async;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import net.wanho.mapper.sys.LogininforMapper;
import net.wanho.mapper.sys.OperLogMapper;
import net.wanho.po.sys.Logininfor;
import net.wanho.po.sys.OperLog;
import net.wanho.util.AddressUtils;
import net.wanho.util.ShiroUtils;
import net.wanho.util.SpringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.TimerTask;

public class AsyncTask {

   /**
    * 操作日志记录
    *
    * @param
    * @return 任务task
    */
   public static TimerTask  recordLogininfor(final HttpServletRequest request, final String name, final String status, final String msg){

      final UserAgent userAgent = UserAgentUtil.parse(request.getHeader("User-Agent"));

      return new TimerTask() {
         @Override
         public void run() {
            // 从spring中获取mapper对象，用到SpringUtils工具类
            LogininforMapper logininforMapper = SpringUtils.getBean(LogininforMapper.class);
            Logininfor logininfor = new Logininfor();
            logininfor.setUserName(name);
            // 用到地址工具类
            logininfor.setIpaddr(AddressUtils.getIpAddr(request));
            logininfor.setLoginLocation(AddressUtils.getRealAddressByIp(logininfor.getIpaddr()));
            logininfor.setBrowser(userAgent.getBrowser().getName());
            logininfor.setOs(userAgent.getOs().getName());
            logininfor.setStatus(status);
            logininfor.setMsg(msg);
            logininfor.setLoginTime(new Date());
            logininforMapper.insertLogininfor(logininfor);
         }
      };
   }

   /**
    * 操作日志记录
    *
    * @param operLog 操作日志信息
    * @return 任务task
    */
   public static TimerTask  recordOperInfor(final HttpServletRequest request, final OperLog operLog){

      // 从spring中获取mapper对象
      final OperLogMapper operLogMapper = SpringUtils.getBean(OperLogMapper.class);

      return new TimerTask() {
         @Override
         public void run() {
            // 获取请求路径
            String requestURL = request.getRequestURL().toString();
            // 如果是登录，则不需要记录
            if (requestURL.endsWith("/sys/user/login")) {
               return;
            }
            String method = request.getMethod();
            Integer businessType=0;
            // 模块标题
            operLog.setTitle(requestURL.split("\\/")[3]);
            // 业务类型(0其它 1新增 2修改 3删除)
            if(method.equalsIgnoreCase("POST")){
               businessType= 1;
            }else if(method.equalsIgnoreCase("DELETE")){
               businessType= 3;
            }if(method.equalsIgnoreCase("PUT")){
               businessType= 2;
            }
            operLog.setBusinessType(businessType);
            // 请求方式
            operLog.setRequestMethod(method);
            // 操作类型(0其它 1后台 2手机)
            operLog.setOperatorType(1);
            // 操作人员
            operLog.setOperName(ShiroUtils.getUserName());
            // 操作人员部门
            operLog.setDeptName(ShiroUtils.getUser().getDept().getDeptName());
            // 请求url
            operLog.setOperUrl(requestURL);
            // 主机地址
            operLog.setOperIp(AddressUtils.getIpAddr(request));
            // 操作地点
            operLog.setOperLocation(AddressUtils.getRealAddressByIp(AddressUtils.getIpAddr(request)));
            // 操作时间
            operLog.setOperTime(new Date());

            operLogMapper.insertOperLog(operLog);
         }
      };
   }
}