package com.entity.vo;

import com.entity.LvseshipinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 绿色食品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("lvseshipin")
public class LvseshipinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 绿色食品名称
     */

    @TableField(value = "lvseshipin_name")
    private String lvseshipinName;


    /**
     * 绿色食品编号
     */

    @TableField(value = "lvseshipin_uuid_number")
    private String lvseshipinUuidNumber;


    /**
     * 绿色食品照片
     */

    @TableField(value = "lvseshipin_photo")
    private String lvseshipinPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 绿色食品类型
     */

    @TableField(value = "lvseshipin_types")
    private Integer lvseshipinTypes;


    /**
     * 参考价格
     */

    @TableField(value = "lvseshipin_new_money")
    private Double lvseshipinNewMoney;


    /**
     * 单位
     */

    @TableField(value = "lvseshipin_danwei")
    private String lvseshipinDanwei;


    /**
     * 绿色食品热度
     */

    @TableField(value = "lvseshipin_clicknum")
    private Integer lvseshipinClicknum;


    /**
     * 绿色食品介绍
     */

    @TableField(value = "lvseshipin_content")
    private String lvseshipinContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "lvseshipin_delete")
    private Integer lvseshipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：绿色食品名称
	 */
    public String getLvseshipinName() {
        return lvseshipinName;
    }


    /**
	 * 获取：绿色食品名称
	 */

    public void setLvseshipinName(String lvseshipinName) {
        this.lvseshipinName = lvseshipinName;
    }
    /**
	 * 设置：绿色食品编号
	 */
    public String getLvseshipinUuidNumber() {
        return lvseshipinUuidNumber;
    }


    /**
	 * 获取：绿色食品编号
	 */

    public void setLvseshipinUuidNumber(String lvseshipinUuidNumber) {
        this.lvseshipinUuidNumber = lvseshipinUuidNumber;
    }
    /**
	 * 设置：绿色食品照片
	 */
    public String getLvseshipinPhoto() {
        return lvseshipinPhoto;
    }


    /**
	 * 获取：绿色食品照片
	 */

    public void setLvseshipinPhoto(String lvseshipinPhoto) {
        this.lvseshipinPhoto = lvseshipinPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：绿色食品类型
	 */
    public Integer getLvseshipinTypes() {
        return lvseshipinTypes;
    }


    /**
	 * 获取：绿色食品类型
	 */

    public void setLvseshipinTypes(Integer lvseshipinTypes) {
        this.lvseshipinTypes = lvseshipinTypes;
    }
    /**
	 * 设置：参考价格
	 */
    public Double getLvseshipinNewMoney() {
        return lvseshipinNewMoney;
    }


    /**
	 * 获取：参考价格
	 */

    public void setLvseshipinNewMoney(Double lvseshipinNewMoney) {
        this.lvseshipinNewMoney = lvseshipinNewMoney;
    }
    /**
	 * 设置：单位
	 */
    public String getLvseshipinDanwei() {
        return lvseshipinDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setLvseshipinDanwei(String lvseshipinDanwei) {
        this.lvseshipinDanwei = lvseshipinDanwei;
    }
    /**
	 * 设置：绿色食品热度
	 */
    public Integer getLvseshipinClicknum() {
        return lvseshipinClicknum;
    }


    /**
	 * 获取：绿色食品热度
	 */

    public void setLvseshipinClicknum(Integer lvseshipinClicknum) {
        this.lvseshipinClicknum = lvseshipinClicknum;
    }
    /**
	 * 设置：绿色食品介绍
	 */
    public String getLvseshipinContent() {
        return lvseshipinContent;
    }


    /**
	 * 获取：绿色食品介绍
	 */

    public void setLvseshipinContent(String lvseshipinContent) {
        this.lvseshipinContent = lvseshipinContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLvseshipinDelete() {
        return lvseshipinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLvseshipinDelete(Integer lvseshipinDelete) {
        this.lvseshipinDelete = lvseshipinDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
