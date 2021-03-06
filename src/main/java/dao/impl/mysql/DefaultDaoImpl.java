package dao.impl.mysql;

import dao.exception.DaoException;
import dao.impl.mysql.converter.DtoConverter;

import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.log4j.Logger;


public class DefaultDaoImpl <T> {
    private final static String ERROR_GENERATE_KEY =
            "Can't retrieve generated key";
    private final static String SQL_LIMIT_ONE = " LIMIT 1";

    private final Logger logger = Logger.getLogger(DefaultDaoImpl.class);

    private Connection connection;

    private DtoConverter<T> converter;

    public DefaultDaoImpl(Connection connection, DtoConverter<T> converter) {
        this.connection = connection;
        this.converter = converter;
    }

    public Connection getConnection() {
        return connection;
    }

    public Optional<T> findOne(String query, Object... params) {
        List<T> results = findAll(query + SQL_LIMIT_ONE, params);
        return Optional.ofNullable(results.isEmpty() ? null : results.get(0));
    }

    public List<T> findAll(String query, Object... params) {
        try (PreparedStatement statement = connection
                .prepareStatement(query)) {

            setParamsToStatement(statement, params);
            try (ResultSet resultSet = statement.executeQuery()) {
                return converter.convertToObjectList(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    public void executeUpdate(String query, Object... params) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            setParamsToStatement(statement, params);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    public long executeInsertWithGeneratedPrimaryKey(String query,
                                                     Object... params) {
        try (PreparedStatement statement = connection
                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            setParamsToStatement(statement, params);
            statement.executeUpdate();

            return getGeneratedPrimaryKey(statement);

        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    private void setParamsToStatement(PreparedStatement statement, Object... params)
            throws SQLException {
        Objects.requireNonNull(params);

        for (int i = 0; i < params.length; i++) {
            if (params[i] != null) {
                statement.setObject(i + 1, params[i]);
            } else {
                statement.setNull(i + 1, Types.OTHER);
            }
        }
    }

    private long getGeneratedPrimaryKey(PreparedStatement statement)
            throws SQLException {
        ResultSet rs = statement.getGeneratedKeys();
        if(rs.next()) {
            return rs.getLong(1);
        } else {
            throw new DaoException(ERROR_GENERATE_KEY);
        }
    }

}
