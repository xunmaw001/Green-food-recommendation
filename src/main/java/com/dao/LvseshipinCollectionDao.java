package com.dao;

import com.entity.LvseshipinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LvseshipinCollectionView;

/**
 * 绿色食品收藏 Dao 接口
 *
 * @author 
 */
public interface LvseshipinCollectionDao extends BaseMapper<LvseshipinCollectionEntity> {

   List<LvseshipinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
