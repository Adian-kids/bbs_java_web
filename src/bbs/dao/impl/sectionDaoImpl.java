package bbs.dao.impl;

import bbs.dao.sectionDao;
import bbs.entity.Section;

public class sectionDaoImpl implements sectionDao {
    /**
     * 通过sectionId获取版块信息
     *
     * @param sectionId
     * @return
     */
    @Override
    public Section getSectionInfoBySectionId(int sectionId) {
        return null;
    }

    /**
     * 增加版块
     *
     * @param section
     * @return
     */
    @Override
    public int addSection(Section section) {
        return 0;
    }

    /**
     * 通过版块id删除版块
     *
     * @param sectionId
     * @return
     */
    @Override
    public int deleteSectionBySectionId(int sectionId) {
        return 0;
    }

    /**
     * 修改版块信息
     *
     * @param section
     * @return
     */
    @Override
    public int editSectionInfo(Section section) {
        return 0;
    }
}
