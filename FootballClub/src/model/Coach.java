package model;

public abstract class Coach extends Employee {

    private int experienceYears;

    public Coach(String name, String id, double salary, int experienceYears) {
        super(name, id, salary);
        this.experienceYears = experienceYears;

    }

    /**
     * @return int return the experienceYears
     */
    public int getExperienceYears() {
        return experienceYears;
    }

    /**
     * @param experienceYears the experienceYears to set
     */
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String infoEmployee() {
        return super.infoEmployee();
    }

    

}
