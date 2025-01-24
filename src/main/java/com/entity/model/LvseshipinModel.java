package com.entity.model;

import com.entity.LvseshipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 绿色食品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LvseshipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 绿色食品名称
     */
    private String lvseshipinName;


    /**
     * 绿色食品编号
     */
    private String lvseshipinUuidNumber;


    /**
     * 绿色食品照片
     */
    private String lvseshipinPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 绿色食品类型
     */
    private Integer lvseshipinTypes;


    /**
     * 参考价格
     */
    private Double lvseshipinNewMoney;


    /**
     * 单位
     */
    private String lvseshipinDanwei;


    /**
     * 绿色食品热度
     */
    private Integer lvseshipinClicknum;


    /**
     * 绿色食品介绍
     */
    private String lvseshipinContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer lvseshipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
