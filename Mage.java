//Jim Yuan
//pd 8
//HW25
//2013-11-14

public  class Mage extends Character{

    public Mage(String name){
	super();
	_name = name;
	_str = 20;
    }

    public boolean isAlive(){
	return super.isAlive();
    }

    public int getDefense(){
	return super.getDefense();
    }

    public String getName(){
	return super.getName();
    }

    public int lowerHP(int dec){
	return super.lowerHP(dec);
    }

    public int attack(Monster opponent){

	return super.attack(opponent);
    }

    public  void specialize(){
	_def = 0;
	_att = 49;

    }

    public  void normalize(){
	_def = 15;
	_att = 7;

    }

    public String about(){
	return	"The Mage:\nThe Mage is a member of an underground cult that kills its members to give them new life as wielders of magic. The Mage substitutes its low stamina with high intelligence, fighting from spots fairly distanced from the enemy, hitting it with powerful magical bursts.";
    }




}
