package bbs.dao.impl;

import bbs.dao.postDao;
import bbs.entity.Post;
import bbs.entity.Reply;

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
        Map selectResult = basedao.sqlQuery(sqlString, params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()) {
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

    /**
     * 获取主页展示的十条最新文章
     *
     * @return
     */
    @Override
    public List getTop10Post() throws SQLException, ClassNotFoundException {
        baseDao basedao = new baseDao();
        List<Post> postList = new ArrayList();
        String sqlString = "SELECT * FROM posts LIMIT 10";
        Map selectResult = basedao.sqlQuery(sqlString,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            Post post = new Post();
            post.setPostId(selectResultSet.getInt("postId"));
            post.setTitle(selectResultSet.getString("title"));
            post.setUserId(selectResultSet.getInt("userId"));
            postList.add(post);
        }

        return postList;
    }

    /**
     * 分页获取某一section下所有post对象
     *  @param sectionId
     * @param page
     */
    @Override
    public List getAllPost(int sectionId, int page) throws SQLException, ClassNotFoundException {

        int index = (int) ((page - 1) * 10 + 1);
        int end = (int) ((page - 1)* 10 + 10);
        System.out.println(index);
        System.out.println(end);

        List resultList = new ArrayList();
        String sqlString = "SELECT * FROM posts WHERE sectionId=? LIMIT "+index+","+end;
        String[] params = {Integer.toString(sectionId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            Post post = new Post();
            post.setPostId(selectResultSet.getInt("postId"));
            post.setTitle(selectResultSet.getString("title"));
            post.setUserId(selectResultSet.getInt("userId"));
            post.setTime(selectResultSet.getString("time"));
            resultList.add(post);
        }

        return resultList;
    }

    /**
     * 获取页数
     */
    @Override
    public int getPageSum() throws SQLException, ClassNotFoundException {
        int pageSum = 0;
        String sqlString = "SELECT count(*) AS counts FROM posts";
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            pageSum = selectResultSet.getInt("counts") / 10;
            if(pageSum==0){
                pageSum = 1;
            }
        }

        return pageSum;
    }

    /**
     * 获取某post下所有的reply
     */
    @Override
    public List getAllReplyInfo(int postId) throws SQLException, ClassNotFoundException {
        List resultList = new ArrayList();
        String sqlString = "SELECT * FROM reply WHERE postId=?";
        String[] params = {Integer.toString(postId)};
        baseDao basedao = new baseDao();
        Map selectReuslt = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectReuslt.get("selectResult");
        while (selectResultSet.next()){
            Reply reply = new Reply();
            reply.setReplyId(selectResultSet.getInt("replyId"));
            reply.setUserId(selectResultSet.getInt("userId"));
            reply.setContent(selectResultSet.getString("content"));
            reply.setIsReply(selectResultSet.getInt("isReply"));
            reply.setToReplyId(selectResultSet.getInt("toReplyId"));
            reply.setTime(selectResultSet.getString("time"));
            resultList.add(reply);
        }
        return resultList;
    }

}
