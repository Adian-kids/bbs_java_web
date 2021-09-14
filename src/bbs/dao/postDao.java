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

    /**
     * 获取主页展示的十条最新文章
     * @return
     */

    public List getTop10Post() throws SQLException, ClassNotFoundException;
    /**
     * 分页获取某一section下所有post对象
     * @param int sectionId
     * @param sectionId
     */
    public List getAllPost(int sectionId, int page) throws SQLException, ClassNotFoundException;

    /**
     * 获取页数
     */
    public int getPageSum() throws SQLException, ClassNotFoundException;

    /**
     * 获取某post下所有的reply
     * @param int postId
     */
    public List getAllReplyInfo(int postId) throws SQLException, ClassNotFoundException;

}
