package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> login(@RequestParam("password") String password, @RequestParam("username")String username, HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        HttpSession session = request.getSession();
        //非空判断
        if (username != null && password != null && !("".equals(username)) && !("".equals(password))){
            User user = userService.login(username, password);
            if (user != null){
                modelMap.put("success",true);
                session.setAttribute("currentUser",user);
                return modelMap;
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg","账号或密码错误，请重新填写。");
            }
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","账号或密码不能为空");
        }
        return modelMap;
    }

    @RequestMapping(value = "/getuserinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getUserInfo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Object currentUser = request.getSession().getAttribute("currentUser");
        try{
            Integer userId = ((User)currentUser).getUserId();
            User user = userService.getUserById(userId);
            user.setPassword("");
            modelMap.put("success",true);
            modelMap.put("user",user);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object> ();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> file = multipartRequest.getFiles("file");
            try {

            }catch (Exception e){

            }
        }
        return modelMap;
    }
}
