package run.hxtia.workbd.controller.admin.notificationwork;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import run.hxtia.workbd.common.util.JsonVos;
import run.hxtia.workbd.pojo.vo.notificationwork.request.page.NotificationPageReqVo;
import run.hxtia.workbd.pojo.vo.notificationwork.request.NotificationReqVo;
import run.hxtia.workbd.pojo.vo.notificationwork.response.NotificationVo;
import run.hxtia.workbd.pojo.vo.common.response.result.DataJsonVo;
import run.hxtia.workbd.pojo.vo.common.response.result.PageVo;
import run.hxtia.workbd.service.notificationwork.NotificationService;

/**
 * @author Xiaojin
 * @date 2024/5/9
 */

@RestController
@RequestMapping("/admin/notificationWork/notification")
@RequiredArgsConstructor
@Api(tags = "NotificationController")
@Tag(name = "NotificationController", description = "【B端】后台通知管理模块")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/list")
    @ApiOperation(value = "分页查询通知")
    public PageVo list(@RequestBody NotificationPageReqVo pageReqVo) {
        return notificationService.list(pageReqVo, pageReqVo.getType());
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "保存或更新通知")
    public boolean saveOrUpdate(@RequestBody NotificationReqVo reqVo) {
        try {
            return notificationService.saveOrUpdate(reqVo);
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/removeByIds")
    @ApiOperation(value = "删除一条或多条通知【逻辑删除】")
    public boolean removeByIds(@RequestParam String ids) {
        return notificationService.removeByIds(ids);
    }

    @GetMapping("/getByNotificationId")
    @ApiOperation(value = "根据通知ID获取通知信息")
    public DataJsonVo<NotificationVo> getByNotificationId(@RequestParam Long notificationId) {
        return JsonVos.ok(notificationService.getByNotificationId(notificationId));
    }

    @PostMapping("/removeHistory")
    @ApiOperation(value = "删除一条或多条通知【彻底删除】")
    public boolean removeHistory(@RequestParam String ids) {
        return notificationService.removeHistory(ids);
    }
}