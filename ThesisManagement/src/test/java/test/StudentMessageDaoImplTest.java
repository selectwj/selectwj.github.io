package test;

import com.google.gson.Gson;
import dao.impl.StudentMessageDaoImpl;
import entity.StudentMessage;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class StudentMessageDaoImplTest extends TestCase {
    StudentMessageDaoImpl studentMessageDao = new StudentMessageDaoImpl();
    public void testWriteMessage() {

        List<StudentMessage> message = new ArrayList<StudentMessage>();
        StudentMessage message1 = new StudentMessage("190405377","王嘉骥","123","456");
        StudentMessage message2 = new StudentMessage("190405310","王嘉骥","123","456");
        StudentMessage message3 = new StudentMessage("190405311","王嘉骥","123","456");
        message.add(message1);
        message.add(message2);
        message.add(message3);
        studentMessageDao.WriteMessageList(message);
        studentMessageDao.WriteMessage(message1);

      //OK
    }

    public void testDeleteMessage() {
        StudentMessage message = new StudentMessage("19541541","王嘉骥","123","456");
        System.out.println(studentMessageDao.DeleteMessage(message));
        //OK
    }

    public void testFindMessageByID() {
        StudentMessage message = new StudentMessage("190405308","王嘉骥","123","456");
        System.out.println(studentMessageDao.FindMessageByID(message));
        //OK
    }

    public void testGetAllMessage() {
        List<StudentMessage> studentList;
        studentList= studentMessageDao.GetAllMessage();
        Gson gson = new Gson();
        String studentListString = gson.toJson(studentList);
        System.out.println(studentListString);
        for (int i=0; i<studentList.size(); i++){
            studentList.get(i).toString();
        }
        //OK
    }
}