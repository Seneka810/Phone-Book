package queries;

import entities.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectQuery {
    public SelectQuery() {
    }

    public static List<Customer> selectTable() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList customers = new ArrayList();

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

            connection.commit();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException var6) {
            var6.printStackTrace(System.out);
        }

        return customers;
    }
}
