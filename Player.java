import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	
	String name;
	int money = 100;
	int zen = 0;
	Temple[] temples = new Temple[0];                      // Player has a List of Temple
	Small_Temple[] small_temples = new Small_Temple[0];    // Player has a List of Small Temple
	int turn;
	
	public Player(String name){
		this.name = name;		
	}
	
	public void Meditate(Player player){
		player.zen += 1;
		player.turn += 1;
	}
	
	public void Help_Someone(Player player){
		player.zen += 5;
		player.money -= 10;
		player.turn += 1;
	}
	
	public void Work_at_Company(Player player){
		player.zen -= 30;
		player.money += 50;
		player.turn += 1;
	}
	
	public void Purchase_Temple(Player player){
		Scanner scanner = new Scanner(System.in);
		player.turn += 1;
		
		System.out.println("What do you want to call your temple?");
		while(true){
			try{
			String name = scanner.nextLine();
			System.out.printf("%nA big temple generates $15 and 5 zen each turn.%n"
					+ "A small temple generates 3 zen each turn.%n"
					+ "Do you want a big (-$70, press 1) or small (-$30, press 2) temple? %n");
			
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			
			if(input<0 || input>2){
				System.out.println("Please input 1 or 2");
				continue;
			}
			if(input==1){
				if(player.money<70){
					System.out.println("Not enough money.");
					break;
				}
				Temple tem = new Temple(name);
				tem.buy(player);
				break;
			}
			if(input==2){
				if(player.money<30){
					System.out.println("Not enough money.");
					break;
				}
				Small_Temple tem = new Small_Temple(name);
				tem.buy(player);
				break;
			}
			}
			catch(InputMismatchException a){
				System.out.println("Please input 1 or 2");
				continue;
			}
		}
	}
	
}
