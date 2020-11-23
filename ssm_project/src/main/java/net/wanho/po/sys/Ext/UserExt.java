package net.wanho.po.sys.Ext;

import lombok.Data;
import net.wanho.po.sys.Dept;
import net.wanho.po.sys.User;
import net.wanho.po.sys.UserPost;
import net.wanho.po.sys.UserRole;

import java.util.List;

@Data
public class UserExt extends User {
   private Dept dept;

   private String startTime;
   private String endTime;

   private Long []postIds;
   private Long []roleIds;

   private List<UserPost> userPostList;
   private List<UserRole> userRoleList;

}
