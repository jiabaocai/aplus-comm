package com.ald.news.core.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用maer匹配, 所有的mapper需要继承
 *
 * @param <T>
 * @author xdj
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
