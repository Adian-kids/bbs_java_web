package bbs.dao.impl;

import bbs.dao.userDao;
import bbs.entity.User;
import bbs.utils.md5;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class userDaoImpl implements userDao {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String email = user.getEmail();
        int checkEmailResult = this.checkEmail(email);
        if (checkEmailResult == 1){
            String nickname = "游客"+email;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time = df.format(new Date());// new Date()为获取当前系统时间
            // md5 pass
            String passwd = new md5().md5Encrypt(user.getPassword());
            baseDao basedao = new baseDao();
            String sqlString = "INSERT INTO users (email,passwd,nickname,regTime) VALUES (?,?,?,?)";
            String[] params = {email,passwd,nickname,time};
            Map insertResult = basedao.sqlQuery(sqlString,params);
            int rowNum = (int) insertResult.get("rowNum");
            return rowNum;
        }else{
            return -1;
        }
    }
    /**
     * 检查邮箱是否已经注册
     * @param email
     */
    public int checkEmail(String email) throws SQLException, ClassNotFoundException {
        String sqlString = "SELECT * FROM users WHERE email='"+email+"'";
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");

        if (selectResultSet.next()){
            return 0;
        }else {
            return 1;
        }
    }
    /**
     * 编辑用户信息(不包括密码和邮箱)
     *
     * @param user
     * @return
     */
    @Override
    public int editUserInfo(User user) throws SQLException, ClassNotFoundException {
        int userId = user.getUserId();
        String nickname = user.getNickName();
        String signature = user.getSignature();
        String sqlString = "UPDATE users SET nickname=?,signature=? WHERE userId=?";
        String[] params = {nickname,signature,Integer.toString(userId)};
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) updateResult.get("rowNum");
        return rowNum;
    }

    /**
     * 通过UserId删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteUserByUserId(int userId) throws SQLException, ClassNotFoundException {
        String sqlString = "DELETE FROM users WHERE userId=?";
        String[] params = {Integer.toString(userId)};
        baseDao basedao = new baseDao();
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }

    /**
     * 通过userId获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserInfoById(int userId) throws SQLException, ClassNotFoundException {
        User user = new User();
        String sqlString = "SELECT nickname,email,signature,picture,regTime FROM users WHERE userId=?";
        String[] params = {Integer.toString(userId)};
        baseDao basedao = new baseDao();
        Map selectResult  = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            user.setUserId(userId);
            user.setEmail(selectResultSet.getString("email"));
            user.setNickName(selectResultSet.getString("nickname"));
            user.setPicture(selectResultSet.getString("picture"));
            user.setRegTime(selectResultSet.getString("regTime"));
        }
        return user;
    }

    /**
     * 修改用户密码
     *
     * @param userId
     * @return
     */
    @Override
    public int changePassByUserId(int userId,String oldPass,String passwd) throws SQLException, ClassNotFoundException {
        baseDao basedao = new baseDao();
        String checkSqlString = "SELECT passwd FROM users WHERE userId=" + Integer.toString(userId);
        Map selectResult = basedao.sqlQuery(checkSqlString,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        if (selectResultSet != null){
            return -1;
        }
        String sqlString = "UPDATE users SET passwd=? WHERE userId=?";
        String[] params = {passwd,Integer.toString(userId)};
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) updateResult.get("rowNum");
        return rowNum;
    }

    /**
     * 检查登陆
     *
     * @param user
     */
    @Override
    public int userLoginCheck(User user) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String sqlString = "SELECT * FROM users WHERE email=?";
        String[] params = {user.getEmail()};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        if (selectResultSet.next()){
            String passwd  = selectResultSet.getString("passwd");
            String passwdForm = new md5().md5Encrypt(user.getPassword());
            if(passwdForm.equals(passwd)){
                return 1;
            }else {
                return 0;
            }
        }else {
            return 0;
        }
    }
}
