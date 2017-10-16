/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.kawhi.security.shiro.demo.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 当是ajax请求时返回json否则转发路径
 *
 * @author Carl
 * @date 2017/10/16
 * @since 1.0.0
 */
public class CustomPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        if (isAjaxRequest((HttpServletRequest) request)) {
            //写json
            writeJson(request, response);
            return false;
        }
        return super.onAccessDenied(request, response);
    }

    /**
     * 输出json
     * @param request
     * @param response
     * @throws IOException
     */
    private void writeJson(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        response.setContentType("application/json");
        if (subject.getPrincipal() == null) {
            response.getWriter().write("{\"msg\":\"未登录\"}");
        } else {
            response.getWriter().write("{\"msg\":\"无权限操作\"}");
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request){
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(header);
    }
}
