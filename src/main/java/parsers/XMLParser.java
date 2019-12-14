package parsers;

import parsers.exceptions.ParserExceptions;

import java.util.List;

public interface XMLParser <T> {
    List<T> getData(String path) throws ParserExceptions;
}
