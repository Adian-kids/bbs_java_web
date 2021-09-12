package bbs.dao;

import bbs.entity.Post;

import java.sql.SQLException;
import java.util.List;

public interface postDao {
    /**
     * 通过postId获取帖子信息
     * @param postId
     * @return
     */
    public Post getPostInfoByPostId(int postId) throws SQLException, ClassNotFoundException;

    /**
     * 添加帖子
     * @param post
     * @return
     */
    public int addPost(Post post) throws SQLException, ClassNotFoundException;

    /**
     * 通过postId删除帖子
     * @param postId
     * @return
     */
    public int deletePostByPostId(int postId) throws SQLException, ClassNotFoundException;

    /**
     * 编辑帖子
     * @param post
     * @return
     */
    public int editPostInfo(Post post) throws SQLException, ClassNotFoundException;

    /**
     * 通过postId查询回复的数量
     * @param postId
     * @return
     */
    public int getReplyNumByPostId(int postId) throws SQLException, ClassNotFoundException;

    /**
     * 获取post下所有reply的id
     * @param postId
     * @return
     */
    public List getAllReplyIdByPostId(int postId) throws SQLException, ClassNotFoundException;

}
