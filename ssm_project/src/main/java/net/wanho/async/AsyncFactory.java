package net.wanho.async;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AsyncFactory {

   // 单例
   private static  AsyncFactory asyncFactory = new AsyncFactory();

   private  AsyncFactory(){}

   public static AsyncFactory getInstance(){
      return asyncFactory;
   }

   //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
   ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(20);

   public void schedule(TimerTask timerTask){
      scheduledThreadPool.schedule(timerTask,0, TimeUnit.MILLISECONDS);
   }

}
