package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LvseshipinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 绿色食品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("lvseshipin")
public class LvseshipinView extends LvseshipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 绿色食品类型的值
	*/
	@ColumnInfo(comment="绿色食品类型的字典表值",type="varchar(200)")
	private String lvseshipinValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public LvseshipinView() {

	}

	public LvseshipinView(LvseshipinEntity lvseshipinEntity) {
		try {
			BeanUtils.copyProperties(this, lvseshipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 绿色食品类型的值
	*/
	public String getLvseshipinValue() {
		return lvseshipinValue;
	}
	/**
	* 设置： 绿色食品类型的值
	*/
	public void setLvseshipinValue(String lvseshipinValue) {
		this.lvseshipinValue = lvseshipinValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "LvseshipinView{" +
			", lvseshipinValue=" + lvseshipinValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
