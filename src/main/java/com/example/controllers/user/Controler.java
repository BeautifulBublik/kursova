package com.example.controllers.user;

import java.io.IOException;
import java.util.Collection;

import com.example.Dao.Dao;
import com.example.model.Apartments;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Controler", urlPatterns = {"/apart","/index.html"})
public class Controler extends HttpServlet {
    Dao apartDao;
    @Override
    public void init() throws ServletException {
        super.init();
        apartDao=(Dao) getServletContext().getAttribute("apartDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("action");
        if(command==null)
        {
            command="First";
        }
        switch (command){
            case "upgradePage":
                upgradePage(req,resp);
                break;
            case"createPage":
                createPage(req,resp);
                break;

            case "First":
                FirstPage(req,resp);
                break;
            default:
                FirstPage(req,resp);
                break;
            case "searchParamPage":
                searchParamPage(req,resp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String command=req.getParameter("action");
    if(command==null){
        resp.sendError(400,"Помилкова команда.");
        return;
    }
    switch (command){
        case "delete":
            delete(req,resp);
            break;
        case "upgrade":
            upgrade(req,resp);
            break;
        case "create":
            create(req,resp) ;
            break;
        default:
            resp.sendError(400,"Помилкова команда.");
    }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            Integer id=Integer.valueOf(req.getParameter("id"));
            apartDao.delete(id);
            resp.sendRedirect("");
        }catch (Exception e){
            resp.sendError(400);
        }
    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String address=req.getParameter("address");
            int numberOfRooms= Integer.parseInt(req.getParameter("numberOfRooms"));
            double rentPrice=Double.parseDouble(req.getParameter("rentPrice"));
            double area=Double.parseDouble(req.getParameter("area"));
            String description=req.getParameter("description");
            Apartments apartment=new Apartments(address,numberOfRooms,area,rentPrice,description);
            apartDao.create(apartment);
            resp.sendRedirect("");

    }catch (Exception e){
            resp.sendError(400);
        }
    }
    private void upgrade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           Integer id = Integer.valueOf(req.getParameter("id"));
           String address = req.getParameter("address1");
           int numberOfRooms = Integer.parseInt(req.getParameter("numberOfRooms1"));
           double rentPrice = Double.parseDouble(req.getParameter("rentPrice1"));
           double area = Double.parseDouble(req.getParameter("area1"));
           String description = req.getParameter("description1");
           Apartments apartment = new Apartments(id, address, numberOfRooms, area, rentPrice, description);
           apartDao.update(apartment);
           resp.sendRedirect("");
       }catch (Exception e){
           resp.sendError(400);
       }

    }
    private void FirstPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Apartments>apartments=apartDao.findAll();
        req.setAttribute("apartments",apartments);
        req.getRequestDispatcher("jsp/First.jsp").forward(req,resp);
    }
    private void upgradePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.valueOf(req.getParameter("id"));
        Apartments apartment=apartDao.findById(id);
        req.setAttribute("apartam",apartment);
        req.getRequestDispatcher("/user/upgrade.jsp").forward(req,resp);
    }
    private void createPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/addApartment.jsp").forward(req,resp);
    }
    private void searchParamPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/searchParameters.jsp").forward(req,resp);
    }
}

