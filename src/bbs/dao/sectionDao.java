package bbs.dao;

import bbs.entity.Section;

public interface sectionDao {
    /**
     * 通过sectionId获取版块信息
     * @param sectionId
     * @return
     */
    public Section getSectionInfoBySectionId(int sectionId);

    /**
     * 增加版块
     * @param section
     * @return
     */
    public int addSection(Section section);

    /**
     * 通过版块id删除版块
     * @param sectionId
     * @return
     */
    public int deleteSectionBySectionId(int sectionId);

    /**
     * 修改版块信息
     * @param section
     * @return
     */
    public int editSectionInfo(Section section);
}
