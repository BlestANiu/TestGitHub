package net.wanho.po.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import net.wanho.po.BasePo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
* @项目名称:	    [cms]
* @类名称:	        [Logininfor]
* @类描述:	        [系统访问记录实体类]
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
public class Logininfor  extends BasePo implements Serializable{
    /**
     * 访问ID
     */
    private Long infoId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 登录IP地址
     */
    private String ipaddr;
    /**
     * 登录地点
     */
    private String loginLocation;
    /**
     * 浏览器类型
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 登录状态（0成功 1失败）
     */
    private String status;
    /**
     * 提示消息
     */
    private String msg;
    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;
}


