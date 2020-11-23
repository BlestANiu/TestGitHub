package net.wanho.service.sys;

import net.wanho.po.sys.JobLog;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [JobLogServiceI]
* @类描述:	    [定时任务调度日志表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface JobLogServiceI {

    /**
     * @方法名:	    [selectJobLogById]
     * @方法描述:	    [查询定时任务调度日志表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public JobLog selectJobLogById(Long jobLogId);

    /**
     * @方法名:	    [selectJobLogList]
     * @方法描述:	    [查询定时任务调度日志表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<JobLog> selectJobLogList(JobLog jobLog);

    /**
     * @方法名:	    [insertJobLog]
     * @方法描述:	    [新增定时任务调度日志表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertJobLog(JobLog jobLog);

    /**
     * @方法名:	    [updateJobLog]
     * @方法描述:	    [修改定时任务调度日志表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateJobLog(JobLog jobLog);

    /**
     * @方法名:	    [deleteJobLogByIds]
     * @方法描述:	    [删除定时任务调度日志表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deleteJobLogByIds(String ids);



}
