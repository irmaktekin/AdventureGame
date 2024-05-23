public class Cave extends BattleLoc{
    public Cave(Player player,String locationAward) {
        super(player, "Cave", new Zombie(), "food",3,locationAward);
    }
}
