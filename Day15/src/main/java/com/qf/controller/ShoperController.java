package com.qf.controller;

import com.qf.domain.Shoper;
import com.qf.service.ShoperService;
import com.qf.utils.PageUtil;
import com.qf.utils.UploadUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShoperController {
    @Autowired
    private ShoperService shoperService;
    @Autowired
    private UploadUtils uploadUtils;

    @RequestMapping("/shopAll")
   public String selectAll(PageUtil pageP, Model model) {
        Shoper shoper = new Shoper();
        PageUtil page = new PageUtil();
        //pageSize默认为10  currentPage默认为1
        page.setPageSize(pageP.getPageSize());
        page.setCurrentPage(pageP.getCurrentPage());
        int startRow = pageP.getStartRow();
        int endRow = pageP.getEndRow();
        shoper.setStartRow(startRow);
        shoper.setEndRow(endRow - startRow);
        Integer count = shoperService.count();
        List<Shoper> shopers = shoperService.selectAll(shoper);
        page.setTotalRecord(count);
        model.addAttribute("shoperList",shopers);
        model.addAttribute("page1",page);
        return "/shoper/shoperManager";
    }
    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        Shoper shoper = new Shoper();
        shoper.setId(id);
        int i = shoperService.deleteById(id);
        return "redirect:/shop/shopAll";

    }

    @RequestMapping("/selectById/{id}")
    public ModelAndView getModel(@PathVariable("id") Integer id){
        Shoper shoper = new Shoper();
        Shoper shoper1 =shoperService.selectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("shoper1",shoper1);
        modelAndView.setViewName("/shoper/update");
        return modelAndView;

    }

    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public  String update(Integer id, String posName , String posStatus , String posTime ){
        Shoper shoper = new Shoper();
       shoper.setId(id);
       shoper.setPosName(posName);
       shoper.setPosStatus(posStatus);
       shoper.setPosTime(posTime);
        shoperService.updateUser(shoper);
        return "redirect:/shop/shopAll";
    }

    @RequestMapping("/testAdd")
    public String testAdd(){
        return "/shoper/add";
    }

    @RequestMapping("/add")
    public String add(Shoper shoper) {
        int insert = shoperService.insert(shoper);
        return "redirect:/shop/shopAll";
    }
}
