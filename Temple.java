
public class Temple {
	
	int zen;
	int money;
	String name;
	
	public Temple(String name){
		this.name = name;
	}
	
	public void buy (Player player){
		player.money -= 70;
		
		for(int i=0; i<player.temples.length; i++){
			if(player.temples[i] == null){				// If element is empty,
				player.temples[i] = new Temple(name);           // then add a element
				player.temples[i].zen = 5;		        // temple's zen is 5
				player.temples[i].money = 15;			// temple's money is 15
				break;
			}
		}
	}
}
