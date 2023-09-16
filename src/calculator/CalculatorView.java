package calculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
public class CalculatorView extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CalculatorFXML.fxml"));
            Parent root = loader.load();
            Font font = new Font(30);
            Label display = (Label)loader.getNamespace().get("display");
            display.setPadding(new Insets(10));
            display.setMaxWidth(300);
            display.setFont(font);
            GridPane grid = (GridPane)loader.getNamespace().get("grid");
            for (int i = 0; i < 4; i++) {
                grid.getColumnConstraints().add(new ColumnConstraints(75));
            }
            for (Node n : grid.getChildren()) {
                Button b = (Button)n;
                b.setMaxWidth(75);
                b.setFont(font);
            }
            stage.setTitle("Calculator");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error during initialization");
        }
    }
}
