package controllers;

import entities.Customer;
import queries.SelectQuery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerController extends HttpServlet {

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");

        List<Customer> customers = SelectQuery.selectTable();

            httpServletRequest.setAttribute("customers", customers);
            RequestDispatcher req = httpServletRequest.getRequestDispatcher("/WEB-INF/views/table.jsp");
            req.forward(httpServletRequest, httpServletResponse);

        }

}

