package model;
import java.util.ArrayList;

/**
 * description of class Club 
 *
 * @author Johan Ricardo
 * @version 
 */
public class Club {
    private String name;
    private String nit;
    private String creationDate;

    private Office offices[][];
    private DressingRoom dressingRooms[][];
    private ArrayList<Employee> employees;
    private Team teamA;
    private Team teamB;


    /**
     * Constructor of the object club <br>
     * @param name , the name of the club 
     * @param nit , the nit of the club 
     * @param creationDate , the date where the club was created 
     */
    public Club(String name, String nit, String creationDate) {
        this.name = name;
        this.nit = nit;
        this.creationDate = creationDate;
        offices= new Office[6][6];
        dressingRooms = new DressingRoom[7][7];
        employees= new ArrayList<Employee>();
        teamA= new Team("Team A");
        teamB = new Team("Team B");
    }

    /**
     * Method: hireEmployee <br>
     * This method let the user hire a new employee, at this method the user can hire a Player for Team A or Team B <br>
     * <b>pos: <br>
     * <b> pre: a new player hire and added to the arraylist employees and added to the team chosen by the user <br> 
     * @param name , the name of the player 
     * @param id , the id of the player 
     * @param salary , the salary of the player 
     * @param numberShirt , the number of the shirt for the player
     * @param numberGoals , the number of goals of the player
     * @param position , the position in which the player plays 
     * @param team , the team chosen by the user 
     * @return String , a message telling if the player joined the team or saying that the team is full
     */
    public String hireEmployee(String name, String id, double salary,String numberShirt,  int numberGoals, String position, String team){
        String msg="";
        Player newPlayer = new Player(name, id, salary, numberShirt, numberGoals, position);
        if(team.equals("Team A")){
           if(teamA.addPlayer(newPlayer)){
               employees.add(newPlayer);
               msg="A new player joined Team A\n";
           }else{
              msg="Team A is currently full :(\n";
           }

        }else{
            if(teamB.addPlayer(newPlayer)){
                employees.add(newPlayer);
                msg="A new player joined Team B\n";
            }else{
               msg="Team B is currently full :(\n";
            }
        }
        
        
        return msg;

    }
    /**
     * Method: hireEmployee <br>
     * This method let the user hire a new employee, at this method the user can hire a Main coach <br>
     * <b> pre: <br>
     * <b> pos: a new Main coach hired and added to the arraylist employees <br> 
     * @param name , the name of the  Main coach 
     * @param id , the id of the coach
     * @param salary , the salary  for the Main coach
     * @param experienceYears , the years that the coach has been a Main coach
     * @param teamsEncharged  , the team that the coach manage 
     * @param wonChampionships , the amount of championships that the teams managed by the coach has won
     * @param team , the team selected for the coach
     * @return String , with a message
     */

    public String hireEmployee(String name, String id, double salary, int experienceYears,int teamsEncharged, int wonChampionships, String team){
        String msg="A new Main Coach has been hired";
        MainCoach newMainCoach = new MainCoach(name, id, salary, experienceYears, teamsEncharged, wonChampionships);
        if(team.equals("Team A")){
           if(teamA.hasMain()){
              msg=" There is a Main coach already in this team you can not hire this Coach";
               }else{
                teamA.setMainCoach(newMainCoach);
                employees.add(newMainCoach);
               
               }
           }else{
            if(teamB.hasMain()){
                msg=" There is a Main coach already in this team you can not hire this Coach";
            }else{
                teamB.setMainCoach(newMainCoach);
                employees.add(newMainCoach);
                  
                 }
            }
        return msg;
    }

    /**
     * Method: hireEmployee <br>
     * This method let the user hire a new employee, at this method the user can hire a Coach assistant <br>
     * <b> pre: <br>
     * <b> pos: A new Coach assistant and added to the arraylist employees <br> 
     * @param name , the mane of the coach 
     * @param id ,  the id of the coach 
     * @param salary , the salary for the coach
     * @param experienceYears , the years that the coach has been a coach
     * @param wasPlayer , if the boolean has been a player
     * @param skill , the skill in which the coach specializes
     * @param team , the team selected for the coach 
     * @return String , with a message
     */

    public String hireEmployee(String name, String id, double salary, int experienceYears, boolean wasPlayer, String skill, String team){
        String msg="A new Coach assistant has been hired";
        CoachAssistant newCoachAssistant = new CoachAssistant(name, id, salary, experienceYears, wasPlayer, skill);
        if(team.equals("Team A")){
            if(teamA.hasMain()){
               msg=" There is a Main coach already in this team you can not hire this Coach";
                }else{
                 teamA.setCoachAssistant(newCoachAssistant);
                 employees.add(newCoachAssistant);
                
                }
            }else{
             if(teamB.hasMain()){
                 msg=" There is a Main coach already in this team you can not hire this Coach";
             }else{
                 teamB.setCoachAssistant(newCoachAssistant);
                 employees.add(newCoachAssistant);
                   
                  }
             }
        
        return msg;
    }

    /**
     * Method fireEmployee <br>
     * This method let the user fire a Coach (main or assistant) and a player of a team <br>
     * <b> pre: there must be almost an employee hire, that means , the arrays of players and the coaches must be different of null <br>
     * <b> pos: an Employee fired, taken out of the array players if its a player or removed from a team if its a coach and finally its status changed to INACTIVE <br>
     * @param team  , the team selected for the user
     * @param employee , the type of employee that the user wants to fire
     * @param idEmployee , the id of the employee that will be fired
     * @return String, with a message
     */
    public String fireEmployee(String team, String employee, String idEmployee){
      String msg="";
      String fired="";
      boolean out=false;
      switch(employee){
          case "PLAYER": if (team.equals("Team A")) {
                             for(int i=0; i<(teamA.getPlayers()).length && !out; i++){
                                  if ((teamA.getPlayers())[i]!= null) {
                                      if(idEmployee.equals(((teamA.getPlayers())[i]).getId())){
                                        msg="The player "+((teamA.getPlayers())[i]).getName()+" has been fired and kicked from Team A \n";
                                        fired=(teamA.getPlayers())[i].getName();  
                                        (teamA.getPlayers())[i]=null;
                                        out=true;
                                      }
                                  }
                             } out=false;
                             for(int i=0; i<employees.size() && !out; i++ ){
                                 if (((employees.get(i)).getName()).equals(fired)) {
                                     (employees.get(i)).setEmployeeStatus("INACTIVE");
                                     out=true;
                                 }

                             }

                            } else {
                                for(int i=0; i<(teamB.getPlayers()).length && !out; i++){
                                    if ((teamB.getPlayers())[i]!= null) {
                                        if(idEmployee.equals(((teamB.getPlayers())[i]).getId())){
                                          msg="The player "+((teamB.getPlayers())[i]).getName()+" has been fired and kicked from Team B \n";
                                          fired=(teamB.getPlayers())[i].getName();  
                                          (teamA.getPlayers())[i]=null;
                                           out=true;
                                          
  
                                        }
                                    }
                               }out=false;
                               for(int i=0; i<employees.size() && !out; i++ ){
                                   if (((employees.get(i)).getName()).equals(fired)) {
                                       (employees.get(i)).setEmployeeStatus("INACTIVE");
                                       out=true;
                                       
                                   }
  
                               }

                             }break;

          case "MAIN_COACH": if (team.equals("Team A")) {
                                if (((teamA.getMainCoach()).getId()).equals(idEmployee)){
                                    teamA.setMainCoach(null);
                                    fired=(teamA.getMainCoach()).getName();
                                    msg="The main Coach "+(teamA.getMainCoach()).getName()+" has been fired ana kicked  from team A\n";
                                }
                                
                             for(int i=0; i<employees.size() && !out; i++ ){
                                 if (((employees.get(i)).getName()).equals(fired)) {
                                     (employees.get(i)).setEmployeeStatus("INACTIVE");
                                     out=true;
                                     
                                 }

                             }
                            }else{
                                if (((teamB.getMainCoach()).getId()).equals(idEmployee)){
                                    fired=(teamB.getMainCoach()).getName();
                                    teamB.setMainCoach(null);
                                    msg="The main Coach "+(teamB.getMainCoach()).getName()+" has been fired ana kicked  from team A\n";
                                }
                                
                             for(int i=0; i<employees.size() && !out; i++ ){
                                 if (((employees.get(i)).getName()).equals(fired)) {
                                     (employees.get(i)).setEmployeeStatus("INACTIVE");
                                     out=true;
                                     
                                 }

                             }
                             }break;

          case "ASSISTANT_COACH": if (team.equals("Team A")) {
                                     if (((teamA.getAssistant()).getId()).equals(idEmployee)){
                                    teamA.setCoachAssistant(null);
                                    fired=(teamA.getAssistant()).getName();
                                    msg="The main Coach "+(teamA.getAssistant()).getName()+" has been fired ana kicked  from team A\n";
                                     }
                                 for(int i=0; i<employees.size() && !out; i++ ){
                                        if (((employees.get(i)).getName()).equals(fired)) {
                                            (employees.get(i)).setEmployeeStatus("INACTIVE");
                                            out=true;
                                            
                                        }
       
                                    }            
                            }else{
                                if (((teamB.getAssistant()).getId()).equals(idEmployee)){
                                    fired=(teamB.getAssistant()).getName();
                                    teamB.setCoachAssistant(null);
                                    msg="The main Coach "+(teamB.getAssistant()).getName()+" has been fired ana kicked  from team A\n";
                                }
                                for(int i=0; i<employees.size() && !out; i++ ){
                                    if (((employees.get(i)).getName()).equals(fired)) {
                                        (employees.get(i)).setEmployeeStatus("INACTIVE");
                                        out=true;
                                        
                                    }
   
                                }
                             }break;
      }


      return msg;
    }

    /**
     * Method: employeesInformation <br>
     * this method will show to the user the information of all the employees <br>
     * <b> pre: there must be almost one employee at the list <br>
     * <b> pos: <br>
     * @return String, with the information of the employees 
     */
    public String employeesInformation(){
        String info="";
        for(int i = 0; i <employees.size(); i++) {
           info+=(employees.get(i)).infoEmployee()+"\n"; 
        }
        return info;
    }

    /**
     * Method: employeesInformation <br>
     * this method will show to the user the information of all the employees <br>
     * <b> pre: there must be almost one employee at the list <br>
     * <b> pos: <br>
     * @param team , the team which belongs the employee that the user wants to know its information
     * @return String, with the information of the employees 
     */
    public String employeesInformation(String team){
        String info="";
        switch(team){
            case "Team A":info="*****Team's A information******\n";
                        for(int i=0; i<(teamA.getPlayers()).length; i++){
                                  if ((teamA.getPlayers())[i]!= null) {
                                    info+=(teamA.getPlayers())[i].infoEmployee()+"\n";   
                                  }
                                   
                              }
                        info+=teamA.getMainCoach().infoEmployee()+"\n";
                        info+=teamA.getMainCoach().infoEmployee()+"\n";      
              break;
            case "Team B": info="*****Team's B information******\n";
                        for(int i=0; i<(teamB.getPlayers()).length; i++){
                            if ((teamB.getPlayers())[i]!= null) {
                                info+=(teamB.getPlayers())[i].infoEmployee()+"\n";   
                                 }
                              }
                        info+=teamB.getMainCoach().infoEmployee()+"\n";
                        info+=teamB.getMainCoach().infoEmployee()+"\n";  
                    break;  


        }
        return info;
    }

    public String marketPrice(){
        return null;
    }


    



    

    
}
