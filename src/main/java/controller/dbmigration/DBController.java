package controller.dbmigration;

import beans.Client;
import beans.CreditCard;
import beans.DebitCard;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DBController {
    private static final Logger logger = LogManager.getLogger(DBController.class.getName());
    private Connection connection;
    private String login;
    private String password;
    private String dbName;
    private String hostname;

    public DBController(String login, String password, String dbName, String hostname) {
        PropertyConfigurator.configure("log4j.properties");
        logger.info("logging is starting");
        this.dbName = dbName;
        this.hostname = hostname;
        this.login = login;
        this.password = password;
    }

    public void Connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/" + dbName, login, password);

        } catch (Exception e) {
            logger.error("connection to DB failed");
        }
    }

    public void Disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        logger.info("logging is stopping(db connection closed)");

    }

    public void AddCreditCardToDB(CreditCard creditCard) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `creditcards`(`cardnumber`, `validthrue`, `balance`, `cardholderName`," +
                    " `cardholderSurname`, `creditbalance`) VALUES (" + creditCard.getCardNumber() + ",'" +
                    creditCard.getValidThru() + "'," + creditCard.getBalance() + ",'" + creditCard.getCardholderName() + "','" +
                    creditCard.getCardholderSurname() + "'," + creditCard.getCreditBalance() + ")");

        } catch (SQLException e) {
            logger.error("cannot added creditcard to DB.Returned:" + e.getMessage());
        }
    }

    public void AddDebitCardToDB(DebitCard paymentCard) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `debetcards`(`cardnumber`, `validthrue`, `balance`, `cardholderName`," +
                    " `cardholderSurname`, `accountnumber`) VALUES (" + paymentCard.getCardNumber() + ",'" +
                    paymentCard.getValidThru() + "'," + paymentCard.getBalance() + ",'" + paymentCard.getCardholderName() + "','" +
                    paymentCard.getCardholderSurname() + "'," + paymentCard.getAccountNumber() + ")");

        } catch (SQLException e) {
            logger.error("cannot added debitcard to DB.Returned:" + e.getMessage());
        }
    }

    public void AddClientToDB(Client client) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `users`(`id`, `name`, `surname`, `clientcardscount`) " +
                    "VALUES (" + client.getId() + ",'" +
                    client.getName() + "','" + client.getSurname() + "'," + client.getClientCardsCount()+")");

        } catch (SQLException e) {
            logger.error("cannot added client to DB. Returned:" + e.getMessage());
        }
    }
}
