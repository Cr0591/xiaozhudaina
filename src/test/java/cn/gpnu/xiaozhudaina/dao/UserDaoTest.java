package cn.gpnu.xiaozhudaina.dao;


import cn.gpnu.xiaozhudaina.BaseTest;
import cn.gpnu.xiaozhudaina.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class UserDaoTest extends BaseTest {

    @Autowired
    public UserDao userDao;

    @Test
    public void testFindUserById(){
        System.out.println("123");
        User user = userDao.findUserById(1);
        System.out.println(user.username);
        System.out.println(user.password);
        System.out.println(user.phoneNumber);
        System.out.println(user.dormAddr);
    }
    @Test
    public void testFindUserByUsername(){
        User user = userDao.findUserByUsername("Cr");

        System.out.println(user.username);
        System.out.println(user.password);
        System.out.println(user.phoneNumber);
        System.out.println(user.dormAddr);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUserId(1);
        user.setDormAddr("七栋");
        int effectedNum = userDao.updateUser(user);
        assertEquals(effectedNum,1);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("lcr");
        user.setPassword("123");
        user.setPhoneNumber("12345678910");
        int effectedNum = userDao.insertUser(user);
        assertEquals(1,effectedNum);
    }
}
