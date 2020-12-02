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
    private CoachAssistant assistant;
    

    /**
     *
     * @param name
     */
    public Team(String name) {
        this.name = name;
        players =  new Player[25];
        teamLineUp = new ArrayList<LineUp>();
        mainCoach=null;
        assistant=null;
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
               System.out.println("Check");
           }
       }
       return available;

    }

    public void setMainCoach(MainCoach newMainCoach){
        this.mainCoach=newMainCoach;
    }

    public void setCoachAssistant(CoachAssistant newCoachAssistant){
        this.assistant= newCoachAssistant;
    }

    public MainCoach getMainCoach(){
        return mainCoach;
    }

    public CoachAssistant getAssistant(){
        return assistant;
    }

    public Player[] getPlayers(){
        return players;
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
        if(assistant!=null){
           has=true;
        }else{
           has=false;
        }

        return has;

    }

    
    
}