# maven mybatis demo module
1. 在 `resources` 文件夹下 添加 `mybatis-config.xml` 配置文件
2. 创建一个包 `com.mybatis.pojo`, 存放`pojo对象类`
3. 在 `com.mybatis.pojo` 包下, 创建`User类`
4. 在 `resources` 文件夹下, 创建一个 mappers 文件夹, 用于存放 mapper文件
5. 在 `resources -> mappers` 文件夹下, 创建一个 `UserMapper.xml` 文件, 用于编写 sql
6. 在 `mybatis-config.xml`配置文件中, `mappers` 域 下, 添加 `<mapper resource="mappers/UsreMapper.xml"/>` mapper 路径为 于mybatis-config.xml文件的相对路径
