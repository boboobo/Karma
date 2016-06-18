
public class Small_Temple extends Temple{
	
	public Small_Temple(String name) {
		super(name);
	}
	
	//Overriding
	public void buy(Player player){
		
		player.money -= 30;
		Small_Temple[] tmp = new Small_Temple[player.small_temples.length+1];            // Makes the length of small_temples more longer            
		for(int i=0; i<player.small_temples.length; i++){ 				 // Copy the element
			tmp[i] = player.small_temples[i];
		}
		player.small_temples = tmp;							 // Change small_temples to tmp
		player.small_temples[player.small_temples.length-1] = new Small_Temple(name);	 // Add new element at last index
		player.small_temples[player.small_temples.length-1].zen = 3;			 // Small_Temple's zen is 3
		
	}
}
