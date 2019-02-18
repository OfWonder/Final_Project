//My name is Joseph Posey and this is my work
package nfl_draft_app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Offensive_Or_Defensive_Player_ScreenController implements Initializable 
{
    
    @FXML
    private void View_Offensive_Player_List(ActionEvent event) throws Exception
    {
        Parent Test = FXMLLoader.load(getClass().getResource("Offensive_Player_List.fxml"));
        Scene fun = new Scene(Test);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(fun);
        window.show();
    }
    
    @FXML
    private void View_Defensive_Player_List(ActionEvent e) throws Exception
    {
        Parent Test = FXMLLoader.load(getClass().getResource("Defensive_Player_List.fxml"));
        Scene fun = new Scene(Test);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(fun);
        window.show();
    }
    
    @FXML
    private void View_ALL_Player_List(ActionEvent e) throws Exception
    {
        Parent Test = FXMLLoader.load(getClass().getResource("All_Player_List.fxml"));
        Scene fun = new Scene(Test);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(fun);
        window.show();
    }
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
