//My name is Joseph Posey and this is my work
package nfl_draft_app;

public abstract class Player 
{
    public String name;
    //public String position;
    public int heightInInches;
    public int weightInPounds;
    public String position;
    public String oPositionsList;
    
    public Player()
    {  
    }
    
    public Player(String name, int heightInInches, int weightInPounds)
    {
        this.name = name;
        //this.position = position;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getHeightInInches()
    {
        return heightInInches;
    }
    
    public void setHeightInInches(int heightInInches)
    {
        this.heightInInches = heightInInches;
    }
    
    public int getWeightInPounds()
    {
        return weightInPounds;
    }
    
    public void setWeightInPounds(int weightInPounds)
    {
        this.weightInPounds = weightInPounds;
    }
    
//    public String getAllStats()
//    {
//        allStats = "Name:\t\t\t" + name + "\n" + "Position:\t\t" + position + "\n" + "Height:\t\t\t" + heightInInches + " In.\n" + "Weight:\t\t\t" + weightInPounds + 
//               " Lb.\n" + "Passing Yards:\t\t" + passingYards + "\n" + "Rushing Yards:\t\t" + rushingYards + "\n" + "Completions:\t\t" + completions + "\n" + 
//               "Tackles:\t\t" + tackles + "\n" + "Interceptions:\t\t" + interceptions + "\n" + "Passing Touchdowns:\t" + passingTouchdowns + "\n" + "Rushing Touchdowns:\t" +
//               rushingTouchdowns + "\n";
//        return allStats;
//    }
    
    public String toString()
    {
        return name;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public String getOffensivePositions() 
    {
        return oPositionsList;
    }
    
    public String getDefensivePositions() 
    {
        return oPositionsList;
    }
    
    public static void main(String[] args)
    {
        
    }
}

