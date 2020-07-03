package base;

import dictionary.BaseRequest;

import java.sql.*;

public class H2 {
    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/out";
    private final String USER = "admin";
    private final String PASS = "12345";

    private static boolean isTableCreating = false;
    private static H2 instance;

    private H2() {
        if (!isTableCreating) {
            createTable();
        }
        isTableCreating = true;
    }

    public static H2 getInstance() {
        if (instance == null) {
            instance = new H2();
        }
        return instance;
    }

    public boolean isExitUsername(Integer userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.prepareStatement(BaseRequest.GET.getText());
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void insertUsername(Integer userId) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(BaseRequest.INSERT.getText());
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBase() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate(BaseRequest.DELETE.getText());
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCountParticipant() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(BaseRequest.GET_ALL.getText());
            if (resultSet.next()) {
                resultSet.last();
                return resultSet.getRow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private void createTable() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate(BaseRequest.CREATE.getText());
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
