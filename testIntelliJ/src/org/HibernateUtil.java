package org;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static void createSession(){
        Configuration cf = new Configuration();
        cf.configure("/config/hibernate.cfg.xml");
        sessionFactory = cf.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
