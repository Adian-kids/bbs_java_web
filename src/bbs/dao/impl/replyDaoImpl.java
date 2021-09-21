package bbs.dao.impl;

import bbs.dao.replyDao;
import bbs.entity.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public int addReply(Reply reply) throws SQLException, ClassNotFoundException {

        int postId = reply.getPostId();
        int userId = reply.getUserId();
        String content = reply.getContent();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间
        int isReply = reply.getIsReply();
        int toReplyId = reply.getToReplyId();
        baseDao basedao = new baseDao();
        String sqlString = "INSERT INTO reply (postId,userId,content,time,isReply,toReplyId) VALUES (?,?,?,?,?,?)";
        String[] params = {Integer.toString(postId),
                Integer.toString(userId),
                content,
                time,
                Integer.toString(isReply),
                Integer.toString(toReplyId)
        };
        Map insertResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) insertResult.get("rowNum");
        return  rowNum;

    }

    /**
     * 删除回复
     *
     * @param replyId
     * @return
     */
    @Override
    public int deleteReplyByReplyId(int replyId) throws SQLException, ClassNotFoundException {
        String sqlString = "DELETE FROM reply WHERE replyId=?";
        String[] params = {Integer.toString(replyId)};
        baseDao basedao = new baseDao();
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }
}
