import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int number = random.nextInt(6)+3;

    public void startGame(){
        System.out.println("Welcome to adventure game!!!!");
        System.out.println("Please enter a name for your player:");

        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome to the adventure " + player.getName());
        System.out.println("Please select a character:");
        System.out.println("---------------------------");
        player.selectCharacter();

        Location location = null;

        while(true){

            System.out.println();
            System.out.println("##### Locations #####");
            System.out.println();
            System.out.println("1.Safe House-----> Here is safe place for you, no enemies are living there.");
            System.out.println("2.Tool Store------> You can buy armors and weapons.");
            System.out.println("3.Cave-------->Be careful!. You can attacked by zombies");
            System.out.println("4.Forest------> Be careful! You can attacked by vampires.");
            System.out.println("5.River-------> Be careful! You can attacked by bears.");
            System.out.println("6.Treasure-------> Be careful! You can attacked by snakes.");
            System.out.println("0.Exit");

            System.out.println("Please select a location:");
            int loc = scanner.nextInt();
//creates locations according to user selection
            switch (loc ){
                    case 0:
                        location = null;
                        break;
                    case 1 :
                        location= new SafeHouse(player);
                        break;
                    case 2 :
                        location = new ToolStore(player);
                        break;
                    case 3:
                        location = new Cave(player,"FOOD");
                        break;
                    case 4:
                        location = new Forest(player,"FIREWOOD");
                        break;
                    case 5:
                        location= new River(player,"WATER");
                        break;
                    case 6:
                        location = new Mine(player,number);
                        break;
                    default:
                        System.out.println("Please enter a valid location.");
                }
            try{
                boolean isGameOver = location.onLocation();
                if(!isGameOver){
                    break;
                }
            }
            catch(NullPointerException e){
                System.out.println("You give up so fast! Hope to see you again.");
                break;
            }
            if( location.getPlayer().getInventory().getCurrentAwards().size()==3 && location.getName().equals("Safe House")){
                System.out.println("<<<---CONGRATS, YOU COLLECT ALL AWARDS AND YOU ARE IN SAFE! --->>>");
                break;
            }

        }

    }
}
