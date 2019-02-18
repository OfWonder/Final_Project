//My name is Joseph Posey and this is my work.
package nfl_draft_app;

import java.lang.reflect.Array;
import java.util.*;

public class Manager 
{
    
    public static void main(String[] args)
    {
//        Manager User = new Manager(); //Test manager
//        User.toString();
//        System.out.print(User.toString() + "\n");
//        System.out.print(User.playerList.get(0).getName() + " weighs " + User.playerList.get(0).getWeightInPounds() + "\n");
//        User.playerList.get(0).setWeightInPounds(300);
//        User.playerList.get(1).setWeightInPounds(189);
//        User.playerList.get(2).setWeightInPounds(500);
//        User.playerList.get(3).setWeightInPounds(306);
//        System.out.print(User.playerList.get(0).getAllStats());
//        System.out.print(User.playerList.get(1).getAllStats());
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
	for (Player n : playerList) 
            playList += (n.name + "\n");
            return playList;
    }
    
    public void removePlayer(int i)
    {
        int p = NFL_Draft_App.user.playerList.indexOf(i);
        NFL_Draft_App.user.playerList.remove(i); 
    }
}

