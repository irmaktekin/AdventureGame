public abstract class GameCharacter {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private String name;
    private int damage;
    private int health;
    private int money;




    public GameCharacter(int id, String name, int damage, int health, int money) {
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
