package model;

public class Player extends Employee {
    private String numberShirt;
    private double averageRating;
    private int numberGoals;

    public Player(String name, String id, double salary, String status, String numberShirt, double averageRating, int numberGoals) {
        super(name, id, salary, status);
        this.numberShirt = numberShirt;
        this.averageRating = averageRating;
        this.numberGoals = numberGoals;
    }

    

    


    
}
