package model;

public class CoachAssistant  extends Coach{

    private Boolean wasPlayer;

    private Skills skills;

    public CoachAssistant(String name, String id, double salary, String status, int experienceYears, boolean wasPlayer, String skill){
        super(name, id, salary, status, experienceYears);
        this.wasPlayer=wasPlayer;
    }

    
    
}
