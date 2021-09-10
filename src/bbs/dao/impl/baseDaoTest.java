package bbs.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import bbs.dao.impl.baseDao;

class baseDaoTest extends baseDao{
    public static void main(String[] args) {
        String sql = "SELECT * FROM forum";
        baseDao basedao = new baseDao();
        try {
            Map result = basedao.sqlQuery(sql,null);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}