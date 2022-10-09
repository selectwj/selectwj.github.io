package servlet;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import test.TestEasyExcel;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/uploadServlet")
public class UploadServlet extends BaseServlet{

    protected void upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //判断上传的数据是否为多段数据
        if(ServletFileUpload.isMultipartContent(req)){
            //闯将工厂实现类
            FileItemFactory fileItemFactory =new DiskFileItemFactory();
            //创建用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //解析上传的数据，得到each表单项
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem file:list) {
                    if(file.isFormField()){
                        //普通表单项
                        System.out.println("name" + file.getFieldName());
                        System.out.println("value" + file.getString("UTF-8"));

                    }else{
                        //上传的文件
                        System.out.println("name" + file.getFieldName());
                        System.out.println("value" + file.getString("UTF-8"));
                        try {
                            file.write(new File("F:\\excel\\上传的学生信息.xlsx"));
                            System.out.println("上传成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            //读取上传的文件并存到数据库
            TestEasyExcel testEasyExcel = new TestEasyExcel();
            testEasyExcel.simpleReadUploadFile();


        }
        //重定向到原来界面
        req.getRequestDispatcher("/pages/administrators/studentMessage.jsp").forward(req, resp);
    }

}
