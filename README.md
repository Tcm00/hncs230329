# hncs230329
湖南创思测试题目

项目介绍：

1.本demo实现了用户信息、课程信息、成绩信息的新增及编辑功能；

2.采用md5加密方式对密码进行加密，Page类进行分页管理；

3.采用了JWT生成token并对登陆、注册、邮件验证码以外的接口进行请求拦截；

4.采用了Swagger进行接口管理；

5.采用了redis进行验证码管理；

6.参照ruoyi开源框架外加了sys_menu,sys_role,sys_user_role 表进行角色权限管理。



由于29日收到demo试题，需在30日上传作品，demo从零开始搭建，故功能可能不够完善，望见谅。

## 超级管理员用户

```
username:root,

password:root,
```

请求头格式

```
token:"登陆接口返回的token信息(不需要加Bear)"
```



## 在线地址

github项目地址：

```
https://github.com/Tcm00/hncs230329
```

redis地址(无密码）：

```
49.235.127.31
```

swagger地址：

```
49.235.127.31:9092/doc.html
或
127.0.0.1:9092/doc.html
```

mysql连接：

```
datasource:
    url: jdbc:mysql://49.235.127.31:3306/testdata?useunicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false
    username: testdata
    password: "123456"
    driver-class-name: com.mysql.cj.jdbc.Driver
```

