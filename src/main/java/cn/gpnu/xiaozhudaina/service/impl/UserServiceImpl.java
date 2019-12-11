package cn.gpnu.xiaozhudaina.service.impl;

import cn.gpnu.xiaozhudaina.dao.UserDao;
import cn.gpnu.xiaozhudaina.entity.User;
import cn.gpnu.xiaozhudaina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public User login(String username, String phoneNumber) {
        User user = userDao.findUserByUsername(username);
        if (user != null && phoneNumber.equals(user.password)){
            return user;
        }
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public boolean modifyUser(User user) {
        try {
            int effectNum = userDao.updateUser(user);
            if (effectNum != 1){
                return false;
            }
        } catch (BadSqlGrammarException e) {
            return false;
        }
        return true;
    }
}
