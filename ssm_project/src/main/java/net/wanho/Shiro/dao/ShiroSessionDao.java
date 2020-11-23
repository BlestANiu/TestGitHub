package net.wanho.Shiro.dao;

import net.wanho.Shiro.constants.ShiroConstants;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ShiroSessionDao extends EnterpriseCacheSessionDAO {

   @Autowired
   private RedisTemplate<Serializable,Session> redisTemplate;

   @Override
   protected Serializable doCreate(Session session) {
      Serializable sessionId = ShiroConstants.SHIRO_SESSION_PREFIX+ UUID.randomUUID().toString();
      System.out.println("doCreate.....");
      // 关联sessionId和session
      this.assignSessionId(session,sessionId);
      redisTemplate.opsForValue().set(sessionId,session, ShiroConstants.SESSION_TIMEOUT, TimeUnit.SECONDS);
      return sessionId;
   }

   @Override
   public Session doReadSession(Serializable sessionId) {
      System.out.println("doReadSession.....");
      // 重置过期时间
      redisTemplate.expire(sessionId, ShiroConstants.SESSION_TIMEOUT, TimeUnit.SECONDS);
      return  redisTemplate.opsForValue().get(sessionId);
   }

   @Override
   protected void doUpdate(Session session) {
       /* ShiroSession shiroSession = (ShiroSession) session;
        if(!shiroSession.isAttributeChanged()){
            return;
        }*/
      System.out.println("doUpdate.....");
      //属性重置false
      //shiroSession.setAttributeChanged(false);
      redisTemplate.opsForValue().set(session.getId(),session, ShiroConstants.SESSION_TIMEOUT, TimeUnit.SECONDS);
   }

   @Override
   public void doDelete(Session session) {
      System.out.println("doDelete.....");
      this.uncache(session);
      redisTemplate.delete(session.getId());
   }
}
