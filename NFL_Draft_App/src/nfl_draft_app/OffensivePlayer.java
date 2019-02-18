//My Name is Joseph Posey and this is my work.
package nfl_draft_app;

import java.util.*;



public class OffensivePlayer extends Player
{
    private String position;
    private static final String[] offensivePositions = {"Center", "Offensive Guard", "Offensive Tackle", "Quarterback", "Running Back", 
                                                        "Wide Reciever", "Tight End"};
    private double passingYards;
    private double rushingYards;
    private int completions;
    private String allStats;
    
    public OffensivePlayer()
    {
    }
    
     public OffensivePlayer(String name, String position)
    {
        this.name =  name;
        this.position = position;
    }
    
    public OffensivePlayer(String name, int oPositions)
    {
        this.name =  name;
        this.position = offensivePositions[oPositions];
    }

    public OffensivePlayer(String name, int heightInInches, int weightInPounds, int oPositions)
    {
        super (name, heightInInches, weightInPounds);
        this.position = offensivePositions[oPositions];
    }
    
    public OffensivePlayer(String name, int heightInInches, int weightInPounds, int oPositions, double passingYards, double rushingYards, int completions)
    {
        super (name, heightInInches, weightInPounds);
        this.position = offensivePositions[oPositions];
        this.passingYards = passingYards;
        this.rushingYards = rushingYards;
        this.completions = completions;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public double getPassingYards()
    {
        return passingYards;
    }
    
    public void setPassingYards(double passingYards)
    {
        this.passingYards = passingYards;
    }

     public double getRushingYards()
    {
        return rushingYards;
    }
    
    public void setRushingYards(double rushingYards)
    {
        this.rushingYards = rushingYards;
    }

    public int getCompletions()
    {
        return completions;
    }
    
    public void setCompletions(int completions)
    {
        this.completions = completions;
    }
    
    public String getOffensivePositions() 
    {
        List<String> pos = Arrays.asList(offensivePositions);
        String oPositionsList = "";
        for (String p:offensivePositions)
            oPositionsList += (p + "\t" + pos.indexOf(p) + "\n");
        return oPositionsList;
    }
    
    @Override
    public String toString()
    {  
        allStats = "Name:\t\t" + name + "\nHeight:\t\t" + heightInInches + " In.\nWeight:\t\t" + weightInPounds + " Lbs.\nPosition:\t" + position
                + "\nPassing:\t" + passingYards + " Yrds.\nRushing:\t" + rushingYards + " Yrds.\nCompletions:\t" + completions + "\n";
        return allStats;
    }
}
