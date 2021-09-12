package bbs.dao.impl;

import bbs.dao.forumDao;
import bbs.entity.Forum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class forumDaoImpl implements forumDao {
    /**
     * 获取论坛参数信息
     */
    @Override
    public Forum getForumInfo() throws SQLException, ClassNotFoundException {
        // 实例化对象
        Forum forum = new Forum();
        // 查询数据
        String sql = "SELECT * FROM forum";
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sql,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
            System.out.println("123");
            forum.setName(selectResultSet.getString("name"));
            forum.setIntroduction(selectResultSet.getString("introduction"));
            forum.setCreateDate(selectResultSet.getString("createDate"));
        }
        return forum;
    }

    /**
     * 修改论坛信息
     *
     * @param forum
     * @return
     */
    @Override
    public int editForumInfo(Forum forum) throws SQLException, ClassNotFoundException {
        String forumName = forum.getName();
        String introduction = forum.getIntroduction();
        String[] params = {forumName,introduction};
        String sqlString = "UPDATE forum SET name=?,introduction=?";
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int resultCode = (int) updateResult.get("rowNum");
        return resultCode;
    }
}
