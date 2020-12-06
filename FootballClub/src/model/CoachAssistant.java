package model;

public class CoachAssistant extends Coach {

    private Boolean wasPlayer;

    private Skill skills;

    public CoachAssistant(String name, String id, double salary, int experienceYears, boolean wasPlayer, String skill) {
        super(name, id, salary, experienceYears);
        this.wasPlayer = wasPlayer;
        this.skills = Skill.valueOf(skill);
    }

    public String wasPlayer() {
        String was = "";
        if (wasPlayer == true) {
            was = "Yes";
        } else {
            was = "No";
        }

        return was;
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
        String info="[*] Type of employee: Assistant coach \n";
        info+=super.infoEmployee();
        info+="[*] Was player: "+wasPlayer()+"\n"+
              "[*] Skills: "+skills.toString()+"\n"+
              "[*] Experience years: "+getExperienceYears()+"\n";
              
        
        return info;
    }

    


    
    
}
