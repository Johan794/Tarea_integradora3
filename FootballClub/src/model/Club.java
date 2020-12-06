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

    private Coach offices[][];
    private Player dressingRooms[][];
    private Player dressingRoom2[][];
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
        offices= new Coach[6][6];
        dressingRooms = new Player[7][7];
        dressingRoom2= new Player[7][6];
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
               msg=">>>>>A new player joined Team A<<<<<\n";
           }else{
              msg=">>>>>Team A is currently full :(<<<<<<<\n";
           }

        }else{
            if(teamB.addPlayer(newPlayer)){
                employees.add(newPlayer);
                msg=">>>>>>A new player joined Team B<<<<<<\n";
            }else{
               msg=">>>>>>Team B is currently full :(<<<<<<<\n";
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
        String msg=">>>>>A new Main Coach has been hired<<<<<";
        MainCoach newMainCoach = new MainCoach(name, id, salary, experienceYears, teamsEncharged, wonChampionships);
        if(team.equals("Team A")){
           if(teamA.hasMain()){
              msg=" >>>>>There is a Main coach already in this team you can not hire this Coach<<<<<";
               }else{
                teamA.setMainCoach(newMainCoach);
                employees.add(newMainCoach);
               
               }
           }else{
            if(teamB.hasMain()){
                msg=" >>>>>There is a Main coach already in this team you can not hire this Coach<<<<<";
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
        String msg=">>>>A new Coach assistant has been hired<<<<<";
        CoachAssistant newCoachAssistant = new CoachAssistant(name, id, salary, experienceYears, wasPlayer, skill);
        if(team.equals("Team A")){
            if(teamA.hasAssistant()){
               msg=" >>>>>>>All the assistant coaches are already hired, you can not hire this Coach<<<<<<<";
                }else{
                 teamA.setCoachAssistant(newCoachAssistant);
                 employees.add(newCoachAssistant);
                
                }
            }else{
             if(teamB.hasAssistant()){
                 msg=">>>>>>>>All the assistant coaches are already hired,  you can not hire this Coach<<<<<<<";
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
     * @param idEmployee , the id of the employee that will be fired, there must not be an id repeated
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
                                    fired=(teamA.getMainCoach()).getName();
                                    msg="The main Coach "+(teamA.getMainCoach()).getName()+" has been fired ana kicked  from team A\n";
                                    teamA.setMainCoach(null);
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
                                    msg="The main Coach "+(teamB.getMainCoach()).getName()+" has been fired ana kicked  from team A\n";
                                    teamB.setMainCoach(null);
                                }
                                
                             for(int i=0; i<employees.size() && !out; i++ ){
                                 if (((employees.get(i)).getName()).equals(fired)) {
                                     (employees.get(i)).setEmployeeStatus("INACTIVE");
                                     out=true;
                                     
                                 }

                             }
                             }break;

          case "ASSISTANT_COACH": if (team.equals("Team A")) {
                                    for (int i = 0; i <(teamA.getAssistant()).length&& !out; i++) {
                                        if ((teamA.getAssistant())[i] != null) {
                                            if (((teamA.getAssistant()[i]).getId()).equals(idEmployee)){
                                                fired=(teamA.getAssistant()[i]).getName();
                                                msg="The Assistant Coach "+(teamA.getAssistant()[i]).getName()+" has been fired and kicked from team A\n";    
                                                teamA.setCoachAssistant(null);
                                                out=true;
                                                
                                                 }
    
                                        }
                                    }
                                     
                                 for(int i=0; i<employees.size() && !out; i++ ){
                                        if (((employees.get(i)).getName()).equals(fired)) {
                                            (employees.get(i)).setEmployeeStatus("INACTIVE");
                                            out=true;
                                            
                                        }
       
                                    }            
                            }else{
                                for (int i = 0; i <(teamB.getAssistant()).length&& !out; i++) {
                                    if ((teamB.getAssistant())[i] != null) {
                                        if (((teamB.getAssistant()[i]).getId()).equals(idEmployee)){
                                            fired=(teamB.getAssistant()[i]).getName();
                                            msg="The Assistant Coach "+(teamB.getAssistant()[i]).getName()+" has been fired and kicked from team A\n";    
                                            teamB.setCoachAssistant(null);
                                            out=true;
                                            
                                             }

                                    }
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
            case "Team A":info+="*****Team's A information******\n";
                        for(int i=0; i<(teamA.getPlayers()).length; i++){
                                  if ((teamA.getPlayers())[i]!= null) {
                                    info+=(teamA.getPlayers())[i].infoEmployee()+"\n";
                                    
                                  }
                                   
                              }
                         if(teamA.getMainCoach()!=null){
                            info+=teamA.getMainCoach().infoEmployee()+"\n";
                         }
                         
                         if ( teamA.getAssistant()!= null) {
                             for (int i = 0; i <(teamA.getAssistant()).length; i++) {
                                 if ((teamA.getAssistant())[i] != null) {
                                    info+=teamA.getAssistant()[i].infoEmployee()+"\n"; 
                                 }
                                
                             }
                                
                         }
                        
                              
              break;

            case "Team B": info+="*****Team's B information******\n";
                        for(int i=0; i<(teamB.getPlayers()).length; i++){
                            if ((teamB.getPlayers())[i]!= null) {
                                info+=(teamB.getPlayers())[i].infoEmployee()+"\n";   
                                 }
                              }
                              if(teamB.getMainCoach()!=null){
                                info+=teamB.getMainCoach().infoEmployee()+"\n";
                             }
                             
                             if ( teamB.getAssistant()!= null) {
                                for (int i = 0; i <(teamB.getAssistant()).length; i++) {
                                    if ((teamB.getAssistant())[i] != null) {
                                        info+=teamB.getAssistant()[i].infoEmployee()+"\n"; 
                                    }
                                    
                                }
                                    
                             }
                    break;  


        }
        return info;
    }

    /**
     * Method: marketPrice <br>
     * This method will show the prices of the players in the market <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String , with the prices of each member of both teams
     */
    public String marketPrice(){
         String marketPrice="";
         marketPrice+=">>>>>>> Prices of the members of team A <<<<<<<\n";
         for(int i=0;i<(teamA.getPlayers()).length;i++){
             if ((teamA.getPlayers())[i] != null) {
               marketPrice+="[*] Player: "+((teamA.getPlayers())[i]).getName()+"\n"+
                            "[*] Current price: "+((teamA.getPlayers())[i]).calculateMarketPrice()+"\n";  
             }
               
         }
         if ( teamA.getMainCoach()!= null) {
            marketPrice+="[*] Coach: "+(teamA.getMainCoach()).getName()+"\n"+
                         "[*] Current price: "+(teamA.getMainCoach()).calculateMarketPrice()+"\n";    
         }
         

         marketPrice+=">>>>>>> Prices of the members of Team B <<<<<<<<<\n";
         for(int i=0;i<(teamB.getPlayers()).length;i++){
            if ((teamB.getPlayers())[i] != null) {
              marketPrice+="[*] Player: "+((teamB.getPlayers())[i]).getName()+"\n"+
                           "[*] Current price: "+((teamB.getPlayers())[i]).calculateMarketPrice()+"\n";  
            }
              
        }
        if ( teamB.getMainCoach()!= null) {
           marketPrice+="[*] Coach: "+(teamB.getMainCoach()).getName()+"\n"+
                        "[*] Current price: "+(teamB.getMainCoach()).calculateMarketPrice()+"\n";    
        }
        return marketPrice;
    }
    
    /**
     * Method: setRating <br>
     * This method helps to set a new rating to a player <br>
     * <b> pre: there must be almost a player at any team<br>
     * <b> pos: <br>
     * @param employee , the name of the player
     * @param team , the team which the player to rate belongs
     * @param newRating , the rate that will be given to the player
     */

    public void setRanting(String employee, String team ,double newRating){
        boolean out=false;       
           if(team.equals("Team A")){
               for(int i=0; i<(teamA.getPlayers()).length && !out; i++){
                   if((teamA.getPlayers())[i] != null){
                       if(((teamA.getPlayers())[i].getName()).equals(employee)){
                        (teamA.getPlayers())[i].setAverageRating(newRating);
                       }     
                   }
                  
                 }
           }else{
               for(int i=0; i<(teamB.getPlayers()).length && !out; i++){
                   if((teamB.getPlayers())[i] != null){
                       if(((teamB.getPlayers())[i].getName()).equals(employee)){
                        (teamB.getPlayers())[i].setAverageRating(newRating);
                       }     
                   }
                  
                 }
           }
       

    }
   /** //corregir
    * Method: addToDressingRoom <br>
    * This method let the user add a team at a dressing room and save it (the method will save it at the dressing room that still have capacity)<br>
    * <b> pre: there must be players hired and belong to a team <br>
    * <b> pos: a new team added to a dressing room depending on the available capacity <br> 
    * @param team , the team of the player that will be added
    * @return String a message saying where the player got in or saying that the player couldn't get it because of te security protocols 
    */
    public String addToDressingRoom(String team){
        String msg="";
        boolean out1=false;
        //Player theChosenOne=null;
        boolean out=false;
             if (team.equals("Team A")) {
                            for(int k=0; k<(teamA.getPlayers()).length; k++){
                                if(teamA.getPlayers()[k]!=null){
                                    for(int i=0; i<dressingRooms.length && !out; i++){
                                        for(int j=0; j<dressingRooms[0].length && !out; j++){
                                            if(i%2==0){
                                                if(j%2==0){
                                                    if(dressingRooms[i][j]==null){
                                                        dressingRooms[i][j]=(teamA.getPlayers()[k]);
                                                        out=true;
                                                        out1=true;
                                                        msg="The team A is at the dressing room";
                                                        
                                                    }
                                                    
                                                }
                                             }
                                        }
                                    }
                                   out=false; 
                                }
                            }                         
                        
                    
                  
                    
                } else {
                    for(int k=0; k<(teamB.getPlayers()).length; k++){
                        if(teamB.getPlayers()[k]!=null){
                            for(int i=0; i<dressingRoom2.length && !out; i++){
                                for(int j=0; j<dressingRoom2[0].length && !out; j++){
                                    if(i%2==0){
                                        if(j%2==0){
                                            if(dressingRoom2[i][j]==null){
                                                dressingRoom2[i][j]=(teamB.getPlayers()[k]);
                                                out=true;
                                                out1=true;
                                                msg="The team A is at the dressing room";
                                                
                                            }
                                            
                                        }
                                     }
                                }
                            }
                           out=false; 
                        }
                    }
                }  

         if(out1==false){
           msg="We sorry, but the team that you want to get in wont be able to. All the dressing rooms are full\n"+
               "Remember that the Club follows its security protocols so you have to wait until a player gets out of a dressing room\n";
        }


        return msg;
    }
  

     /**
    * Method: addToOffice<br>
    * This method let the user add a coach at the office and save it <br>
    * <b> pre: there must be coaches  hired <br>
    * <b> pos: a new coach added to the office depending on the available capacity <br> 
    * @return String a message saying where the player got in or saying that the coach couldn't get it because of te security protocols 
    */
    public String addToOffice(){
        String msg="";
        boolean out1=false;
        boolean out=false;
        Coach theCoach=null;
        for(int k=0; k<(employees).size(); k++){
            if((employees.get(k))instanceof Coach &&((employees.get(k).getStatus()).equals(Status.ACTIVE))){
                theCoach= (Coach)(employees.get(k));
                    for(int i=0; i<offices.length && !out; i++){
                        for(int j=0; j<offices[0].length && !out; j++){
                            if(i%2==0){
                                if(j%2==0){
                                    if(offices[i][j]==null){
                                        offices[i][j]=theCoach;
                                        out=true;
                                        out1=true;
                                        msg=theCoach.getName()+" is at the office "+i+j+"\n";
                                    }
                                    
                                }
                             }
                          
                        }
                    }
            }
            out=false;              
        }
        
        if(out1==false){
            msg="We sorry, but the coach that you want to get in wont be able to. All the offices are full\n"+
                "Remember that the Club follows its security protocols so you have to wait until a player gets out of a dressing room\n";
         }
        return msg;
    }

    /**
     * Method: newLineUp <br>
     * This method let the user set a new Line up for a team <br>
     * <b> pre: the string of the line up must contains "-" in order to do the split <br>
     * <b> pos: a new Line up set and created <br>
     * @param lineUp , the input with the formation of the line up 
     * @param team , the team which will have the new line up 
     * @param tactics , the kind of tactic that the line up will have
     * @param date , the date of creation of the line up 
     */

    public void newLineUp(String lineUp, String team, String tactics , String date){
        String positions[]= lineUp.split("-");
         
        if(team.equals("Team A")){
            teamA.setLineUp(date, tactics, positions);
        }else{
            teamB.setLineUp(date, tactics, positions);
        }
    }
    /**
     * Method: lineUpInfo <br>
     * This method let the user see all the lines up set for a team <br>
     * <b> pre: the date for looking the line up that the user wants must follow the format dd/mm/yy <br>
     * <b> pos: <br> 
     * @param team , the team chosen by the user , this team must have a line up already set
     * @param date , the date of the line up which must follow the format dd/mm/yy
     * @return String with all the  lines up of a team or an specific one 
     */

    public String lineUpInfo(String team, String date){
        String info="";
        if (team.equals("Team A")) {
            info+=teamA.teamsLineUp(date);
        } else {
            info+=teamB.teamsLineUp(date);
            
        }
        
        return info;
    }
    /**
     * Method: getInfo <br>
     * This method will show all the information of the club to the user <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String with the info of the club
     */
    public String getInfo(){
         String info="";
         info+=">>>>>>>>>>>>>>>>>> CLUB'S INFO <<<<<<<<<<<<<<<<<<<<<<<\n"+
               ">>>> Name:"+name+"\n"+
               ">>>> Nit: "+nit+"\n"+
               ">>>> Creation date: "+creationDate+"\n"+
               "\n"+
               ">>>>>>>>>>>>>>>>>>>> Teams info <<<<<<<<<<<<<<<<<<<<<<\n"+
               employeesInformation("Team A")+"\n"+
               "\n"+
               employeesInformation("Team B")+"\n"+
               "\n"+
               ">>>>>>>>>>>>>>>>>>>>> Dressing rooms info <<<<<<<<<<<<<<\n"+
               "\n"+
               ">>>> Team's A dressing room: \n";
          
          for(int i=0; i<dressingRooms.length; i++){
              for(int j=0; j<dressingRooms[0].length; j++){
                  if(dressingRooms[i][j]==null){
                      info+="Empty"+"\t";
                  }else{
                      info+=(dressingRooms[i][j]).getName()+"\t";
                  }
              }
            info+="\n";  
          } 
          
          info+="\n"+
               ">>>>Team's B dressing room: \n";
           for(int i=0; i<dressingRoom2.length; i++){
              for(int j=0; j<dressingRoom2[0].length; j++){
                  if(dressingRoom2[i][j]==null){
                      info+="Empty"+"\t";
                  }else{
                      info+=(dressingRoom2[i][j]).getName()+"\t";
                  }
              }
            info+="\n";  
          }
          
          info+=">>>>>>>>>>>> Offices info <<<<<<<<<<<<<<<<< \n"+
               "\n";
          for(int i=0; i<offices.length; i++){
              for(int j=0; j<offices[0].length; j++){
                   if (offices[i][j]==null) {
                       info+="Empty"+"\t";
                   } else {
                       info+= (offices[i][j]).getName()+"\t";
                       
                   }
              }

             info+="\n"; 

          }     


         return info;
    }





    



    

    
}
