package db_objs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.main_interface;

public class MyJDBC {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "saryuisagod1123";

    public static Stocks getStocks() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM stocks");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String product_name = resultSet.getString("product_name");
                BigDecimal product_price = resultSet.getBigDecimal("product_price");
                String category = resultSet.getString("category");
                int qty = resultSet.getInt("quantity");

                return new Stocks(id, product_name, product_price, category, qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String status = resultSet.getString("status");
                return new User(userId, username, password, name, email, address, status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validateUsername(String username) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?");

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean register(String username, String password, String name, String address, String email, String status) {
        try {
            if (!checkUser(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(username, password, name, address, email, status) "
                        + "VALUES(?,?,?,?,?,?)");

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, status);

                preparedStatement.executeUpdate();
                return true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkUser(String username) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?");

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public static boolean forgotPassword(String username, String password) {
        try {
            if (checkUser(username)) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE users SET password = ? WHERE username = ?");

                preparedStatement.setString(1, password);
                preparedStatement.setString(2, username);

                preparedStatement.executeUpdate();
                return true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addTransactionToDatabase(Transaction transaction) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement insertTransaction = connection.prepareStatement(
                    "INSERT transaction(user_id, product_name, product_price, product_quantity, transaction_type, seller, total_price,payment_method,status,pre_order_date,category,description,delivery,date)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,NOW())");

            insertTransaction.setInt(1, transaction.getUserId());
            insertTransaction.setString(2, transaction.getProductName());
            insertTransaction.setBigDecimal(3, transaction.getProductPrice());
            insertTransaction.setInt(4, transaction.getProductQuantity());
            insertTransaction.setString(5, transaction.getTransactionType());
            insertTransaction.setString(6, transaction.getSeller());
            insertTransaction.setBigDecimal(7, transaction.getTotalPrice());
            insertTransaction.setString(8, transaction.getPaymentMethod());
            insertTransaction.setString(9, transaction.getStatus());
            insertTransaction.setString(10, transaction.getPreOrderDate());
            insertTransaction.setString(11, transaction.getCategory());
            insertTransaction.setString(12, transaction.getDesc());
            insertTransaction.setString(13, transaction.getDelivery());
            
            insertTransaction.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addLogsToDatabase(Logs logs) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement insertLogs = connection.prepareStatement(
                    "INSERT logs(actions, modified_by, user_id1, date, time)"
                    + "VALUES(?,?,?,NOW(),NOW())");

            insertLogs.setString(1, logs.getActions());
            insertLogs.setString(2, logs.getModifiedBy());
            insertLogs.setInt(3, logs.getUserId());

            insertLogs.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Logs> getLogs(User user) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllLogs = connection.prepareStatement(
                    "SELECT * FROM logs");

            ResultSet resultSet = selectAllLogs.executeQuery();

            // resultSet.getInt("Id")
            //(int userId, String actions, String modified_by, Date logsDate, Time logsTime)
            while (resultSet.next()) {
                Logs logs = new Logs(resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                main_interface.pastLogs.add(logs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return main_interface.pastLogs;
    }

    public static ArrayList<Logs> getLogsProduct(User user) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllLogs = connection.prepareStatement(
                    "SELECT * FROM logs WHERE actions LIKE '%ITEM%'");

            ResultSet resultSet = selectAllLogs.executeQuery();

            // resultSet.getInt("Id")
            //(int userId, String actions, String modified_by, Date logsDate, Time logsTime)
            while (resultSet.next()) {
                Logs logs = new Logs(resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                main_interface.pastLogs.add(logs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return main_interface.pastLogs;
    }

    public static ArrayList<Logs> getLogsProfile(User user) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllLogs = connection.prepareStatement(
                    "SELECT * FROM logs WHERE actions LIKE '%PROFILE%'");

            ResultSet resultSet = selectAllLogs.executeQuery();

            // resultSet.getInt("Id")
            //(int userId, String actions, String modified_by, Date logsDate, Time logsTime)
            while (resultSet.next()) {
                Logs logs = new Logs(resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                main_interface.pastLogs.add(logs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return main_interface.pastLogs;
    }

    public static ArrayList<Logs> getLogsUser(User user) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllLogs = connection.prepareStatement(
                    "SELECT * FROM logs WHERE user_id1 = ?");

            selectAllLogs.setInt(1, user.getId());

            ResultSet resultSet = selectAllLogs.executeQuery();

            // resultSet.getInt("Id")
            //(int userId, String actions, String modified_by, Date logsDate, Time logsTime)
            while (resultSet.next()) {
                Logs logs = new Logs(resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                main_interface.pastLogs1.add(logs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return main_interface.pastLogs1;
    }

    public static ArrayList<Logs> getLogsUserProduct(User user) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllLogs = connection.prepareStatement(
                    "SELECT * FROM logs WHERE user_id1 = ? and actions LIKE '%ITEM%'");

            selectAllLogs.setInt(1, user.getId());

            ResultSet resultSet = selectAllLogs.executeQuery();

            // resultSet.getInt("Id")
            //(int userId, String actions, String modified_by, Date logsDate, Time logsTime)
            while (resultSet.next()) {
                Logs logs = new Logs(resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                main_interface.pastLogs1.add(logs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return main_interface.pastLogs1;
    }

    public static ArrayList<Logs> getLogsUserProfile(User user) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement selectAllLogs = connection.prepareStatement(
                    "SELECT * FROM logs WHERE user_id1 = ? and actions LIKE '%PROFILE%'");

            selectAllLogs.setInt(1, user.getId());

            ResultSet resultSet = selectAllLogs.executeQuery();

            // resultSet.getInt("Id")
            //(int userId, String actions, String modified_by, Date logsDate, Time logsTime)
            while (resultSet.next()) {
                Logs logs = new Logs(resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                main_interface.pastLogs1.add(logs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return main_interface.pastLogs1;
    }
    public static Logs logs;

    public static ArrayList<Logs> getLogsUserSearch(User user, String search, int hehe) {
        String query = "SELECT * FROM logs WHERE user_id1 = ? AND (actions LIKE ? OR modified_by LIKE ?)";

        ArrayList<Logs> pastLogs = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Construct the search string with wildcards
            String searchString = "%" + search + "%";

            PreparedStatement selectAllLogs = connection.prepareStatement(query);
            selectAllLogs.setInt(1, hehe); // Assuming hehe is used to represent user_id1
            selectAllLogs.setString(2, searchString);
            selectAllLogs.setString(3, searchString);

            ResultSet resultSet = selectAllLogs.executeQuery();

            while (resultSet.next()) {
                Logs logs = new Logs(
                        resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                pastLogs.add(logs);
            }

            resultSet.close();
            selectAllLogs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastLogs;
    }

    public static ArrayList<Logs> getLogsAdminSearch(User user, String search) {
        String query = "SELECT * FROM logs WHERE (actions LIKE ? OR modified_by LIKE ?)";

        ArrayList<Logs> pastLogs = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Construct the search string with wildcards
            String searchString = "%" + search + "%";

            PreparedStatement selectAllLogs = connection.prepareStatement(query);
            // Assuming hehe is used to represent user_id1
            selectAllLogs.setString(1, searchString);
            selectAllLogs.setString(2, searchString);

            ResultSet resultSet = selectAllLogs.executeQuery();

            while (resultSet.next()) {
                Logs logs = new Logs(
                        resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                pastLogs.add(logs);
            }

            resultSet.close();
            selectAllLogs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastLogs;
    }
    
    public static ArrayList<Logs> getLogsUserSearchAction(User user, String search, int hehe) {
        String query = "SELECT * FROM logs WHERE user_id1 = ? AND (actions LIKE ?)";

        ArrayList<Logs> pastLogs = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Construct the search string with wildcards
            String searchString = "%" + search + "%";

            PreparedStatement selectAllLogs = connection.prepareStatement(query);
            selectAllLogs.setInt(1, hehe); // Assuming hehe is used to represent user_id1
            selectAllLogs.setString(2, searchString);


            ResultSet resultSet = selectAllLogs.executeQuery();

            while (resultSet.next()) {
                Logs logs = new Logs(
                        resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                pastLogs.add(logs);
            }

            resultSet.close();
            selectAllLogs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastLogs;
    }
public static ArrayList<Logs> getLogsAdminSearchAction(User user, String search) {
        String query = "SELECT * FROM logs WHERE (actions LIKE ?)";

        ArrayList<Logs> pastLogs = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Construct the search string with wildcards
            String searchString = "%" + search + "%";

            PreparedStatement selectAllLogs = connection.prepareStatement(query);
            // Assuming hehe is used to represent user_id1
            selectAllLogs.setString(1, searchString);


            ResultSet resultSet = selectAllLogs.executeQuery();

            while (resultSet.next()) {
                Logs logs = new Logs(
                        resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                pastLogs.add(logs);
            }

            resultSet.close();
            selectAllLogs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastLogs;
    }

public static ArrayList<Logs> getLogsAdminSearchUser(User user, String search) {
        String query = "SELECT * FROM logs WHERE (modified_by LIKE ?)";

        ArrayList<Logs> pastLogs = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Construct the search string with wildcards
            String searchString = "%" + search + "%";

            PreparedStatement selectAllLogs = connection.prepareStatement(query);
            // Assuming hehe is used to represent user_id1
            selectAllLogs.setString(1, searchString);


            ResultSet resultSet = selectAllLogs.executeQuery();

            while (resultSet.next()) {
                Logs logs = new Logs(
                        resultSet.getInt("Id"),
                        resultSet.getString("actions"),
                        resultSet.getString("modified_by"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                );
                pastLogs.add(logs);
            }

            resultSet.close();
            selectAllLogs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pastLogs;
    }

}
