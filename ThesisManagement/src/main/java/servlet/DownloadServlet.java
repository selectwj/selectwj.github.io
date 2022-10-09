package servlet;

import com.alibaba.excel.util.IoUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import test.TestEasyExcel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/downloadServlet")
public class DownloadServlet extends BaseServlet{

    protected void download(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //更新文件和数据库同步
        TestEasyExcel testEasyExcel = new TestEasyExcel();
        testEasyExcel.export1();

        //获取下载的文件名
        String downloadFileName="allStudentMessage.xlsx";

        //读取内容

        ServletContext servletContext = getServletContext();
        //获取文件类型名
        String  mimeType=servletContext.getMimeType("/file/"+ downloadFileName);
        //回传前告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //告诉客户端用于下载
        //"Content-Disposition", 响应头表示数据怎么处理
        // "attachment; 附件 下载使用
        // filename=文件名" 指定下载的文件名
        resp.setHeader("Content-Disposition","attachment;filename="+downloadFileName);

        //读取内容
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //下载的文件内容传回客户端
        OutputStream outputStream = resp.getOutputStream();
        //读取流中全部数据，赋值给输出流
        IoUtils.copy(resourceAsStream,outputStream);


//        //重定向到原来界面
//        req.getRequestDispatcher("/pages/administrators/studentMessage.jsp").forward(req, resp);
    }

}
