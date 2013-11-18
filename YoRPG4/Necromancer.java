public class Necromancer extends Character {
    
    private String name;
    private int atkboost;
    private int defdrop;

    public Necromancer() {
	super();
	name = "Yorick";
	HP = (int)(Math.random() * 60) + 90;
	str= (int)(Math.random() * 30) + 20;
	def = (int)(Math.random() * 30) + 20;
	atkboost = 0;
	defdrop = 0;
	skills[0] = "Summon Stuff";
    }
    
    public Necromancer(String user){
	this();
	name = user;
    }

    public String getName() {
	return name;
    }

    public boolean isAlive() {
	return (HP > 0);
    }

    public int getDefense() {
        int def = defense;
	return def;
    }

    public void lowerHP(int loss) {
	HP -= loss;
    }

    public int attack(Monster x) {
	int damage = (int)((strength * rate) - x.getDefense());
	x.lowerHP(damage);
	return damage;
    }

    public void specialize() {
	str -= atkboost;
	def += defdrop;
	atkboost = (int)(Math.random() * 20);
	defdrop = (int)(Math.random() * 20);
	str += atkboost;
	def -= defdrop;
    }

    public void normalize() {
	str -= atkboost;
	def += defdrop;
	atkboost = 0;
	defdrop = 0;
    }
 
    public String about() { 
	String rtnstn = "Type: Necromancer/n";
	rtnstn += "Name: " + name + "/n";
	rtnstn += "Strength: " + Integer.toString(str) + "/n";
	rtnstn += "Defense: " + Integer.toString(def) + "/n";
	return rtnstn;

    }

    public void levelup() {
	level += 1;
	HP += 50 + (int)(Math.random()*10);
	str += 2 + (int)((Math.random()*4)*1.2);
	def += 2 + (int)(Math.random()*4);
	intel += 2 + (int)(Math.random()*4);
	con += 2 + (int)(Math.random()*4);
	
    }
    
    public void addskill() { 

	skills[1] = "More Summons";
	if (isTopStat(str)) {

	    skills[1] = "Summons Again";

	}
	if (isTopStat(dex)) {

	    skills[1] = "Summon Stuff";

	}
    }	

