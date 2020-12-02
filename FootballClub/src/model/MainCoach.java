package model;

public class MainCoach extends Coach implements Profitable {

    private int teamsEncharged;
    private int wonChampionships;

    public MainCoach(String name, String id, double salary, int experienceYears, int teamsEncharged,
            int wonChampionships) {
        super(name, id, salary, experienceYears);
        this.teamsEncharged = teamsEncharged;
        this.wonChampionships = wonChampionships;

    }

    public double calculateMarketPrice() {
        double marketPrice=0.0;
        marketPrice=(getSalary()*10)+(getExperienceYears()*100)+(wonChampionships*50);

        return marketPrice;
    }

    public double calculateStars() {
        double stars=0.0;
        stars= 5+(wonChampionships/10);
        return stars;
    }

    public int getTeamsEncharged() {
        return teamsEncharged;
    }

    public void setTeamsEncharged(int teamsEncharged) {
        this.teamsEncharged = teamsEncharged;
    }

    public int getWonChampionships() {
        return wonChampionships;
    }

    public void setWonChampionships(int wonChampionships) {
        this.wonChampionships = wonChampionships;
    }

    @Override
    public String infoEmployee() {
        String info="[*] Type of employee: Main coach \n";
        info+=super.infoEmployee();
        info+="[*] Teams managed: "+teamsEncharged+"\n"+
              "[*] Championships won: "+wonChampionships+"\n"+
              "[*] Experience years: "+getExperienceYears()+"\n"+
              "[*] Coach's current calcification: "+calculateMarketPrice();
        return info;
    }
    

    
}
