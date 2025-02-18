package com.dao;

import com.entity.LvseshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LvseshipinView;

/**
 * 绿色食品 Dao 接口
 *
 * @author 
 */
public interface LvseshipinDao extends BaseMapper<LvseshipinEntity> {

   List<LvseshipinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
