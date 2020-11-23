package net.wanho.po.sys;

import lombok.*;
import net.wanho.po.BasePo;
import java.io.Serializable;
import java.util.Date;

/**
* @项目名称:	    [cms]
* @类名称:	        [Job]
* @类描述:	        [定时任务调度表实体类]
* @创建人:	        [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	        []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class Job  extends BasePo implements Serializable{
    /**
     * 任务ID
     */
    private Long jobId;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务组名
     */
    private String jobGroup;
    /**
     * 调用目标字符串
     */
    private String invokeTarget;
    /**
     * cron执行表达式
     */
    private String cronExpression;
    /**
     * 计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     */
    private String misfirePolicy;
    /**
     * 是否并发执行（0允许 1禁止）
     */
    private String concurrent;
    /**
     * 状态（0正常 1暂停）
     */
    private String status;
}


