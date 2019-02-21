//My Name is Joseph Posey and this is my work.
package nfl_draft_app;

import java.util.*;



public class OffensivePlayer extends Player
{
    private String position;
    public static final String[] offensivePositions = {"Center", "Offensive Guard", "Offensive Tackle", "Quarterback", "Running Back", "Wide Reciever", "Tight End"};
    public double passingYards;
    public double rushingYards;
    public int completions;
    public String allStats;
    
    public OffensivePlayer()
    {
    }
    
    public OffensivePlayer(String name)
    {
        this.name =  name;
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
    public int getPositionIndex(String j)
    {
        String count = getOffensivePositions();
        String[] lines = count.split("\r\n|\r|\n");
        int k = Arrays.asList(lines).indexOf(j);
        return k;
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
    
    @Override
    public String getOffensivePositions() 
    {
        List<String> pos = Arrays.asList(offensivePositions);
        String oPositionsList = "";
        for (String p:offensivePositions)
            oPositionsList += (p + "\n");
        return oPositionsList;
    }
    
    @Override
    public String toString()
    {  
        allStats = name + "\n" + heightInInches + "\n" + weightInPounds + "\n" + position + "\n" + passingYards + "\n" + rushingYards + "\n" + completions;
        return allStats;
    }
}
