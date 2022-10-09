package json;

import com.google.gson.Gson;
import entity.MyLog;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class jsonTest {


    /**
     * 单个转化
     */
    @Test
    public void test(){
        MyLog log = new MyLog(0,"root","123","测试","写入日志1");
        //创建gson实例
        Gson gson = new Gson();
        //tojson()转化字符串
        String logString = gson.toJson(log);
        System.out.println(logString);

        MyLog a = gson.fromJson(logString,MyLog.class);
        System.out.println(a);

    }

    /**
     * 集合
     */
    @Test
    public void test2(){
        MyLog log1 = new MyLog(0,"root","123","测试1","写入日志1");
        MyLog log2 = new MyLog(0,"root","456","测试2","写入日志1");
        List<MyLog> logList = new ArrayList<>();
        logList.add(log1);
        logList.add(log2);

        //创建gson实例
        Gson gson = new Gson();
        //tojson()转化list 为 json字符串
        String logString = gson.toJson(logList);
        System.out.println(logString);


        //转化回来
        List<MyLog> list =gson.fromJson(logString,new LogListType().getType());
        System.out.println(list);
        MyLog myLog =list.get(0);
        System.out.println(myLog);


    }
}
