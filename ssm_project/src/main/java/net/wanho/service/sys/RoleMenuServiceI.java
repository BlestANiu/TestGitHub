package net.wanho.service.sys;

import net.wanho.po.sys.RoleMenu;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [RoleMenuServiceI]
* @类描述:	    [角色和菜单关联表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface RoleMenuServiceI {

    /**
     * @方法名:	    [selectRoleMenuById]
     * @方法描述:	    [查询角色和菜单关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<RoleMenu> selectRoleMenuById(Long roleId);

    /**
     * @方法名:	    [selectRoleMenuList]
     * @方法描述:	    [查询角色和菜单关联表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<RoleMenu> selectRoleMenuList(RoleMenu roleMenu);

    /**
     * @方法名:	    [insertRoleMenu]
     * @方法描述:	    [新增角色和菜单关联表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertRoleMenu(RoleMenu roleMenu);

    /**
     * @方法名:	    [updateRoleMenu]
     * @方法描述:	    [修改角色和菜单关联表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateRoleMenu(RoleMenu roleMenu);

    /**
     * @方法名:	    [deleteRoleMenuByIds]
     * @方法描述:	    [删除角色和菜单关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deleteRoleMenuByIds(String ids);



}
