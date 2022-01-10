package cool.tdl.service;

import cool.tdl.dao.housedatebase;
import cool.tdl.dao.userdatebase;
import cool.tdl.pojo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 查找房源功能
 */
@WebServlet("/manage/admin_readhouse")
public class admin_readhouse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        int cpage = 1;
        int count = 10;
        boolean flag=true;
        String cp = req.getParameter("cp");
        String keyword = req.getParameter("keywords");
        String diqu= req.getParameter("wh_xz_name");
        String home_name= req.getParameter("home_name");
        String totalprize= req.getParameter("totalprize");
        String huxin= req.getParameter("huxin");
        String area= req.getParameter("area");
        int num=0;
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        int arr[] = housedatebase.totalPage_house(count, keyword);
        ArrayList<house> list=null;
        if (home_name!=null){//小区
            //获取所有房源记录
           //int fid=Integer.valueOf(home_fid);
            list = housedatebase.selectall_house_homefid(cpage, count, keyword,home_name);
            num=list.size();
            flag=false;
        }else if (diqu!=null){//行政区
            list = housedatebase.selectall_house_xz(cpage, count, keyword,diqu);
            num=list.size();
            flag=false;
        }else if (totalprize!=null){//售价
            list = housedatebase.selectall_house_totalprize(cpage, count, keyword,totalprize);
            num=list.size();
            flag=false;
        }else if (huxin!=null){//房型
            list = housedatebase.selectall_house_huxin(cpage, count, keyword,huxin);
            num=list.size();
            flag=false;
        }else if (area!=null){//面积
            list = housedatebase.selectall_house_area(cpage, count, keyword,area);
            num=list.size();
            flag=false;
        }
        else {
            list = housedatebase.selectall_house(cpage, count, keyword);
        }

        //获取所有的行政区
        ArrayList<wh_xz> list1 = housedatebase.selectall_wh_xz();
        //获得行政区中的小区
//        ArrayList<home> list2 = userdatebase.selectall_home_key(diqu);
        ArrayList<option_home> list3 = housedatebase.selectall_home();
        ArrayList<huxin> list4 = housedatebase.selectall_huxin();

        //放到请求对象域里
        req.setAttribute("houselist", list);
        req.setAttribute("wh_xzlist",list1);
//        req.setAttribute("homelist",list2);
        req.setAttribute("homelist",list3);
        req.setAttribute("huxinlist",list4);

        req.setAttribute("num",num);
        req.setAttribute("flag",flag);

        req.setAttribute("tsum", arr[0]);
        req.setAttribute("tpage", arr[1]);
        req.setAttribute("cpage", cpage);
        req.setAttribute("keyword", keyword);

        if (keyword != null) {
            req.setAttribute("searchParams", "&keywords=" + keyword);
        }
        req.getRequestDispatcher("admin_select_house.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
