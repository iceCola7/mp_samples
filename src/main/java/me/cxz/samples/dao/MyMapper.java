package me.cxz.samples.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyMapper<T> extends BaseMapper<T> {

    /**
     * 自定义sql注入器，删除所有
     *
     * @return 影响行数
     */
    int deleteAll();

    int insertBatchSomeColumn(List<T> list);

    int deleteByIdWithFill(T entity);

    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

}
