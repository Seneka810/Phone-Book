//import entities.Customer;
//import queries.ConnectDatabase;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestDB {
//    public static void main(String[] args) throws IOException {
//        Connection connection = null;
//        try{
//            Class.forName("org.hsqldb.jdbcDriver");
//        }
//        catch (ClassNotFoundException e){
//            System.err.println("НЕ удалось загрузить драйвер ДБ.");
//            e.printStackTrace(System.out);
//        }
//        try {
//            connection = DriverManager.getConnection(
//                    "jdbc:hsqldb:file:c:\\Java\\phoneBook\\db\\contactsDB", "SA", "");
//        } catch (SQLException e) {
//            System.err.println("НЕ удалось создать соединение.");
//            e.printStackTrace(System.out);
//        }
//
//        Statement statement = null;
//        ResultSet resultSet = null;
//        Customer customer;
//        List<Customer> customers = new ArrayList<>();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String surname = reader.readLine();
//        String name = reader.readLine();
//        String age = reader.readLine();
//        String sex = reader.readLine();
//        String phone = reader.readLine();
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(surname, name, age, sex, phone) VALUES (?, ?, ?, ?, ?)");
//            preparedStatement.setString(1, surname);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, age);
//            preparedStatement.setString(4, sex);
//            preparedStatement.setString(5, phone);
//
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("SELECT id, surname, name, age, sex, phone FROM users");
//
//            while (resultSet.next()){
//                customer = new Customer();
//                customer.setId(resultSet.getInt("id"));
//                customer.setSurname(resultSet.getString("surname"));
//                customer.setName(resultSet.getString("name"));
//                customer.setAge(resultSet.getInt("age"));
//                customer.setSex(resultSet.getString("sex"));
//                customer.setPhone(resultSet.getString("phone"));
//
//                customers.add(customer);
//            }
//
//            connection.commit();
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        }
//
//        for (Customer c : customers) {
//            System.out.print(c.getId() + " | ");
//            System.out.print(c.getSurname() + " | ");
//            System.out.print(c.getName() + " | ");
//            System.out.print(c.getAge() + " | ");
//            System.out.print(c.getSex() + " | ");
//            System.out.print(c.getPhone());
//            System.out.println();
//        }
//    }
//}
