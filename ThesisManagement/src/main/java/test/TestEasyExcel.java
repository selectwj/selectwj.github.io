package test;

import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import dao.impl.StudentMessageDaoImpl;
import entity.DemoData;
import entity.StudentMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;

import java.util.List;
import java.util.function.Consumer;




public class TestEasyExcel extends BaseTest{
    StudentMessageDaoImpl studentMessageDao = new StudentMessageDaoImpl();
    @Test
    public void re(){
        System.out.println(studentMessageDao.GetAllMessage());
    }
    @Test
    public void export1() {
        Consumer<ExcelWriter> consumer = writer -> {
            //studentMessageDao.GetAllMessage()获取全部数据库数据库输出到excel中
            writer.write(studentMessageDao.GetAllMessage(), EasyExcel.writerSheet("学生信息")
                    .head(StudentMessage.class)
                    .build());
        };
        export("E:\\web\\ThesisManagement\\src\\main\\web\\file\\allStudentMessage.xlsx", consumer);
    }


    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "F:/报表.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, StudentMessage.class, new StudentMessageListener()).sheet().doRead();
    }
    @Test
    public void simpleReadUploadFile() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "F:\\excel\\上传的学生信息.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, StudentMessage.class, new StudentMessageListener()).sheet().doRead();

    }

}

