//My name is Joseph Posey and this is my work
package nfl_draft_app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Defensive_Player_ListController implements Initializable {

   
    @FXML private TableView<DefensivePlayer> tableView;
    @FXML private TableColumn<DefensivePlayer, String> PlayerColumn;
    @FXML private TableColumn<DefensivePlayer, String> PositionColumn;
    
    @FXML
    private void removePlayer(ActionEvent event)
    {
        String p = tableView.getSelectionModel().getSelectedItem().getName();
        int i = NFL_Draft_App.user.getIndex(p);
        NFL_Draft_App.user.removePlayer(i);
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
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
        PlayerColumn.setCellValueFactory(new PropertyValueFactory<DefensivePlayer, String>("name"));
        PositionColumn.setCellValueFactory(new PropertyValueFactory<DefensivePlayer, String>("position"));
        tableView.setItems(getOPlayers());   
    }
    
    public ObservableList<DefensivePlayer> getOPlayers()
    {
        ObservableList<DefensivePlayer> dPlayers = FXCollections.observableArrayList();
        
        int l = NFL_Draft_App.user.playerList.size();
        for(int i = 0; i < l; i++)
        {
            String dP = "Defensive End Middle Linebacker Defensive Tackle Outside Linebacker Cornerback Safety Nickleback Dimeback";
            boolean n = dP.contains(NFL_Draft_App.user.playerList.get(i).getPosition());
            if (n == true)
            {
                dPlayers.add(new DefensivePlayer(NFL_Draft_App.user.playerList.get(i).getName(), NFL_Draft_App.user.playerList.get(i).getPosition()));
            }
        }
        return dPlayers;
    }
}

