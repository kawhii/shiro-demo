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
http://localhost:8080