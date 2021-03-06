package model;

public class Player extends Employee implements Profitable {
    
    private String numberShirt;
    private double averageRating;
    private int numberGoals;

    private Position playerPosition;

    public Player(String name, String id, double salary, String numberShirt, int numberGoals, String position) {
        super(name, id, salary);
        this.numberShirt = numberShirt;
        this.averageRating = 0.0;
        this.numberGoals = numberGoals;
        this.playerPosition = Position.valueOf(position);
    }

    public double calculateMarketPrice() {
        double marketPrice=0.0;
        if(playerPosition.equals(Position.GOALKEEPER)){
             marketPrice=((getSalary())*12)+(averageRating*150);
        }

        if(playerPosition.equals(Position.DEFENDER)){
            marketPrice=((getSalary())*13)+(averageRating*125)+(numberGoals*100);

        }

        if(playerPosition.equals(Position.MIDFIELD)){
            marketPrice=((getSalary())*14)+(averageRating*135)+(numberGoals*125);
        }

        if(playerPosition.equals(Position.STRICKER)){
            marketPrice=((getSalary())*15)+(averageRating*145)+(numberGoals*150);
        }

        return marketPrice;
    }

    public double calculateStars(){
        double stars=0.0;
        if(playerPosition.equals(Position.GOALKEEPER)){
            stars=averageRating*0.9;
       }

       if(playerPosition.equals(Position.DEFENDER)){
          stars=(averageRating*0.9)+(numberGoals/100);
       }

       if(playerPosition.equals(Position.MIDFIELD)){
        stars=(averageRating*0.9)+(numberGoals/90);
       }

       if(playerPosition.equals(Position.STRICKER)){
        stars=(averageRating*0.9)+(numberGoals/80);
           
       }
        

        return stars;
    }

   

    public void setAverageRating(double averageRating) {
        this.averageRating+= averageRating;
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
        String info="";
        info+="[*] Type of employee: Player \n";
        info+=super.infoEmployee();
        info+="[*] Shirt 's number: "+numberShirt+"\n"+
              "[*] player's position "+playerPosition.toString()+"\n"+
              "[*] Player's current rating: "+averageRating+"\n"+
              "[*] Current stars: "+calculateStars()+"\n";
        return info;
    }

    

    


    
}
