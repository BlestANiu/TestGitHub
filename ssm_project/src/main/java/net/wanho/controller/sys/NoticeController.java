package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Notice;
import net.wanho.service.sys.NoticeServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.PageVo;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [NoticeController]
* @类描述:	    [通知公告表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/notice")
@ResponseBody
@Slf4j
public class NoticeController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private NoticeServiceI noticeService;

    @RequiresPermissions("sys:notice:view")
    @GetMapping()
    public ModelAndView Notice(){
        ModelAndView mv = new ModelAndView("/sys/notice");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询通知公告表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(Notice notice) {
        try {
            startPage();
            List<Notice> list = noticeService.selectNoticeList(notice);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除通知公告表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            noticeService.deleteNoticeByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增通知公告表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/notice/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加通知公告表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:notice:add")
    public AjaxResult add(Notice notice){

        try {
            noticeService.insertNotice(notice);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByNoticeById]
     * @方法描述:	    [查询通知公告表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{noticeId}")
    public AjaxResult getByNoticeById(@PathVariable Integer noticeId){
        try {
            Notice notice = noticeService.selectNoticeById(noticeId);
            return success(notice);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改通知公告表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Notice:edit")
    public AjaxResult update(Notice notice){

        try {
            noticeService.updateNotice(notice);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
