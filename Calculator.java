import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Calculator {
    private ArrayList<Double> number = new ArrayList<Double>();
    private ArrayList<String> operators = new ArrayList<String>();
    private double result = 0;// will hold final calculation

    // bean constructor
    public Calculator() {

    }

    // method to add all number to list
    public void performOperation(double operand) {
        number.add(operand);
    }

    // method to add all operators to list
    public void performOperation(String operator) {
        if (operator != "=") {
            this.operators.add(operator);
        } else {
            for (int i = operators.size() - 1; i >= 0; --i) {
                String myOperator = operators.get(i);
                if (myOperator.equals("*")) {
                    double sum = this.number.get(i) * this.number.get(i + 1);
                    // replace op with result
                    this.number.set(i, sum);
                    this.number.remove(i + 1);
                } else if (myOperator.equals("/")) {
                    double sum = this.number.get(i) / this.number.get(i + 1);
                    this.number.set(i, sum);
                    this.number.remove(i + 1);
                }
            }

            for (int i = 0; i < this.operators.size(); i++) {
                if (this.operators.get(i) == "+") {
                    this.result += this.number.get(i) + this.number.get(i + 1);
                } else if (this.operators.get(i) == "-") {
                    this.result -= this.number.get(i) - this.number.get(i + 1);
                }
            }
        }
    }

    public void getResults() {
        System.out.println(this.result);
    }

}