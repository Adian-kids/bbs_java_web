package bbs.dao;

import bbs.entity.Classify;

import java.sql.SQLException;
import java.util.List;

public interface classifyDao {
    /**
     * 通过classifyId获取分类信息
     * @param classifyId
     */
    public Classify getClassifyContentByClassifyId(int classifyId) throws SQLException, ClassNotFoundException;
    /**
     * 通过classifyId获取所有版块sectionId
     * @param classifyId
     */
    public List getAllSectionContentByClassifyId(int classifyId) throws SQLException, ClassNotFoundException;
    /**
     * 新增一个classify
     * @param classify
     */
    public int addClassify(Classify classify) throws SQLException, ClassNotFoundException;
    /**
     * 通过classifyId删除一个classify
     * @param classifyId
     */
    public int deleteClassifyByClassifyId(int classifyId) throws SQLException, ClassNotFoundException;
    /**
     * 修改classify内容
     * @param classify
     */
    public int editClassifyInfo(Classify classify) throws SQLException, ClassNotFoundException;
}
