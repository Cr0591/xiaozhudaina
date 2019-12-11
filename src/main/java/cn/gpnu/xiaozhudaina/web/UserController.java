package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.UserService;
import cn.gpnu.xiaozhudaina.util.ImageUtil;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    /**
     * 登录  且登录后将用户存在Session中currentUser   方便其他方法校验是否登陆
     * @param password
     * @param username
     * @param request
     * @return
     */
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

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object> ();
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        Integer userId = currentUser.getUserId();
        if (currentUser != null){//用户已登陆
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> fileList = multipartRequest.getFiles("file");
            try {
                for (MultipartFile file:fileList){
                    String dest = ImageUtil.generateThumbnail(file, userId);
                    currentUser.setImgAddr(dest);
                    try {
                        userService.modifyUser(currentUser);
                    } catch (BadSqlGrammarException e) {
                        modelMap.put("success",false);
                        modelMap.put("errMsg",e.getMessage());
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                modelMap.put("success",false);
                modelMap.put("errMsg","图片上传失败，请重新提交。");
                e.printStackTrace();
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请先登录，登录后才能设置信息。");
        }
        modelMap.put("success",true);
        return modelMap;
    }
}
