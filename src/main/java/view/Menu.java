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

        System.out.println("			           Menú			             ");
        System.out.println("*************************************************");
        System.out.println(" 	1.  Mostrar todos los campeones	             ");
        System.out.println("	4.  Mostrar campeón por ID                   ");
        System.out.println("	7.  Modificar el nombre de un campeón        ");
        System.out.println("	10. Borrar un campeón por nombre             ");
        System.out.println("	0.  Salir                         	         ");
        System.out.println("*************************************************");

        System.out.println("Escoje una opción: ");
        try{
            option = sc.nextInt();
        }catch (Exception e){
            System.out.println("La opción elegida no existe, por favor, escoje una opción correcta!!");
        }
        return option;
    }
}