package bbs.dao.impl;

import bbs.dao.impl.classifyDaoImpl;
import bbs.entity.Classify;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bbs.entity.Forum;
import bbs.entity.Post;
import bbs.entity.Section;

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
        //forumDaoImpl dao = new forumDaoImpl();
        //Forum forum = dao.getForumInfo();
        //System.out.println(forum.getName());
        /*
        try {
            forumDaoImpl dao = new forumDaoImpl();
            Forum forum = dao.getForumInfo();
            List<Classify> allClassify = new classifyDaoImpl().getAllClassifyInfo();
            List<Section> sectionList= new ArrayList();
            Map SectionMap = null;
            for (int i=0; i<allClassify.size();i++) {
                sectionList = new classifyDaoImpl().getAllSectionContentByClassifyId(allClassify.get(i).getClassifyId());
                System.out.println(allClassify.get(i).getClassifyId());
                System.out.println(new classifyDaoImpl().getAllSectionContentByClassifyId(allClassify.get(i).getClassifyId()).toString());
                SectionMap.put(allClassify.get(i).getClassifyId(),new classifyDaoImpl().getAllSectionContentByClassifyId(allClassify.get(i).getClassifyId()));
            }
            System.out.println(sectionList.size());
            for (int i = 0; i < sectionList.size(); i++) {
                System.out.println(11);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
        //List<Post> top10Post = new postDaoImpl().getTop10Post();
        //System.out.println(top10Post.toString());
        String sectionId = "2";
        String page = "1";
        postDaoImpl dao = new postDaoImpl();
        int pageSum = dao.getPageSum();
        Section section = new sectionDaoImpl().getSectionInfoBySectionId(Integer.parseInt(sectionId));
        List postList = dao.getAllPost(Integer.parseInt(sectionId),Integer.parseInt(page));
        System.out.println(pageSum);
        System.out.println(postList.toString());
        System.out.println(section.getName());


    }

}