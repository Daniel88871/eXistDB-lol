package controller;

import javax.xml.xquery.*;

import net.xqj.exist.ExistXQDataSource;
import org.exist.http.jaxb.Query;
import javax.xml.namespace.QName;

/**
 * Esta clase es el controlador del xml, nos permite gestionar las opciones del menu en base a los métodos que se crearán dentro de esta clase
 */
public class ExistController {
    private XQConnection connection;


    /**
     * Este constructor nos conecta con el existDB, para que desde la terminal el xquery pueda ver como es el xml y que pueda acceder a el y modificarlo
     * @throws RuntimeException Si no se conecta, saltara este error
     */
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

    /**
     * Este metodo permite ejecutar consultas que haremos desde el codigo, y la conexion creara la expresion para que esta ejecute el resto.
     * @return xqrs Devuelve el resultado de la consulta
     * @param query Este parametro reocge la consulta que ponemos
     * @throws RuntimeException si ocurre un error con la consulta, enviara un error indicando que la consulta no ha sido un éxito
     */
    public XQResultSequence executeQuery(String query) {
        try {
            XQExpression xqe = connection.createExpression();
            XQResultSequence xqrs = xqe.executeQuery(query);
            return xqrs;

        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este metodo ejecuta el comando una vez llamado el metodo
     * @param command Este parametro recoge el comando que queremos ejecutar
     */
    public void executeCommand(String command) {
        try {
            XQExpression xqe = connection.createExpression();
            xqe.executeCommand(command);
        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este metodo nos imprime por pantalla el resultado que nos ha dado la consulta que hemos realizado anteriormente
     * @param xqrs Este parametro recoge el resultado de la consulta y lo imprime por pantalla
     * @throws RuntimeException si ocurre un error al imprimir el resultado, saltara un error
     */
    public void printResultSequence(XQResultSequence xqrs) {
        try {
            while (xqrs.next()) {
                System.out.println(xqrs.getItemAsString(null));
            }
        } catch (XQException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este metodo nos lista todos los campeones, y luego los imprime
     */
    public void queryAllCampeones(){
        XQResultSequence xqrs = executeQuery("for $campeon in doc('/db/apps/foaf/campeones.xml')//Campeon return $campeon");
        printResultSequence(xqrs);
    }

    /**
     * Este metodo nos lista todos los campeones de forma ordenada y luego imprime solamente los nombres
     */
    public void queryAllCampeonesByName(){
        XQResultSequence xqrs = executeQuery("for $campeon in doc('/db/apps/foaf/campeones.xml')//Campeon order by $campeon/nombre return $campeon/nombre");
        printResultSequence(xqrs);
    }

    /**
     * Este metodo hace que puedas modificar el nombre de un campeon
     * @param oldName el nombre antiguo del campeon
     * @param newName el nombre nuevo del campeon
     */
    public void modifierCampeonName(String oldName, String newName) {
        String xquery = "update value \n" +
                "doc('/db/apps/foaf/campeones.xml')//Campeon[nombre='" + oldName + "']/nombre \n" +
                " with '" + newName + "'";
        executeCommand(xquery);

        String query = "for $campeon in doc('/db/apps/foaf/campeones.xml')//Campeon[nombre='" + newName + "'] return $campeon";
        XQResultSequence xqrs = executeQuery(query);
        printResultSequence(xqrs);
    }

    /**
     * Este metodo modifica el porcentaje de victorias del campeon que le indiquemos
     * @param nombre el nombre del campeon que queremos modificar
     * @param newporcentajedeVictoria el nuevo porcentaje de victoria que queremos que tenga nuestro campeon
     */
    public void modifierVictoryPercentajeCampeon(String nombre, String newporcentajedeVictoria) {
        String xquery = "update value \n" +
                "doc('/db/apps/foaf/campeones.xml')//Campeon[nombre='" + nombre + "']/porcentaje_de_victoria \n" +
                " with '" + newporcentajedeVictoria + "'";
        executeCommand(xquery);

        String query = "for $campeon in doc('/db/apps/foaf/campeones.xml')//Campeon[porcentaje_de_victoria='" + newporcentajedeVictoria + "'] return $campeon";
        XQResultSequence xqrs = executeQuery(query);
        printResultSequence(xqrs);
    }

    /**
     * Este metodo borra el campeon que le indiquemos
     * @param nameCampeon el nombre del campeon que queremos borrar
     */
    public void deleteCampeonesByName(String nameCampeon){
        String delete = "update delete doc('/db/apps/foaf/campeones.xml')//Campeon[nombre='" + nameCampeon + "']";
        executeCommand(delete);
    }

    /**
     * Este metodo borra un campeon por su ID
     * @param IDCampeon la ID del campeon que queremos borrar
     */
    public void deleteCampeonesByID(String IDCampeon){
        String delete = "update delete doc('/db/apps/foaf/campeones.xml')//Campeon[id='" + IDCampeon + "']";
        executeCommand(delete);
    }
}