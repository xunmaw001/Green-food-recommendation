package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LvseshipinLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 绿色食品留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("lvseshipin_liuyan")
public class LvseshipinLiuyanView extends LvseshipinLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 绿色食品
		/**
		* 绿色食品名称
		*/

		@ColumnInfo(comment="绿色食品名称",type="varchar(200)")
		private String lvseshipinName;
		/**
		* 绿色食品编号
		*/

		@ColumnInfo(comment="绿色食品编号",type="varchar(200)")
		private String lvseshipinUuidNumber;
		/**
		* 绿色食品照片
		*/

		@ColumnInfo(comment="绿色食品照片",type="varchar(200)")
		private String lvseshipinPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 绿色食品类型
		*/
		@ColumnInfo(comment="绿色食品类型",type="int(11)")
		private Integer lvseshipinTypes;
			/**
			* 绿色食品类型的值
			*/
			@ColumnInfo(comment="绿色食品类型的字典表值",type="varchar(200)")
			private String lvseshipinValue;
		/**
		* 参考价格
		*/
		@ColumnInfo(comment="参考价格",type="decimal(10,2)")
		private Double lvseshipinNewMoney;
		/**
		* 单位
		*/

		@ColumnInfo(comment="单位",type="varchar(200)")
		private String lvseshipinDanwei;
		/**
		* 绿色食品热度
		*/

		@ColumnInfo(comment="绿色食品热度",type="int(11)")
		private Integer lvseshipinClicknum;
		/**
		* 绿色食品介绍
		*/

		@ColumnInfo(comment="绿色食品介绍",type="longtext")
		private String lvseshipinContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer lvseshipinDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public LvseshipinLiuyanView() {

	}

	public LvseshipinLiuyanView(LvseshipinLiuyanEntity lvseshipinLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, lvseshipinLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 绿色食品

		/**
		* 获取： 绿色食品名称
		*/
		public String getLvseshipinName() {
			return lvseshipinName;
		}
		/**
		* 设置： 绿色食品名称
		*/
		public void setLvseshipinName(String lvseshipinName) {
			this.lvseshipinName = lvseshipinName;
		}

		/**
		* 获取： 绿色食品编号
		*/
		public String getLvseshipinUuidNumber() {
			return lvseshipinUuidNumber;
		}
		/**
		* 设置： 绿色食品编号
		*/
		public void setLvseshipinUuidNumber(String lvseshipinUuidNumber) {
			this.lvseshipinUuidNumber = lvseshipinUuidNumber;
		}

		/**
		* 获取： 绿色食品照片
		*/
		public String getLvseshipinPhoto() {
			return lvseshipinPhoto;
		}
		/**
		* 设置： 绿色食品照片
		*/
		public void setLvseshipinPhoto(String lvseshipinPhoto) {
			this.lvseshipinPhoto = lvseshipinPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 绿色食品类型
		*/
		public Integer getLvseshipinTypes() {
			return lvseshipinTypes;
		}
		/**
		* 设置： 绿色食品类型
		*/
		public void setLvseshipinTypes(Integer lvseshipinTypes) {
			this.lvseshipinTypes = lvseshipinTypes;
		}


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

		/**
		* 获取： 参考价格
		*/
		public Double getLvseshipinNewMoney() {
			return lvseshipinNewMoney;
		}
		/**
		* 设置： 参考价格
		*/
		public void setLvseshipinNewMoney(Double lvseshipinNewMoney) {
			this.lvseshipinNewMoney = lvseshipinNewMoney;
		}

		/**
		* 获取： 单位
		*/
		public String getLvseshipinDanwei() {
			return lvseshipinDanwei;
		}
		/**
		* 设置： 单位
		*/
		public void setLvseshipinDanwei(String lvseshipinDanwei) {
			this.lvseshipinDanwei = lvseshipinDanwei;
		}

		/**
		* 获取： 绿色食品热度
		*/
		public Integer getLvseshipinClicknum() {
			return lvseshipinClicknum;
		}
		/**
		* 设置： 绿色食品热度
		*/
		public void setLvseshipinClicknum(Integer lvseshipinClicknum) {
			this.lvseshipinClicknum = lvseshipinClicknum;
		}

		/**
		* 获取： 绿色食品介绍
		*/
		public String getLvseshipinContent() {
			return lvseshipinContent;
		}
		/**
		* 设置： 绿色食品介绍
		*/
		public void setLvseshipinContent(String lvseshipinContent) {
			this.lvseshipinContent = lvseshipinContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getLvseshipinDelete() {
			return lvseshipinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setLvseshipinDelete(Integer lvseshipinDelete) {
			this.lvseshipinDelete = lvseshipinDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "LvseshipinLiuyanView{" +
			", lvseshipinName=" + lvseshipinName +
			", lvseshipinUuidNumber=" + lvseshipinUuidNumber +
			", lvseshipinPhoto=" + lvseshipinPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", lvseshipinNewMoney=" + lvseshipinNewMoney +
			", lvseshipinDanwei=" + lvseshipinDanwei +
			", lvseshipinClicknum=" + lvseshipinClicknum +
			", lvseshipinContent=" + lvseshipinContent +
			", lvseshipinDelete=" + lvseshipinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
