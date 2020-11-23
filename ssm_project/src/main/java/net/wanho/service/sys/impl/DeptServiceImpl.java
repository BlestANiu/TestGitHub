package net.wanho.service.sys.impl;


import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.DeptMapper;
import net.wanho.po.sys.Dept;
import net.wanho.po.sys.Ext.DeptExt;
import net.wanho.service.sys.DeptServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [DeptServiceImpl]
* @类描述:	    [部门表业务逻辑层实现]
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
public class DeptServiceImpl  implements DeptServiceI {

	@Autowired
	private DeptMapper deptMapper;

	/**
	 * @方法名:	    [selectDeptById]
	 * @方法描述:		[查询部门表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public DeptExt selectDeptById(Long deptId){
		try{
			return deptMapper.selectDeptById(deptId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectDeptList]
	 * @方法描述:		[查询部门表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Dept> selectDeptList(Dept dept){
		try{
			return deptMapper.selectDeptList(dept);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertDept]
	 * @方法描述:		[新增部门表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertDept(@RequestBody  Dept dept){
		try{
			Long parentId = dept.getParentId();
			if(parentId.intValue()==0){
				dept.setAncestors("0");
			}else{
				Dept parentDept = this.selectDeptById(parentId);
				if(ObjectUtil.isNotEmpty(parentDept))
				dept.setAncestors(parentDept.getAncestors()+","+parentDept.getDeptId());
			}
			//todo 从登录用户获取
			dept.setCreateBy("admin");
			dept.setCreateTime(new Date());
			return deptMapper.insertDept(dept);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateDept]
	 * @方法描述:		[修改部门表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateDept(@RequestBody Dept dept){
		try{
			// todo 从登录用户获取
			dept.setUpdateBy("admin");
			dept.setUpdateTime(new Date());
			//先更新部门再修改部门祖先关系
			int res = deptMapper.updateDept(dept);

			// 修改ancestors==》修改当前部门和所有的子部门的值
			String oldAncestors= dept.getAncestors();

			String newAncestors="";
			Long parentId = dept.getParentId();
			if(parentId.intValue()==0){
				newAncestors="0";
			}else{
				Dept parentDept = this.selectDeptById(parentId);
				if(ObjectUtil.isNotEmpty(parentDept))
					newAncestors=parentDept.getAncestors()+","+parentDept.getDeptId();
			}
			// oldAncestors老的关系，newAncestors新关系
			//先更新部门再修改部门祖先关系
			deptMapper.updateAncestors(oldAncestors,newAncestors,dept.getDeptId());

			return res;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteDeptByIds]
	 * @方法描述:		[删除部门表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteDeptByIds(String ids) {
		String[] idArray = ids.split(",");
		if (ObjectUtil.isNotEmpty(idArray) && idArray.length == 1) {
			// 判断是否存在下级部门，存在则给予提示，不能删除
			List<Dept> subDepts = deptMapper.findSubDept(idArray[0]);
			if (ObjectUtil.isNotEmpty(subDepts) && subDepts.size() > 0) {
				throw new RuntimeException("存在下级部门，不能删除");
			}
		}
		// 逻辑删除，把状态修改成2
		return deptMapper.deleteDeptByIds(idArray);
	}

}
