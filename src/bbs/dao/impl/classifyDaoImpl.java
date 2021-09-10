package bbs.dao.impl;

import bbs.dao.classifyDao;
import bbs.entity.Classify;

import java.util.List;

public class classifyDaoImpl implements classifyDao {
    /**
     * 通过classifyId获取分类信息
     *
     * @param classifyId
     */
    @Override
    public Classify getClassifyContentByClassifyId(int classifyId) {
        return null;
    }

    /**
     * 通过classifyId获取所有版块sectionId
     *
     * @param classifyId
     */
    @Override
    public List getAllSectionIdByClassifyId(int classifyId) {
        return null;
    }

    /**
     * 新增一个classify
     *
     * @param classify
     */
    @Override
    public int addClassifyById(Classify classify) {
        return 0;
    }

    /**
     * 通过classifyId删除一个classify
     *
     * @param classifyId
     */
    @Override
    public int deleteClassifyByClassifyId(int classifyId) {
        return 0;
    }

    /**
     * 修改classify内容
     *
     * @param classify
     */
    @Override
    public int editClassifyInfo(Classify classify) {
        return 0;
    }
}
