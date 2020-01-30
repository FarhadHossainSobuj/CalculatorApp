package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btnSum, btnSub, btnMul, btnDiv, btnClear;
    private TextView tvMonitor;
    private String leftOp = "", rightOp = "";
    private String allValues = "";
    private int flag = 0;
    private String operator = "";
    private int leftOperand, rightOperand;
    private int num1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btnClear = findViewById(R.id.btnClear);
        btnSum = findViewById(R.id.btnSum);
        btnSub= findViewById(R.id.btnSub);

        tvMonitor = findViewById(R.id.tvMonitor);
    }

    public void btnClicked(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn0:
                btnPerform("0");
                break;
            case R.id.btn1:
                btnPerform("1");
                break;
            case R.id.btn2:
                btnPerform("2");
                break;
            case R.id.btn3:
                btnPerform("3");
                break;
            case R.id.btn4:
                btnPerform("4");
                break;
            case R.id.btn5:
                btnPerform("5");
                break;
            case R.id.btn6:
                btnPerform("6");
                break;
            case R.id.btn7:
                btnPerform("7");
                break;
            case R.id.btn8:
                btnPerform("8");
                break;
            case R.id.btn9:
                btnPerform("9");
                break;
            case R.id.btn00:
                btnPerform("00");
                break;
            case R.id.btnSum:
                operator = "+";
                tvMonitor.setText(leftOp + "\n" + operator);
                break;
            case R.id.btnSub:
                operator = "-";
                tvMonitor.setText(leftOp + "\n" + operator);
                break;
            case R.id.btnMul:
                operator = "X";
                tvMonitor.setText(leftOp + "\n" + operator);
                break;
            case R.id.btnDiv:
                operator = "/";
                tvMonitor.setText(leftOp + "\n" + operator);
                break;
            case R.id.btnEq:
                num1 = Integer.parseInt(leftOp);
                int num2 = Integer.parseInt(rightOp);
                switch (operator){
                    case "+":
                        tvMonitor.setText(num1 + " + " + num2 + "\n= " + (num1 + num2));
                        leftOp = ""+(num1 + num2);
                        rightOp = "";
                        operator = "";
                        break;
                    case "-":
                        tvMonitor.setText(num1 + " - " + num2 + "\n= " + (num1 - num2));
                        leftOp = ""+(num1 - num2);
                        rightOp = "";
                        operator = "";
                        break;
                    case "X":
                        tvMonitor.setText(num1 + " X " + num2 + "\n= " + (num1 * num2));
                        leftOp = ""+(num1 * num2);
                        rightOp = "";
                        operator = "";
                        break;
                    case "/":
                        try {
                            tvMonitor.setText(num1 + " / " + num2 + "\n= " + (num1 / num2));
                            leftOp = ""+(num1 / num2);
                            rightOp = "";
                            operator = "";
                        } catch (Exception e){
                            clearPerform();
                            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
                break;
            case R.id.btnClear:
                clearPerform();
                break;
        }
    }

    private void clearPerform() {
        leftOp = "";
        rightOp = "";
        tvMonitor.setText("0");
    }

    private void btnPerform(String num) {
        if (operator.equals("")){
            leftOp = leftOp + "" + num;
            tvMonitor.setText(leftOp);
        }
        else {
            rightOp = rightOp + "" + num;
            tvMonitor.setText(leftOp + "\n" + operator + "\n" + rightOp);
        }
    }
}
