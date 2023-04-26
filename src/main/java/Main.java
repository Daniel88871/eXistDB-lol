import controller.ExistController;
import view.Menu;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws XQException, InterruptedException, IOException {
        ExistController ec = new ExistController();
        XQResultSequence xqrs;
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        int option;
        option = menu.mainMenu();

        while (option != 9) {
            switch (option) {
                case 1 -> {
                    String cad = "for $i in doc('/db/apps/foaf/characters.xml')/Characters/Character"
                            +"\n"
                            + "return concat($i/CHARACATER_NAME, ' - ', $i/CHARACTER_RAREZA, ' - ', $i/CHARACTER_ELEMENTO, ' - ', $i/CHARACTER_REGION, ' - ', $i/CHARACTER_ARMA, ' - ', $i/CHARACTER_IMAGE, ' - ', $i/CHARACTER_DESCRIPCION)";
                    xqrs = ec.executeQuery(cad);
                    ec.printResultSequence(xqrs);
                }

                case 2 -> {
                    System.out.println("Enter the region name : ");
                    String region = sc.nextLine();
                    String cad = "for $i in doc('/db/apps/foaf/characters.xml')/Characters/Character " +
                            "where $i/CHARACTER_REGION = '" + region + "'"
                            + "\n"
                            + "return concat($i/CHARACATER_NAME, ' - ', $i/CHARACTER_RAREZA, ' - ', $i/CHARACTER_ELEMENTO, ' - ', $i/CHARACTER_REGION, ' - ', $i/CHARACTER_ARMA, ' - ', $i/CHARACTER_IMAGE, ' - ', $i/CHARACTER_DESCRIPCION)\n";
                    xqrs = ec.executeQuery(cad);
                    ec.printResultSequence(xqrs);
                }

                case 3 -> {
                    String cad = "for $i in doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACTER_RAREZA='5 Stars']"
                            +"\n"
                            + "return concat($i/CHARACATER_NAME, ' - ', $i/CHARACTER_RAREZA, ' - ', $i/CHARACTER_ELEMENTO, ' - ', $i/CHARACTER_REGION, ' - ', $i/CHARACTER_ARMA, ' - ', $i/CHARACTER_IMAGE, ' - ', $i/CHARACTER_DESCRIPCION)";
                    xqrs = ec.executeQuery(cad);
                    ec.printResultSequence(xqrs);
                }

                case 4 -> {
                    System.out.println("Enter the Character name : ");
                    String characterName = sc.nextLine();
                    String cad = "for $i in doc('/db/apps/foaf/characters.xml')/Characters/Character " +
                            "where $i/CHARACATER_NAME = '" + characterName + "'"
                            + "\n"
                            + "return concat($i/CHARACATER_NAME, ' - ', $i/CHARACTER_RAREZA, ' - ', $i/CHARACTER_ELEMENTO, ' - ', $i/CHARACTER_REGION, ' - ', $i/CHARACTER_ARMA, ' - ', $i/CHARACTER_IMAGE, ' - ', $i/CHARACTER_DESCRIPCION)\n";
                    xqrs = ec.executeQuery(cad);
                    ec.printResultSequence(xqrs);
                }

                case 5 -> {

                    System.out.println("Enter the character name: ");
                    String characterName = sc.nextLine();

                    System.out.println("Enter the new character name: ");
                    String name  = sc.nextLine();

                    String xquery = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + characterName + "']/CHARACATER_NAME \n" +
                           " with '" + name + "'";
                    ec.executeCommand(xquery);
                }

                case 6 -> {
                    System.out.println("Enter the character name: ");
                    String characterName = sc.nextLine();

                    System.out.println("Enter the new character name: ");
                    String name  = sc.nextLine();
                    String xquery_name = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + characterName + "']/CHARACATER_NAME \n" +
                            " with '" + name + "'";
                    ec.executeCommand(xquery_name);


                    System.out.println("Enter the new character rarity: ");
                    String rarity  = sc.nextLine();
                    String xquery_rarity = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + name + "']/CHARACTER_IMAGE \n" +
                            " with '" + rarity + "'";
                    ec.executeCommand(xquery_rarity);


                    System.out.println("Enter the new character image: ");
                    String image  = sc.nextLine();
                    String xquery_image = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + name + "']/CHARACTER_RAREZA \n" +
                            " with '" + image + "'";
                    ec.executeCommand(xquery_image);


                    System.out.println("Enter the new character description: ");
                    String description  = sc.nextLine();
                    String xquery_description = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + name + "']/CHARACTER_DESCRIPCION \n" +
                            " with '" + description + "'";
                    ec.executeCommand(xquery_description);


                    System.out.println("Enter the new character element: ");
                    String element  = sc.nextLine();
                    String xquery_element = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + name + "']/CHARACTER_ELEMENTO \n" +
                            " with '" + element + "'";
                    ec.executeCommand(xquery_element);


                    System.out.println("Enter the new character region: ");
                    String region  = sc.nextLine();
                    String xquery_region = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + name + "']/CHARACTER_REGION \n" +
                            " with '" + region + "'";
                    ec.executeCommand(xquery_region);


                    System.out.println("Enter the new character weaponType: ");
                    String weaponType  = sc.nextLine();
                    String xquery_weaponType = "update value \n" +
                            "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + name + "']/CHARACTER_ARMA \n" +
                            " with '" + weaponType + "'";
                    ec.executeCommand(xquery_weaponType);

                }
                case 7 -> {
                    System.out.println("Enter the name of the character you want to remove");
                    String characterName = sc.nextLine();

                    String cad = "update delete doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACATER_NAME='" + characterName + "']";
                    ec.executeCommand(cad);

                }
                case 8 -> {
                    System.out.println("Enter the Region of the characters you want to remove");
                    String characterRegion = sc.nextLine();

                    String cad = "update delete \n" + "doc('/db/apps/foaf/characters.xml')/Characters/Character[CHARACTER_REGION='" + characterRegion + "']";
                    ec.executeCommand(cad);
                    System.out.println("Characters removed successful");
                }
                default -> System.out.println("option not found, try again");
            }
            option = menu.mainMenu();
        }
    }
}