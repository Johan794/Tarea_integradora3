package ui;
import java.util.Scanner;
import model.Club;

public class Main {
	private Scanner sc;
	private Club myClub;
	
	Main(){
        sc = new Scanner(System.in);
		
    }
    
	public static void main(String[] args) {
		int option=0;
		System.out.println("Welcome to the aplication\n");
		Main ppal= new Main();
		if((ppal.createClub())==1){
			do{
				option= ppal.showMenu();
				ppal.executeOperation(option);
				
			}while (option!=0);
		}
		
		
	}

	public int createClub(){
		String name, nit, creationDate;
		int desicion=0;
		System.out.println("Would you like to work with a new Club?\n"+"Type 1 for yes or 0 for no" );
		desicion=sc.nextInt();
		sc.nextLine();
		if(desicion==1){
			System.out.print("Please type de name of the club:");
			  name=sc.nextLine();
			System.out.print("nit of the club: ");
				nit=sc.nextLine();
			System.out.print("the date of creation of the club:");
				creationDate=sc.nextLine();
				myClub= new Club(name, nit, creationDate);	
			System.out.println("the club was created successfully\n");
		}else{
			desicion=0;
			System.out.println("then bye!");
		}
		return desicion;
		
	}
	
	public int showMenu() {
		int option=0;
			System.out.println(
				">>>>>>>>>>>>>>>> Main menu, please pick an option <<<<<<<<<<<<<<<<<<<<<<<<<\n" +
				"<*>[1] I want to hire a new Employee \n" +
				"<*>[2] I want to fire an Employee \n"+
				"<*>[3] I want to set the rating for the players\n"+
				"<*>[4] I want to see and calculate the market price of my employees\n"+
				"<*>[5] I want to put a team in a dressing room \n"+
				"<*>[6] I want to put the coaches at the offices \n"+
				"<*>[7] I want to set a new Line up\n"+
				"<*>[8] I want to see the information of all the employees of the club\n"+
				"<*>[9] I want to see the information of a specific Team\n"+
				"<*>[10] I want to see the line up of a team\n"+
				"<*>[11] I want to see the information of the club\n"+ 
				"<*>[0] I want to leave the application\n"+
				"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n"
				);
		     option= sc.nextInt();
	     	sc.nextLine();
		return option;
	}

	
	
	public void executeOperation(int operation) {
		int typeOfCoach, choose,forEnum;
		String employee="";
		String idEmployee="";
		String team="";
		String lineUp, tactics, date;
		double newRating;
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1: System.out.println("what kind of employee would you like to hire\n"+
								"[1] Player \n"+
								"[2] Main Coach \n"+
								"[3] Assistant coach"
			   ); typeOfCoach=sc.nextInt();
			      sc.nextLine();
			       hire(typeOfCoach);
			break;
		case 2: System.out.println("Please type what kind of are you going to fire\n"+
								   "[1] Player \n"+
								   "[2] Main coach\n"+
								   "[3] Assistant coach"
				); choose=sc.nextInt();
				    sc.nextLine();
				  employee=kindOfEmployee(choose);
				 System.out.println("Which team does the employee belongs?\n"+
									"[1] Team A\n"+
									"[2] Team B\n"
									); choose=sc.nextInt();
						team=setTeam(choose);
					sc.nextLine();	
				 System.out.println("This is the information of all the employees currently working at "+team+"\n");
				 System.out.println(myClub.employeesInformation(team));	 
				 System.out.println("Now type the id of the Employee that you want to fire");
				   idEmployee=sc.nextLine();
				System.out.println(myClub.fireEmployee(team, employee, idEmployee));					     
			break;
	
		case 3:System.out.println("Please type the name of the player that you want to rate");
				 employee=sc.nextLine();
				 System.out.println("Which team does the Player belongs?\n"+
									"[1] Team A\n"+
									"[2] Team B\n"
									); choose=sc.nextInt();
									team=setTeam(choose);		
				System.out.print("Now rate the player:");
				  newRating=sc.nextDouble();
				 myClub.setRanting(employee, team, newRating); 	
			break;

		case 4: System.out.println(myClub.marketPrice());
			break;

		case 5: System.out.println("Which do you want to get in its dressing room?\n"+
									"[1] Team A\n"+
									"[2] Team B\n"
									); choose=sc.nextInt();
									team=setTeam(choose);
		    System.out.println(myClub.addToDressingRoom(team));
			 break;	

		case 6: System.out.println(myClub.addToOffice());
				  break;

		case 7: System.out.println("for which Team  is the lineup?\n"+
									   "[1] Team A \n"+
									   "[2] Team B \n"
					);		    choose=sc.nextInt();
					          sc.nextLine();
									team=setTeam(choose);
				System.out.println("Please type the line up in the next format: n-n-n-n");
						 lineUp=sc.nextLine();
				System.out.println("Now type a date for the new Lineup");
					date=sc.nextLine();
				System.out.println("Finally type which tactic that will be used in this line up\n"+
								   "[1] POSSESSION\n"+
								   "[2] COUNTERATTACK\n"+
								   "[3] HIGPRESSION\n"+
								   "[4] DEFAULT\n"
				);        forEnum=sc.nextInt();
				 tactics=valueTactic(forEnum);
				 myClub.newLineUp(lineUp, team, tactics, date);
				 System.out.println("New line up set!");
					 break;

		case 8:System.out.println(myClub.employeesInformation());
				 break;

		case 9: System.out.println("Which team's information do you want to see\n"+
								   "[1] Team A\n"+
								   "[2] Team B\n"
		); 		         choose=sc.nextInt();
						 team=setTeam(choose);
				System.out.println(myClub.employeesInformation(team));
				  break;
		case 10:System.out.println("Which team does the line up belong\n"+
								   "[1] Team A\n"+
								   "[2] Team B\n"
		); 		         choose=sc.nextInt();
						 team=setTeam(choose);
					sc.nextLine();	 
				System.out.println("Now type the date of the line up (do not forget write it in the format dd/mm/yy)\n"+
				                   "or type All to see al the lines up"
				);	
					date=sc.nextLine();
				System.out.println(myClub.lineUpInfo(team, date));
				  break;
		case 11: System.out.println(myClub.getInfo());
		          break;		  		  		  		
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}

	public void hire(int typeOfCoach){
		int forEnum, choose;
		String name, id, position, numberShirt, wasPlayer2, team, skill;
		double salary;
		int numberGoals, experienceYears, teamsEncharged , wonChampionships;
		boolean wasPlayer;
		switch(typeOfCoach){
			case 1: System.out.println("Please type the name of the player");
					     name= sc.nextLine();
					System.out.println("please type the id");
						  id=sc.nextLine();
					System.out.println("please type the Salary for the player");
						  salary = sc.nextDouble();
					 sc.nextLine();	  
					System.out.println("please type the number of the shirt for the player");
						numberShirt=sc.nextLine();
					System.out.println("please type the amount of goals made for the player");	
						numberGoals=sc.nextInt();
					System.out.println("Now please type the position in which the player will play\n"+
									   "[1] GOALKEEPER \n"+
									   "[2] DEFENDER\n"+
									   "[3] MIDFIELD\n"+
									   "[4] STRICKER"
					);
					   forEnum=sc.nextInt();
					   position= valuePotion(forEnum);	    
					System.out.println("in which Team the player is gonna play\n"+
									   "[1] Team A \n"+
									   "[2] Team B \n"
					);  choose = sc.nextInt();
					  team=setTeam(choose);
					  System.out.println(myClub.hireEmployee(name, id, salary, numberShirt, numberGoals, position, team));
				 break;
			case 2: System.out.println("Please type the name of the coach");
					     name= sc.nextLine();
					System.out.println("please type the id");
						  id=sc.nextLine();
					System.out.println("please type the Salary for the coach");
						  salary = sc.nextDouble();
					System.out.println("please type the experience years of the coach");
					   experienceYears=sc.nextInt();
					System.out.println("how many teams did the coach has managed?");
						teamsEncharged=sc.nextInt();
					System.out.println("how may championships has the coach won?");
						wonChampionships=sc.nextInt();
					System.out.println("which Team the Coach is gonna train\n"+
									   "[1] Team A \n"+
									   "[2] Team B \n"
					);  choose = sc.nextInt();
					  team=setTeam(choose);	
				     System.out.println(myClub.hireEmployee(name, id, salary, experienceYears, teamsEncharged, wonChampionships, team)); 			 	
				 break;
			case 3: System.out.println("Please type the name of the coach");
					     name= sc.nextLine();
					System.out.println("please type the id");
						  id=sc.nextLine();
					System.out.println("please type the Salary for the coach");
						  salary = sc.nextDouble();
					System.out.println("please type the experience years of the coach");
					   experienceYears=sc.nextInt();
					  sc.nextLine(); 	  
			        System.out.println("Did de coach was a player, type yes or no");
					   wasPlayer2=sc.nextLine();
					 wasPlayer=wasPlayer(wasPlayer2);
					System.out.println("Now type the skills in which the coach specializes\n"+
										"[1] OFFENSIVE\n"+
										"[2] DEFENSIVE\n"+
										"[3] CONTROLLER\n"+
										"[4] LAB_PLAYS"
					);       forEnum=sc.nextInt();
					   skill=valueSkill(forEnum);
					System.out.println("which Team the Coach is gonna train\n"+
									   "[1] Team A \n"+
									   "[2] Team B \n"
					);  choose = sc.nextInt();
					  team=setTeam(choose);	
					 System.out.println(myClub.hireEmployee(name, id, salary, experienceYears, wasPlayer, skill, team));    

			     break; 	 	 

		}

	}

	public String kindOfEmployee(int choose){
		String employee="";
		switch (choose) {
			case 1: employee="PLAYER";
				    break;
			case 2: employee="MAIN_COACH";
					break;
			case 3: employee="ASSISTANT_COACH";
			        break;

		}
		return employee;
	}

	public String setTeam(int choose){
		String team="";
		switch(choose){
			case 1: team="Team A";
				break;
			case 2: team= "Team B";
			   break;	
		}
		return team;

	}

	public boolean wasPlayer(String wasPlayer2){
		boolean player;
		if (wasPlayer2.equals("yes")) {
		    player=true;	
		}else{
			player=false;
		}
		return player;
	}


	public String valuePotion(int forEnum ){
		String value="";
		switch(forEnum){
			case 1: value="GOALKEEPER";
					 break;
			case 2: value="DEFENDER";
					 break;
			case 3: value="MIDFIELD";
					 break;
			case 4: value="STRICKER";
			         break;		 		 	 
		}
		return value;
	}

	public String valueSkill(int forEnum){
		String value="";
	   switch(forEnum){
		    case 1: value="OFFENSIVE";
					 break;
	       case 2: value ="DEFENSIVE";
					  break;
		   case 3: value="CONTROLLER";
					  break;
		   case 4: value="LAB_PLAYS";
		              break;		  		  
	   }
		return value;
	}

    public String valueTactic(int forEnum){
		String value="";
		switch(forEnum){
		    case 1: value="POSSESSION";
					 break;
	       case 2: value ="COUNTERATTACK";
					  break;
		   case 3: value="HIGPRESSION";
					  break;
			case 4: value="DEFAULT";
			          break;		  		  		  
		}

		return value;
	}

}