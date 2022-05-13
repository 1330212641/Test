package com.service;

import com.mapper.CategoryMapper;
import com.pojo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public List<Category> showcategory(Integer state) {
        return categoryMapper.showcategory(state);
    }
}
