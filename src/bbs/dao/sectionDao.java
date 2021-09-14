package bbs.dao;

import bbs.entity.Section;

import java.sql.SQLException;
import java.util.List;

public interface sectionDao {
    /**
     * 通过sectionId获取版块信息
     * @param sectionId
     * @return
     */
    public Section getSectionInfoBySectionId(int sectionId) throws SQLException, ClassNotFoundException;

    /**
     * 增加版块
     * @param section
     * @return
     */
    public int addSection(Section section) throws SQLException, ClassNotFoundException;

    /**
     * 通过版块id删除版块
     * @param sectionId
     * @return
     */
    public int deleteSectionBySectionId(int sectionId) throws SQLException, ClassNotFoundException;

    /**
     * 修改版块信息
     * @param section
     * @return
     */
    public int editSectionInfo(Section section) throws SQLException, ClassNotFoundException;

    /**
     *
     * @return
     */
    public List<Section> getAllSection() throws SQLException, ClassNotFoundException;
}
