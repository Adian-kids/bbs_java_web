package bbs.dao.impl;

import bbs.dao.replyDao;
import bbs.entity.Reply;

public class replyDaoImpl implements replyDao {
    /**
     * 通过replyId获取回复信息
     *
     * @param replyId
     * @return
     */
    @Override
    public Reply getReplyInfoByReplyId(int replyId) {
        return null;
    }

    /**
     * 新增回复
     *
     * @param reply
     * @return
     */
    @Override
    public int addReply(Reply reply) {
        return 0;
    }

    /**
     * 删除回复
     *
     * @param replyId
     * @return
     */
    @Override
    public int deleteReplyByReplyId(int replyId) {
        return 0;
    }
}
