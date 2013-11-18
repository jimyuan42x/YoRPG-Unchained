public class Monster extends Character{

    public Monster(){
	super();
	HP = 150;
	def = 20;
	rate = 1;
	str = (int)((Math.random()*45) + 20);
    }

    public void normalize(){}
    public void specialize(){}
    public  String about(){
	return "The Monster is a fearsome creature that emerged many eons ago from the depths of the dark swamp. Not much is known about Monsters.";}
}
