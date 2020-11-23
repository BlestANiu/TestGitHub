package net.wanho.po.sys.Ext;

import lombok.Data;
import net.wanho.po.sys.Menu;

@Data
public class MenuExt extends Menu {
   private String parentMenuName;
   private boolean checked;
}
