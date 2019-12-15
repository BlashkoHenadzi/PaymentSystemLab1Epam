package dao.impl.mysql.converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface DtoConverter <T> {
    String EMPTY_STRING = "";
    default List<T> convertToObjectList(ResultSet resultSet)
            throws SQLException {
        return convertToObjectList(resultSet, EMPTY_STRING);
    }
    default List<T> convertToObjectList(ResultSet resultSet, String tablePrefix)
            throws SQLException {
        List<T> convertedObjects = new ArrayList<T>();

        while (resultSet.next()){
            convertedObjects.add(convertToObject(resultSet, tablePrefix));
        }

        return convertedObjects;
    }


    default T convertToObject(ResultSet resultSet) throws SQLException {
        return convertToObject(resultSet, EMPTY_STRING);
    }

    T convertToObject(ResultSet resultSet, String tablePrefix) throws SQLException;

}
