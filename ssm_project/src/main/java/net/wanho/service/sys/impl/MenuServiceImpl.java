package net.wanho.service.sys.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.MenuMapper;
import net.wanho.mapper.sys.RoleMenuMapper;
import net.wanho.po.sys.Ext.MenuExt;
import net.wanho.po.sys.Menu;
import net.wanho.po.sys.RoleMenu;
import net.wanho.service.sys.MenuServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [MenuServiceImpl]
* @类描述:	    [菜单权限表业务逻辑层实现]
* @创建人:	    [choco]
* @创建时间:		[2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:		[]
* @修改备注:		[]
* @版本:			[]
* @版权:			[]
*/
@Service
@Slf4j
public class MenuServiceImpl  implements MenuServiceI {

	@Autowired
	private MenuMapper menuMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
	 * @方法名:	    [selectMenuById]
	 * @方法描述:		[查询菜单权限表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public MenuExt selectMenuById(Long menuId){
		try{
			return menuMapper.selectMenuById(menuId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectMenuList]
	 * @方法描述:		[查询菜单权限表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Menu> selectMenuList(Menu menu){
		try{
			return menuMapper.selectMenuList(menu);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertMenu]
	 * @方法描述:		[新增菜单权限表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertMenu(@RequestBody  Menu menu){
		try{
			//todo 从登录用户获取
			menu.setCreateBy("admin");
			menu.setCreateTime(new Date());
			return menuMapper.insertMenu(menu);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateMenu]
	 * @方法描述:		[修改菜单权限表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateMenu(@RequestBody Menu menu){
		try{
			//todo 从登录用户获取
			menu.setUpdateBy("admin");
			menu.setUpdateTime(new Date());
			int res = menuMapper.updateMenu(menu);

			//修改ancestors==》修改当前菜单和所有的子菜单的值
			String oldAncestors = menu.getAncestors();

			String newAncestors ="";
			Long parentId = menu.getParentId();
			if(parentId.intValue()==0){
				newAncestors="0";
			}else{
				Menu parentMenu = this.selectMenuById(parentId);
				if(ObjectUtil.isNotEmpty(parentMenu))
					newAncestors = parentMenu.getAncestors()+","+parentMenu.getMenuId();
			}
			// oldAncestors老的关系，newAncestors新关系
			menuMapper.updateAncestors(oldAncestors,newAncestors,menu.getMenuId());

			return res;

		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteMenuByIds]
	 * @方法描述:		[删除菜单权限表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteMenuByIds(String ids){
		try {

			String[] idArray = ids.split(",");
			if (ObjectUtil.isNotEmpty(idArray) && idArray.length == 1) {
				// 判断是否存在下级部门，存在则给予提示，不能删除
				List<Menu> subMenus = menuMapper.findSubMenus(idArray[0]);
				if (ObjectUtil.isNotEmpty(subMenus) && subMenus.size() > 0) {
					throw new RuntimeException("存在下级部门，不能删除");
				}
			}
			// 逻辑删除，把状态修改成2
			return menuMapper.deleteMenuByIds(idArray);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
			//String[] idArray = ids.split(",");
			//if (ArrayUtil.length(idArray) == 1) {
			//	// 判断是否存在下级部门，存在则给予提示，不能删除
			//	Menu menu = new Menu();
			//	menu.setParentId(Long.valueOf(idArray[0]));
			//	List<Menu> subMenus = menuMapper.selectMenuList(menu);
			//	if (ObjectUtil.isNotEmpty(subMenus)) {
			//		throw new RuntimeException("存在下级菜单，不能删除");
			//	}
			//}
			//return menuMapper.deleteMenuByIds(idArray);
	}

	@Override
	public List<Menu> selectMenuListByUserId(Long userId) {
		return menuMapper.selectMenuListByUserId(userId);
	}

	/**
	 * @方法名:	    [selectPermsByUserId]
	 * @方法描述:		[根据用户id查询所有权限字符串]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<String> selectPermsByUserId(Long userId) {
		List<String> lst = new ArrayList<>();
		List<Menu> menus = menuMapper.selectMenuListByUserId(userId);
		for(Menu item:menus){
			if(ObjectUtil.isNotEmpty(item) && StrUtil.isNotEmpty(item.getPerms())){
				lst.add(item.getPerms());
			}
		}
		return  lst;
	}

   @Override
   public List<MenuExt> selectMenuExtList(Long roleId) {
	   // 查所有菜单
	   List<Menu> menus = this.selectMenuList(new Menu());

	   // 把当前角色的菜单的checked设置为true
	   List<MenuExt> menuExts = new ArrayList<>(menus.size());
	   for(Menu item:menus){
		   MenuExt menuExt = new MenuExt();
		   BeanUtils.copyProperties(item,menuExt);
		   // 嵌套循环找到当前角色的菜单也是一个集合，当前菜单id一样的时候，设置成true即可
		   List<RoleMenu> roleMenus = roleMenuMapper.selectRoleMenuById(roleId);
		   for(RoleMenu roleMenu:roleMenus){
			   if(roleMenu.getMenuId().intValue()==item.getMenuId().intValue()){
				   menuExt.setChecked(true);
			   }
		   }
		   menuExts.add(menuExt);
	   }
	   return menuExts;
   }

}
