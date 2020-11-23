package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.UserRoleMapper;
import net.wanho.po.sys.UserRole;
import net.wanho.service.sys.UserRoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [UserRoleServiceImpl]
* @类描述:	    [用户和角色关联表业务逻辑层实现]
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
public class UserRoleServiceImpl  implements UserRoleServiceI {

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * @方法名:	    [selectUserRoleById]
	 * @方法描述:		[查询用户和角色关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public UserRole selectUserRoleById(Long userId){
		try{
			return userRoleMapper.selectUserRoleById(userId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectUserRoleList]
	 * @方法描述:		[查询用户和角色关联表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<UserRole> selectUserRoleList(UserRole userRole){
		try{
			return userRoleMapper.selectUserRoleList(userRole);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertUserRole]
	 * @方法描述:		[新增用户和角色关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertUserRole(@RequestBody  UserRole userRole){
		try{
			return userRoleMapper.insertUserRole(userRole);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateUserRole]
	 * @方法描述:		[修改用户和角色关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateUserRole(@RequestBody UserRole userRole){
		try{
			return userRoleMapper.updateUserRole(userRole);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteUserRoleByIds]
	 * @方法描述:		[删除用户和角色关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteUserRoleByIds(String ids){
		try{
			return userRoleMapper.deleteUserRoleByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
