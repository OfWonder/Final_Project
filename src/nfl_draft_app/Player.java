//My name is Joseph Posey and this is my work
package nfl_draft_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static nfl_draft_app.OffensivePlayer.offensivePositions;

public abstract class Player 
{
    public int heightInInches, weightInPounds;
    public String name, position, oPositionsList, dPositionList;
    
    public Player()
    {  
    }
    
    public Player(String name, int heightInInches, int weightInPounds)
    {
        this.name = name;
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
    
    public int getOPositionIndex(String j)
    {
        String count = getOffensivePositions();
        String[] lines = count.split("\r\n|\r|\n");
        int k = Arrays.asList(lines).indexOf(j);
        return k;
    }
    
    public int getDPositionIndex(String j)
    {
        String count = getDefensivePositions();
        String[] lines = count.split("\r\n|\r|\n");
        int k = Arrays.asList(lines).indexOf(j);
        return k;
    }
    
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
    
    public String getAllPositions()
    {
        List list = new ArrayList(Arrays.asList(OffensivePlayer.offensivePositions));
        list.addAll(Arrays.asList(DefensivePlayer.defensivePositions));
        Object[] allPositions = list.toArray();
        String[] p = Arrays.copyOf(allPositions, allPositions.length, String[].class);
        List<String> pos = Arrays.asList(p);
        String aPositionsList = "";
        for (String l: p)
            aPositionsList += (l + "\n");
        return aPositionsList;
    }
    
    public String getDefensivePositions() 
    {
        return dPositionList;
    }
    
    public double getPassingYards(Player j)
    {
        String[] p = j.toString().split("\r\n|\r|\n");
        double passingYards = Double.parseDouble(p[4]);
        return passingYards;
    }
    
    public double getRushingYards(Player j)
    {
        String[] p = j.toString().split("\r\n|\r|\n");
        double rushingYards = Double.parseDouble(p[5]);
        return rushingYards;
    }
     
    public int getCompletions(Player j)
    {
        String[] p = j.toString().split("\r\n|\r|\n");
        int completions = Integer.parseInt(p[6]);
        return completions;
    }
    
    public int getInterceptions(Player j)
    {
        String[] p = j.toString().split("\r\n|\r|\n");
        int interceptions= Integer.parseInt(p[4]);
        return interceptions;
    }
    
    public int getTackles(Player j)
    {
        String[] p = j.toString().split("\r\n|\r|\n");
        int tackles = Integer.parseInt(p[5]);
        return tackles;
    }
    
    public int getFumbles(Player j)
    {
        String[] p = j.toString().split("\r\n|\r|\n");
        int fumbles = Integer.parseInt(p[6]);
        return fumbles;
    }
}

