package com.example.scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.scaffold.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
