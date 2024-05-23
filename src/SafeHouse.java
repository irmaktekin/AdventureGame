public class SafeHouse extends  NormalLoc{
    public SafeHouse(Player p) {
        super(p, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the safe house. There is no enemy here.");
        System.out.println("Your health is refilled.");
        this.getPlayer().setHealth(this.getPlayer().getOrginalHealth());
        return true;
    }
}
