package model;

public class LineUp {
    private String date;
    private int  formation[][];
    private Tactic teamTactics;
  
    public LineUp(String date, String teamTactics){
        this.date= date;
        this.teamTactics= Tactic.valueOf(teamTactics);
        formation= new int[7][10];
    }
    
}
