//Jim Yuan
//pd 8
//HW24
//2013-11-13
//Update:
//HW25
//2013-11-14
public abstract class Character {

    //variables
    protected String _name;
    protected int _hp, _str, _def;
    protected double _att;


    public Character(){//def constructor
	_hp = 200;
	_def = 75;
	_att = 80;
    }

    //methods
    protected String getName(){
	return _name;
    }
    protected boolean isAlive(){
	return (_hp > 0);
    }

    protected int getDefense(){//accessor for def
	return _def;
    }

    protected int lowerHP(int dec){
	_hp = _hp - dec;
	return _hp;
    }


    protected int attack(Character opponent){
	double dmg = ((_str * _att) - opponent.getDefense());
	if (dmg < 0){
	    dmg = 0;
	}
	return (int)dmg;
    }

    protected abstract void specialize();/*{
	_def = 0;
	_att = 49;
	}*/

    protected abstract void normalize();/*{
	_def = 15;
	_att = 7;
	}*/

    protected abstract String about();


    

    

}
