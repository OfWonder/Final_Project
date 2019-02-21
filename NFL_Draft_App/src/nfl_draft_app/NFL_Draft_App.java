//My name is Joseph Posey and this is my Work
package nfl_draft_app;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NFL_Draft_App extends Application
{
    public static Stage primaryStage;
    public static Scene SplashScene, MainMenu;
    public static Manager user = new Manager();
    public static void main(String[] args) 
    {
        launch(args);
       
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent Splash = FXMLLoader.load(getClass().getResource("Splash_Screen.fxml"));
        Parent MainMenu = FXMLLoader.load(getClass().getResource("Offensive_Or_Defensive_Player_Screen.fxml"));
        
        Scene SplashScene = new Scene(Splash, 600, 400);
        
        primaryStage.setTitle("Posey INC NFL Draft App");
        primaryStage.setScene(SplashScene);
        primaryStage.setResizable(false);
        FadeTransition ft = new FadeTransition(Duration.millis(1500), Splash);
        ft.setFromValue(.1);
        ft.setToValue(1);
        ft.setCycleCount(3);
        ft.setAutoReverse(true);
        ft.play();
        primaryStage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000),
        ae -> afterSplash(primaryStage, MainMenu)));
        timeline.play();
        
    }
    
    private void afterSplash(Stage primaryStage, Parent MainMenu)
    {
        Scene MainMenuScene = new Scene(MainMenu, 600, 400);
        primaryStage.setScene(MainMenuScene);
        primaryStage.show();
    }
     
}
