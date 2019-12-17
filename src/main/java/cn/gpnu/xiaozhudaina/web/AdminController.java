package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.dto.UserOrder;
import cn.gpnu.xiaozhudaina.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private Map<String,Object> getAllList(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<UserOrder> userOrderList = userOrderService.getAllList();
        int count = userOrderService.getAllListCount();
        modelMap.put("success",true);
        modelMap.put("count",count);
        modelMap.put("userOrderList",userOrderList);
        return modelMap;
    }
}
