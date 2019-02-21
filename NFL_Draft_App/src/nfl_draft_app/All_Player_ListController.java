//My name is Joseph Posey and this is my work
package nfl_draft_app;

import java.net.URL;
import java.util.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;

public class All_Player_ListController implements Initializable 
{
    @FXML private TableView<Player> tableView;
    @FXML private TableColumn<Player, String> PlayerColumn;
    @FXML private TableColumn<Player, String> PositionColumn;
    
    @FXML 
    private void removePlayer(ActionEvent event) throws Exception
    {
        Player p = tableView.getSelectionModel().getSelectedItem();
        if (p == null)
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Please Select a Player to remove them from the list.");
            a.setHeaderText("No Player Selected!");
            a.show();
        }
        else
        {
            String n = tableView.getSelectionModel().getSelectedItem().getName();
            int i = NFL_Draft_App.user.getIndex(n);
            NFL_Draft_App.user.removePlayer(i);
            tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        }
    }
    
    @FXML
    public void ViewStats(ActionEvent event) throws Exception
    {
        Player p = tableView.getSelectionModel().getSelectedItem();
        if (p == null)
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Please Select a Player to view their stats.");
            a.setHeaderText("No Player Selected!");
            a.show();
        }
        else
        {
            Stat_ScreenController.currentPlayer = p;
            Stat_ScreenController.last = "a";
            String oP = "Center Offensive Guard Offensive Tackle Quarterback Running Back Wide Reciever Tight End";
            boolean n = oP.contains(p.getPosition());
            
            if (n == true)
            {
                Stat_ScreenController.all = "o";
            }
            else
            {
                Stat_ScreenController.all = "d";
            }
            
            Parent Test = FXMLLoader.load(getClass().getResource("Stat_Screen.fxml"));
            Scene fun = new Scene(Test);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(fun);
            window.show();
        }
    }
    
    @FXML
    private void Return_Button(ActionEvent event) throws Exception
    {
        Parent Test = FXMLLoader.load(getClass().getResource("Offensive_Or_Defensive_Player_Screen.fxml"));
        Scene fun = new Scene(Test);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(fun);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        PlayerColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        PositionColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
        tableView.setItems(getPlayers());   
        tableView.setItems(getPlayers());   
    }
    
    public ObservableList<Player> getPlayers()
    {
        ObservableList<Player> Players = FXCollections.observableArrayList();
        int l = NFL_Draft_App.user.playerList.size();
        
        for(int i = 0; i < l; i++)
        {
            String oP = "Center Offensive Guard Offensive Tackle Quarterback Running Back Wide Reciever Tight End";
            boolean n = oP.contains(NFL_Draft_App.user.playerList.get(i).getPosition());
            
            if (n == true)
            {
                String p = NFL_Draft_App.user.playerList.get(i).getPosition();
                Player oPlayer = NFL_Draft_App.user.playerList.get(i);
                Players.add(new OffensivePlayer(
                    NFL_Draft_App.user.playerList.get(i).getName()
                    ,NFL_Draft_App.user.playerList.get(i).getHeightInInches()
                    ,NFL_Draft_App.user.playerList.get(i).getWeightInPounds()
                    ,NFL_Draft_App.user.playerList.get(i).getOPositionIndex(p)
                    ,NFL_Draft_App.user.playerList.get(i).getPassingYards(oPlayer)
                    ,NFL_Draft_App.user.playerList.get(i).getRushingYards(oPlayer)
                    ,NFL_Draft_App.user.playerList.get(i).getCompletions(oPlayer)
                ));
            }
            else
            {
                String p = NFL_Draft_App.user.playerList.get(i).getPosition();
                Player dPlayer = NFL_Draft_App.user.playerList.get(i);
                Players.add(new DefensivePlayer(
                        NFL_Draft_App.user.playerList.get(i).getName() 
                        ,NFL_Draft_App.user.playerList.get(i).getHeightInInches()
                        ,NFL_Draft_App.user.playerList.get(i).getWeightInPounds()
                        ,NFL_Draft_App.user.playerList.get(i).getDPositionIndex(p)
                        ,NFL_Draft_App.user.playerList.get(i).getInterceptions(dPlayer)
                        ,NFL_Draft_App.user.playerList.get(i).getTackles(dPlayer)
                        ,NFL_Draft_App.user.playerList.get(i).getFumbles(dPlayer)
                ));
            }
        }
        return Players;
    }
}
