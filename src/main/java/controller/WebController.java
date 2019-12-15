package controller;
import beans.User;
import beans.CreditCard;
import beans.DebitCard;
import dao.factory.DaoFactory;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.Logger;
import parsers.DOMParser;
import parsers.SAXParser;
import parsers.StAXParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@MultipartConfig
@WebServlet
public class WebController extends HttpServlet {

    SAXParser parserSAX= new SAXParser();
    DOMParser parserDOM = new DOMParser();
    StAXParser parserSTAX= new StAXParser();
    private final static Logger logger = Logger.getLogger(DOMParser.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // PropertyConfigurator.configure("log4j.properties");
       // logger.info("In doGet");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> list = null;
        List<User> list1 = null;
        List<User> list2 = null;


        try {
            parserDOM.getData("clients.xml", User.class);
            list = DaoFactory.getInstance().getClientDAO().ReadClient();
            parserSAX.getData("clients.xml", CreditCard.class);
            list1 = DaoFactory.getInstance().getClientDAO().ReadClient();
            parserSTAX.getData("clients.xml", DebitCard.class);
            list2 = DaoFactory.getInstance().getClientDAO().ReadClient();

        } catch (ParserException e) {

        }
        req.setAttribute("listDom", list);
       req.setAttribute("listSax", list1);
        req.setAttribute("listStax", list2);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
