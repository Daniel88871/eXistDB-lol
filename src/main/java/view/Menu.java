package view;

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

        System.out.println("			          Menú  		            ");
        System.out.println("************************************************");
        System.out.println(" 	1. Mostrar todos los campeones	            ");
        System.out.println("	2. Mostrar campeón por ID                   ");
        System.out.println("	3. Modificar campeón                        ");
        System.out.println("	4. Modificar el nombre de un campeón        ");
        System.out.println("	5. Borrar campeones por ID de objeto        ");
        System.out.println("	6. Borrar un campeón por nombre             ");
        System.out.println("	0. Salir                         	        ");
        System.out.println("************************************************");

        System.out.println("Escoje una opción: ");
        try{
            option = sc.nextInt();
        }catch (Exception e){
            System.out.println("La opción elegida no existe, por favor, escoje una opción correcta!!");
        }
        return option;
    }
}