package queries;

import entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertQuery {

    public static List<Customer> insertUsers(String surname, String name, int age, String sex, String phone) {
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(surname, name, age, sex, phone) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, phone);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SelectQuery.selectUsers();
    }
}
