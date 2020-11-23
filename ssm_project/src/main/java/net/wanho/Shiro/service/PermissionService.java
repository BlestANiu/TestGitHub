package net.wanho.Shiro.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

@Service("permission")
public class PermissionService {

   public boolean hasPermi(String permission){
      return SecurityUtils.getSubject().isPermitted(permission);
   }
}
