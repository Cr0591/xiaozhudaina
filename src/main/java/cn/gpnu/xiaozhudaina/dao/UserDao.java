package cn.gpnu.xiaozhudaina.dao;

import cn.gpnu.xiaozhudaina.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.BadSqlGrammarException;

public interface UserDao {
    /**
     * 通过Id查询用户
     *
     * @param userId
     * @return
     */
    User findUserById(@Param("userId") Integer userId);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User findUserByUsername(@Param("username") String username);

    /**
     * 更新用户信息
     *
     * @return
     */
    int updateUser(User user) throws BadSqlGrammarException;

}
