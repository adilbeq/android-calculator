package info.adilbek.secondcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private String operation;
    private double first = 0;
    private double second = 0;
    private boolean ini = false;
    private boolean inie = false;
    private int ss = 0;
    private boolean ol = false;
    private boolean comma = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
    }
    public void onClearPressed(View view){
        Button b = (Button)view;
        text.setText("0");
        first = 0;
        second = 0;
        operation = "";
        ini = false;
    }
    @SuppressLint("SetTextI18n")
    public void onPlusMinusPressed(View view){
        String temp = text.getText().toString();
        double tempsan = Double.parseDouble(temp);
        tempsan = tempsan * -1;
        String kazir = ""+tempsan;
        if (!ini){
            first = tempsan;
            tempsan = 0;
        }
        else {
            second = tempsan;
            tempsan = 0;
        }
        text.setText(kazir+"");
    }

    @SuppressLint("SetTextI18n")
    public void PercentPressed(View view){
        String result = text.getText().toString();
        float ans = Float.parseFloat(result) / 100;
        text.setText(ans + "");
    }

    public void ButtonPressed(View view){
        Button b = (Button)view;
        String current = text.getText().toString();
        if (current.equals("0")){
            current = "";
        }
        if(!ol){
            current="";
            second=0;
        }
        ol=true;
        String tapped = current + b.getText().toString();
        if (!ini){
            first = Integer.parseInt(tapped);
            text.setText("");
        }
        else{
            second = Integer.parseInt(tapped);
        }
        text.setText(tapped);
    }

    public void PlusPressed(View view){
        if(operation=="+"&&second>0){
            first = first + second;
        }
        if(operation=="-"&&second>0){
            first = first - second;
        }
        if(operation=="*"&&second>0){
            first = first * second;
        }
        if(operation=="/"&&second>0){
            first = first / second;
        }
        operation = "+";
        text.setText("");
        ol=true;
        ini = true;
    }
    public void MinusPressed(View view){
        if(operation=="+"&&second>0){
            first = first + second;
        }
        if(operation=="-"&&second>0){
            first = first - second;
        }
        if(operation=="*"&&second>0){
            first = first * second;
        }
        if(operation=="/"&&second>0){
            first = first / second;
        }
        operation = "-";
        text.setText("");
        ol=true;
        ini = true;
    }
    public void MultiplyPressed(View view){
        if(operation=="+"&&second>0){
            first = first + second;
        }
        if(operation=="-"&&second>0){
            first = first - second;
        }
        if(operation=="*"&&second>0){
            first = first * second;
        }
        if(operation=="/"&&second>0){
            first = first / second;
        }
        operation = "*";
        text.setText("");
        ol=true;
        ini = true;
    }
    public void DividePressed(View view){
        if(operation=="+"&&second>0){
            first = first + second;
        }
        if(operation=="-"&&second>0){
            first = first - second;
        }
        if(operation=="*"&&second>0){
            first = first * second;
        }
        if(operation=="/"&&second>0){
            first = first / second;
        }
        operation = "/";
        text.setText("");
        ol=true;
        ini = true;
    }
    public void onComma(View view){
        if (!comma){
            String cur = findViewById(R.id.text).toString();
            cur = cur + ".";
            text.setText(cur);
            comma = true;
        }
        else {
            if (inie) {
                first =  Double.parseDouble(findViewById(R.id.text).toString());
                inie = false;
            }
            else{
                first =  Double.parseDouble(findViewById(R.id.text).toString());
                inie = true;
            }

        }
    }
    public static int convert(double n){
        return (int)(n);
    } // not used yet

    @SuppressLint("SetTextI18n")
    public void EqualPressed(View view){
        switch (operation){
            case "+":
                first = first + second;
                if (first % 2 == 0){
                    int result = (int)first;
                    text.setText(""+result);
                }
                else {
                    text.setText(""+first);
                }
                ol=false;
                ini = false;
                second=0;
                operation="";
                comma = false;
                inie = false;
                break;
            case "-":
                first = first - second;
                text.setText(""+first);
                ol=false;
                ini = false;
                inie = false;
                second=0;
                comma = false;
                operation="";
                break;
            case "*":
                first = first * second;
                text.setText(""+first);
                ol=false;
                inie = false;
                ini = false;
                comma = false;
                second=0;
                operation="";
                break;
            case "/":
                if (second == 0){
                    text.setText("Ошибка");
                    break;
                } // needs fixes - crashes when checking it
                else{
                    inie = false;
                    first = first / second;
                    text.setText(""+first);
                    ol = false;
                    ini = false;
                    second=0;
                    operation="";
                    comma = false;
                    break;
                }
        }
    }
}
