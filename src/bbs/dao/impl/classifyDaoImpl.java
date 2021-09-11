package bbs.dao.impl;

import bbs.dao.classifyDao;
import bbs.entity.Classify;
import bbs.entity.Section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class classifyDaoImpl implements classifyDao  {
    /**
     * 通过classifyId获取分类信息
     *
     * @param classifyId
     */
    @Override
    public Classify getClassifyContentByClassifyId(int classifyId) throws SQLException, ClassNotFoundException {
        Classify classify = new Classify();
        String sqlString = "SELECT * FROM classify WHERE classifyId=?";
        baseDao basedao = new baseDao();
        String[] params = {Integer.toString(classifyId)};
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
            classify.setClassifyId(classifyId);
            classify.setName(selectResultSet.getString("name"));
        }
        return classify;
    }

    /**
     * 通过classifyId获取所有版块sectionId
     *
     * @param classifyId
     */
    @Override
    public List getAllSectionContentByClassifyId(int classifyId) throws SQLException, ClassNotFoundException {
        List resultList = new ArrayList();
        String sqlString = "SELECT sectionId,name FROM section WHERE classifyId=?";
        String[] params = {Integer.toString(classifyId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
            Section section = new Section();
            section.setClassifyId(classifyId);
            section.setSectionId(selectResultSet.getInt("sectionId"));
            section.setName(selectResultSet.getString("name"));
            resultList.add(section);
        }

        return resultList;
    }

    /**
     * 新增一个classify
     *
     * @param classify
     */
    @Override
    public int addClassify(Classify classify) throws SQLException, ClassNotFoundException {
        String[] params = {classify.getName()};
        String sqlString = "INSERT INTO classify (name) VALUES (?)";
        baseDao basedao = new baseDao();
        Map insertResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) insertResult.get("rowNum");
        return rowNum;
    }

    /**
     * 通过classifyId删除一个classify
     *
     * @param classifyId
     */
    @Override
    public int deleteClassifyByClassifyId(int classifyId) throws SQLException, ClassNotFoundException {
        String[] params = {Integer.toString(classifyId)};
        baseDao basedao = new baseDao();
        String sqlString = "DELETE FROM classify WHERE classifyId=?";
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }

    /**
     * 修改classify内容
     *
     * @param classify
     */
    @Override
    public int editClassifyInfo(Classify classify) throws SQLException, ClassNotFoundException {
        String name = classify.getName();
        int classifyId = classify.getClassifyId();
        String[] params = {name,Integer.toString(classifyId)};
        String sqlString = "UPDATE forum SET name=? WHERE classifyId=?";
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int resultCode = (int) updateResult.get("rowNum");
        return resultCode;
    }
}
