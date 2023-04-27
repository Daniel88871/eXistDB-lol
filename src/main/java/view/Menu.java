package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Esta clase es la que creara nuestro menu y indicara que menu hay que teclear por pantalla
 */
public class Menu {
    private int option;
    Scanner sc = new Scanner(System.in);

    /**
     * Este constructor nos permite llamar al menu desde el main
     */
    public Menu() {
        super();
    }

    /**
     * Este metodo basicamente crea las opciones y permite que el usuario solo escoja del 1 al 6, siendo 0 el exit del menu
     * @return option devuelve la opcion del usuario, indicandole que metodo debera ejecutar
     */
    public int mainMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

        System.out.println("			          Menú  		            ");
        System.out.println("************************************************");
        System.out.println(" 	1. Mostrar todos los campeones	            ");
        System.out.println("	2. Mostrar campeón por orden alfabético     ");
        System.out.println("	3. Modificar el nombre de un campeón        ");
        System.out.println("	4. Modificar el % de victoria de un campeón ");
        System.out.println("	5. Borrar campeones por ID de objeto        ");
        System.out.println("	6. Borrar un campeón por nombre             ");
        System.out.println("	0. Salir                         	        ");
        System.out.println("************************************************");

        System.out.println("Escoje una opción: ");
        try {
            option = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Este valor no es válido, por favor escoja una opción correcta!!");
            e.printStackTrace();
        }
    } while (option != 1  && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 0);

        return option;
    }
}