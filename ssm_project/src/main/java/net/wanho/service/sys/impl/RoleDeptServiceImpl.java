package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.RoleDeptMapper;
import net.wanho.po.sys.RoleDept;
import net.wanho.service.sys.RoleDeptServiceI;
import net.wanho.util.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @项目名称:		[cms]
* @类名称:	    [RoleDeptServiceImpl]
* @类描述:	    [角色和部门关联表业务逻辑层实现]
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
public class RoleDeptServiceImpl  implements RoleDeptServiceI {

	@Autowired
	private RoleDeptMapper roleDeptMapper;

	/**
	 * @方法名:	    [selectRoleDeptById]
	 * @方法描述:		[查询角色和部门关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public RoleDept selectRoleDeptById(Long roleId){
		try{
			return roleDeptMapper.selectRoleDeptById(roleId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectRoleDeptList]
	 * @方法描述:		[查询角色和部门关联表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<RoleDept> selectRoleDeptList(RoleDept roleDept){
		try{
			return roleDeptMapper.selectRoleDeptList(roleDept);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertRoleDept]
	 * @方法描述:		[新增角色和部门关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertRoleDept(@RequestBody  RoleDept roleDept){
		try{
			return roleDeptMapper.insertRoleDept(roleDept);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateRoleDept]
	 * @方法描述:		[修改角色和部门关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateRoleDept(@RequestBody RoleDept roleDept){
		try{
			return roleDeptMapper.updateRoleDept(roleDept);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteRoleDeptByIds]
	 * @方法描述:		[删除角色和部门关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteRoleDeptByIds(String ids){
		try{
			return roleDeptMapper.deleteRoleDeptByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
