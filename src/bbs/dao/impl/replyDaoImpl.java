package bbs.dao.impl;

import bbs.dao.replyDao;
import bbs.entity.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class replyDaoImpl implements replyDao {
    /**
     * 通过replyId获取回复信息
     *
     * @param replyId
     * @return
     */
    @Override
    public Reply getReplyInfoByReplyId(int replyId) throws SQLException, ClassNotFoundException {
        Reply reply = new Reply();
        baseDao basedao = new baseDao();
        String sqlString = "SELECT * FROM reply WHERE replyId=?";
        String[] params = {Integer.toString(replyId)};
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            reply.setIsReply(selectResultSet.getInt("isReply"));
            reply.setReplyId(replyId);
            reply.setToReplyId(selectResultSet.getInt("toReplyId"));
            reply.setContent(selectResultSet.getString("content"));
            reply.setTime(selectResultSet.getString("time"));
            reply.setPostId(selectResultSet.getInt("postId"));
            reply.setUserId(selectResultSet.getInt("userId"));
        }

        return reply;
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
