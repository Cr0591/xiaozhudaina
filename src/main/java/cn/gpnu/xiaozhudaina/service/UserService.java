package cn.gpnu.xiaozhudaina.service;

import cn.gpnu.xiaozhudaina.entity.User;

public interface UserService {
    /**
     * 判断是否登录
     * @param username
     * @param phoneNumber
     * @return
     */
    User login(String username, String phoneNumber);

    /**
     * 根据UserId得到用户
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 用户修改信息
     * @param user
     * @return
     */
    boolean modifyUser(User user);

    /**
     * 用于用户注册
     * @return
     */
    int userRegister(User user);
}
