package net.wanho.po.sys;

import lombok.*;
import net.wanho.po.BasePo;
import java.io.Serializable;
import java.util.Date;

/**
* @项目名称:	    [cms]
* @类名称:	        [RoleMenu]
* @类描述:	        [角色和菜单关联表实体类]
* @创建人:	        [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	        []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class RoleMenu  extends BasePo implements Serializable{
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
}


