package net.wanho.Shiro.cache;

import net.wanho.Shiro.constants.ShiroConstants;
import net.wanho.po.sys.User;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisCache<K, V>  implements Cache<K, V> {
   private RedisTemplate<K,V> redisTemplate;

   public RedisCache(RedisTemplate redisTemplate) {
      this.redisTemplate = redisTemplate;
   }


   //设置cache的名称
   private String createCacheKey(K k){
      if(k instanceof PrincipalCollection) {
         PrincipalCollection principalCollection = (PrincipalCollection) k;
         User user = (User) principalCollection.getPrimaryPrincipal();
         return ShiroConstants.SHIRO_CACHE_PREFIX+user.getUserId() ;
      }
      return "";
   }

   @Override
   public V get(K k) throws CacheException {
      return redisTemplate.opsForValue().get(createCacheKey(k));
   }

   @Override
   public V put(K k, V v) throws CacheException {
      redisTemplate.opsForValue().set((K)createCacheKey(k),v, ShiroConstants.CACHE_TIMEOUT, TimeUnit.SECONDS);
      return  v;
   }

   @Override
   public V remove(K k) throws CacheException {
      redisTemplate.delete((K)createCacheKey(k));
      return this.get(k);
   }

   @Override
   public void clear() throws CacheException {
      Collection<K> keys = redisTemplate.keys((K) ShiroConstants.SHIRO_CACHE_PREFIX_KYES);
      redisTemplate.delete(keys);
   }

   @Override
   public int size() {
      return  keys().size();
   }

   @Override
   public Set<K> keys() {
      return redisTemplate.keys((K) ShiroConstants.SHIRO_CACHE_PREFIX_KYES);
   }

   @Override
   public Collection<V> values() {
      return redisTemplate.opsForValue().multiGet(this. keys());
   }
}

