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

    public void queryAllCampeones(){
        XQResultSequence xqrs = executeQuery("for $campeon in doc('/db/apps/foaf/campeones.xml')//campeon return $campeon");
        printResultSequence(xqrs);
    }

    public void queryAllCampeonesByName(){
        XQResultSequence xqrs = executeQuery("for $campeon in doc('/db/apps/foaf/campeones.xml')//campeon order by $campeones/nombre return $campeones/nombre");
        printResultSequence(xqrs);
    }

    public void modifierCampeonName(String oldName, String newName) {
        String xquery = "update value \n" +
                "doc('/db/apps/foaf/campeones.xml')//campeon[nombre='" + oldName + "']/nombre \n" +
                " with '" + newName + "'";
        executeCommand(xquery);

        String query = "for $campeon in doc('/db/apps/foaf/campeones.xml')//campeon[nombre='" + newName + "'] return $campeon";
        XQResultSequence xqrs = executeQuery(query);
        printResultSequence(xqrs);
    }

    public void modifierVictoryPercentajeCampeon(String oldName, String newName) {
        String xquery = "update value \n" +
                "doc('/db/apps/foaf/campeones.xml')//campeon[porcentaje_de_victoria='" + oldName + "']/porcentaje_de_victoria \n" +
                " with '" + newName + "'";
        executeCommand(xquery);

        String query = "for $campeon in doc('/db/apps/foaf/campeones.xml')//campeon[porcentaje_de_victoria='" + newName + "'] return $campeon";
        XQResultSequence xqrs = executeQuery(query);
        printResultSequence(xqrs);
    }

    public void deleteCampeonesByName(String nameCampeon){
        String delete = "update delete doc('/db/apps/foaf/campeones.xml')//campeon[nombre='" + nameCampeon + "']";
        executeCommand(delete);
    }

    public void deleteCampeonesByID(String IDCampeon){
        String delete = "update delete doc('/db/apps/foaf/campeones.xml')//campeon[id='" + IDCampeon + "']";
        executeCommand(delete);
    }
}