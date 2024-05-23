public class ToolStore extends NormalLoc {
    public ToolStore(Player p) {
        super(p, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        System.out.println("Welcome to tool store. You can buy weapons from here.");
        while(showMenu){
           System.out.println("1.Weapons");
           System.out.println("2.Armors");
           System.out.println("3.Exit");
           System.out.println("Your choice:");
           int selectCase = input.nextInt();
           while (selectCase < 1 || selectCase > 3) {
               System.out.println("Invalid number.Please enter another number!");
               selectCase = input.nextInt();
           }
           switch (selectCase) {
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("See you!");
                   showMenu=false;
                   break;
           }
       }
        return true;

    }

    private void buyArmor() {
        System.out.println("Please select an armor");
        int selectedArmorId= input.nextInt();
        while (selectedArmorId < 0 || selectedArmorId > Weapon.Weapons().length) {
            System.out.println("Invalid number.Please enter another number!");
            selectedArmorId = input.nextInt();
        }
        if(selectedArmorId != 0){
            Armor selectedArmor = Armor.getArmorById(selectedArmorId);
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()> getPlayer().getMoney()){
                    System.out.println("Not enough money");
                }
                else{
                    System.out.println("You bought"+" "+selectedArmor.getName());
                    int balance = this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remain credit: "+balance);


                }
            }
        }


    }

    public void printArmor() {
        System.out.println("-----Armors:--------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId()+"-"+armor.getName()+"<Price: " + armor.getPrice() + " Block: " + armor.getBlock()+">");
        }
        System.out.println("Press 0 for exit");

    }

    public void printWeapon() {
        System.out.println("-------Weapons:-------");
        for (Weapon weapon : Weapon.Weapons()) {
            System.out.println("Name: " + weapon.getName() + " Price: " + weapon.getPrice() + " Damage: " + weapon.getDamage());
        }
        System.out.println("Press 0 for exit");



    }
    public void buyWeapon(){
        System.out.println("Select a weapon:");
        int selectedWeaponId= input.nextInt();
        while (selectedWeaponId < 0 || selectedWeaponId > Weapon.Weapons().length) {
            System.out.println("Invalid number.Please enter another number!");
            selectedWeaponId = input.nextInt();
        }
        if(selectedWeaponId!=0){
            Weapon weapon = Weapon.getWeaponObjectById(selectedWeaponId);
            if (weapon!= null) {
                if(weapon.getPrice()> getPlayer().getMoney()){
                    System.out.println("Not enough money for this"+ weapon.getName());
                }
                else{
                    System.out.println("You bought"+weapon.getName());
                    int balance = this.getPlayer().getMoney() - weapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remain credit: "+balance);
                    this.getPlayer().getInventory().setWeapon(weapon);
                    System.out.println("New weapon: "+ this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }

    }


}