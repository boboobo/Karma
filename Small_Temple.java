
public class Small_Temple extends Temple{
	
	public Small_Temple(String name) {
		super(name);
	}
	
	//Overriding
	public void buy(Player player){
		player.money -= 30;
		
		for(int i=0; i<player.small_temples.length; i++){
			if(player.small_temples[i] == null){		              //If element is empty,
				player.small_temples[i] = new Small_Temple(name);     //then add a element
				player.small_temples[i].zen = 3;	              //small_temple's zen is 3
				break;
			}
		}
		
	}
}
