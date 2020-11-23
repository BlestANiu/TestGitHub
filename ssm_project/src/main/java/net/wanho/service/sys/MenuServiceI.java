package net.wanho.service.sys;

import net.wanho.po.sys.Ext.MenuExt;
import net.wanho.po.sys.Menu;

import java.util.Collection;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [MenuServiceI]
* @类描述:	    [菜单权限表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface MenuServiceI {

    /**
     * @方法名:	    [selectMenuById]
     * @方法描述:	    [查询菜单权限表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public MenuExt selectMenuById(Long menuId);

    /**
     * @方法名:	    [selectMenuList]
     * @方法描述:	    [查询菜单权限表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<Menu> selectMenuList(Menu menu);

    /**
     * @方法名:	    [insertMenu]
     * @方法描述:	    [新增菜单权限表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertMenu(Menu menu);

    /**
     * @方法名:	    [updateMenu]
     * @方法描述:	    [修改菜单权限表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateMenu(Menu menu);

    /**
     * @方法名:	    [deleteMenuByIds]
     * @方法描述:	    [删除菜单权限表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deleteMenuByIds(String ids);


   List<Menu> selectMenuListByUserId(Long userId);

    Collection<String> selectPermsByUserId(Long userId);

   List<MenuExt> selectMenuExtList(Long roleId);
}
