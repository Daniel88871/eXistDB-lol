package controller;

import javax.xml.xquery.*;

import net.xqj.exist.ExistXQDataSource;
import org.exist.http.jaxb.Query;
import javax.xml.namespace.QName;

public class ExistController {
    private XQConnection connection;
    public ExistController() {
        try {
            XQDataSource xqs = new ExistXQDataSource();

            xqs.setProperty("serverName", "localhost");
            xqs.setProperty("port", "8080");
            xqs.setProperty("user", "admin");
            xqs.setProperty("password", "");
            connection = xqs.getConnection();

        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }

    public XQResultSequence executeQuery(String query) {
        try {
            XQExpression xqe = connection.createExpression();
            XQResultSequence xqrs = xqe.executeQuery(query);
            return xqrs;

        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeCommand(String command) {
        try {
            XQExpression xqe = connection.createExpression();
            xqe.executeCommand(command);
        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }

    public void printResultSequence(XQResultSequence xqrs) {
        try {
            while (xqrs.next()) {
                System.out.println(xqrs.getItemAsString(null));
            }
        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }
}