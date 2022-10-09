package test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.util.function.Consumer;

public class BaseTest {
    /**
     * 导出方法
     *
     * @param fileName       文件
     * @param writerConsumer consumer
     */
    public static void export(String fileName, Consumer<ExcelWriter> writerConsumer) {
        ExcelWriter writer = EasyExcel.write(fileName)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .build();
        writerConsumer.accept(writer);
        writer.finish();
    }
}
