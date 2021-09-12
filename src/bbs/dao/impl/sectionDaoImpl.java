package bbs.dao.impl;

import bbs.dao.sectionDao;
import bbs.entity.Section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class sectionDaoImpl implements sectionDao {
    /**
     * 通过sectionId获取版块信息
     *
     * @param sectionId
     * @return
     */
    @Override
    public Section getSectionInfoBySectionId(int sectionId) throws SQLException, ClassNotFoundException {
        Section section = new Section();
        String sqlString = "SELECT * FROM section WHERE sectionId=?";
        String[] params = {Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            section.setSectionId(sectionId);;
            section.setName(selectResultSet.getString("name"));
            section.setClassifyId(selectResultSet.getInt("classifyId"));
        }
        return section;
    }

    /**
     * 增加版块
     *
     * @param section
     * @return
     */
    @Override
    public int addSection(Section section) throws SQLException, ClassNotFoundException {
        String name = section.getName();
        int classifyId = section.getClassifyId();
        String sqlString = "INSERT INTO section (name,classifyId) VALUES (?,?)";
        String[] params = {name,Integer.toString(classifyId)};
        baseDao basedao = new baseDao();
        Map insertResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) insertResult.get("rowNum");
        return rowNum;
    }

    /**
     * 通过版块id删除版块
     *
     * @param sectionId
     * @return
     */
    @Override
    public int deleteSectionBySectionId(int sectionId) throws SQLException, ClassNotFoundException {
        String sqlString = "DELETE FROM section WHERE sectionId=?";
        String[] params = {Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }

    /**
     * 修改版块信息
     *
     * @param section
     * @return
     */
    @Override
    public int editSectionInfo(Section section) throws SQLException, ClassNotFoundException {
        String name = section.getName();
        int sectionId = section.getSectionId();
        int classifyId = section.getClassifyId();
        String sqlString = "UPDATE section SET name=?,classifyId=? WHERE sectionId=?";
        String[] params = {name,Integer.toString(classifyId),Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) updateResult.get("rowNum");
        return rowNum;
    }
}
