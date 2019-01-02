package com.ald.news.user.mapper;

import com.ald.news.core.base.BaseMapper;
import com.ald.news.domain.user.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper extends BaseMapper<UserDo> {

    @Select({"<script>",
            "select id,nickname from news_user where id in ",
            "<foreach item='item' index='index' open='(' collection='replyUserIdList' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"})
    List<UserDo> getUserByPrimarykey(@Param("replyUserIdList") List<Long> replyUserIdList);
}