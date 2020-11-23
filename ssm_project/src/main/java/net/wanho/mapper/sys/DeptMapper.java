package net.wanho.mapper.sys;
import net.wanho.po.sys.Dept;
import net.wanho.po.sys.Ext.DeptExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [DeptMapper]
 * @类描述:	    [部门表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:58]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface DeptMapper {
        /**
         * @方法名:	    [selectDeptById]
         * @方法描述:	    [查询部门表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public DeptExt selectDeptById(Long deptId);

        /**
         * @方法名:	    [selectDeptList]
         * @方法描述:	    [查询部门表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<Dept> selectDeptList(Dept dept);

        /**
         * @方法名:	    [insertDept]
         * @方法描述:	    [新增部门表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertDept(Dept dept);

        /**
         * @方法名:	    [updateDept dept]
         * @方法描述:	    [修改部门表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateDept(Dept dept);

        /**
         * @方法名:	    [deleteDeptById]
         * @方法描述:	    [删除部门表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteDeptById(Long deptId);

        /**
         * @方法名:	    [deleteDeptByIds]
         * @方法描述:	    [批量删除部门表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteDeptByIds(String[] deptIds);

        void updateAncestors(@Param("oldAncestors") String oldAncestors, @Param("newAncestors")String newAncestors, @Param("deptId")Long deptId);

        List<Dept> findSubDept(String deptId);
}