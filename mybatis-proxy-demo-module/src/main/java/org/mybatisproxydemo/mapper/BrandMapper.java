package org.mybatisproxydemo.mapper;

import org.mybatisproxydemo.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    public List<Brand> selectAll();

    public Brand selectAllById(int id);
}
