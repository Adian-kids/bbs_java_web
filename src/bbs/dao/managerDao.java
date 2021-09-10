package bbs.dao;

import bbs.entity.Manager;

import java.util.List;

public interface managerDao {
    /**
     * 通过userId添加管理员
     * @param userId
     * @return
     */
    public int addManagerByUserId(int userId);

    /**
     * 通过managerId删除管理员信息
     * @param managerId
     * @return
     */
    public int deleteManagerByUserId(int managerId);

    /**
     * 获取所有管理员信息
     * @return
     */
    public List getAllManagerInfo();

    /**
     * 通过userId获取其版块管理权限
     * @param userId
     * @return
     */
    public Manager getManagerInfoByUserId(int userId);

    /**
     * 查询某一section下所有管理员信息
     * @param sectionId
     * @return
     */
    public List getManagerInfoBySectionId(int sectionId);


}
