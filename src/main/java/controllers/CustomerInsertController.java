package controllers;

import entities.Customer;
import queries.InsertQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class CustomerInsertController extends HttpServlet {
    public CustomerInsertController() {
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        String surname = httpServletRequest.getParameter("surname");
        String name = httpServletRequest.getParameter("name");
        int age;
        if ((age = Integer.parseInt(httpServletRequest.getParameter("age"))) == 0) {
            writer.print("Введите возраст");
        }

        String sex = httpServletRequest.getParameter("sex");
        String phone = httpServletRequest.getParameter("phone");
        List customers = InsertQuery.insertTable(surname, name, age, sex, phone);

        try {
            Iterator var10 = customers.iterator();

            while(var10.hasNext()) {
                Customer c = (Customer)var10.next();
                writer.print(c.getId() + " | ");
                writer.print(c.getSurname() + " | ");
                writer.print(c.getName() + " | ");
                writer.print(c.getAge() + " | ");
                writer.print(c.getSex() + " | ");
                writer.print(c.getPhone() + " |");
                writer.print("</br>");
            }
        } finally {
            writer.close();
        }

    }
}
