public abstract class Rogue extends Character{

    private String name;
    private int atkboost;
    private int defdrop;


    public Rogue() {  //clearly not confirmed stats, we'll decide that later
	super();
	name = "Captain Teemo";
	HP = (int)(Math.random() * 60) + 90;
	str= (int)(Math.random() * 30) + 20;
	def = (int)(Math.random() * 30) + 20;
	atkboost = 0;
	defdrop = 0;
	skills[0] = "Speedy Delivery"; //now this skill has to be recorded in the Skills class/ I was thinking either default skill for all classes or maybe 3 default skills in each class. Probably the former unless we have the time.
    }

    public Rogue(String user) {
	this();
	name = user;
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
	String rtnstn = "Type: Rogue/n";
	rtnstn += "Name: " + name + "/n";
	rtnstn += "Strength: " + Integer.toString(str) + "/n";
	rtnstn += "Defense: " + Integer.toString(def) + "/n";
	return rtnstn;

    }

    public void levelup() { //Again, values not officially determined
	level += 1;
	HP += 50 + (int)(Math.random()*10);
	str += 2 + (int)((Math.random()*4)*1.2); //example of second-tier boost
	def += 2 + (int)(Math.random()*4);
	intel += 2 + (int)(Math.random()*4);
	con += 2 + (int)(Math.random()*4);
	
	//...you get the point.

    }
    
    public void addskill() { //Example of adding skills

	skills[1] = "Combo Freak";
	if (isTopStat(str)) { //if this is true, replace Combo Freak

	    skills[1] = "Dirty Beatdown";

	}
	if (isTopStat(dex)) {

	    skills[1] = "Quick Feet";

	}
    }	

    public void addskill2() {
    	
    	skills[2] = "Dual Strike";
    	if (isTopStat(con)) {	
    		skills[2] = "Synchro Mode";
    	}
    	if (isTopStat(def)) {
    		skills[2] = "Guarded Strike";
    	}
    }	

}
