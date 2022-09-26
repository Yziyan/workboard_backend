package run.hxtia.workbd.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import run.hxtia.workbd.mapper.AdminUserRoleMapper;
import run.hxtia.workbd.pojo.po.AdminUserRole;
import run.hxtia.workbd.service.admin.AdminUserRoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色模块 业务层
 */
@Service
public class AdminUserRoleServiceImpl
    extends ServiceImpl<AdminUserRoleMapper, AdminUserRole> implements AdminUserRoleService {

    /**
     * 根据用户ID，删除所有的角色信息
     * @param userId：用户ID
     * @return ：是否成功
     */
    @Override
    public boolean removeByUserId(Long userId) {
        if (userId == null || userId <= 0) return false;
        LambdaQueryWrapper<AdminUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdminUserRole::getUserId, userId);
        return remove(wrapper);
    }

    /**
     * 添加角色信息
     * @param userId：用户ID
     * @param roleIdsStr：角色ID【多个角色用 逗号, 隔开】
     * @return ：是否成功
     */
    @Override
    public boolean save(Long userId, String roleIdsStr) {
        if (!StringUtils.hasLength(roleIdsStr)) return false;

        // 构建用户角色信息
        String[] roleIds = roleIdsStr.split(",");

        List<AdminUserRole> adminUserRoles = new ArrayList<>();
        for (String roleId : roleIds) {
            adminUserRoles.add(new AdminUserRole(userId, Short.valueOf(roleId)));
        }

        return saveBatch(adminUserRoles);
    }
}