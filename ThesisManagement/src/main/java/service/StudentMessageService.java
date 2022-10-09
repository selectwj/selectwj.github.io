package service;

import dao.impl.StudentMessageDaoImpl;
import entity.Administrator;
import entity.StudentMessage;

public interface StudentMessageService {
    StudentMessageDaoImpl ooo =new StudentMessageDaoImpl();

    /**
     * 添加信息
     * @param message
     */
    public void addMessage(StudentMessage message);


    /**
     *
     * @param ID
     * @return
     */
    public boolean hadMessage(String ID);
}
