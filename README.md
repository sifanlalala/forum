## 论坛
## 资料
[Spring 文档](https://spring.io/guides)<br>
[Spring Web](https://spring.io/guides/gs/serving-web-content/)<br>
[es社区](https://elasticsearch.cn/explore)<br>
[Github deploy key](https://help.github.com/en/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account)<br>
[Bootstrap文档](https://v3.bootcss.com/getting-started/#download)<br>
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/authorizing-oauth-apps/)<br>
[Maven库](https://mvnrepository.com/)<br>
[OkHttp文档](https://square.github.io/okhttp/)<br>
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)<br>
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)<br>
[Editor.md](http://editor.md.ipandao.com/)<br>
[iconfont](https://www.iconfont.cn/)<br>
[Scheduling Tasks](https://spring.io/guides/gs/scheduling-tasks/)<br>
## 工具
[Git](https://git-scm.com/downloads)<br>
[Visual Paradigm](https://www.visual-paradigm.com)<br>
[Flyway](http://flywaydb.org/getstarted/firststeps/maven)<br>
[Lombok](https://www.projectlombok.org/)<br>
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)<br>
[Spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-handlermapping-interceptor)<br>
[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)<br>
[OSS](https://help.aliyun.com/product/31815.html?spm=a2c4g.11174283.6.540.d5fa7da20k6Baz)<br>
## 脚本
```sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```
```bssh
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate