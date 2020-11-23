package net.wanho.Shiro.session;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.shiro.session.mgt.SimpleSession;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * session信息扩展
 */
@Data
public class ShiroSession extends SimpleSession implements Serializable {

   /** 浏览器类型（请求时） */
   private String browser;
   /** 操作系统 （请求时） */
   private String os;
   /** 登录IP地址（请求时） */
   private String ipaddr;
   /** 登录地址（请求时） */
   private String loginLocation;

   /** 用户ID (数据库) */
   private Long userId;
   /** 用户名称  (数据库) */
   private String loginName;
   /** 部门名称  (数据库) */
   private String deptName;

   /** 用户会话id (父类中) */
   private String sessionId;
   /** session创建时间(父类中) */
   @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
   private Date startTime;
   /** session最后访问时间(父类中) */
   @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
   private Date lastTime;
   /** 超时时间，单位为分钟(父类中) */
   private Long outTime;
   public String getSessionId() {
      return super.getId().toString();
   }

   public Date getStartTime() {
      return super.getStartTimestamp();
   }

   public Date getLastTime() {
      return super.getLastAccessTime();
   }

   public Long getOutTime() {
      return super.getTimeout();
   }


   /**
    * 属性是否改变 优化session数据同步
    */
   private transient boolean attributeChanged = false;


   public ShiroSession() {
      setAttributeChanged(true);
   }

   public ShiroSession(String host) {
      super(host);
      setAttributeChanged(true);
   }

   @Override
   public void setId(Serializable id) {
      setAttributeChanged(true);
      super.setId(id);
   }

   @Override
   public void setStartTimestamp(Date startTimestamp) {
      setAttributeChanged(true);
      super.setStartTimestamp(startTimestamp);
   }

   @Override
   public void setStopTimestamp(Date stopTimestamp) {
      setAttributeChanged(true);
      super.setStopTimestamp(stopTimestamp);
   }

   @Override
   public void setLastAccessTime(Date lastAccessTime) {
      // 设置过期时间小于5分钟，则更新属性
      if(getTimeout()<30000){
         setAttributeChanged(true);
      }else{
         setAttributeChanged(false);
      }
      super.setLastAccessTime(lastAccessTime);
   }

   @Override
   public void setExpired(boolean expired) {
      setAttributeChanged(true);
      super.setExpired(expired);
   }

   @Override
   public void setTimeout(long timeout) {
      setAttributeChanged(true);
      super.setTimeout(timeout);
   }

   @Override
   public void setHost(String host) {
      setAttributeChanged(true);
      super.setHost(host);
   }

   @Override
   public void setAttributes(Map<Object, Object> attributes) {
      setAttributeChanged(true);
      super.setAttributes(attributes);
   }

   @Override
   public void setAttribute(Object key, Object value) {
      setAttributeChanged(true);
      super.setAttribute(key, value);
   }

}
