package run.hxtia.workbd.common.mapstruct;

import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import run.hxtia.workbd.pojo.dto.ResourceDto;
import run.hxtia.workbd.pojo.po.*;
import run.hxtia.workbd.pojo.vo.request.organization.*;
import run.hxtia.workbd.pojo.vo.request.WxSubscribeMessageReqVo;
import run.hxtia.workbd.pojo.vo.request.save.*;
import run.hxtia.workbd.pojo.vo.response.AdminLoginVo;
import run.hxtia.workbd.pojo.vo.response.RoleVo;
import run.hxtia.workbd.pojo.vo.response.StudentVo;
import run.hxtia.workbd.pojo.vo.response.*;
import run.hxtia.workbd.pojo.vo.response.organization.ClassVo;
import run.hxtia.workbd.pojo.vo.response.organization.CollegeVo;
import run.hxtia.workbd.pojo.vo.response.organization.GradeVo;

/**
 * 1、简单Java对象的转换【不用自己写很多 set、get】
 * 2、https://github.com/mapstruct/mapstruct
 */
@Mapper(uses = {
       MapStructFormatter.class
})
public interface MapStructs {

   // 生成实例对象。可以调用下面的方法
   MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

   /*
    1、Po -> vo     【用来将从数据库查到的数据过滤成 vo返回给前端】
    2、可以解决转换类型不匹配、参数名不匹配的问题。 @Mapping 参数如下
    （1）source：源对象
    （2）target：目标对象
    （3）qualifiedBy：找转换器中的方法
    */
    StudentVo po2vo(Student po);
    AdminLoginVo po2loginVo(AdminUsers po);
    RoleVo po2vo(Role po);

    AdminUserVo po2adminUserVo(AdminUsers po);
    CollegeVo po2vo(College po);
    GradeVo po2vo(Grade po);
    ClassVo po2vo(Classes po);

   // reqVo -> po  【用来做数据库保存】

   AdminUsers reqVo2po(AdminUserReqVo reqVo);
   @Mapping(source = "email", target = "username")
   AdminUsers reqVo2po(AdminUserRegisterReqVo reqVo);
   AdminUsers reqVo2po(AdminUserEditReqVo reqVo);
   AdminUsers reqVo2po(AdminUserInfoEditReqVo reqVo);
   Student reqVo2po(StudentReqVo reqVo);
   Role reqVo2po(RoleReqVo reqVo);


    @Mapping(source = "name", target = "name")
   College reqVo2po(CollegeReqVo reqVo);
    @Mapping(source = "name", target = "name")
    College reqVo2po(CollegeEditReqVo reqVo);
    Grade reqVo2po(GradeReqVo reqVo);
    Grade reqVo2po(GradeEditReqVo reqVo);
    Classes reqVo2po(ClassReqVo reqVo);
    Classes reqVo2po(ClassEditReqVo reqVo);

   // reqVo -> wxSdk
    WxMaSubscribeMessage reqVo2wxVo(WxSubscribeMessageReqVo reqVo);

    // PO -> DTO
    ResourceDto po2dto(Resource po);


    NotificationVo po2vo(Notification notification);


    Notification reqVo2po(NotificationReqVo reqVo);
}
