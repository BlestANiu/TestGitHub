package net.wanho.mapper.sys;
import net.wanho.po.sys.OperLog;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [OperLogMapper]
 * @类描述:	    [操作日志记录数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:59]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface OperLogMapper {
        /**
         * @方法名:	    [selectOperLogById]
         * @方法描述:	    [查询操作日志记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public OperLog selectOperLogById(Long operId);

        /**
         * @方法名:	    [selectOperLogList]
         * @方法描述:	    [查询操作日志记录列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<OperLog> selectOperLogList(OperLog operLog);

        /**
         * @方法名:	    [insertOperLog]
         * @方法描述:	    [新增操作日志记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertOperLog(OperLog operLog);

        /**
         * @方法名:	    [updateOperLog operLog]
         * @方法描述:	    [修改操作日志记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateOperLog(OperLog operLog);

        /**
         * @方法名:	    [deleteOperLogById]
         * @方法描述:	    [删除操作日志记录信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteOperLogById(Long operId);

        /**
         * @方法名:	    [deleteOperLogByIds]
         * @方法描述:	    [批量删除操作日志记录]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteOperLogByIds(String[] operIds);

}