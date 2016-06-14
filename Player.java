import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	
	String name;
	int money = 100;
	int zen = 0;
	Temple[] temples = new Temple[0];
	Small_Temple[] small_temples = new Small_Temple[0];
	int turn = 0;
	
	public Player(String name){
		this.name = name;		
	}
	
	public void Meditate(Player player){
		player.zen += 1;
		player.turn += 1;
	}
	
	public void Help_Someone(Player player){
		player.zen += 1;
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
			System.out.printf("A big temple generates $15 and 5 zen each turn.%n"
					+ "A small temple generates 3 zen each turn.%n"
					+ "Do you want a big (-$70, press 1) or small (-$30, press 2) temple?%n");
			
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
				player.money -= 70;
				Temple[] tmp = new Temple[player.temples.length+1];
				for(int i=0; i<player.temples.length; i++){
					tmp[i] = player.temples[i];
				}
				player.temples = tmp;
				player.temples[player.temples.length-1] = new Temple(name);
				player.temples[player.temples.length-1].zen = 5;
				player.temples[player.temples.length-1].money = 15;
				
				break;
			}
			if(input==2){
				if(player.money<30){
					System.out.println("Not enough money.");
					break;
				}
				player.money -= 30;
				Small_Temple[] tmp = new Small_Temple[player.small_temples.length+1];
				for(int i=0; i<player.small_temples.length; i++){
					tmp[i] = player.small_temples[i];
				}
				player.small_temples = tmp;
				player.small_temples[player.small_temples.length-1] = new Small_Temple(name);
				player.small_temples[player.small_temples.length-1].zen = 3;
				
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
