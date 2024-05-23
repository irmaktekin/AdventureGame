public class Weapon {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int id;
    private int damage;
    private int price;
    public static Weapon [] Weapons(){
        Weapon [] weapons = new Weapon[3];
        weapons[0] = new Weapon("Gun",1,2,5);
        weapons[1] = new Weapon("Sword",2,3,35);
        weapons[2] = new Weapon("Rifle",1,7,45);
        return weapons;

    }

    public Weapon(String name,int id, int damage, int price) {
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.name= name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public static Weapon getWeaponObjectById(int id) {
        for (Weapon w : Weapon.Weapons()) {
            if (w.getId() == id) {
                return w;
            }

        }
        return null;

    }
}

