# design-pattern

源码
1、设计模式

2、mybatis v1 
实现简单的mybatis机制，
sqlsession进行用户会话，是入口
利用动态代理生成mapper接口的实例，但该实例是MapperProxy接口的实例，这个实例主要是负责找到sql
excutor封装了jdbc操作

3、mybatis v2
比v1版本更近一步的实现了annotation机制，让实现能够利用注解找到sql语句
还实现了plugin，demo中 已经实现的2个插件为 InserPlugin和SelectPlugin 



