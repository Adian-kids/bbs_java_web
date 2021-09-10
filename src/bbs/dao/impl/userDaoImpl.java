package bbs.dao.impl;

import bbs.dao.userDao;
import bbs.entity.User;

public class userDaoImpl implements userDao {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return 0;
    }

    /**
     * 编辑用户信息(不包括密码和邮箱)
     *
     * @param user
     * @return
     */
    @Override
    public int editUserInfo(User user) {
        return 0;
    }

    /**
     * 通过UserId删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteUserByUserId(int userId) {
        return 0;
    }

    /**
     * 通过userId获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserInfoById(int userId) {
        return null;
    }

    /**
     * 修改用户密码
     *
     * @param userId
     * @return
     */
    @Override
    public int changePassByUserId(int userId) {
        return 0;
    }
}
