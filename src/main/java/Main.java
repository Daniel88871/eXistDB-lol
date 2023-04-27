import controller.ExistController;
import view.Menu;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase es la que gestionara lo que el usuario ponga por terminal, llamando a los metodos necesarios de cada opción
 */
public class Main {

    /**
     * Constructor vacio del main
     */
    public Main(){}

    /**
     * El metodo que basicamente ejecutara nuestra aplicación, mostrara el menu y donde el usuario escribira la opcion que desea
     * @param args los argumentos por parametro que se le pasan
     * @throws XQException Si ocurre un error, saltara esta excepcion
     */
    public static void main(String[] args) throws XQException {
        ExistController ec = new ExistController();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        String nameCampeon, newNameCampeon, newVictoryCampeon, campeonDelete, campeonIDelete;
        int option = 0;

        option = menu.mainMenu();

        while (option != 0){
            switch (option){
                case 1:
                    ec.queryAllCampeones();
                    break;

                case 2:
                    ec.queryAllCampeonesByName();
                    break;

                case 3:
                    System.out.print("Introduce el nombre del campeón que quieres modificar: ");
                    nameCampeon = scanner.nextLine();
                    System.out.println("Ahora introduce el nombre nuevo del campeón");
                    newNameCampeon = scanner.nextLine();
                    ec.modifierCampeonName(nameCampeon,newNameCampeon);
                    break;

                case 4:
                    System.out.print("Introduce el nombre del campeón que quieres modificar: ");
                    nameCampeon = scanner.nextLine();
                    System.out.println("Ahora introduce el nuevo porcentaje de victoria del campeón");
                    newVictoryCampeon = scanner.nextLine();
                    ec.modifierVictoryPercentajeCampeon(nameCampeon, newVictoryCampeon);
                    break;

                case 5:
                    System.out.print("Introduce la ID del campeón que quieres borrar: ");
                    campeonDelete = scanner.nextLine();
                    ec.deleteCampeonesByID(campeonDelete);
                    break;

                case 6:
                    System.out.print("El nombre del campeon que quieres borrar: ");
                    campeonIDelete = scanner.nextLine();
                    ec.deleteCampeonesByName(campeonIDelete);
                    break;
            }
            option = menu.mainMenu();
        }
    }
}