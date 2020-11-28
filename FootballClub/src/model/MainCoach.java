package model;

public class MainCoach extends Coach implements Profitable {

    private int teamsEncharged;
    private int wonChampionships;

    public MainCoach(String name, String id, double salary, String status, int experienceYears,int teamsEncharged, int wonChampionships){
        super(name, id, salary, status, experienceYears);
        this.teamsEncharged=teamsEncharged;
        this.wonChampionships= wonChampionships;

    }
    
    public double calculateMarketPrice() {
        
        return 0;
    }

    
    public double calculateStars() {
        
        return 0;
    }
    

    
}
