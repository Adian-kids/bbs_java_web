package bbs.dao.impl;

import bbs.dao.managerDao;
import bbs.entity.Manager;

import java.util.List;

public class managerDaoImpl implements managerDao {
    /**
     * 通过userId添加管理员
     *
     * @param userId
     * @return
     */
    @Override
    public int addManagerByUserId(int userId) {

        return 0;
    }

    /**
     * 通过managerId删除管理员信息
     *
     * @param managerId
     * @return
     */
    @Override
    public int deleteManagerByUserId(int managerId) {
        return 0;
    }

    /**
     * 获取所有管理员信息
     *
     * @return
     */
    @Override
    public List getAllManagerInfo() {
        return null;
    }

    /**
     * 通过userId获取其版块管理权限
     *
     * @param userId
     * @return
     */
    @Override
    public Manager getManagerInfoByUserId(int userId) {
        return null;
    }

    /**
     * 查询某一section下所有管理员信息
     *
     * @param sectionId
     * @return
     */
    @Override
    public List getManagerInfoBySectionId(int sectionId) {
        return null;
    }
}
