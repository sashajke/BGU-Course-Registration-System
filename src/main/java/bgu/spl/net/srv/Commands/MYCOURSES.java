package bgu.spl.net.srv.Commands;

import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MYCOURSES implements Command<Database> {
    private final short opcode =11;
    private String userName;
    @Override
    public Serializable execute(Database arg) {
        // TODO : need to create an ACK or ERR message and create the string that represents the courses
        List<Integer> coursesList =  arg.getRegisteredCourses(userName);
        if(coursesList == null)
            return new ERR(opcode);
        String courses = "[";
        for(int i=0;i<coursesList.size();i++){
            courses += coursesList.get(i) + ", ";
        }
        courses = courses.substring(0,courses.length()-1); // remove the last , char
        courses += "]";
        return new ACK(opcode,courses);
    }

    @Override
    public short getOpCode() {
        return opcode;
    }

    @Override
    public void AddUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public boolean needUserName() {
        return true;
    }
}
