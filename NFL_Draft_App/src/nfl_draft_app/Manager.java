//My name is Joseph Posey and this is my work.
package nfl_draft_app;

import java.util.*;

public class Manager 
{
    
    public static void main(String[] args)
    {
    }
    
    public Manager()
    {    
        createPlayers();
    }
    public static ArrayList<Player> playerList = new ArrayList<Player>();
    
    public static void createPlayers() //Use this to Add players to manage
    {
        Player ClintonDixH = new DefensivePlayer("Ha Ha Clinton-Dix", 73, 207, 5);
        Player BaldwinD = new OffensivePlayer("Doug Baldwin", 71, 189, 5, 618, -4, 50);
        Player MosleyC = new DefensivePlayer("C.J. Mosely", 74, 238, 1);
        Player HydeC = new OffensivePlayer("Carlos Hyde", 72, 236, 4, 33, 571, 10);
        Player JenkinsM = new DefensivePlayer("Malcolm Jenkins", 72, 204, 5, 1, 97, 0);
        Player JohnsonL = new DefensivePlayer("Lane Johnson", 78, 310, 2);
        playerList.add(ClintonDixH);
        playerList.add(BaldwinD);
        playerList.add(MosleyC);
        playerList.add(HydeC);
        playerList.add(JenkinsM);
        playerList.add(JohnsonL);    
    }
    
    public String getOPlayers() 
    {
	String playList = "";
	for (Player n : playerList) 
            playList += (n.name);
            return playList;
    }
    
    public static int getIndex(String j)
    {
        String count = NFL_Draft_App.user.nameList();
        String[] lines = count.split("\r\n|\r|\n");
        int k = Arrays.asList(lines).indexOf(j);
        return k;
    }
    
    @Override
    public String toString() 
    {
	String playList = "";
	for (Player n : playerList) 
            playList += (n.name + "\t " + playerList.indexOf(n) + "\n");
            return playList;
    }
    
    public String nameList() 
    {
	String playList = "";
	for (Player p : playerList) 
            playList += (p.name + "\n");
            return playList;
    }
    
    public void removePlayer(int i)
    {
        int p = NFL_Draft_App.user.playerList.indexOf(i);
        NFL_Draft_App.user.playerList.remove(i); 
    }
}

