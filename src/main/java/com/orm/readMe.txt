ORM 对象关系映射
说的就是将已经持久化的数据内容转换为一个java对象
java对象来描述对象与对象之间的关系和数据内容

Hibernate  Mybatis  JPA SpringJDBC
Hibernate 全自动挡
Mybatis 手自一体
SpringJDBC 手动挡

Spring万能胶  /IOC/AOP/DI/MVC/JDBC/bigData/Cloud/Boot

为什么要自己写ORM框架
1、解决实际的业务问题
2、自定义需求，如果要直接第三方开源框架的话，需要进行第三次开发
3、解决团队成员之间水平参差不齐的问题
4、可以实现统一的管理、监控、排错等等一系列底层操作

大数据监测系统
数据吞吐量大
数据存储方式多样化
数据源需要频繁切换
API无法统一

最底层的类
1、统一方法名
    select
    insert
    delete
    update

    //约定
    如果是删、改，以ID作为唯一的检索条件，如果没有ID，那么先查出来得到ID

2、统一参数
   如果做条件查询, QueryRule(自己封装)
   批量更新和插入  方法名以All结尾，参数为List
   删、改、插一条数据，参数用 T

3、统一返回结果



c3p0
druid

morphia




