package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    private int option;
    Scanner sc = new Scanner(System.in);

    /**
     * constructor
     */
    public Menu() {
        super();
    }

    /**
     * Menu que contiene los opciones que controla los submenus
     * @return retorna las opciones
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