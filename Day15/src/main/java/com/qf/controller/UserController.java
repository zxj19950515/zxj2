package com.qf.controller;

import com.alibaba.fastjson.JSONArray;
import com.qf.dao.QfShopMapper;
import com.qf.domain.ShopNode;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.PageUtil;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 54110 on 2019-05-24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadUtils uploadUtils;

    String url;
    @RequestMapping("/register")
    public String register(User user , Model model){
        try {
            User userLogin = userService.selectUserByLoginName(user.getLoginName());
            if(userLogin!=null){
                model.addAttribute("msg","注册失败,该登入名已存在！");
            }else{
                userService.insertUser(user);
                model.addAttribute("msg","注册成功，请登入！ ");
            }
        }catch (Exception e){
            model.addAttribute("msg","注册失败！");
            e.printStackTrace();
        }
        return "system/login";
    }

    @RequestMapping("/login")
    public String login(Model model,User user,HttpServletRequest request){
        User userLogin = userService.selectUserByLoginName(user.getLoginName());
        if(userLogin==null){
            model.addAttribute("msg","登录失败,没有该账号！");
            return "system/login";
        }else if(userLogin.getStatus().equals("0")){
            model.addAttribute("msg","用户状态为失效状态，禁止登录！请联系管理员");
            return "system/login";
        }else if(userLogin.getPassword().equals(user.getPassword())){
            /*将用户信息放入session*/
            request.getSession().setAttribute("userInfo",userLogin);
            //获取sessionid
            String sessionId=request.getSession().getId();
            model.addAttribute("sessionId",sessionId);
            return "system/main";
        }
        return "system/login";
    }

    @RequestMapping("/selectAll")
    public String selectAll(Model model,User userInfo,PageUtil pageP){

        int count = userService.selectUserCount();
        PageUtil page = new PageUtil();
        //pageSize默认为10  currentPage默认为1
        page.setPageSize(pageP.getPageSize());
        page.setCurrentPage(pageP.getCurrentPage());
        //mysql中用 --这里用limit a,b 去分页，数据量比较大时不推荐limit
        //a表示起始行，b表示数量，如 limit 0,5 表示查5条数据，从数据库中的第一条查起
        userInfo.setStartRow(page.getStartRow());
        userInfo.setEndRow(page.getEndRow()-page.getStartRow());
        List<User> userList= userService.selectAll(userInfo);
        if((userInfo.getUserName()!=null&&!"".equals(userInfo.getUserName()))
                ||(userInfo.getLoginName()!=null&&!"".equals(userInfo.getLoginName()))){
            page.setTotalRecord(userList.size());
        }else{
            page.setTotalRecord(count);
        }

        model.addAttribute("userList",userList);
        model.addAttribute("page1",page);
        model.addAttribute("userInfo1",userInfo);
        return "user/userManager";
    }

    /**
     * 新增或编辑用户信息
     * @param userInfo
     * @param model
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser( @RequestParam("file")MultipartFile file,User userInfo, Model model, String myid){
        try {
            User user = userService.selectUserByLoginName(userInfo.getLoginName());
            Integer picId=null;
            if (file!=null&&!file.getOriginalFilename().equals("")){
                picId= uploadUtils.savePic(file);
            }
            if(myid==null&&user!=null){
                    model.addAttribute("msg","操作失败,该登入名已存在！");
            }else{
                if(myid!=null&&!"".equals(myid)){//myid存在表示编辑操作
                    userInfo.setId(Integer.parseInt(myid));
                    if(picId!=null){

                        userInfo.setUserPic(picId);
                    }
                    userService.updateUser(userInfo);
                }else{
                    if(picId!=null){
                        userInfo.setUserPic(picId);
                    }
                    userService.insertUser(userInfo);
                }
                model.addAttribute("msg","操作成功！");
            }
        }catch (Exception e){
            model.addAttribute("msg","操作失败！");
            e.printStackTrace();
        }
        return "redirect:/user/selectAll";
    }

    /**
     * 根据ID获取用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("selectUserById")
    @ResponseBody
    public User selectUserById(int id,Model model){
        User userInfo = userService.selectUserById(id);
        return userInfo;
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        try {
            userService.deleteUser(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 退出系统
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        //清空session
        request.getSession().invalidate();
        return "system/login";
    }
    @Autowired
    private QfShopMapper qfShopMapper;
    @RequestMapping("/shopList")
    private ModelAndView shopList(){
        ModelAndView md = new ModelAndView();
        ShopNode shopNodeList = qfShopMapper.selectList();
        String string = JSONArray.toJSONString(shopNodeList);
        md.setViewName("/user/shopNode");
        md.addObject("shopNode",string);
        return md;
    }

}
