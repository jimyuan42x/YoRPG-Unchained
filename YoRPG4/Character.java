import java.util.Arrays;

public abstract class Character {

    protected String name;
    protected int HP;
    protected int str;
    protected int def;
    protected int intel;
    protected int con;
    protected int spd;
    protected int dex;
    protected int lck;
    protected int MP;
    protected String[] skills;
    protected int level;
    protected int[] stats;

    protected Character() {

	HP = 0;
	MP = 0;
	str = 0;
	def = 0;
	intel = 0;
	con = 0;
	spd = 0;
	dex = 0;
	skills = new String[3];
	level = 1;

    }


    protected String getName(){
	return name;
    }
    protected boolean isAlive() {
	return HP > 0;
    }

    protected int getDefense() {
        int defense = def;
	return defense;
    }

    protected void lowerHP(int loss) {
	HP -= loss;
    }

    protected int attack(Character x) {

	int damage = (int)((str) - x.getDefense());
	x.lowerHP(damage);
	return damage;

    }

    protected boolean isTopStat(int x) {
        int[] stats = {str,def,intel,con,spd,dex,lck};
	Arrays.sort(stats);
	return (x == stats[stats.length - 1]); // this might be wrong, test pls.
    }	

    protected abstract void levelup();

    protected abstract void addskill();

    protected abstract void normalize();

    protected abstract void specialize();

    protected abstract String about();

}
