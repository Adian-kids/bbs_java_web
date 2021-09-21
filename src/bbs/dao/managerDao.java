package bbs.dao;

import bbs.entity.Manager;

import java.sql.SQLException;
import java.util.List;

public interface managerDao {
    /**
     * 通过userId添加管理员
     * @param manager
     * @return
     */
    public int addManagerByUserId(Manager manager) throws SQLException, ClassNotFoundException;

    /**
     * 通过managerId删除管理员信息
     * @param manager
     * @return
     */
    public int deleteManagerByUserId(Manager manager) throws SQLException, ClassNotFoundException;

    /**
     * 获取所有管理员信息
     * @return
     */
    public List getAllManagerInfo() throws SQLException, ClassNotFoundException;

    /**
     * 通过userId获取其版块管理权限
     * @param userId
     * @return
     */
    public List getManagerInfoByUserId(int userId) throws SQLException, ClassNotFoundException;

    /**
     * 查询某一section下所有管理员信息
     *
     * @param sectionId
     * @return
     */
    public List getManagerInfoBySectionId(int sectionId) throws SQLException, ClassNotFoundException;

    /**
     * 检查是否为管理员
     *
     * @param userId
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int checkManager(int userId) throws SQLException, ClassNotFoundException;


}
