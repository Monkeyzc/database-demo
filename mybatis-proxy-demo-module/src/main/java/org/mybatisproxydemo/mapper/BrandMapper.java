package org.mybatisproxydemo.mapper;

import jdk.nashorn.internal.ir.BreakableNode;
import org.apache.ibatis.annotations.Param;
import org.mybatisproxydemo.pojo.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BrandMapper {

    public List<Brand> selectAll();

    public Brand selectAllById(int id);

    /**
     * 多条件查询, 多参数:
     *  1. 使用 @Param 注解, 对应 mapper xml 文件中 参数 #{}
     *  2. 使用 Map 封装 参数
     * */
//    public Brand selectByCondition(
//            @Param("status") int status,
//            @Param("companyName") String companyName,
//            @Param("brandName") String brandName);

//    public Brand selectByCondition(Map map);
    public Brand selectByCondition(Brand brand);

    public void add(Brand brand);

    public void updateById(Brand brand);

    public void deleteById(int id);

    public void deleteByIds(@Param("ids") ArrayList<Integer> ids);
}
