package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 绿色食品
 *
 * @author 
 * @email
 */
@TableName("lvseshipin")
public class LvseshipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LvseshipinEntity() {

	}

	public LvseshipinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 绿色食品名称
     */
    @ColumnInfo(comment="绿色食品名称",type="varchar(200)")
    @TableField(value = "lvseshipin_name")

    private String lvseshipinName;


    /**
     * 绿色食品编号
     */
    @ColumnInfo(comment="绿色食品编号",type="varchar(200)")
    @TableField(value = "lvseshipin_uuid_number")

    private String lvseshipinUuidNumber;


    /**
     * 绿色食品照片
     */
    @ColumnInfo(comment="绿色食品照片",type="varchar(200)")
    @TableField(value = "lvseshipin_photo")

    private String lvseshipinPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 绿色食品类型
     */
    @ColumnInfo(comment="绿色食品类型",type="int(11)")
    @TableField(value = "lvseshipin_types")

    private Integer lvseshipinTypes;


    /**
     * 参考价格
     */
    @ColumnInfo(comment="参考价格",type="decimal(10,2)")
    @TableField(value = "lvseshipin_new_money")

    private Double lvseshipinNewMoney;


    /**
     * 单位
     */
    @ColumnInfo(comment="单位",type="varchar(200)")
    @TableField(value = "lvseshipin_danwei")

    private String lvseshipinDanwei;


    /**
     * 绿色食品热度
     */
    @ColumnInfo(comment="绿色食品热度",type="int(11)")
    @TableField(value = "lvseshipin_clicknum")

    private Integer lvseshipinClicknum;


    /**
     * 绿色食品介绍
     */
    @ColumnInfo(comment="绿色食品介绍",type="longtext")
    @TableField(value = "lvseshipin_content")

    private String lvseshipinContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "lvseshipin_delete")

    private Integer lvseshipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：绿色食品名称
	 */
    public String getLvseshipinName() {
        return lvseshipinName;
    }
    /**
	 * 设置：绿色食品名称
	 */

    public void setLvseshipinName(String lvseshipinName) {
        this.lvseshipinName = lvseshipinName;
    }
    /**
	 * 获取：绿色食品编号
	 */
    public String getLvseshipinUuidNumber() {
        return lvseshipinUuidNumber;
    }
    /**
	 * 设置：绿色食品编号
	 */

    public void setLvseshipinUuidNumber(String lvseshipinUuidNumber) {
        this.lvseshipinUuidNumber = lvseshipinUuidNumber;
    }
    /**
	 * 获取：绿色食品照片
	 */
    public String getLvseshipinPhoto() {
        return lvseshipinPhoto;
    }
    /**
	 * 设置：绿色食品照片
	 */

    public void setLvseshipinPhoto(String lvseshipinPhoto) {
        this.lvseshipinPhoto = lvseshipinPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：绿色食品类型
	 */
    public Integer getLvseshipinTypes() {
        return lvseshipinTypes;
    }
    /**
	 * 设置：绿色食品类型
	 */

    public void setLvseshipinTypes(Integer lvseshipinTypes) {
        this.lvseshipinTypes = lvseshipinTypes;
    }
    /**
	 * 获取：参考价格
	 */
    public Double getLvseshipinNewMoney() {
        return lvseshipinNewMoney;
    }
    /**
	 * 设置：参考价格
	 */

    public void setLvseshipinNewMoney(Double lvseshipinNewMoney) {
        this.lvseshipinNewMoney = lvseshipinNewMoney;
    }
    /**
	 * 获取：单位
	 */
    public String getLvseshipinDanwei() {
        return lvseshipinDanwei;
    }
    /**
	 * 设置：单位
	 */

    public void setLvseshipinDanwei(String lvseshipinDanwei) {
        this.lvseshipinDanwei = lvseshipinDanwei;
    }
    /**
	 * 获取：绿色食品热度
	 */
    public Integer getLvseshipinClicknum() {
        return lvseshipinClicknum;
    }
    /**
	 * 设置：绿色食品热度
	 */

    public void setLvseshipinClicknum(Integer lvseshipinClicknum) {
        this.lvseshipinClicknum = lvseshipinClicknum;
    }
    /**
	 * 获取：绿色食品介绍
	 */
    public String getLvseshipinContent() {
        return lvseshipinContent;
    }
    /**
	 * 设置：绿色食品介绍
	 */

    public void setLvseshipinContent(String lvseshipinContent) {
        this.lvseshipinContent = lvseshipinContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLvseshipinDelete() {
        return lvseshipinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setLvseshipinDelete(Integer lvseshipinDelete) {
        this.lvseshipinDelete = lvseshipinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Lvseshipin{" +
            ", id=" + id +
            ", lvseshipinName=" + lvseshipinName +
            ", lvseshipinUuidNumber=" + lvseshipinUuidNumber +
            ", lvseshipinPhoto=" + lvseshipinPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", lvseshipinTypes=" + lvseshipinTypes +
            ", lvseshipinNewMoney=" + lvseshipinNewMoney +
            ", lvseshipinDanwei=" + lvseshipinDanwei +
            ", lvseshipinClicknum=" + lvseshipinClicknum +
            ", lvseshipinContent=" + lvseshipinContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", lvseshipinDelete=" + lvseshipinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
