package queries;

import entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectQuery {

    public static List<Customer> selectUsers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList();

        try {
            connection = ConnectDatabase.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id, surname, name, age, sex, phone FROM users");

            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setName(resultSet.getString("name"));
                customer.setAge(resultSet.getInt("age"));
                customer.setSex(resultSet.getString("sex"));
                customer.setPhone(resultSet.getString("phone"));
                customers.add(customer);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return customers;
    }

    public static Customer selectUserById(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = new Customer();

        try {
            connection = ConnectDatabase.getConnection();
            preparedStatement = connection.prepareStatement("SELECT surname, name, age, sex, phone FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            customer.setId(id);
            while(resultSet.next()) {
                customer.setSurname(resultSet.getString("surname"));
                customer.setName(resultSet.getString("name"));
                customer.setAge(resultSet.getInt("age"));
                customer.setSex(resultSet.getString("sex"));
                customer.setPhone(resultSet.getString("phone"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return customer;
    }
}
