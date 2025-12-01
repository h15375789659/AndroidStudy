package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConstraintCalculatorActivity extends AppCompatActivity {
    private TextView displayField;
    private String currentValue = "";
    private String operator = "";
    private double firstValue = 0.0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_calculator);
        
        displayField = findViewById(R.id.displayField);
        
        setupNumberButton(R.id.btn0, "0");
        setupNumberButton(R.id.btn1, "1");
        setupNumberButton(R.id.btn2, "2");
        setupNumberButton(R.id.btn3, "3");
        setupNumberButton(R.id.btn4, "4");
        setupNumberButton(R.id.btn5, "5");
        setupNumberButton(R.id.btn6, "6");
        setupNumberButton(R.id.btn7, "7");
        setupNumberButton(R.id.btn8, "8");
        setupNumberButton(R.id.btn9, "9");
        setupNumberButton(R.id.btnDot, ".");
        
        setupOperatorButton(R.id.btnPlus, "+");
        setupOperatorButton(R.id.btnMinus, "-");
        setupOperatorButton(R.id.btnMultiply, "*");
        setupOperatorButton(R.id.btnDivide, "/");
        
        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }
    
    private void setupNumberButton(int buttonId, final String number) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue += number;
                displayField.setText(currentValue);
            }
        });
    }
    
    private void setupOperatorButton(int buttonId, final String op) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentValue.isEmpty()) {
                    try {
                        firstValue = Double.parseDouble(currentValue);
                        operator = op;
                        currentValue = "";
                    } catch (NumberFormatException e) {
                        displayField.setText("错误");
                    }
                }
            }
        });
    }
    
    private void calculate() {
        if (currentValue.isEmpty()) return;
        
        try {
            double secondValue = Double.parseDouble(currentValue);
            double result = 0;
            
            switch (operator) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "*":
                    result = firstValue * secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result = firstValue / secondValue;
                    } else {
                        displayField.setText("除数不能为0");
                        return;
                    }
                    break;
                default:
                    result = secondValue;
                    break;
            }
            
            displayField.setText(String.valueOf(result));
            currentValue = String.valueOf(result);
            operator = "";
        } catch (NumberFormatException e) {
            displayField.setText("错误");
        }
    }
}
