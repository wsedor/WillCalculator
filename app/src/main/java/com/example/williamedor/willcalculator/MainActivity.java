package com.example.williamedor.willcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList numInputArray;
    String operator;
    String displayNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numInputArray = new ArrayList(2);
        displayNum = "";

        // initialize fields and buttons TODO: Use a function that does the initial setup
        final EditText numberFieldText = (EditText) findViewById(R.id.numberFieldText);
        Button acButton = (Button) findViewById(R.id.acButton);
        Button polarityButton = (Button) findViewById(R.id.polarityButton);
        Button percentButton = (Button) findViewById(R.id.percentButton);
        Button divideButton = (Button) findViewById(R.id.divideButton);
        Button productButton = (Button) findViewById(R.id.productButton);
        Button subtractButton = (Button) findViewById(R.id.subtractButton);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button equalButton = (Button) findViewById(R.id.equalButton);
        Button decimalButton = (Button) findViewById(R.id.decimalButton);
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        // set text field to button values
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "1";
                //numberFieldText.setText(displayNum);
                setDispNum("1", numberFieldText);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "2";
                //numberFieldText.setText(displayNum);
                setDispNum("2", numberFieldText);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "3";
                //numberFieldText.setText(displayNum);
                setDispNum("3", numberFieldText);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "4";
                //numberFieldText.setText(displayNum);
                setDispNum("4", numberFieldText);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "5";
                //numberFieldText.setText(displayNum);
                setDispNum("5", numberFieldText);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "6";
                //numberFieldText.setText(displayNum);
                setDispNum("6", numberFieldText);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "7";
                //numberFieldText.setText(displayNum);
                setDispNum("7", numberFieldText);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "8";
                //numberFieldText.setText(displayNum);
                setDispNum("8", numberFieldText);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "9";
                //numberFieldText.setText(displayNum);
                setDispNum("9", numberFieldText);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //displayNum = displayNum + "0";
                //numberFieldText.setText(displayNum);
                setDispNum("0", numberFieldText);
            }
        });

        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNum = "0";
                numberFieldText.setText(displayNum);
                numInputArray.clear();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeDispNum();
                operator = "+";
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeDispNum();
                operator = "-";
            }
        });

        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeDispNum();
                operator = "x";
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeDispNum();
                operator = "/";
            }
        });

        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check for valid decimal point placement
                String currentDispVal = displayNum;
                String newDispVal = displayNum + ".";
                try {
                    displayNum = newDispVal;
                    float num = Float.parseFloat(newDispVal);
                } catch (NumberFormatException ex) {
                    // revert to currentValue
                    displayNum = currentDispVal;
                }
                numberFieldText.setText(displayNum);
            }
        });

        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNum = computeOneNumInputResult("%") + "";
                numberFieldText.setText(displayNum);
            }
        });

        polarityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNum = computeOneNumInputResult("+/-") + "";
                numberFieldText.setText(displayNum);
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numInputArray.add(displayNum);
                displayNum = computeTwoNumInputResult() + "";
                numberFieldText.setText(displayNum);
            }
        });

    }

    /**
     * Compute the result of operating on one number
     * @param operator the operator to use
     * @return calcResult the computed result
     */
    private float computeOneNumInputResult(String operator) {
        float calcResult = 0;
        float num = Float.parseFloat(displayNum);

        switch (operator) {
            case "%":
                calcResult = num / 100;
                break;
            case "+/-":
                calcResult = num * -1;
                break;
            default:
                break;
        }

        return calcResult;
    }

    /**
     * Compute the result of operating on the two numbers
     * @return calcResult the computed result
     */
    private float computeTwoNumInputResult() {
        // get values from array
        float calcResult = 0;
        float num_1;
        float num_2;

        num_1 = Float.parseFloat((String) numInputArray.get(0));
        num_2 = Float.parseFloat((String) numInputArray.get(1));

        switch (operator) {
            case "+":
                calcResult = num_1 + num_2;
                break;
            case "-":
                calcResult = num_1 - num_2;
                break;
            case "x":
                calcResult = num_1 * num_2;
                break;
            case "/":
                calcResult = num_1 / num_2;
                break;
            default:
                break;
        }

        numInputArray.clear();

        return calcResult;
    }

    /**
     * store display Number in number array and reset the display string
     */
    private void storeDispNum() {
        if (displayNum != "") {
            numInputArray.add(displayNum);
            displayNum = "";
        }
    }

    /**
     * Update the display string
     */
    private void setDispNum(String newVal, EditText numberFieldText) {
        if (displayNum != "0") {
            displayNum = displayNum + newVal;
        } else {
            displayNum = newVal;
        }

        numberFieldText.setText(displayNum);
    }
}
