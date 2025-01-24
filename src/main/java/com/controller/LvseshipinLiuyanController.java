
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 绿色食品留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/lvseshipinLiuyan")
public class LvseshipinLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(LvseshipinLiuyanController.class);

    private static final String TABLE_NAME = "lvseshipinLiuyan";

    @Autowired
    private LvseshipinLiuyanService lvseshipinLiuyanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private LvseshipinService lvseshipinService;//绿色食品
    @Autowired
    private LvseshipinCollectionService lvseshipinCollectionService;//绿色食品收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = lvseshipinLiuyanService.queryPage(params);

        //字典表数据转换
        List<LvseshipinLiuyanView> list =(List<LvseshipinLiuyanView>)page.getList();
        for(LvseshipinLiuyanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LvseshipinLiuyanEntity lvseshipinLiuyan = lvseshipinLiuyanService.selectById(id);
        if(lvseshipinLiuyan !=null){
            //entity转view
            LvseshipinLiuyanView view = new LvseshipinLiuyanView();
            BeanUtils.copyProperties( lvseshipinLiuyan , view );//把实体数据重构到view中
            //级联表 绿色食品
            //级联表
            LvseshipinEntity lvseshipin = lvseshipinService.selectById(lvseshipinLiuyan.getLvseshipinId());
            if(lvseshipin != null){
            BeanUtils.copyProperties( lvseshipin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLvseshipinId(lvseshipin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(lvseshipinLiuyan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LvseshipinLiuyanEntity lvseshipinLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,lvseshipinLiuyan:{}",this.getClass().getName(),lvseshipinLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            lvseshipinLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        lvseshipinLiuyan.setCreateTime(new Date());
        lvseshipinLiuyan.setInsertTime(new Date());
        lvseshipinLiuyanService.insert(lvseshipinLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LvseshipinLiuyanEntity lvseshipinLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,lvseshipinLiuyan:{}",this.getClass().getName(),lvseshipinLiuyan.toString());
        LvseshipinLiuyanEntity oldLvseshipinLiuyanEntity = lvseshipinLiuyanService.selectById(lvseshipinLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            lvseshipinLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        lvseshipinLiuyan.setUpdateTime(new Date());

            lvseshipinLiuyanService.updateById(lvseshipinLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LvseshipinLiuyanEntity> oldLvseshipinLiuyanList =lvseshipinLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        lvseshipinLiuyanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LvseshipinLiuyanEntity> lvseshipinLiuyanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LvseshipinLiuyanEntity lvseshipinLiuyanEntity = new LvseshipinLiuyanEntity();
//                            lvseshipinLiuyanEntity.setLvseshipinId(Integer.valueOf(data.get(0)));   //绿色食品 要改的
//                            lvseshipinLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            lvseshipinLiuyanEntity.setLvseshipinLiuyanText(data.get(0));                    //留言内容 要改的
//                            lvseshipinLiuyanEntity.setInsertTime(date);//时间
//                            lvseshipinLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            lvseshipinLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            lvseshipinLiuyanEntity.setCreateTime(date);//时间
                            lvseshipinLiuyanList.add(lvseshipinLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        lvseshipinLiuyanService.insertBatch(lvseshipinLiuyanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = lvseshipinLiuyanService.queryPage(params);

        //字典表数据转换
        List<LvseshipinLiuyanView> list =(List<LvseshipinLiuyanView>)page.getList();
        for(LvseshipinLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LvseshipinLiuyanEntity lvseshipinLiuyan = lvseshipinLiuyanService.selectById(id);
            if(lvseshipinLiuyan !=null){


                //entity转view
                LvseshipinLiuyanView view = new LvseshipinLiuyanView();
                BeanUtils.copyProperties( lvseshipinLiuyan , view );//把实体数据重构到view中

                //级联表
                    LvseshipinEntity lvseshipin = lvseshipinService.selectById(lvseshipinLiuyan.getLvseshipinId());
                if(lvseshipin != null){
                    BeanUtils.copyProperties( lvseshipin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLvseshipinId(lvseshipin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(lvseshipinLiuyan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody LvseshipinLiuyanEntity lvseshipinLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,lvseshipinLiuyan:{}",this.getClass().getName(),lvseshipinLiuyan.toString());
        lvseshipinLiuyan.setCreateTime(new Date());
        lvseshipinLiuyan.setInsertTime(new Date());
        lvseshipinLiuyanService.insert(lvseshipinLiuyan);

            return R.ok();
        }

}

