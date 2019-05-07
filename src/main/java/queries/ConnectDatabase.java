package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public ConnectDatabase() {
    }

    protected static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("НЕ удалось загрузить драйвер ДБ.");
            e.printStackTrace(System.out);
        }

        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:file:c:\\Java\\phoneBook\\db\\contactsDB", "SA", "");
        } catch (SQLException ex) {
            System.err.println("НЕ удалось создать соединение.");
            ex.printStackTrace(System.out);
        }

        return connection;
    }
}
