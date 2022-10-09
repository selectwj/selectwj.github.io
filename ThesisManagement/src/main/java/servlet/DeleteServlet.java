package servlet;

import dao.StudentMessageDao;
import dao.impl.StudentMessageDaoImpl;
import entity.StudentMessage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import test.TestEasyExcel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteServlet")
public class DeleteServlet extends BaseServlet{
    StudentMessageDao studentMessageDao = new StudentMessageDaoImpl();
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("ok ok");
//
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] buffer =new byte[1024000];
//        int read = inputStream.read(buffer);
//        System.out.println(new String(buffer,0,read));
        String studentID = req.getParameter("studentID");
        String msg = "";
        if (studentMessageDao.DeleteMessage(new StudentMessage(studentID,"","",""))==-1){
            msg="没有这个ID";
        }else {
            msg="删除成功";
        }
        //重定向到原来界面
        req.getRequestDispatcher("/pages/administrators/studentMessage.jsp").forward(req, resp);
    }
}
