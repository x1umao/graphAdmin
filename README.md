生成证书
```shell
keytool -genkey -alias tomcat  -storetype PKCS12 -keyalg RSA -keysize 2048  -keystore keystore.p12 -validity 3650
```

前端后端两次hmac
前端密钥数据库随机生成
后端密钥为用户设置