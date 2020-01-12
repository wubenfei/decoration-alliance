package com.ours.userappservice.common;


import com.ours.entity.User;
import com.ours.userappservice.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MybatisShiroRealm extends AuthorizingRealm {
    @Resource
    private UserMapper userMapper;

    /**
     * @param principal
     * @return 授权
     * @Auth:MrW
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principal) {
//        User user = (User) principal.getPrimaryPrincipal();
//        // 查询所有角色
//        Set<Role> roles = roleMapper.findRolesByU serId(user.getUserId());
//        // 将set转换为String，提取角色value
//        Set<String> roleString = roles.stream()
//                .map(Role::getRoleValue).collect(Collectors.toSet());
//        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
//        // 根据id查询权限
//        Set<Integer> roleIds = roles.stream()
//                .map(Role::getRoleId).collect(Collectors.toSet());b
//        auth.setRoles(roleString);
//        Set<String> perms = permMapper.findPermInRoleIds(roleIds);
//        auth.setStringPermissions(perms);
//        return auth;
        return null;
    }

    /**
     * @param
     * @return 认证
     * @Auth:MrW
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        System.out.println("正在认证信息..." + token);
        // 获取用户名
        String tel = (String) token.getPrincipal();
        System.out.println("tel：" + tel);
        // 根据用户名到数据库进行查询
        User user = userMapper.selectByPhone(tel);
        // 判断设计师是否存在,都不存在说明无该用户
        if (user == null) {
            throw new UnknownAccountException("用户[" + tel + "]没有注册");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
    }
}