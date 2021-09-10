package bbs.dao;

import bbs.entity.Reply;

import java.util.List;

public interface replyDao {
    /**
     * 通过replyId获取回复信息
     * @param replyId
     * @return
     */
    public Reply getReplyInfoByReplyId(int replyId);

    /**
     * 新增回复
     * @param reply
     * @return
     */
    public int addReply (Reply reply);

    /**
     * 删除回复
     * @param replyId
     * @return
     */
    public int deleteReplyByReplyId(int replyId);
}
