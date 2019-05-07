package controllers;

import entities.Customer;
import queries.SelectQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CustomerController extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = httpServletResponse.getWriter();

        List<Customer> customers = SelectQuery.selectTable();

        for(Customer c : customers) {
                writer.print(c.getId() + " | ");
                writer.print(c.getSurname() + " | ");
                writer.print(c.getName() + " | ");
                writer.print(c.getAge() + " | ");
                writer.print(c.getSex() + " | ");
                writer.print(c.getPhone() + " |");
                writer.print("</br>");
            }
        }

}

