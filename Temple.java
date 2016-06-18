
public class Temple {
	
	int zen;
	int money;
	String name;
	
	public Temple(String name){
		this.name = name;
	}
	
	public void buy (Player player){
		
		player.money -= 70;
		Temple[] tmp = new Temple[player.temples.length+1];           // Makes the length of temples more longer
		for(int i=0; i<player.temples.length; i++){                   // Copy the element
			tmp[i] = player.temples[i];
		}
		player.temples = tmp;					      // Change temples to tmp
		player.temples[player.temples.length-1] = new Temple(name);   // Add new element at last index
		player.temples[player.temples.length-1].money = 15;           // Temple's money is $15
		player.temples[player.temples.length-1].zen = 5;              // Temple's zen is 5
	}
}
