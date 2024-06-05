package com.example.web;

import com.example.Dao.Dao;
import com.example.Dao.InMemoryDao;
import com.example.testDB.TestDateBase;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Dao apartDao=new InMemoryDao();
        TestDateBase.createApartments(apartDao);
        sce.getServletContext().setAttribute("apartDao", apartDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}