package cn.gpnu.xiaozhudaina.Service;

import cn.gpnu.xiaozhudaina.BaseTest;
import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertEquals;

public class UserServiceTest extends BaseTest {
    @Autowired
    public UserService userService;

    @Test
    public void testLogin(){
        String username = "Cra";
        String password = "123";
        System.out.println(userService);
        User user = userService.login(username, password);
        System.out.println(user);
        //assertEquals("13192700591".equals(user.phoneNumber),true);
    }

    @Test
    public void testUserRegister(){
        User user = new User();
        user.setUsername("ych");
        user.setPassword("123");
        user.setPhoneNumber("12315415312");
        int effectedNum = userService.userRegister(user);
        assertEquals(effectedNum,1);
    }
}
