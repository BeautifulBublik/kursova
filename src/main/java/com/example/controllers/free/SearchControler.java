package com.example.controllers.free;
import java.io.IOException;
import java.util.Collection;

import com.example.Dao.Dao;
import com.example.model.ApartmentParameters;
import com.example.model.Apartments;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchControler", urlPatterns = {"/apart1"})
public class SearchControler extends HttpServlet {
    Dao apartDao;
    @Override
    public void init() throws ServletException {
        super.init();
        apartDao=(Dao) getServletContext().getAttribute("apartDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("action");

        switch (command){
            case "search":
                Search(req, resp);
                break;
            case "SearchParameters":
                SearchParametres(req, resp);
            case "sortByPrice":
                sortByPrice(req, resp);
                break;
            case "sortByArea":
                sortByArea(req, resp);
                break;
            case "sortByNumberOfRooms":
                sortByNumberOfRooms(req, resp);
                break;
            case "searchParamPage":
                searchParamPage(req,resp);
                break;
            case "login":
                login(req,resp);

        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void Search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           String address = req.getParameter("searchAddress");
           Collection<Apartments> apartments=apartDao.findByAdress(address);
           req.setAttribute("apartments",apartments);
           req.getRequestDispatcher("jsp/First.jsp").forward(req,resp);
       }catch (Exception e){
           resp.sendError(400);
       }
    }
    private void SearchParametres(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int minRooms = Integer.parseInt(req.getParameter("minRooms"));
            int maxRooms = Integer.parseInt(req.getParameter("maxRooms"));
            double minArea=Double.parseDouble(req.getParameter("minArea"));
            double maxArea=Double.parseDouble(req.getParameter("maxArea"));
            double minRentPrice=Double.parseDouble(req.getParameter("minRentPrice"));
            double maxRentPrice=Double.parseDouble(req.getParameter("maxRentPrice"));
            ApartmentParameters apartmentParameters=new ApartmentParameters(minRooms,maxRooms,minArea,maxArea,minRentPrice,maxRentPrice);
            Collection<Apartments> apartments=apartDao.findByParameters(apartmentParameters);
            req.setAttribute("apartments",apartments);
            req.getRequestDispatcher("jsp/First.jsp").forward(req,resp);
        }catch (Exception e){
            resp.sendError(400);
        }

    }
    private void sortByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Apartments> sortedApartments = apartDao.sortByPrice();
        req.setAttribute("apartments", sortedApartments);
        req.getRequestDispatcher("jsp/First.jsp").forward(req, resp);
    }

    private void sortByArea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Apartments> sortedApartments = apartDao.sortByArea();
        req.setAttribute("apartments", sortedApartments);
        req.getRequestDispatcher("jsp/First.jsp").forward(req, resp);
    }

    private void sortByNumberOfRooms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Apartments> sortedApartments = apartDao.sortByNumberOfRooms();
        req.setAttribute("apartments", sortedApartments);
        req.getRequestDispatcher("jsp/First.jsp").forward(req, resp);
    }
    private void searchParamPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/searchParameters.jsp").forward(req,resp);
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("loginError/login.jsp").forward(req, resp);
    }
}
