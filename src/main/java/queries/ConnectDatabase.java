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
        } catch (ClassNotFoundException var3) {
            System.err.println("НЕ удалось загрузить драйвер ДБ.");
            var3.printStackTrace(System.out);
        }

        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:file:c:\\Java\\phoneBook\\db\\contactsDB", "SA", "");
        } catch (SQLException var2) {
            System.err.println("НЕ удалось создать соединение.");
            var2.printStackTrace(System.out);
        }

        return connection;
    }
}
