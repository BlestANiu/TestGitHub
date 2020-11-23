package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.JobLogMapper;
import net.wanho.po.sys.JobLog;
import net.wanho.service.sys.JobLogServiceI;
import net.wanho.util.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @项目名称:		[cms]
* @类名称:	    [JobLogServiceImpl]
* @类描述:	    [定时任务调度日志表业务逻辑层实现]
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
public class JobLogServiceImpl  implements JobLogServiceI {

	@Autowired
	private JobLogMapper jobLogMapper;

	/**
	 * @方法名:	    [selectJobLogById]
	 * @方法描述:		[查询定时任务调度日志表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public JobLog selectJobLogById(Long jobLogId){
		try{
			return jobLogMapper.selectJobLogById(jobLogId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectJobLogList]
	 * @方法描述:		[查询定时任务调度日志表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<JobLog> selectJobLogList(JobLog jobLog){
		try{
			return jobLogMapper.selectJobLogList(jobLog);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertJobLog]
	 * @方法描述:		[新增定时任务调度日志表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertJobLog(@RequestBody  JobLog jobLog){
		try{
			return jobLogMapper.insertJobLog(jobLog);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateJobLog]
	 * @方法描述:		[修改定时任务调度日志表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateJobLog(@RequestBody JobLog jobLog){
		try{
			return jobLogMapper.updateJobLog(jobLog);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteJobLogByIds]
	 * @方法描述:		[删除定时任务调度日志表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteJobLogByIds(String ids){
		try{
			return jobLogMapper.deleteJobLogByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
