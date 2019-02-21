//My name is Joseph Posey and this is my work
package nfl_draft_app;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Stat_ScreenController implements Initializable 
{
    @FXML private TextField name_in, height_in, weight_in, O1_in, O2_in, O3_in;
    @FXML private ChoiceBox position_list;
    @FXML private Text O_or_D, O1, O2, O3, M1, M2;
    @FXML private Button Save_ChangesBtn;
    public static Player currentPlayer;
    public static String last, all, alln;
    private static int playerCount;
    int height, weight, position;
    double pYards;
    double rYards;
    int completions;
    int interceptions;
    int tackles;
    int fumbles;

    @FXML
    public void returnButton(ActionEvent event)throws Exception
    {
        if (last == "o")
        {
            Parent Test = FXMLLoader.load(getClass().getResource("Offensive_Player_List.fxml"));
            Scene fun = new Scene(Test);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(fun);
            window.show();
        }
        else if (last == "d")
        {
            Parent Test = FXMLLoader.load(getClass().getResource("Defensive_Player_List.fxml"));
            Scene fun = new Scene(Test);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(fun);
            window.show();
        }
        else if (last == "a")
        {
            Parent Test = FXMLLoader.load(getClass().getResource("All_Player_List.fxml"));
            Scene fun = new Scene(Test);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(fun);
            window.show();
        }
        else
        {
            Parent Test = FXMLLoader.load(getClass().getResource("Offensive_Or_Defensive_Player_Screen.fxml"));
            Scene fun = new Scene(Test);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(fun);
            window.show();
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Save_ChangesBtn.setVisible(false);
        position_list.getSelectionModel().selectedIndexProperty().addListener((obs, oldText, newText) -> 
        {
            ChangeDetected();
        });
        Platform.runLater(new Runnable() 
        {
            public void run() 
            {
                O_or_D.requestFocus();
            }
        });
        if ((last == "d") || (last == "o") || (last == "a"))
        {
            loadPlayerStats(currentPlayer);
        }
        else
        {
            newPlayer(currentPlayer);
        }
        
        
    }
    
    private void newPlayer(Player p)
    {
        O1.setVisible(false);
        O2.setVisible(false);
        O3.setVisible(false);
        O1_in.setVisible(false);
        O2_in.setVisible(false);
        O3_in.setVisible(false);
        name_in.setPromptText("Please enter a name");
        height_in.setPromptText("Please enter height"); 
        weight_in.setPromptText("Please enter weight"); 
        String positions = p.getAllPositions();
        String[] Apositions = positions.split("\r\n|\r|\n");
        all = "n";
        
        int j = Apositions.length;
        for (int i = 0; i < j; i++)
        {
            position_list.getItems().add((Apositions[i]));
        }
        
        position_list.getSelectionModel().selectedIndexProperty().addListener((fun, oldText, newText) -> 
        {
            O1.setVisible(true);
            O2.setVisible(true);
            O3.setVisible(true);
            O1_in.setVisible(true);
            O2_in.setVisible(true);
            O3_in.setVisible(true);
            if (newText.intValue() < 7)
            {
                currentPlayer = new OffensivePlayer();
                O_or_D.setText("Create Offensive Player");
                O1.setText("Passing Yards:");
                O2.setText("Rushing Yards:");
                O3.setText("Completions:");
                M1.setText("Yrds.");
                M2.setText("Yrds.");
                alln = "o";
            }
            else
            {
                currentPlayer = new DefensivePlayer();
                O_or_D.setText("Create Defensive Player");
                O1.setText("Interceptions:");
                O2.setText("Tackles:");
                O3.setText("Fumbles:");
                M1.setText("");
                M2.setText("");
                alln = "d";
            }
        });
    }
    
    private void loadPlayerStats(Player p)
    {
        name_in.setText (p.getName());
        height_in.setText (p.getHeightInInches() + "");
        weight_in.setText (p.getWeightInPounds() + "");
        if (all == "o")
        {
            O_or_D.setText("Offensive Player");
            O1.setText("Passing Yards:");
            O1_in.setText(p.getPassingYards(p) + "");
            O2.setText("Rushing Yards:");
            O2_in.setText(p.getRushingYards(p) + "");
            O3.setText("Completions:");
            O3_in.setText(p.getCompletions(p) + "");
            M1.setText("Yrds.");
            M2.setText("Yrds.");
            String oPositions = p.getOffensivePositions();
            String[] positions = oPositions.split("\r\n|\r|\n");
            
            int j = positions.length;
            for (int i = 0; i < j; i++)
            {
                position_list.getItems().add((positions[i]));
            }
            int o = p.getOPositionIndex(p.getPosition());
            position_list.getSelectionModel().select(o);
            
        }
        else if (all == "d")
        {
            O_or_D.setText("Defensive Player");
            O1.setText("Interceptions:");
            O1_in.setText(p.getInterceptions(p) + "");
            O2.setText("Tackles:");
            O2_in.setText(p.getTackles(p) + "");
            O3.setText("Fumbles:");
            O3_in.setText(p.getFumbles(p) + "");
            String dPositions = p.getDefensivePositions();
            String[] positions = dPositions.split("\r\n|\r|\n");
            int j = positions.length;
            for (int i = 0; i < j; i++)
            {
                position_list.getItems().add((positions[i]));
            }
            int o = p.getDPositionIndex(p.getPosition());
            position_list.getSelectionModel().select(o);
        }
        Save_ChangesBtn.setVisible(false);
    }
    
    @FXML
    private void ChangeDetected()
    {
        Save_ChangesBtn.setVisible(true);
    }
    
    @FXML
    private void UpdatePlayer(ActionEvent event) throws Exception
    {
        playerCount++;
        String n = currentPlayer.name;
        String name = name_in.getText();
        
        if (all == "o")
        {
            if (onlyLetters(name) && onlyNumbers(height_in.getText().replaceAll("", "0")) && (onlyNumbers(weight_in.getText().replaceAll("", "0")) && (onlyNumbers(O1_in.getText().replaceAll("", "0"))
                        && (onlyNumbers(O2_in.getText().replaceAll("", "0")) && (onlyNumbers(O3_in.getText().replaceAll("", "0")))))))
            {
                setOZero();
                int i = NFL_Draft_App.user.getIndex(n);
                NFL_Draft_App.user.removePlayer(i);
                OffensivePlayer P = new OffensivePlayer(name, height, weight, position, pYards, rYards, completions);
                NFL_Draft_App.user.playerList.add(P);
                Success(P);
            }
            else
            {
                FormatCheck();
            }
        }
        else if (all == "d")
        {
            if (onlyLetters(name) && onlyNumbers(height_in.getText().replaceAll("", "0")) && (onlyNumbers(weight_in.getText().replaceAll("", "0")) && (onlyNumbers(O1_in.getText().replaceAll("", "0"))
                        && (onlyNumbers(O2_in.getText().replaceAll("", "0")) && (onlyNumbers(O3_in.getText().replaceAll("", "0")))))))
            {
                setDZero();
                int i = NFL_Draft_App.user.getIndex(n);
                NFL_Draft_App.user.removePlayer(i);
                DefensivePlayer P = new DefensivePlayer(name, height, weight, position, interceptions, tackles, fumbles);
                NFL_Draft_App.user.playerList.add(P);
                Success(P);
            }
            else
            {
                FormatCheck();
            }
        }
        else if (all == "n")
        {   
            if (position_list.getValue() == null)
            {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Please Select a position for your player.");
                a.setHeaderText("No Position Selected!");
                a.show();
            }
            else
            {
                if (alln == "o")
                {
                    
                    if (onlyLetters(name) && onlyNumbers(height_in.getText().replaceAll("", "0")) && (onlyNumbers(weight_in.getText().replaceAll("", "0")) && (onlyNumbers(O1_in.getText().replaceAll("", "0"))
                        && (onlyNumbers(O2_in.getText().replaceAll("", "0")) && (onlyNumbers(O3_in.getText().replaceAll("", "0")))))))
                    {
                        setOZero();
                        OffensivePlayer P = new OffensivePlayer(name, height, weight, position, pYards, rYards, completions);
                        NFL_Draft_App.user.playerList.add(P);
                        all = "o";
                        Success(P);
                    }
                    else
                    {
                        FormatCheck();
                    }
                }
                else if (alln == "d")
                {
                    if (onlyLetters(name) && onlyNumbers(height_in.getText().replaceAll("", "0")) && (onlyNumbers(weight_in.getText().replaceAll("", "0")) && (onlyNumbers(O1_in.getText().replaceAll("", "0"))
                        && (onlyNumbers(O2_in.getText().replaceAll("", "0")) && (onlyNumbers(O3_in.getText().replaceAll("", "0")))))))
                    {
                        setDZero();
                        DefensivePlayer P = new DefensivePlayer(name, height, weight, position, interceptions, tackles, fumbles);
                        NFL_Draft_App.user.playerList.add(P);
                        Success(P);
                    }
                    else
                    {
                        FormatCheck();
                    }
                } 
            }
        }
    }

    private void setCurrentPlayer(Player p)
    {
        this.currentPlayer = p;
    }
    private void FormatCheck()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Please double check there are only numbers in the fields other than Name and Position."
            + "\n\nAlso watch out for any unnecessary SPACES.");
        a.setHeaderText("Check Your Formating!");
        a.show();
    }
    
    private void Success(Player P)
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Changes to " + P.getName() + " were saved successfully.");
        a.setHeaderText("Changes Saved!");
        a.show();
        setCurrentPlayer(P);
        loadPlayerStats(P);
        Save_ChangesBtn.setVisible(false);
    }
    
    private boolean onlyLetters(String n) 
    {
        n = n.replaceAll("\\s","");
        return Pattern.matches("[a-zA-Z0-9]+", n);
    }
    
    private boolean onlyNumbers(String n)
    {
        n = n.replaceAll(" .+$", "");
        n = n.replaceAll("\\s","");
        if (n.matches("^-?[0-9]\\d*(\\.\\d+)?$"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    private boolean onlyInt(String n)
    {
        n.replaceAll("\\s","");
        if (n.matches("^-?[0-9]\\d*(\\.\\d+)?$"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void setOZero()
    {
        String p1 = position_list.getValue().toString();
        position = currentPlayer.getOPositionIndex(p1);
        
        String h = height_in.getText();
        if (h.isEmpty())
        {
            height = 0;
        }
        else
        {
            height = Integer.parseInt(height_in.getText().replaceAll("\\s",""));
        }
        
        String w =  weight_in.getText();
        if (w.isEmpty())
        {
            weight = 0;
        }
        else
        {
            weight = Integer.parseInt(weight_in.getText().replaceAll("\\s",""));
        }
        
        String p =  O1_in.getText();
        if (p.isEmpty())
        {
            pYards = 0;
        }
        else
        {
            pYards = Double.parseDouble(O1_in.getText().replaceAll("\\s",""));
        }
        
        String t =  O2_in.getText();
        if (t.isEmpty())
        {
            rYards = 0;
        }
        else
        {
            rYards = Double.parseDouble(O2_in.getText().replaceAll("\\s",""));
        }
       
        String f =  O3_in.getText();
        if (f.isEmpty())
        {
            completions = 0;
        }
        else
        {
             completions = Integer.parseInt(O3_in.getText().replaceAll("\\s",""));
        }
    }
    
    private void setDZero()
    {
        String p1 = position_list.getValue().toString();
        position = currentPlayer.getDPositionIndex(p1);
        
        String h = height_in.getText();
        if (h.isEmpty())
        {
            height = 0;
        }
        else
        {
            height = Integer.parseInt(height_in.getText().replaceAll("\\s",""));
        }
        
        String w =  weight_in.getText();
        if (w.isEmpty())
        {
            weight = 0;
        }
        else
        {
            weight = Integer.parseInt(weight_in.getText().replaceAll("\\s",""));
        }
        
        String i =  O1_in.getText();
        if (i.isEmpty())
        {
            interceptions = 0;
        }
        else
        {
            interceptions = Integer.parseInt(O1_in.getText().replaceAll("\\s",""));
        }
        
        String t =  O2_in.getText();
        if (t.isEmpty())
        {
            tackles = 0;
        }
        else
        {
             tackles = Integer.parseInt(O2_in.getText().replaceAll("\\s",""));
        }
       
        String f =  O3_in.getText();
        if (f.isEmpty())
        {
            fumbles = 0;
        }
        else
        {
             fumbles = Integer.parseInt(O3_in.getText().replaceAll("\\s",""));
        }
    }
}
