package org.mybatisproxydemo.mapper;

import org.mybatisproxydemo.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectAll();

    public User selectById(int id);
}
