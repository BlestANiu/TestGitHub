package net.wanho.mapper.sys;
import net.wanho.po.sys.Logininfor;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [LogininforMapper]
 * @类描述:	    [系统访问记录数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:58]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface LogininforMapper {
        /**
         * @方法名:	    [selectLogininforById]
         * @方法描述:	    [查询系统访问记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public Logininfor selectLogininforById(Long infoId);

        /**
         * @方法名:	    [selectLogininforList]
         * @方法描述:	    [查询系统访问记录列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<Logininfor> selectLogininforList(Logininfor logininfor);

        /**
         * @方法名:	    [insertLogininfor]
         * @方法描述:	    [新增系统访问记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertLogininfor(Logininfor logininfor);

        /**
         * @方法名:	    [updateLogininfor logininfor]
         * @方法描述:	    [修改系统访问记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateLogininfor(Logininfor logininfor);

        /**
         * @方法名:	    [deleteLogininforById]
         * @方法描述:	    [删除系统访问记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteLogininforById(Long infoId);

        /**
         * @方法名:	    [deleteLogininforByIds]
         * @方法描述:	    [批量删除系统访问记录]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteLogininforByIds(String[] infoIds);

}