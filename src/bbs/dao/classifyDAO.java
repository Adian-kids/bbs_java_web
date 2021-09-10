package bbs.dao;

import bbs.entity.Classify;

public interface classifyDAO {
    /**
     * 通过classifyId获取分类信息
     * @param classifyId
     */
    public Classify getClassifyContentById(int classifyId);
    /**
     * 通过classifyId获取所有版块sectionId
     * @param classifyId
     */
    public int[] getAllSectionIdById(int classifyId);
    /**
     * 新增一个classify
     * @param classify
     */
    public int addClassifyById(Classify classify);
    /**
     * 通过classifyId删除一个classify
     * @param classifyId
     */
    public int deleteClassifyById(int classifyId);
    /**
     * 通过classifyId修改name
     * @param classifyId
     */
    public int editClassifyNameById(int classifyId);
}
