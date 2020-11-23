package net.wanho.service.sys;

import net.wanho.po.sys.RoleDept;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [RoleDeptServiceI]
* @类描述:	    [角色和部门关联表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface RoleDeptServiceI {

    /**
     * @方法名:	    [selectRoleDeptById]
     * @方法描述:	    [查询角色和部门关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public RoleDept selectRoleDeptById(Long roleId);

    /**
     * @方法名:	    [selectRoleDeptList]
     * @方法描述:	    [查询角色和部门关联表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<RoleDept> selectRoleDeptList(RoleDept roleDept);

    /**
     * @方法名:	    [insertRoleDept]
     * @方法描述:	    [新增角色和部门关联表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertRoleDept(RoleDept roleDept);

    /**
     * @方法名:	    [updateRoleDept]
     * @方法描述:	    [修改角色和部门关联表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateRoleDept(RoleDept roleDept);

    /**
     * @方法名:	    [deleteRoleDeptByIds]
     * @方法描述:	    [删除角色和部门关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deleteRoleDeptByIds(String ids);



}
