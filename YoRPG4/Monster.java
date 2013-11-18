//Jim Yuan
//pd 8
//HW23
//2013-11-12
//Update:
//HW24
//2013-11-12

public class Monster extends Character{

    /*    private String _name = "";
    private int _hp, _str, _def;
    private double  _att;
    */
    //le default cons
    public Monster(){
	super();
	/*	_hp = 150;
	_def = 20;
	_att = 1;*/
	_str = (int)((Math.random()*45) + 20);
    }


    public boolean isAlive(){
	//	return(_hp > 0);
	return super.isAlive();
    }
    //le accessors
    public int getDefense(){
	//	return _def;
	return super.getDefense();
    }

    public String getName(){
	//	return _name;
	return super.getName();
    }

    //assuming dec will be positive, like a damage value
    public int lowerHP(int dec){
	/*	_hp = _hp -= dec;
		return _hp;*/
	return super.lowerHP(dec);
    }

    public int attack(Warrior hero){
	/*	double dmg = (_str * _att) - hero.getDefense();
	if (dmg < 0){
	    dmg = 0;
	}
	return (int)dmg;*/
	return super.attack(hero);
    }

    public void normalize(){}

    public void specialize(){}
    public  String about(){
	return "The Monster is a fearsome creature that emerged many eons ago from the depths of the dark swamp. Not much is known about Monsters.";}
}
