package com.qf.controller;

import com.qf.domain.ShopPic;
import com.qf.service.ShopPicService;
import com.qf.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 54110 on 2019-05-27.
 */
@Controller
@RequestMapping("/pic")
public class ShopPicController {

    @Autowired
    private ShopPicService shopPicService;
    @RequestMapping("/picAll")
    public String picAll(Model model, ShopPic shopPic,PageUtil pageP){
        int count = shopPicService.selectUserCount();
        PageUtil page = new PageUtil();
        page.setPageSize(pageP.getPageSize());
        page.setCurrentPage(pageP.getCurrentPage());
        //mysql中用 --这里用limit a,b 去分页，数据量比较大时不推荐limit
        //a表示起始行，b表示数量，如 limit 0,5 表示查5条数据，从数据库中的第一条查起
        shopPic.setStartRow(page.getStartRow());
        shopPic.setEndRow(page.getEndRow()-page.getStartRow());
        List<ShopPic> shopPicList = shopPicService.selectAll(shopPic);
        if((shopPic.getStatus()!=null&&!"".equals(shopPic.getStatus()))
                ){
            page.setTotalRecord(shopPicList.size());
        }else{
            page.setTotalRecord(count);
        }

        model.addAttribute("shopPicList",shopPicList);
        model.addAttribute("page1",page);
        return "/pic/shopManager";
    }

    @RequestMapping("/updateStatus/{id}/{status}")
    public String updateStatus(@PathVariable("id") Integer id,@PathVariable("status") String status){
        ShopPic shopPic = new ShopPic();
        shopPic.setId(id);
        shopPic.setStatus(status);
        shopPicService.updateStatus(shopPic);
        return "redirect:/pic/picAll";

    }
}
