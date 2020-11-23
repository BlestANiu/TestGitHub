package net.wanho.po.sys.Ext;

import lombok.Data;
import net.wanho.po.sys.Dept;

@Data
public class DeptExt extends Dept {
   private String parentMenuName;
}
