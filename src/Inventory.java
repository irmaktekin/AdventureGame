import java.util.ArrayList;

public class Inventory {

    private Weapon weapon;
    private Armor armor;

    public ArrayList<String> getCurrentAwards() {
        return currentAwards;
    }

    public void setCurrentAwards(ArrayList<String> currentAwards) {
        this.currentAwards = currentAwards;
    }

    private ArrayList<String> currentAwards;

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory() {
        this.weapon = new Weapon("Punching",-1,0,0);
        this.armor = new Armor(-1,"Armor1",0,0);
        this.currentAwards = new ArrayList<>();
    }

    public String addAward(String awardName){
        currentAwards.add(awardName);
        this.setCurrentAwards(currentAwards);
        return awardName;

    }

}
