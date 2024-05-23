import javax.tools.Tool;
import java.util.Scanner;

public class Player {
    private int damage ;
    private int orginalHealth;
    private int health;
    private int money ;
    private String charName;


    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private String name;
    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name = name;
        this.inventory=new Inventory();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void selectCharacter(){

        GameCharacter [] gameCharacters = {new Samurai(), new Archer(),new Knight()};


        for (GameCharacter gameChar : gameCharacters){
            System.out.println("ID "+gameChar.getId()+"\tCharacter: "+gameChar.getName()+"\tDamage:" + gameChar.getDamage()+"\tHealth:"+gameChar.getHealth()+ "\tMoney:"+gameChar.getMoney());

        }
        int selectCharacter = scanner.nextInt();
        System.out.println("-----------------------------");
        switch (selectCharacter){
            case 1 :
                initializePlayer(new Samurai());
                break;
            case 2 :
                initializePlayer(new Archer());
                break;
            case 3 :
                initializePlayer(new Knight());
                break;
            default:
                initializePlayer(new Samurai());

        }



    }

    public void initializePlayer(GameCharacter gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
        this.setOrginalHealth(gameChar.getHealth());
        printInfo();


    }

    public void printInfo(){
        System.out.println(
                        "Your weapon: " + this.getInventory().getWeapon().getName()
                        +"\t Your Armor:"+this.getInventory().getArmor().getName()
                        +"\t Your Block Level:"+this.getInventory().getArmor().getBlock()
                        +"\t Your Damage:"+this.getTotalDamage()
                        +"\t Your Health: "+this.getHealth()
                        + "\t Your Money: "+this.getMoney());



    }
    public int getTotalDamage(){
        return damage + this.inventory.getWeapon().getDamage();
    }

}
