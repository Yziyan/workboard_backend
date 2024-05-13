package run.hxtia.workbd.controller.miniapp.notificationwork;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import run.hxtia.workbd.common.util.JsonVos;
import run.hxtia.workbd.pojo.vo.common.response.result.PageJsonVo;
import run.hxtia.workbd.pojo.vo.common.response.result.PageVo;
import run.hxtia.workbd.pojo.vo.notificationwork.request.page.StudentNotificationPageReqVo;
import run.hxtia.workbd.pojo.vo.notificationwork.response.NotificationVo;
import run.hxtia.workbd.service.notificationwork.HomeworkService;
import run.hxtia.workbd.service.notificationwork.NotificationService;
import run.hxtia.workbd.service.notificationwork.StudentNotificationService;

/**
 * @author Xiaojin
 * @date 2024/5/9
 */


@RestController
@RequestMapping("/wx/notificationWork/notifyAndWork")
@RequiredArgsConstructor
@Api(tags = "NotificationWorksController")
@Tag(name = "NotificationWorksController", description = "小程序作业通知模块")
public class NotificationWorksController {

        // 作业
        private final HomeworkService workService;
        // 通知
        private final StudentNotificationService studentNotificationService;

        // 查看通知列表  TODO 留你一手
        @PostMapping("/notifications")
        @ApiOperation("获取学生通知列表")
        public PageJsonVo<NotificationVo> getStudentNotifications(@RequestBody StudentNotificationPageReqVo reqVo) {

                PageVo<NotificationVo> notifications =  studentNotificationService.getNotificationListByStuId(reqVo);
                return JsonVos.ok(notifications);
        }

        //查看作业列表

}
