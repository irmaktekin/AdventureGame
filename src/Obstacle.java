public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int award;
    private int originalHealth;

    public String getName() {
        return name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public  int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Obstacle(int id, String name, int damage, int health,int award) {
        this.id = id;
        this.name= name;
        this.damage = damage;
        this.health = health;
        this.award=award;
        this.originalHealth=health;
    }
    public Obstacle(int id, String name, int damage,int health) {
        this.id = id;
        this.name= name;
        this.health = health;
        this.originalHealth=health;
        this.damage=damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
