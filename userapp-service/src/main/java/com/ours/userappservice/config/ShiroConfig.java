package com.ours.userappservice.config;

import com.ours.userappservice.common.MybatisShiroRealm;
import com.ours.userappservice.utils.EncryptUtil;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        System.out.println("ShiroFilterChainDefinition被调用了");
        DefaultShiroFilterChainDefinition dsfcd =
                new DefaultShiroFilterChainDefinition();
        // anon 匿名访问，不需登录
        // authc 不能访问，需要登录
        // logout 登出请求
//        dsfcd.addPathDefinition("/css/**","anon");
//        dsfcd.addPathDefinition("/js/**","anon");
//        dsfcd.addPathDefinition("/images/**","anon");
        dsfcd.addPathDefinition("/userLogin", "anon");
        dsfcd.addPathDefinition("/staffLogout", "staff");
//        dsfcd.addPathDefinition("/register","anon");
        dsfcd.addPathDefinition("/erro", "anon");
        //必须是携带有user信息，否则不通过
        dsfcd.addPathDefinition("/**", "staff");

        return dsfcd;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean("securityManager")
    public SessionsSecurityManager securityManager() {
        System.out.println("manager被调用了");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    /**
     * 加密需要用到的
     * CredentialsMatcher：凭证匹配器
     */
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        System.out.println("credentialMatcher被调用了");
        HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
        //哈希算法的算法名
        hcm.setHashAlgorithmName(EncryptUtil.HASH_ALOG);
        //哈希迭代次数
        hcm.setHashIterations(EncryptUtil.HASH_ITERATIONS);
        return hcm;
    }

    @Bean
    public Realm getRealm() {
        System.out.println("getRealm被调用了");
        MybatisShiroRealm mybatisShiroRealm = new MybatisShiroRealm();
        //设置密码匹配器，用于密码的匹配
        mybatisShiroRealm.setCredentialsMatcher(credentialsMatcher());
        return new MybatisShiroRealm();
    }
}
