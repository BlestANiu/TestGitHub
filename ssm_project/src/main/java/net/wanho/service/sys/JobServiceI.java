package net.wanho.service.sys;

import net.wanho.po.sys.Job;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [JobServiceI]
* @类描述:	    [定时任务调度表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface JobServiceI {

    /**
     * @方法名:	    [selectJobById]
     * @方法描述:	    [查询定时任务调度表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public Job selectJobById(Long jobId);

    /**
     * @方法名:	    [selectJobList]
     * @方法描述:	    [查询定时任务调度表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<Job> selectJobList(Job job);

    /**
     * @方法名:	    [insertJob]
     * @方法描述:	    [新增定时任务调度表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertJob(Job job);

    /**
     * @方法名:	    [updateJob]
     * @方法描述:	    [修改定时任务调度表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateJob(Job job);

    /**
     * @方法名:	    [deleteJobByIds]
     * @方法描述:	    [删除定时任务调度表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deleteJobByIds(String ids);



}
