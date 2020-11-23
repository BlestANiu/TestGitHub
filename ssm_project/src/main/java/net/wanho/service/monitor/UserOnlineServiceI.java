package net.wanho.service.monitor;

import net.wanho.vo.PageVo;
import net.wanho.vo.TableDataInfo;

public interface UserOnlineServiceI {

   TableDataInfo list(PageVo pageVo);

   public void forceLogout(String sessionId);
}
