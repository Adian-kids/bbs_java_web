package bbs.dao.impl;

import bbs.dao.postDao;
import bbs.entity.Post;

import java.util.List;

public class postDaoImpl implements postDao {
    /**
     * 通过postId获取帖子信息
     *
     * @param postId
     * @return
     */
    @Override
    public Post getPostInfoByPostId(int postId) {
        return null;
    }

    /**
     * 添加帖子
     *
     * @param post
     * @return
     */
    @Override
    public int addPost(Post post) {
        return 0;
    }

    /**
     * 通过postId删除帖子
     *
     * @param postId
     * @return
     */
    @Override
    public int deletePostByPostId(int postId) {
        return 0;
    }

    /**
     * 编辑帖子
     *
     * @param post
     * @return
     */
    @Override
    public int editPostInfo(Post post) {
        return 0;
    }

    /**
     * 通过postId查询回复的数量
     *
     * @param PostId
     * @return
     */
    @Override
    public int getReplyNumByPostId(int PostId) {
        return 0;
    }

    /**
     * 获取post下所有reply的id
     *
     * @param postId
     * @return
     */
    @Override
    public List getAllReplyIdByPostId(int postId) {
        return null;
    }
}
