
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
 * 绿色食品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/lvseshipin")
public class LvseshipinController {
    private static final Logger logger = LoggerFactory.getLogger(LvseshipinController.class);

    private static final String TABLE_NAME = "lvseshipin";

    @Autowired
    private LvseshipinService lvseshipinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private LvseshipinCollectionService lvseshipinCollectionService;//绿色食品收藏
    @Autowired
    private LvseshipinLiuyanService lvseshipinLiuyanService;//绿色食品留言
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
        params.put("lvseshipinDeleteStart",1);params.put("lvseshipinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = lvseshipinService.queryPage(params);

        //字典表数据转换
        List<LvseshipinView> list =(List<LvseshipinView>)page.getList();
        for(LvseshipinView c:list){
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
        LvseshipinEntity lvseshipin = lvseshipinService.selectById(id);
        if(lvseshipin !=null){
            //entity转view
            LvseshipinView view = new LvseshipinView();
            BeanUtils.copyProperties( lvseshipin , view );//把实体数据重构到view中
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
    public R save(@RequestBody LvseshipinEntity lvseshipin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,lvseshipin:{}",this.getClass().getName(),lvseshipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LvseshipinEntity> queryWrapper = new EntityWrapper<LvseshipinEntity>()
            .eq("lvseshipin_name", lvseshipin.getLvseshipinName())
            .eq("zan_number", lvseshipin.getZanNumber())
            .eq("cai_number", lvseshipin.getCaiNumber())
            .eq("lvseshipin_types", lvseshipin.getLvseshipinTypes())
            .eq("lvseshipin_danwei", lvseshipin.getLvseshipinDanwei())
            .eq("shangxia_types", lvseshipin.getShangxiaTypes())
            .eq("lvseshipin_delete", lvseshipin.getLvseshipinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LvseshipinEntity lvseshipinEntity = lvseshipinService.selectOne(queryWrapper);
        if(lvseshipinEntity==null){
            lvseshipin.setLvseshipinClicknum(1);
            lvseshipin.setShangxiaTypes(1);
            lvseshipin.setLvseshipinDelete(1);
            lvseshipin.setInsertTime(new Date());
            lvseshipin.setCreateTime(new Date());
            lvseshipinService.insert(lvseshipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LvseshipinEntity lvseshipin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,lvseshipin:{}",this.getClass().getName(),lvseshipin.toString());
        LvseshipinEntity oldLvseshipinEntity = lvseshipinService.selectById(lvseshipin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(lvseshipin.getLvseshipinPhoto()) || "null".equals(lvseshipin.getLvseshipinPhoto())){
                lvseshipin.setLvseshipinPhoto(null);
        }

            lvseshipinService.updateById(lvseshipin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LvseshipinEntity> oldLvseshipinList =lvseshipinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<LvseshipinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LvseshipinEntity lvseshipinEntity = new LvseshipinEntity();
            lvseshipinEntity.setId(id);
            lvseshipinEntity.setLvseshipinDelete(2);
            list.add(lvseshipinEntity);
        }
        if(list != null && list.size() >0){
            lvseshipinService.updateBatchById(list);
        }

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
            List<LvseshipinEntity> lvseshipinList = new ArrayList<>();//上传的东西
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
                            LvseshipinEntity lvseshipinEntity = new LvseshipinEntity();
//                            lvseshipinEntity.setLvseshipinName(data.get(0));                    //绿色食品名称 要改的
//                            lvseshipinEntity.setLvseshipinUuidNumber(data.get(0));                    //绿色食品编号 要改的
//                            lvseshipinEntity.setLvseshipinPhoto("");//详情和图片
//                            lvseshipinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            lvseshipinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            lvseshipinEntity.setLvseshipinTypes(Integer.valueOf(data.get(0)));   //绿色食品类型 要改的
//                            lvseshipinEntity.setLvseshipinNewMoney(data.get(0));                    //参考价格 要改的
//                            lvseshipinEntity.setLvseshipinDanwei(data.get(0));                    //单位 要改的
//                            lvseshipinEntity.setLvseshipinClicknum(Integer.valueOf(data.get(0)));   //绿色食品热度 要改的
//                            lvseshipinEntity.setLvseshipinContent("");//详情和图片
//                            lvseshipinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            lvseshipinEntity.setLvseshipinDelete(1);//逻辑删除字段
//                            lvseshipinEntity.setInsertTime(date);//时间
//                            lvseshipinEntity.setCreateTime(date);//时间
                            lvseshipinList.add(lvseshipinEntity);


                            //把要查询是否重复的字段放入map中
                                //绿色食品编号
                                if(seachFields.containsKey("lvseshipinUuidNumber")){
                                    List<String> lvseshipinUuidNumber = seachFields.get("lvseshipinUuidNumber");
                                    lvseshipinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> lvseshipinUuidNumber = new ArrayList<>();
                                    lvseshipinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("lvseshipinUuidNumber",lvseshipinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //绿色食品编号
                        List<LvseshipinEntity> lvseshipinEntities_lvseshipinUuidNumber = lvseshipinService.selectList(new EntityWrapper<LvseshipinEntity>().in("lvseshipin_uuid_number", seachFields.get("lvseshipinUuidNumber")).eq("lvseshipin_delete", 1));
                        if(lvseshipinEntities_lvseshipinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LvseshipinEntity s:lvseshipinEntities_lvseshipinUuidNumber){
                                repeatFields.add(s.getLvseshipinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [绿色食品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        lvseshipinService.insertBatch(lvseshipinList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<LvseshipinView> returnLvseshipinViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = lvseshipinCollectionService.queryPage(params1);
        List<LvseshipinCollectionView> collectionViewsList =(List<LvseshipinCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(LvseshipinCollectionView collectionView:collectionViewsList){
            Integer lvseshipinTypes = collectionView.getLvseshipinTypes();
            if(typeMap.containsKey(lvseshipinTypes)){
                typeMap.put(lvseshipinTypes,typeMap.get(lvseshipinTypes)+1);
            }else{
                typeMap.put(lvseshipinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("lvseshipinTypes",type);
            PageUtils pageUtils1 = lvseshipinService.queryPage(params2);
            List<LvseshipinView> lvseshipinViewList =(List<LvseshipinView>)pageUtils1.getList();
            returnLvseshipinViewList.addAll(lvseshipinViewList);
            if(returnLvseshipinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = lvseshipinService.queryPage(params);
        if(returnLvseshipinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnLvseshipinViewList.size();//要添加的数量
            List<LvseshipinView> lvseshipinViewList =(List<LvseshipinView>)page.getList();
            for(LvseshipinView lvseshipinView:lvseshipinViewList){
                Boolean addFlag = true;
                for(LvseshipinView returnLvseshipinView:returnLvseshipinViewList){
                    if(returnLvseshipinView.getId().intValue() ==lvseshipinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnLvseshipinViewList.add(lvseshipinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnLvseshipinViewList = returnLvseshipinViewList.subList(0, limit);
        }

        for(LvseshipinView c:returnLvseshipinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnLvseshipinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = lvseshipinService.queryPage(params);

        //字典表数据转换
        List<LvseshipinView> list =(List<LvseshipinView>)page.getList();
        for(LvseshipinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LvseshipinEntity lvseshipin = lvseshipinService.selectById(id);
            if(lvseshipin !=null){

                //点击数量加1
                lvseshipin.setLvseshipinClicknum(lvseshipin.getLvseshipinClicknum()+1);
                lvseshipinService.updateById(lvseshipin);

                //entity转view
                LvseshipinView view = new LvseshipinView();
                BeanUtils.copyProperties( lvseshipin , view );//把实体数据重构到view中

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
    public R add(@RequestBody LvseshipinEntity lvseshipin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,lvseshipin:{}",this.getClass().getName(),lvseshipin.toString());
        Wrapper<LvseshipinEntity> queryWrapper = new EntityWrapper<LvseshipinEntity>()
            .eq("lvseshipin_name", lvseshipin.getLvseshipinName())
            .eq("lvseshipin_uuid_number", lvseshipin.getLvseshipinUuidNumber())
            .eq("zan_number", lvseshipin.getZanNumber())
            .eq("cai_number", lvseshipin.getCaiNumber())
            .eq("lvseshipin_types", lvseshipin.getLvseshipinTypes())
            .eq("lvseshipin_danwei", lvseshipin.getLvseshipinDanwei())
            .eq("lvseshipin_clicknum", lvseshipin.getLvseshipinClicknum())
            .eq("shangxia_types", lvseshipin.getShangxiaTypes())
            .eq("lvseshipin_delete", lvseshipin.getLvseshipinDelete())
//            .notIn("lvseshipin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LvseshipinEntity lvseshipinEntity = lvseshipinService.selectOne(queryWrapper);
        if(lvseshipinEntity==null){
                lvseshipin.setZanNumber(1);
                lvseshipin.setCaiNumber(1);
            lvseshipin.setLvseshipinClicknum(1);
            lvseshipin.setLvseshipinDelete(1);
            lvseshipin.setInsertTime(new Date());
            lvseshipin.setCreateTime(new Date());
        lvseshipinService.insert(lvseshipin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

