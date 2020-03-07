## 论坛
## 资料
[Spring 文档](https://spring.io/guides)
[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)
[es社区](https://elasticsearch.cn/explore)
[Github deploy key](https://help.github.com/en/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account)
[Bootstrap文档](https://v3.bootcss.com/getting-started/#download)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/authorizing-oauth-apps/)
[Maven库](https://mvnrepository.com/)
[OkHttp文档](https://square.github.io/okhttp/)
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)
## 工具
[Git](https://git-scm.com/downloads)
[Visual Paradigm](https://www.visual-paradigm.com)
[Flyway](http://flywaydb.org/getstarted/firststeps/maven)
##脚本
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
```