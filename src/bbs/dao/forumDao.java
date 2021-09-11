package bbs.dao;

import bbs.entity.Forum;

import java.sql.SQLException;

public interface forumDao {
    /**
     * 获取论坛参数信息
     * @return
     */
    public Forum getForumInfo() throws SQLException, ClassNotFoundException;

    /**
     * 修改论坛信息
     * @param forum
     * @return
     */
    public int editForumInfo(Forum forum) throws SQLException, ClassNotFoundException;

}
