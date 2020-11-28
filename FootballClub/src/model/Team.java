package model;
import java.util.ArrayList;

/**
 * description of class Team 
 *
 * @author Johan Ricardo
 * @version  Final
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
    }

    
    
}
