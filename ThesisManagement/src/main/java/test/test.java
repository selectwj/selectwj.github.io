package test;


import com.alibaba.excel.EasyExcel;
import entity.DemoData;
import org.joda.time.DateTime;
import org.junit.Test;



import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    String PATH = "D:\\excel";



    String path = "D:\\excel";
    @Test
    public void testExcelWrite03Version() throws IOException {

        // 1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        // 2.创建工作表
        Sheet sheet1 = workbook.createSheet("表名1"); // 表名默认是sheet0
        // 3.创建第一行
        Row row1 = sheet1.createRow(0);
        // 4.创建单元格（1，1）
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("第一次使用poi");
        // （1，2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("好激动啊");
        // 创建第二行
        Row row2 = sheet1.createRow(1);
        //  (2,1)
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("现在时间是：");
        // （2，2）
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy年MM月dd日 HH:mm:ss"));

        // 生成文件
        FileOutputStream fileOutputStream = new FileOutputStream(path + "\\poi03hss.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("生成完毕");
    }

    @Test
    public void testExcelWrite07VersionXss() throws IOException {

        // 1.创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        // 2.创建工作表
        Sheet sheet1 = workbook.createSheet("表名2"); // 表名默认是sheet0
        // 3.创建第一行
        Row row1 = sheet1.createRow(0);
        // 4.创建单元格（1，1）
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("第一次使用poi");
        // （1，2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("好激动啊");
        // 创建第二行
        Row row2 = sheet1.createRow(1);
        //  (2,1)
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("现在时间是：");
        // （2，2）
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy年MM月dd日 HH:mm:ss"));

        // 生成文件
        FileOutputStream fileOutputStream = new FileOutputStream(path + "\\poi07xss.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("生成完毕");
    }

    @Test
    public void testExcelWrite07VersionSxss() throws IOException {

        // 1.创建一个工作簿
        Workbook workbook = new SXSSFWorkbook();
        // 2.创建工作表
        Sheet sheet1 = workbook.createSheet("表名2"); // 表名默认是sheet0
        // 3.创建第一行
        Row row1 = sheet1.createRow(0);
        // 4.创建单元格（1，1）
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("第一次使用poi");
        // （1，2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("好激动啊");
        // 创建第二行
        Row row2 = sheet1.createRow(1);
        //  (2,1)
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("现在时间是：");
        // （2，2）
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy年MM月dd日 HH:mm:ss"));

        // 生成文件
        FileOutputStream fileOutputStream = new FileOutputStream(path + "\\poi07sxss.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("生成完毕");
    }

    //大文件

    @Test
    public void testBigDataWrite03VersionHss() throws IOException {
        long start = System.currentTimeMillis();
        // 1.创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        // 2.创建工作表
        Sheet sheet1 = workbook.createSheet("表名2"); // 表名默认是sheet0
        // 循环创建行
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet1.createRow(rowNum);
            // 循环创建单元格
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(new DateTime().toString("HH:mm:ss"));
            }
        }
        System.out.println("HSS创建完毕！");

        // 生成文件
        FileOutputStream fileOutputStream = new FileOutputStream(path + "\\BigDataPoi03.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("SSH生成完毕");

        long end = System.currentTimeMillis();
        System.out.println((double) (end - start) / 1000);
    }


















    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }


    @Test
    public void testEasyExcelWrite(){
        // 写法2
        String fileName = PATH + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        // fileName 文件写出的目录和工作簿名称
        // DemoData.class 写出对象的字节码文件
        // sheet("模板") 工作表名称
        // data() 写入到工作表的数据
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }
    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = PATH + "demo.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }
}
