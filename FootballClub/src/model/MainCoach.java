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

   

    
    /**
     * Method: infoEmployee <br>
     * This method let the user know all the information of this employee <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String , with all the info of the employee
     */
    @Override
    public String infoEmployee() {
        String info="[*] Type of employee: Main coach \n";
        info+=super.infoEmployee();
        info+="[*] Teams managed: "+teamsEncharged+"\n"+
              "[*] Championships won: "+wonChampionships+"\n"+
              "[*] Experience years: "+getExperienceYears()+"\n"+
              "[*] Current stars: "+calculateStars()+"\n";

        return info;
    }
    

    
}
