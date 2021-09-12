package bbs.dao.impl;

import bbs.dao.managerDao;
import bbs.entity.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class managerDaoImpl implements managerDao {
    /**
     * 通过userId添加管理员
     *
     * @param manager
     * @return
     */
    @Override
    public int addManagerByUserId(Manager manager) throws SQLException, ClassNotFoundException {
        int userId = manager.getUserId();
        int sectionId = manager.getSectionId();
        int level = manager.getLevel();
        String sqlString = "INSERT INTO manager (userId,level,sectionId) VALUES (?,?,?)";
        String[] params = {Integer.toString(userId), Integer.toString(level), Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map insertResult = basedao.sqlQuery(sqlString, params);
        int rowNum = (int) insertResult.get("rowNum");
        return rowNum;
    }

    /**
     * 通过managerId删除管理员信息
     *
     * @param manager
     * @return
     */
    @Override
    public int deleteManagerByUserId(Manager manager) throws SQLException, ClassNotFoundException {
        int userId = manager.getUserId();
        int sectionId = manager.getSectionId();
        String sqlString = "DELETE FROM manager WHERE userId=? and sectionId=?";
        String[] params = {Integer.toString(userId), Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map insertResult = basedao.sqlQuery(sqlString, params);
        int rowNum = (int) insertResult.get("rowNum");
        return rowNum;
    }


    /**
     * 获取所有管理员信息
     *
     * @return
     */
    @Override
    public List getAllManagerInfo() throws SQLException, ClassNotFoundException {
        List managerList = new ArrayList();
        String sqlString = "SELECT * FROM manager";
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString, null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
            managerList.add(selectResultSet.getInt("sectionId"));
        }


        return managerList;
    }

    /**
     * 通过userId获取其版块管理权限
     *
     * @param userId
     * @return
     */
    @Override
    public List getManagerInfoByUserId(int userId) throws SQLException, ClassNotFoundException {
        List managerList = new ArrayList();
        String sqlString = "SELECT * FROM manager WHERE userId=?";
        String[] params = {Integer.toString(userId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString, params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
            managerList.add(selectResultSet.getInt("sectionId"));
        }


        return managerList;
    }

    /**
     * 查询某一section下所有管理员信息
     *
     * @param sectionId
     * @return
     */
    @Override
    public List getManagerInfoBySectionId(int sectionId) throws SQLException, ClassNotFoundException {
        List managerList = new ArrayList();
        String sqlString = "SELECT * FROM manager WHERE sectionId=?";
        String[] params = {Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString, params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
            managerList.add(selectResultSet.getInt("sectionId"));
        }


        return managerList;
    }
}