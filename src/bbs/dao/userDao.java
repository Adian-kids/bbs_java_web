package bbs.dao;

import bbs.entity.User;

import javax.swing.plaf.PanelUI;

public interface userDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 编辑用户信息(不包括密码和邮箱)
     * @param user
     * @return
     */
    public int editUserInfo(User user);

    /**
     * 通过UserId删除用户
     * @param userId
     * @return
     */
    public int deleteUserByUserId(int userId);

    /**
     * 通过userId获取用户信息
     * @param userId
     * @return
     */
    public User getUserInfoById(int userId);

    /**
     * 修改用户密码
     * @param userId
     * @return
     */
    public int changePassByUserId(int userId);

}
