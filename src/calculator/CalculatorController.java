package calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class CalculatorController {
    @FXML private Label display;
    @FXML public void num(ActionEvent e) {
        if (CalculatorModel.num(((Button)e.getSource()).getText())) {
            display.setText(CalculatorModel.getNum1() + " " + CalculatorModel.getOp() + " " + CalculatorModel.getNum2());
        } else {
            CalculatorModel.clear();
            display.setText("Invalid Input");
        }
    }
    @FXML public void clear() {
        CalculatorModel.clear();
        display.setText("0");
    }
    @FXML public void eval() {
        if (CalculatorModel.eval()) {
            display.setText(CalculatorModel.getNum1());
        } else {
            CalculatorModel.clear();
            display.setText("Invalid Input");
        }
    }
    @FXML public void op(ActionEvent e) {
        if (CalculatorModel.setOp(((Button)e.getSource()).getText())) {
            display.setText(CalculatorModel.getNum1() + " " + CalculatorModel.getOp());
        } else {
            CalculatorModel.clear();
            display.setText("Invalid Input");
        }
    }
}
