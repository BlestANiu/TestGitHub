package net.wanho.mapper.sys;
import net.wanho.po.sys.Notice;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [NoticeMapper]
 * @类描述:	    [通知公告表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:58]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface NoticeMapper {
        /**
         * @方法名:	    [selectNoticeById]
         * @方法描述:	    [查询通知公告表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public Notice selectNoticeById(Integer noticeId);

        /**
         * @方法名:	    [selectNoticeList]
         * @方法描述:	    [查询通知公告表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<Notice> selectNoticeList(Notice notice);

        /**
         * @方法名:	    [insertNotice]
         * @方法描述:	    [新增通知公告表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertNotice(Notice notice);

        /**
         * @方法名:	    [updateNotice notice]
         * @方法描述:	    [修改通知公告表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateNotice(Notice notice);

        /**
         * @方法名:	    [deleteNoticeById]
         * @方法描述:	    [删除通知公告表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteNoticeById(Integer noticeId);

        /**
         * @方法名:	    [deleteNoticeByIds]
         * @方法描述:	    [批量删除通知公告表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:58]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteNoticeByIds(String[] noticeIds);

}