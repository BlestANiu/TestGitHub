package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Config;
import net.wanho.service.sys.ConfigServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [ConfigController]
* @类描述:	    [参数配置表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/config")
@ResponseBody
@Slf4j
public class ConfigController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private ConfigServiceI configService;

    @RequiresPermissions("sys:config:view")
    @GetMapping()
    public ModelAndView Config(){
        ModelAndView mv = new ModelAndView("/sys/config");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询参数配置表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(Config config) {
        try {
            startPage();
            List<Config> list = configService.selectConfigList(config);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除参数配置表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            configService.deleteConfigByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增参数配置表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/config/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加参数配置表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:config:add")
    public AjaxResult add(Config config){

        try {
            configService.insertConfig(config);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByConfigById]
     * @方法描述:	    [查询参数配置表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{configId}")
    public AjaxResult getByConfigById(@PathVariable Integer configId){
        try {
            Config config = configService.selectConfigById(configId);
            return success(config);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改参数配置表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Config:edit")
    public AjaxResult update(Config config){

        try {
            configService.updateConfig(config);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
