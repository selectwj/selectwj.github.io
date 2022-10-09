package test;

import org.junit.Test;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class readExcelTest {

    public class ExcelReadTest {
        String path = "D:\\excel";
        @Test
        public void testReadHss() throws IOException {
            // 获取文件流
            FileInputStream fileInputStream = new FileInputStream(path + "\\会员消费商品明细表.xls");
            // 创建一个工作簿， Excel里面的操作，这边都有
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            // 创建工作表
            HSSFSheet sheet = workbook.getSheetAt(0);
            // 获取一行
            HSSFRow row = sheet.getRow(0);
            // 获取一个单元格（1，1）
            HSSFCell cell = row.getCell(0);

            System.out.println(cell.getStringCellValue());
            fileInputStream.close();
        }

        @Test
        public void testReadXss() throws IOException {
            // 获取文件流
            FileInputStream fileInputStream = new FileInputStream(path + "\\BigDataPoi07SXss.xls");
            // 创建一个工作簿， Excel里面的操作，这边都有
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            // 创建工作表
            XSSFSheet sheet = workbook.getSheetAt(0);
            // 获取一行
            XSSFRow row = sheet.getRow(0);
            // 获取一个单元格（1，1）
            XSSFCell cell = row.getCell(0);

            System.out.println(cell.getStringCellValue());
            fileInputStream.close();
        }

    }

}
