package org;

import com.user.TestTable;
import com.user.User;
import org.hibernate.Session;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public class DBManager {
    private Session _session;
    
    public DBManager(){
        System.out.println("created DBManager");
        start();
    }

    private void start() {
        HibernateUtil.createSession();

        _session = getSession();
        _session.beginTransaction();

        User user = null;

        try{
            user = (User)_session.load(User.class, 2);
        }catch(Exception e){
            System.out.println("error " + e.getMessage());
            return;
        }
        System.out.println("User -> from db:" + user.toString());

        TestTable testTable = null;

        try{
            testTable = (TestTable)_session.load(TestTable.class, 3);
        }catch (Exception e){
            System.out.println("error testTable:" + e.getMessage());
            return;
        }
        System.out.println("TestTable -> from db:" + testTable.toString());
    }

    public Boolean createUser(){
        return true;
    }

    private Session getSession(){
        if(_session != null && _session.isConnected()){
            return _session;
        }
        _session = HibernateUtil.getSessionFactory().openSession();
        return _session;
    }

}
