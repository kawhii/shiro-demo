/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.kawhi.security.shiro.demo.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @date 2017/10/19
 * @since 2.3.7
 */
public class DelegateRealm implements Realm {
    private List<Realm> realms = new ArrayList<>();

    public List<Realm> getRealms() {
        return realms;
    }

    public DelegateRealm setRealms(List<Realm> realms) {
        this.realms = realms;
        return this;
    }

    @Override
    public String getName() {
        return "delegate-realm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        for(Realm realm: realms) {
            if(realm.supports(token)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        for(Realm realm: realms) {
            if(realm.supports(token)) {
                return realm.getAuthenticationInfo(token);
            }
        }
        return null;
    }
}
