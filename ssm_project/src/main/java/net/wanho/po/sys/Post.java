package net.wanho.po.sys;

import lombok.*;
import net.wanho.po.BasePo;

import java.io.Serializable;

/**
* @项目名称:	    [cms]
* @类名称:	        [Post]
* @类描述:	        [岗位信息表实体类]
* @创建人:	        [choco]
* @创建时间:	    [2020-09-30 10:36:08]
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
public class Post  extends BasePo implements Serializable{
    /**
     * 岗位ID
     */
    private Long postId;
    /**
     * 岗位编码
     */
    private String postCode;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 显示顺序
     */
    private Integer postSort;
    /**
     * 状态（0正常 1停用）
     */
    private String status;
}


