package bbs.dao.impl;

import bbs.dao.postDao;
import bbs.entity.Post;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class postDaoImpl implements postDao {
    /**
     * 通过postId获取帖子信息
     *
     * @param postId
     * @return
     */
    @Override
    public Post getPostInfoByPostId(int postId) throws SQLException, ClassNotFoundException {
        Post post = new Post();
        String sqlString = "SELECT * FROM posts WHERE postId=?";
        String[] params = {Integer.toString(postId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            post.setPostId(postId);
            post.setSectionId(selectResultSet.getInt("sectionId"));
            post.setUserId(selectResultSet.getInt("userId"));
            post.setTitle(selectResultSet.getString("title"));
            post.setContent(selectResultSet.getString("content"));
            post.setTime(selectResultSet.getString("time"));
        }
        return post;
    }

    /**
     * 添加帖子
     *
     * @param post
     * @return
     */
    @Override
    public int addPost(Post post) throws SQLException, ClassNotFoundException {
        int sectionId = post.getSectionId();
        int userId =post.getUserId();
        String time = post.getTime();
        String title = post.getTitle();
        String content = post.getContent();
        String sqlString = "INSERT INTO posts (selectId,userId,time,title,content) VALUES (?,?,?,?,?)";
        String[] params = {Integer.toString(sectionId),Integer.toString(userId),time,title,content};
        baseDao basedao = new baseDao();
        Map insertResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) insertResult.get("rowNum");
        return  rowNum;
    }

    /**
     * 通过postId删除帖子
     *
     * @param postId
     * @return
     */
    @Override
    public int deletePostByPostId(int postId) throws SQLException, ClassNotFoundException {
        String sqlString = "DELETE FROM posts WHERE postId=?";
        String[] params = {Integer.toString(postId)};
        baseDao basedao = new baseDao();
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }

    /**
     * 编辑帖子
     *
     * @param post
     * @return
     */
    @Override
    public int editPostInfo(Post post) throws SQLException, ClassNotFoundException {
        int postId = post.getPostId();
        String title = post.getTitle();
        String content = post.getContent();
        String sqlString = "UPDATE posts SET title=?,content=? WHERE postId=?";
        String[] params = {title,content,Integer.toString(postId)};
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) updateResult.get("rowNum");

        return rowNum;
    }

    /**
     * 通过postId查询回复的数量
     *
     * @param postId
     * @return
     */
    @Override
    public int getReplyNumByPostId(int postId) throws SQLException, ClassNotFoundException {
        int replyNum = 0;
        String sqlString = "SELECT count(*) as replyNum FROM posts WHERE postId=?";
        String[] params = {Integer.toString(postId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
             replyNum = selectResultSet.getInt("replyNum");
        }

        return replyNum;

    }

    /**
     * 获取post下所有reply的id
     *
     * @param postId
     * @return
     */
    @Override
    public List getAllReplyIdByPostId(int postId) throws SQLException, ClassNotFoundException {
        List replyIdList = new ArrayList();
        String sqlString = "SELECT replyId FROM reply WHERE postId=?";
        String[] params = {Integer.toString(postId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            replyIdList.add(selectResultSet.getInt("replyId"));
        }
        return replyIdList;
    }
}
