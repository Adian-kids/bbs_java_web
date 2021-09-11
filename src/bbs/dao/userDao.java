package bbs.dao;

import bbs.entity.User;

import javax.swing.plaf.PanelUI;
import java.sql.SQLException;

public interface userDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user) throws SQLException, ClassNotFoundException;
    /**
     * 检查邮箱是否已经注册
     * @param email
     */
    public int checkEmail(String email) throws SQLException, ClassNotFoundException;
    /**
     * 编辑用户信息(不包括密码和邮箱)
     * @param user
     * @return
     */
    public int editUserInfo(User user) throws SQLException, ClassNotFoundException;

    /**
     * 通过UserId删除用户
     * @param userId
     * @return
     */
    public int deleteUserByUserId(int userId) throws SQLException, ClassNotFoundException;

    /**
     * 通过userId获取用户信息
     * @param userId
     * @return
     */
    public User getUserInfoById(int userId) throws SQLException, ClassNotFoundException;

    /**
     * 修改用户密码
     * @param userId
     * @return
     */
    public int changePassByUserId(int userId,String oldPass,String passwd) throws SQLException, ClassNotFoundException;

}
