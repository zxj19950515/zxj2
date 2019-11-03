package com.qf.controller;


import com.qf.domain.Goods;
import com.qf.domain.Shoper;
import com.qf.service.GoodsService;
import com.qf.utils.PageUtil;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UploadUtils uploadUtils;

    @RequestMapping("/goodsAll")
    public String selectAll(PageUtil pageP, Model model) {
        Goods goods = new Goods();
        PageUtil page = new PageUtil();
        //pageSize默认为10  currentPage默认为1
        page.setPageSize(pageP.getPageSize());
        page.setCurrentPage(pageP.getCurrentPage());
        int startRow = pageP.getStartRow();
        int endRow = pageP.getEndRow();
        goods.setStartRow(startRow);
        goods.setEndRow(endRow - startRow);
        Integer count = goodsService.count();
        List<Goods> goods1 = goodsService.selectAll(goods);
        page.setTotalRecord(count);
        model.addAttribute("goodsList",goods1);
        model.addAttribute("page1",page);
        return "/goods/goodsManager";
    }

    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        goodsService.deleteById(id);
        return "redirect:/goods/goodsAll";
    }

    @RequestMapping("/testAdd")
    public String testAdd(){
        return "/goods/add";
    }

    @RequestMapping("/add")
    public String add(Goods goods) {
        int insert = goodsService.insert(goods);
        return "redirect:/goods/goodsAll";
    }


    @RequestMapping("/selectById/{id}")
    public ModelAndView getModel(@PathVariable("id") Integer id){
        Goods goods = new Goods();
        Goods goods1 = goodsService.selectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goods1",goods1);
        modelAndView.setViewName("/goods/update");
        return modelAndView;

    }

    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public  String update(Integer id, String shopName , String shopStatus , String shopDetil ,Integer posId , String createTime , String updateTime){
        Goods goods = new Goods();
        goods.setShopName(shopName);
        goods.setShopStatus(shopStatus);
        goods.setShopDetil(shopDetil);
        goods.setPosId(posId);
        goods.setCreateTime(createTime);
        goods.setUpdateTime(updateTime);
        goodsService.updateGoods(goods);
        return "redirect:/goods/shopAll";
    }
}
