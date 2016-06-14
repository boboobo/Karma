import java.util.InputMismatchException;
import java.util.Scanner;

public class Karma {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		
		Player player = new Player(name);
		
		System.out.printf("Boss: %s. you were a good worker, I am sad you are leaving the company. Good luck on becoming a monk.%n", player.name);
		
		int turn;  
		while(player.zen < 100){
			try{
				
				System.out.printf("You have $%d and %d Zen points%n"
						+ "What would you like to do?%n"
						+ "Meditate 0$, +1 Zen -> Press 1%n"
						+ "Help Someone -10$, +5 Zen -> Press 2%n"
						+ "Work at Company +$50, -30 Zen -> Press 3%n"
						+ "Purchase Temple -> Press 4%n", player.money, player.zen);
				
				Scanner in = new Scanner(System.in);
				int input = in.nextInt();
				
				if(input<0 || input>4){
					System.out.println("Please input only 1~4");
					continue;
				}
				
				if(input==1){
					player.Meditate(player);
				}
				if(input==2){
					player.Help_Someone(player);
				}
				if(input==3){
					player.Work_at_Company(player);
				}
				if(input==4){
					player.Purchase_Temple(player);
				}
				Collecting(player);
				
			}
			catch(InputMismatchException a){
				System.out.println("Please input only 1~4");
				continue;
				
			}
			
			
			
		}
		
		System.out.printf("Congrats, %s became a master monk in %d turns.%n",player.name, player.turn);
		
	}
	
	public static void Collecting(Player player){
		System.out.println("Collecting from all temples...");
		for(int i=0; i<player.temples.length; i++){
			System.out.printf("Collecting $%d and %d Zen from %s%n",player.temples[i].money, player.temples[i].zen, player.temples[i].name);
			player.money += player.temples[i].money;
			player.zen += player.temples[i].zen;
		}
		for(int i=0; i<player.small_temples.length; i++){
			System.out.printf("Collecting $%d and %d Zen from %s%n",player.small_temples[i].money, player.small_temples[i].zen, player.small_temples[i].name);
			player.money += player.small_temples[i].money;
			player.zen += player.small_temples[i].zen;
		}
		System.out.println("Done collecting from temples...");
		
	}
	
}
