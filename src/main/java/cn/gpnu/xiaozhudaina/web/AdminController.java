package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.dto.UserOrder;
import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping(value = "/getalllist",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<UserOrder> userOrderList = userOrderService.getAllList();
        User user = (User)request.getSession().getAttribute("currentUser");
        if (user != null && user.getUserId() == 1){
            int count = userOrderService.getAllListCount();
            modelMap.put("success",true);
            modelMap.put("total",count);
            modelMap.put("userOrderList",userOrderList);
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","不是管理员，无法进行操作。");
        }
        return modelMap;
    }
}
