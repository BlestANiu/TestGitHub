package net.wanho.mapper.sys;
import net.wanho.po.sys.Ext.MenuExt;
import net.wanho.po.sys.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [MenuMapper]
 * @类描述:	    [菜单权限表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:58]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface MenuMapper {
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
         * @方法描述:	    [新增菜单权限表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertMenu(Menu menu);

        /**
         * @方法名:	    [updateMenu menu]
         * @方法描述:	    [修改菜单权限表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateMenu(Menu menu);

        /**
         * @方法名:	    [deleteMenuById]
         * @方法描述:	    [删除菜单权限表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteMenuById(Long menuId);

        /**
         * @方法名:	    [deleteMenuByIds]
         * @方法描述:	    [批量删除菜单权限表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteMenuByIds(String[] menuIds);

        void updateAncestors(@Param("oldAncestors") String oldAncestors, @Param("newAncestors")String newAncestors, @Param("menuId")Long menuId);

        List<Menu> findSubMenus(String menuId);

        List<Menu> selectMenuListByUserId(Long userId);
}