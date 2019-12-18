package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.entity.Order;
import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> submitOrder(@RequestBody Order order, HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object> ();
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        System.out.println(order);
        if (currentUser != null){
            Integer userId = currentUser.getUserId();
            order.setUserId(userId);
            order.setCreateTime(new Date());
            order.setOrderStatus(0);
            int res = orderService.submitOrder(order);
            if (res == 1){
                modelMap.put("success",true);
                modelMap.put("message","success");
            }else{
                modelMap.put("success",false);
                modelMap.put("message","error");
            }
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","未登录，请先登录。");
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
