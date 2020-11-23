package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.RoleMenuMapper;
import net.wanho.po.sys.RoleMenu;
import net.wanho.service.sys.RoleMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [RoleMenuServiceImpl]
* @类描述:	    [角色和菜单关联表业务逻辑层实现]
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
public class RoleMenuServiceImpl  implements RoleMenuServiceI {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
	 * @方法名:	    [selectRoleMenuById]
	 * @方法描述:		[查询角色和菜单关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<RoleMenu> selectRoleMenuById(Long roleId){
		try{
			return roleMenuMapper.selectRoleMenuById(roleId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectRoleMenuList]
	 * @方法描述:		[查询角色和菜单关联表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<RoleMenu> selectRoleMenuList(RoleMenu roleMenu){
		try{
			return roleMenuMapper.selectRoleMenuList(roleMenu);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertRoleMenu]
	 * @方法描述:		[新增角色和菜单关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertRoleMenu(@RequestBody  RoleMenu roleMenu){
		try{
			return roleMenuMapper.insertRoleMenu(roleMenu);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateRoleMenu]
	 * @方法描述:		[修改角色和菜单关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateRoleMenu(@RequestBody RoleMenu roleMenu){
		try{
			return roleMenuMapper.updateRoleMenu(roleMenu);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteRoleMenuByIds]
	 * @方法描述:		[删除角色和菜单关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteRoleMenuByIds(String ids){
		try{
			return roleMenuMapper.deleteRoleMenuByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
