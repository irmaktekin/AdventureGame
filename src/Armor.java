public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public static Armor[] armors(){
        Armor [] armors = new Armor[3];
        armors[0]  = new Armor(1,"Light",1,15);
        armors[1]  = new Armor(2,"Medium",3,25);
        armors[2]  = new Armor(3,"Heavy",5,40);
        return armors;


    }
    public static Armor getArmorById(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }

        }
        return null;

    }
}
