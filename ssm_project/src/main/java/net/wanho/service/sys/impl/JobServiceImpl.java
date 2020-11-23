package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.JobMapper;
import net.wanho.po.sys.Job;
import net.wanho.service.sys.JobServiceI;
import net.wanho.util.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @项目名称:		[cms]
* @类名称:	    [JobServiceImpl]
* @类描述:	    [定时任务调度表业务逻辑层实现]
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
public class JobServiceImpl  implements JobServiceI {

	@Autowired
	private JobMapper jobMapper;

	/**
	 * @方法名:	    [selectJobById]
	 * @方法描述:		[查询定时任务调度表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public Job selectJobById(Long jobId){
		try{
			return jobMapper.selectJobById(jobId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectJobList]
	 * @方法描述:		[查询定时任务调度表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Job> selectJobList(Job job){
		try{
			return jobMapper.selectJobList(job);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertJob]
	 * @方法描述:		[新增定时任务调度表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertJob(@RequestBody  Job job){
		try{
			return jobMapper.insertJob(job);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateJob]
	 * @方法描述:		[修改定时任务调度表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateJob(@RequestBody Job job){
		try{
			return jobMapper.updateJob(job);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteJobByIds]
	 * @方法描述:		[删除定时任务调度表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteJobByIds(String ids){
		try{
			return jobMapper.deleteJobByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
