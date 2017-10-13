# Shiro-Demo [官方教程](https://github.com/lhazlewood/apache-shiro-tutorial-webapp)
用于对shiro1.2测试，测试任务包括

1. 登录策略配置
2. 无权限访问相应结果

# 测试结果

1. auth权限未登录会转发到登录页
2. 访问需要perms未登录会转发到登录页,若已登录抛出401


# 部署

## 启动

```bash
mvn jetty:run
```

## 访问
用户：
http://localhost:8080

|用户名|密码|角色
|:--|:--|:--
|admin|123|admin_role
|wangwu|123| |

角色：

|角色编码|权限
|:--|:--
|admin_role|admin_p

资源：

|资源|限制情况
|:--|:--
|/perms.jsp|perms["admin_p"]
|/logout|logout
|/**|authc


如：

用户：admin/123 有权限访问 http://localhost:8080/perms.jsp

用户：wangwu/123 w无权限访问 http://localhost:8080/perms.jsp