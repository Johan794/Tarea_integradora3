package model;

public class LineUp {
    private String date;
    private int  formation[][];
    private Tactic LineUpTactics;
  
    /**
     * Constructor of the object Line up <br>
     * @param date , the date for the line uo
     * @param teamTactics ,  the kind of tactics
     */
    public LineUp(String date, String teamTactics){
        this.date= date;
        this.LineUpTactics= Tactic.valueOf(teamTactics);
        formation= new int[10][7];
    }
    

   
    public String getDate() {
        return date;
    }

    
    public String getLineUpTactics() {
        return LineUpTactics.toString();
    }

   

    public void setFormation(int [] positions2){
        boolean out=false;
        int sentinel=0;
            for(int k=formation.length-1; k>=0 && out!=true; k--){
                    if(k%2==0){
                        //System.out.println("Set");
                        while (out!=true && sentinel!=positions2.length) {
                            switch(positions2[sentinel]){
        
                                case 1:formation[k][3]=1;
                                       //System.out.println("Set 1");
                                        out=true;
                                        sentinel+=1;  
                                      break;
        
                                case 2: formation[k][2]=1;
                                        formation[k][4]=1;
                                        //System.out.println("Set 2");
                                        out=true;
                                        sentinel+=1;  
                                       break;
        
                                case 3: formation[k][1]=1;
                                        formation[k][3]=1;
                                        formation[k][5]=1;
                                        //System.out.println("Set 3");
                                        out=true;
                                        sentinel+=1;
                                      break;
        
                                case 4: formation[k][1]=1;
                                        formation[k][2]=1;
                                        formation[k][4]=1;
                                        formation[k][5]=1;
                                        //System.out.println("Set 4");
                                        out=true;
                                        sentinel+=1;
                                      break;
                               case 5:  formation[k][1]=1;
                                        formation[k][2]=1;
                                        formation[k][3]=1;
                                        formation[k][4]=1;
                                        formation[k][5]=1;
                                        //System.out.println("Set 5");
                                        out=true;
                                        sentinel+=1;
                                    break;
                                case 6: formation[k][1]=1;
                                        formation[k][2]=1;
                                        formation[k][3]=1;
                                        //System.out.println("Set 6");
                                        formation[k][4]=1;
                                        formation[k][5]=1;
                                        formation[k][6]=1;
                                        //System.out.println("Set 7");
                                        out=true;
                                        sentinel+=1;
                                         break;
        
                                 case 7:formation[k][1]=1;
                                        formation[k][2]=1;
                                        formation[k][3]=1;
                                        formation[k][4]=1;
                                        formation[k][5]=1;
                                        formation[k][6]=1;
                                        formation[k][0]=1;
                                        out=true;
                                        sentinel+=1;
                                        //System.out.println("Set 8"); 
                                        break;
        
                                        }
                              if (sentinel==positions2.length) {
                                            out=true;
                                    }
                        } 

                        
                            
                                      
                           
                      }



                

                out=false;  
                
               
             }

        
            
             
                
         
         
       



       
        
        
    }
    
    /**
     * Method: LineUpToString <br>
     * This method creates an String with the information of a lineup <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String , with the information of the matrix formation[][]
     */
    public String lineUpToString(){
        String lineUpString="";
     for (int i = 0; i < formation.length; i++) {
         for(int j=0; j<formation[0].length; j++){
             lineUpString += formation[i][j] + " ";
         }
         lineUpString += "\n";

     }

     return lineUpString;
    }   

}
