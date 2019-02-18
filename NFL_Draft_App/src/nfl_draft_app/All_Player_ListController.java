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

public class All_Player_ListController implements Initializable {

    @FXML private TableView<Player> tableView;
    @FXML private TableColumn<Player, String> PlayerColumn;
    @FXML private TableColumn<Player, String> PositionColumn;
    
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
        PlayerColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        PositionColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
        tableView.setItems(getPlayers());   
    }
    
    public ObservableList<Player> getPlayers()
    {
        ObservableList<Player> dPlayers = FXCollections.observableArrayList();
        
        int l = NFL_Draft_App.user.playerList.size();
        for(int i = 0; i < l; i++)
        {
            dPlayers.add(new OffensivePlayer(NFL_Draft_App.user.playerList.get(i).getName(), NFL_Draft_App.user.playerList.get(i).getPosition()));
        }
        return dPlayers;
    }
}
