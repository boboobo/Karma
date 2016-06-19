import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	
	String name;
	int money = 100;
	int zen;
	int bet;
	Temple[] temples = new Temple[20];                      // Player has List of Temple
	Small_Temple[] small_temples = new Small_Temple[20];    // Player has List of Small Temple
	int turn;
	
	public Player(String name){
		this.name = name;		
	}
	
	public void Meditate(Player player){
		System.out.println("Oh, what an Awakening!");
		player.zen += 1;
		player.turn += 1;
	}
	
	public void Help_Someone(Player player){
		System.out.println("Oh, what an Awakening!");
		player.zen += 5;
		player.money -= 10;
		player.turn += 1;
	}
	
	public void Work_at_Company(Player player){
		System.out.println("Oh, feel so tired.");
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
	
	public void Gamble(Player player){
		turn += 1;
		zen -= 20;
		
		System.out.println("This game is a Odd and Even");
		while(true){
			System.out.printf("%s, How much do you want to bet?",player.name);
			try{
				Scanner scanner = new Scanner(System.in);
				int bet = scanner.nextInt();
				
				if(player.money<bet){
					System.out.println("Not enough money. Please rebet");
					continue;
				}
				else{
					System.out.printf("%s bet %d$%n",player.name, bet);
					player.bet = bet;
					break;
				}
			}
			catch(InputMismatchException a){
				System.out.println("Please input number");
				continue;
			}	
		}
		
		System.out.println("Choose odd (press 1) or even(press2)");
		while(true){
			try{
				Scanner scanner = new Scanner(System.in);
				int choose = scanner.nextInt();
				
				if(choose!=1 && choose!=2){
					System.out.println("Please choose 1 or 2");
					continue;
				}
				
				if(choose == 1){
					System.out.println("You choose odd");
				}
				if(choose == 2){
					System.out.println("You choose even");
				}
				
				int num = (int)(Math.random()*2+1);                        // num became 1 or 2
				if(num==choose){				           // because Math.random()*2+1 is greater than or equal to 1.0 and less than 3.0
					System.out.printf("Number is %d%n",num);
					System.out.printf("You win. You get $%d%n",bet);
					player.money += player.bet;
					break;
				}
				else{
					System.out.printf("Number is %d%n",num);
					System.out.printf("You lose $%d%n",bet);
					player.money -= player.bet;
					break;
				}
				
				
			}
			catch(InputMismatchException a){
				System.out.println("Please input number");
				continue;
			}	
		}
	}
}
