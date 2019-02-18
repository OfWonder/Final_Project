//My Name is Joseph Posey and this is my work.
package nfl_draft_app;

import java.util.*;

public class DefensivePlayer extends Player
{
    public DefensivePlayer()
    {
    }

    public DefensivePlayer(String name, String position)
    {
        this.name = name;
        this.position = position;
    }
    
    public DefensivePlayer(String name, int heightInInches, int weightInPounds, int dPositions)
    {
        super (name, heightInInches, weightInPounds);
        this.position = defensivePositions[dPositions];
        
    }
    
     public DefensivePlayer(String name, int heightInInches, int weightInPounds, int dPositions, int interceptions, int tackles, int fumbles)
    {
        super (name, heightInInches, weightInPounds);
        this.position = defensivePositions[dPositions];
        this.interceptions = interceptions;
        this.tackles = tackles;
        this.fumbles = fumbles;
    }
    
    private String position;
    private static final String[] defensivePositions = {"Defensive End", "Middle Linebacker", "Defensive Tackle", "Outside Linebacker", "Cornerback", 
                                                        "Safety", "Nickleback", "Dimeback"};
    private int interceptions;
    private int tackles;
    private int fumbles;
    private String allStats;
    
    public String getPosition()
    {
        return position;
    }
    
    public int getInterceptions()
    {
        return interceptions;
    }
    
    public void setInterceptions(int interceptions)
    {
        this.interceptions = interceptions;
    }
    
     public int getTackles()
    {
        return tackles;
    }
    
    public void setTackles(int tackles)
    {
        this.tackles = tackles;
    }
    
    public int getFumbles()
    {
        return fumbles;
    }
    
    public void setFumbles(int fumbles)
    {
        this.fumbles = fumbles;
    }
    
    public String getDefensivePositions() 
    {
        List<String> pos = Arrays.asList(defensivePositions);
        String dPositionsList = "";
        for (String p:defensivePositions)
            dPositionsList += (p + "\t" + pos.indexOf(p) + "\n");
        return dPositionsList;
    }
    
    @Override
    public String toString()
    {  
        allStats = "Name:\t\t" + name + "\nHeight:\t\t" + heightInInches + " In.\nWeight:\t\t" + weightInPounds + " Lbs.\nPosition:\t" + position + 
                "\nInterceptions:\t" + interceptions + "\nTackles:\t" + tackles + "\nFumbles:\t" + fumbles + "\n";
        return allStats;
    }
}
