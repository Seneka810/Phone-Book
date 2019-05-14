package queries;

import entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateQuery {

    public static void updateUser(Customer customer){

        try{
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET surname = ?, name = ?, age = ?, sex = ?, phone = ? WHERE id = ?");
            preparedStatement.setString(1, customer.getSurname());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.setString(4, customer.getSex());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setInt(6, customer.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
