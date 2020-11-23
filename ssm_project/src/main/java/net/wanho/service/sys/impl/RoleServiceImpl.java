package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.RoleMapper;
import net.wanho.mapper.sys.RoleMenuMapper;
import net.wanho.po.sys.Ext.RoleExt;
import net.wanho.po.sys.Role;
import net.wanho.po.sys.RoleMenu;
import net.wanho.service.sys.RoleServiceI;
import net.wanho.util.ShiroUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [RoleServiceImpl]
* @类描述:	    [角色信息表业务逻辑层实现]
* @创建人:	    [choco]
* @创建时间:		[2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:		[]
* @修改备注:		[]
* @版本:			[]
* @版权:			[]
*/
@Service
@Slf4j
public class RoleServiceImpl  implements RoleServiceI {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
	 * @方法名:	    [selectRoleById]
	 * @方法描述:		[查询角色信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public RoleExt selectRoleById(Long roleId){
		try{
			if(roleId.equals("1")){
				throw new RuntimeException("无法修改管理员");
			}else {
				RoleExt roleExt = roleMapper.selectRoleById(roleId);
				roleExt.setMenuIds((Long[]) ConvertUtils.convert(roleExt.getMenuIdStr().split(","), Long.class));
				return roleExt;
			}
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectRoleList]
	 * @方法描述:		[查询角色信息表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Role> selectRoleList(Role role){
		try{
			return roleMapper.selectRoleList(role);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertRole]
	 * @方法描述:		[新增角色信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertRole( RoleExt roleExt){
		try{
			roleExt.setCreateTime(new Date());
			roleExt.setCreateBy(ShiroUtils.getUserName());
			roleExt.setDelFlag("0");
			roleExt.setDataScope("1");
			int res = roleMapper.insertRole(roleExt);
			//保存角色和菜单的关系
			insertRoleMenu(roleExt);


			return res;
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	private void insertRoleMenu(RoleExt roleExt){

		Long[] menuIds = roleExt.getMenuIds();
		List<RoleMenu> roleMenuList = new ArrayList<>();
		for(int i=0;i<menuIds.length;i++){
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(roleExt.getRoleId());
			roleMenu.setMenuId(menuIds[i]);
			roleMenuList.add(roleMenu);
		}

		roleMenuMapper.batchInsertRoleMenu(roleMenuList);
	}

	/**
	 * @方法名:	    [updateRole]
	 * @方法描述:		[修改角色信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateRole(RoleExt roleExt){
		try{

			roleExt.setUpdateBy(ShiroUtils.getUserName());
			roleExt.setUpdateTime(new Date());
			int res = roleMapper.updateRole(roleExt);

			// 关系维护
			roleMenuMapper.deleteRoleMenuById(roleExt.getRoleId());
			insertRoleMenu(roleExt);

			return res;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteRoleByIds]
	 * @方法描述:		[删除角色信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteRoleByIds(String ids){
		try{
			return roleMapper.deleteRoleByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
