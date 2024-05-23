import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private String locationAward;



    public String getLocationAward() {
        return locationAward;
    }

    public void setLocationAward(String locationAward) {
        this.locationAward = locationAward;
    }


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle,String locationAward) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle = maxObstacle;
        this.locationAward=locationAward;

    }
    //Constructor overloading for be able to create a location without award.
    public BattleLoc(Player player, String name, Obstacle obstacle,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.maxObstacle=maxObstacle;

    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    //Location checks and selection for fight or run.
    @Override
    public boolean onLocation() {

            if(getPlayer().getInventory().getCurrentAwards().contains(getLocationAward())){
                System.out.println("Already entered this location");
                return true;
            }
            int obstNumber = randomObstacleNumber();

            System.out.println("You are in: " + this.getName());
            System.out.println("Be careful, " + obstNumber +" "+ this.getObstacle().getName() + " are living here.");
            System.out.println("Press F --> Fight\nPress R --> Run ");
            String selectCase = input.nextLine();
            selectCase = selectCase.toUpperCase();
            if (selectCase.equals("F") && combat(obstNumber)) {
                System.out.println(this.getPlayer().getName() + " killed all enemies.");
                System.out.println("You win the special award ---> "+ getLocationAward());
                return true;

            } else if(selectCase.equals("R")){
                System.out.println("You've ran from " + getName());
                return true;
            }
            else if (this.getPlayer().getHealth() <= 0) {
                System.out.println("You are dead.");
                System.out.println("GAME OVER");
                return false;
            }
            return false;
    }
    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public int getMaxObstacle() {
        return maxObstacle;

    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;

    }

    //fighting
    public boolean combat(int obsNumber) {
        Random random = new Random();

        for (int i = 1; i <= obsNumber; i++) {
            int result = random.nextInt(2);
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("Fight or run");
                String selectCombat = input.nextLine().toUpperCase();

                if (selectCombat.equals("F")) {
                    System.out.println("Round: "+i);
                    if(result==0){

                        playerHit();
                        obstacleHit();
                    }
                    else if(result==1){
                        obstacleHit();
                        playerHit();
                    }
                    System.out.println("-----------------");

                } else {
                    return false;
                }
            }
                if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                    System.out.println("You beat the enemy.");
                    System.out.println("Your award is:  " + this.getObstacle().getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Your credit:" + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().addAward(this.getLocationAward());

                    if(this.getObstacle().getName().equals("Snake")){
                        System.out.println("-----Random Awards!----");
                        collectRandomAward();
                    }
                    return true;

                }
                return false;
            }
        return false;
        }

    //It randomly generates an object or money in the location Mine.
    private void collectRandomAward() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber < 15) {
            int armorNumber = random.nextInt(100);
            if (armorNumber < 20) {
                System.out.println("You win heavy armor!");
            } else if (armorNumber < 50) {
                System.out.println("You win medium armor!");
            } else {
                System.out.println("You win light armor!");
            }
        } else if (randomNumber < 35) {
            int weaponNumber = random.nextInt(100);
            if (weaponNumber < 20) {
                System.out.println("You win a rifle!");
            } else if (weaponNumber < 50) {
                System.out.println("You win a sword!");
            } else {
                System.out.println("You win a pistol!");
            }
        } else if (randomNumber < 60) {
            int moneyNumber = random.nextInt(100);
            if (moneyNumber < 20) {
                System.out.println("You win 10 money!");
            } else if (moneyNumber < 50) {
                System.out.println("You win 5 money!");
            } else {
                System.out.println("You win 1 money!");
            }
        } else {
            System.out.println("You don't win anything.");
        }
    }


    public void afterHit() {
        System.out.println("Your health: "+this.getPlayer().getHealth());
        System.out.println("Health of  "+this.getObstacle().getName() +"is" + this.getObstacle().getHealth());
        System.out.println("-------------");
    }

    public void playerHit(){
        System.out.println("You hit!");
        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
        afterHit();
    }
    public void obstacleHit(){
        if (this.getObstacle().getHealth() >= 0) {
            System.out.println();
            System.out.println(this.obstacle.getName() + " is hit you.");
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
            if (obstacleDamage < 0) {
                obstacleDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
            afterHit();
        }

    }

    public void obstacleStats(int i) {
        System.out.println(i+"."+this.obstacle.getName()+" Values:");
        System.out.println("-------------");
        System.out.println("Health: "+this.getObstacle().getHealth());
        System.out.println("Damage:"+ this.getObstacle().getDamage());
        System.out.println("Award: "+this.getObstacle().getAward());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Player values:");
        System.out.println("-------------");
        System.out.println("Health: "+this.getPlayer().getHealth());
        System.out.println("Health: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage:"+ this.getPlayer().getTotalDamage());
        System.out.println("Money:"+ this.getPlayer().getMoney());
        System.out.println();

    }

}
