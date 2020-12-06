package model;
import java.util.ArrayList;

/**
 * description of class Team 
 *
 * @author Johan Ricardo
 * @version  
 */
public class Team {
    //attributes
    private String name;
   
    //relationships with other entities
    private ArrayList<LineUp> teamLineUp;
    private Player players[];
    private MainCoach mainCoach;
    private CoachAssistant assistant[];
    

    /**
     * Constructor of the object Team <br>
     * @param name , the name of the team
     */
    public Team(String name) {
        this.name = name;
        players =  new Player[25];
        teamLineUp = new ArrayList<LineUp>();
        assistant= new CoachAssistant[3];
        mainCoach=null;
    }

    /**
     * Method: addPlayer <br>
     * This method let the user add a player to a team and will notify if the team can have players <br>
     * <b>pre: <br>
     * <b>pos: a new player added to a team or not <br>
     * @param aPlayer , the object player that will be added to a team
     * @return boolean , true if the user can add a new player , false if the array is full
     */
    public boolean addPlayer(Player aPlayer){
       boolean available=false;
       for(int i=0; i<players.length && available!=true; i++){
           if(players[i]==null){
               players[i]=aPlayer;
               available=true;
               //System.out.println("Check");
           }
       }
       return available;

    }

    public void setMainCoach(MainCoach newMainCoach){
        this.mainCoach=newMainCoach;
    }

    public void setCoachAssistant(CoachAssistant newCoachAssistant){
        boolean out=false;
        for (int i = 0; i < assistant.length && !out; i++) {
            if(assistant[i]==null){
                this.assistant[i]= newCoachAssistant;
                out=true;
            }
            
        }
        
    }

    public MainCoach getMainCoach(){
        return mainCoach;
    }

    public CoachAssistant[] getAssistant(){
        return assistant;
    }

    public Player[] getPlayers(){
        return players;
    }

    public void setLineUp(String date, String teamTactics, String[] positions){
        LineUp newLineUp = new LineUp(date, teamTactics);
        int [] positions2 = new int[positions.length];
        for(int i = 0; i < positions.length; i++) {
           positions2[i]= Integer.parseInt(positions[i]);
        }
        newLineUp.setFormation(positions2);
        teamLineUp.add(newLineUp);

    }

    public ArrayList<LineUp> getLineUp(){
        return teamLineUp;
    }

    public String getName(){
        return name;
    }

     /**
     * Method: hasMain <br>
     * this method helps to check if the team already has a Main coach <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return boolean, true or false
     */

    public boolean hasMain(){
        boolean has;
        if(mainCoach!=null){
           has=true;
        }else{
            has=false;
        }
        return has;

    }

    /**
     * Method: hasAssistant<br>
     * this method helps to check if the team already has an Assistant coach <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return boolean, true or false
     */

    public boolean hasAssistant(){
        boolean has;
        int x=0;
        for(int i=0; i<assistant.length; i++){
              if (assistant[i]!=null) {
                    x+=1;  
              } 
        }

        if (x==3) {
            has=true;
        } else {
            has=false;
        }
        return has;

    }

    /**
     * Method: TeamsLineUp <br>
     * This method creates an String with the information of a lineup or all them <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @param date , the date  of for looking an specific line up or all of them
     * @return String with the info of the line up 
     */

    public String teamsLineUp(String date){
        String lineUpInfo="";
        boolean out=false;
        if (date.equals("All")) {
            for(int i = 0; i < teamLineUp.size(); i++){
                lineUpInfo+=">>>>>>>>>Line up for the team "+name+"<<<<<<<<<<<<<<\n"+
                             ">>Date: "+(teamLineUp.get(i)).getDate()+"\n"+
                             ">>> Tactic: "+(teamLineUp.get(i)).getLineUpTactics()+"\n"+
                             "\n";
                         
                lineUpInfo+=teamLineUp.get(i).lineUpToString()+"\n";
            }
            
        } else {
            for(int i = 0; i < teamLineUp.size()&& !out; i++){
                if((teamLineUp.get(i).getDate()).equals(date)){
                    lineUpInfo+=">>>>>>>>>Line up for the team "+name+"<<<<<<<<<<<<<<\n"+
                             ">>Date: "+(teamLineUp.get(i)).getDate()+"\n"+
                             ">>> Tactic: "+(teamLineUp.get(i)).getLineUpTactics()+"\n"+
                             "\n";
        
                    lineUpInfo+=teamLineUp.get(i).lineUpToString()+"\n";;
                    out=true;    
                }
                
            }
            
        }
        return lineUpInfo;

    }

    
    
}