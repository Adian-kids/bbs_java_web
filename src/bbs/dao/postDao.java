package bbs.dao;

import bbs.entity.Post;

import java.util.List;

public interface postDao {
    /**
     * 通过postId获取帖子信息
     * @param postId
     * @return
     */
    public Post getPostInfoByPostId(int postId);

    /**
     * 添加帖子
     * @param post
     * @return
     */
    public int addPost(Post post);

    /**
     * 通过postId删除帖子
     * @param postId
     * @return
     */
    public int deletePostByPostId(int postId);

    /**
     * 编辑帖子
     * @param post
     * @return
     */
    public int editPostInfo(Post post);

    /**
     * 通过postId查询回复的数量
     * @param PostId
     * @return
     */
    public int getReplyNumByPostId(int PostId);

    /**
     * 获取post下所有reply的id
     * @param postId
     * @return
     */
    public List getAllReplyIdByPostId(int postId);

}
