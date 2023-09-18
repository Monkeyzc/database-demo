package org.mybatisproxydemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.mybatisproxydemo.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectAll();

    public User selectById(int id);

    // 使用注解完成更新
    @Update(value = "update users set name = #{name} where id = #{id}")
    public void updateById(@Param("id") int id, @Param("name") String name);
}
