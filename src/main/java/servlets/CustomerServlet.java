package servlets;

import entities.Customer;
import queries.SelectQuery;
import queries.UpdateQuery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");

        List<Customer> customers = SelectQuery.selectUsers();

            httpServletRequest.setAttribute("customers", customers);
            RequestDispatcher req = httpServletRequest.getRequestDispatcher("/WEB-INF/views/table.jsp");
            req.forward(httpServletRequest, httpServletResponse);

        }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");

        int id = 0;
        System.out.println(httpServletRequest.getParameter("id"));
        try {
            id = Integer.parseInt(httpServletRequest.getParameter("id"));
        }
        catch (NumberFormatException e){
            System.err.print("Выберите строку");
        }

        Customer customer = SelectQuery.selectUserById(id);

        System.out.println(httpServletRequest.getParameter("id"));

        String surname = httpServletRequest.getParameter("surname");
        String name = httpServletRequest.getParameter("name");
        int age = 0;
        try {
            age = Integer.parseInt(httpServletRequest.getParameter("age"));
        }catch (NumberFormatException e) {
            System.err.print("Введите возраст");
        }
        String sex = httpServletRequest.getParameter("sex");
        String phone = httpServletRequest.getParameter("phone");

        customer.setSurname(surname);
        customer.setName(name);
        customer.setAge(age);
        customer.setSex(sex);
        customer.setPhone(phone);

        UpdateQuery.updateUser(customer);

        httpServletResponse.sendRedirect("table.jsp");
    }

}

