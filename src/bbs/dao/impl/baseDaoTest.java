package bbs.dao.impl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import bbs.dao.impl.forumDaoImpl;
import bbs.entity.Classify;
import bbs.entity.Forum;

class baseDaoTest{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Forum newForm = new Forum();
        //newForm.setName("New Name For BBS");
        //newForm.setIntroduction("一起来玩耍");
        //forumDaoImpl forumdaoimpl = new forumDaoImpl();
        //int rowNum = forumdaoimpl.editForumInfo(newForm);
        //System.out.println(rowNum);

        //classifyDaoImpl classifydaoimpl = new classifyDaoImpl();
        //Classify classify = (Classify) classifydaoimpl.getClassifyContentByClassifyId(1);
        //System.out.println(classify.getName());

        //baseDao basedao = new baseDao();
        //String checkSqlString = "SELECT passwd FROM users WHERE userId=33" ;
        //Map selectResult = basedao.sqlQuery(checkSqlString,null);
        //ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        //if (selectResultSet != null){
        //    System.out.println("-1");
        //}
        forumDaoImpl dao = new forumDaoImpl();
        Forum forum = dao.getForumInfo();
        System.out.println(forum.getName());


    }

}