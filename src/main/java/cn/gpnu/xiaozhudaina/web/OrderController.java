package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.entity.Order;
import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/isexistorder",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> isExistOrder(@RequestParam("orderno")String orderNo){
        Map<String,Object> modelMap = new HashMap<String,Object> ();
        boolean exist = orderService.isExistOrder(orderNo);
        if (exist){
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
        }
        return modelMap;
    }


    @RequestMapping(value = "/getorderlist",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getOrderList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object> ();
        User currentUser = (User)(request.getSession().getAttribute("currentUser"));
        if (currentUser != null){
            Integer userId = currentUser.getUserId();
            List<Order> orderList = orderService.queryOrderList(userId);
            modelMap.put("success",true);
            modelMap.put("orderList",orderList);
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","未登录，请先登录。");
        }
        return modelMap;
    }
}
