//Jim Yuan
//pd 8
//HW23
//2013-11-12
//Update:
//HW24
//2013-11-13
//Update:
//HW25
//2013-11-14
public class Warrior extends Character{
    //attributes
    /* private String _name = "";
    private int _hp, _str, _def;
    private double _att;
    */
    //le default
    public Warrior(String name){
	super();
	_name = name;
	//	_hp = 250;
	_str = 20;
	//	_def = 15;
	//_att = 7.0;
    }
    
    public boolean isAlive(){
	//	return (_hp > 0);
	return super.isAlive();
    }
    //le accessors
    public int getDefense(){
	//	return _def;
	return super.getDefense();
    }

    public String getName(){
	return super.getName();
	//	return _name;
    }
    //assuming dec will be positive, like a damage value
    public int lowerHP(int dec){
	//	_hp = _hp -= dec;
	//return _hp;
	return super.lowerHP(dec);
    }

    public int attack(Monster baddie){
	/*	double dmg = (_str * _att) - baddie.getDefense();
	if (dmg < 0){
	    dmg = 0;
	}
	return (int)dmg;*/
	return super.attack(baddie);
    }
    //prepare for trouble!
    public void specialize(){
	_def = 0;
	_att = 49;//why not make it double?
	
    }
    public void normalize(){//blasted off again. :[
	_def = 15;
	_att = 7;

    }

    public String about(){

	return "The Warrior:\nThe Warrior is a fearless fighter who boasts high physical strength and stamina. Though occasionally reckless, the Warrior fights nobly, and can sustain a great deal of damage, and retaliates with an even greater force.";
    }
}
