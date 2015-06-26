package com.lemonickous.scicalc;


import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math.*;

public class CalcMain extends Activity {

    private TextView calcDisp;
    private TextView debugDisp;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button but0;
    private Button clr;
    private Button butDecimal;
    private Button butEquals;
    private Button butPlus;
    private Button butMinus;
    private Button butMultiply;
    private Button butDivide;

    // private double num1_d = 0, num2_d = 0, soln_d = 0;
    private static double num1 = 0, num2 = 0, soln = 0;
    private static int digit = 11, operation, isDecimal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_main);

        calcDisp = (TextView) findViewById(R.id.textView);
        debugDisp = (TextView) findViewById(R.id.debugText);
        clr = (Button) findViewById(R.id.clear);
        but1 = (Button) findViewById(R.id.button1);
        but2 = (Button) findViewById(R.id.button2);
        but3 = (Button) findViewById(R.id.button3);
        but4 = (Button) findViewById(R.id.button4);
        but5 = (Button) findViewById(R.id.button5);
        but6 = (Button) findViewById(R.id.button6);
        but7 = (Button) findViewById(R.id.button7);
        but8 = (Button) findViewById(R.id.button8);
        but9 = (Button) findViewById(R.id.button9);
        but0 = (Button) findViewById(R.id.button0);
        butDecimal = (Button) findViewById(R.id.buttonDecimal);
        butEquals = (Button) findViewById(R.id.buttonEquals);
        butPlus = (Button) findViewById(R.id.buttonPlus);
        butMinus = (Button) findViewById(R.id.buttonMinus);
        butMultiply = (Button) findViewById(R.id.buttonMultiply);
        butDivide = (Button) findViewById(R.id.buttonDivide);

        calcDisp.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* The main logic for calc app for pocket calculator style operation */
    // Get input (define style as pocket)

    // if digit, append

    // if operator, check if expecting operator

    // if expecting operator, bump num1 to num2 and proceed

    // default operation: set int operation as respective operator

    // wait for next input

    // Method for setting the number based on input digit
    public void setNum(View v) {
        if (num2 == 0) {
            calcDisp.setText("");
            num1 = 1;
        }
        switch (v.getId()) {
            case R.id.button0:
                digit = 0;
                break;
            case R.id.button1:
                digit = 1;
                break;
            case R.id.button2:
                digit = 2;
                break;
            case R.id.button3:
                digit = 3;
                break;
            case R.id.button4:
                digit = 4;
                break;
            case R.id.button5:
                digit = 5;
                break;
            case R.id.button6:
                digit = 6;
                break;
            case R.id.button7:
                digit = 7;
                break;
            case R.id.button8:
                digit = 8;
                break;
            case R.id.button9:
                digit = 9;
                break;
        }

        calcDisp.append(String.valueOf(digit));

        if (isDecimal == 0) {
            num1 = num1 * 10 + digit;
            debugDisp.setText("num1: " + String.valueOf(num1) + "_num2: " + String.valueOf(num2));
        } else {
            num1 = num1 + ((float) digit / isDecimal);
            debugDisp.setText("dig: " + String.valueOf((float) digit / isDecimal) + "_num1: " + String.valueOf(num1));
            isDecimal = isDecimal * 10;
        }

    }

    public void setDecimal(View v) {
        if (isDecimal == 0) {
            calcDisp.append(".");
            isDecimal = 10;
        }
    }

    public void setOperation(View v) {
        if (operation == 0 && num2 == 0) {

            switch (v.getId()) {
                case R.id.buttonPlus:
                    calcDisp.append("+");
                    operation = 1;
                    break;
                case R.id.buttonMinus:
                    calcDisp.append("-");
                    operation = 2;
                    break;
                case R.id.buttonMultiply:
                    calcDisp.append("x");
                    operation = 3;
                    break;
                case R.id.buttonDivide:
                    calcDisp.append("/");
                    operation = 4;
                    break;
                case R.id.buttonSquare:
                    calcDisp.append("^2");
                    operation = 5;
                    break;
                case R.id.buttonCube:
                    calcDisp.append("^3");
                    operation = 6;
                    break;
                case R.id.buttonPower:
                    calcDisp.append("^");
                    operation = 7;
                    break;
                case R.id.buttonInverse:
                    calcDisp.append("^(-1)");
                    operation = 8;
                    break;
                case R.id.buttonSqrt:
                    calcDisp.append("?");
                    operation = 9;
                    break;
                case R.id.buttonCubert:
                    calcDisp.append("3?");
                    operation = 10;
                    break;
                case R.id.buttonLog10:
                    calcDisp.append("log10(");
                    operation = 11;
                    break;
                case R.id.buttonLoge:
                    calcDisp.append("ln(");
                    operation = 12;
                    break;
                case R.id.buttonFactorial:
                    calcDisp.append("!");
                    operation = 13;
                    break;
                case R.id.buttonnPr:
                    calcDisp.append("P");
                    operation = 14;
                    break;
                case R.id.buttonnCr:
                    calcDisp.append("C");
                    operation = 15;
                    break;
                case R.id.buttonPercent:
                    calcDisp.append("%");
                    operation = 16;
                    solveIt(null);
                    break;
            }
            num2 = num1;
            num1 = 0;
            isDecimal = 0;
            debugDisp.setText("num1: " + String.valueOf(num1) + "_num2: " + String.valueOf(num2) + " operation: " + operation);
        } else if (operation != 0 && num2 != 0) {
            solveIt(null);
            setOperation(v);
        }
    }

    public void solveIt(View v) {
        debugDisp.setText("Operation: " + operation);
        switch (operation) {
            case 1:
                soln = num1 + num2;
                break;
            case 2:
                soln = num2 - num1;
                break;
            case 3:
                soln = num1 * num2;
                break;
            case 4:
                soln = num2 / num1;
                break;
            case 5:
                soln = java.lang.Math.pow(num2, 2);
                break;
            case 6:
                soln = java.lang.Math.pow(num2, 3);
                break;
            case 7:
                soln = java.lang.Math.pow(num2, num1);
                break;
            case 8:
                soln = 1 / num2;
                break;
            case 9:
                if (num2 == 0) {
                    soln = java.lang.Math.sqrt(num1);
                } else {
                    soln = java.lang.Math.sqrt(num2);
                }
                break;
            case 10:
                if (num2 == 0) {
                    soln = java.lang.Math.cbrt(num1);
                } else {
                    soln = java.lang.Math.cbrt(num2);
                }
                break;
            case 11:
                soln = java.lang.Math.log10(num2);
                break;
            case 12:
                soln = java.lang.Math.log(num2);
                break;
            case 13:
                soln = factorial(num2);
                break;
            case 14:
                soln = npr(num2, num1);
                break;
            case 15:
                soln = ncr(num2, num1);
                break;
            case 16:
                soln = num1 / 100;
                break;
        }
        updateDisplay(soln);
        num1 = soln;
        num2 = 0;
        isDecimal = 0;
        operation = 0;
    }

    private void updateDisplay(double num) {
        if (num % 1 > 0) {
            debugDisp.setText("isFloat");
            calcDisp.setText(String.valueOf(num));
        } else {
            debugDisp.setText("isInt");
            calcDisp.setText(String.valueOf((int) num));
        }
    }

    public void clear(View v) {
        num1 = 0;
        num2 = 0;
        digit = 11;
        operation = 0;
        isDecimal = 0;
        calcDisp.setText("");
    }

    public double factorial(double num_in) {
        double num_out = 1;

        for (int i = 2; i <= num_in; i++) {
            num_out = num_out * i;
        }

        return num_out;
    }

    public double npr(double n1, double n2) {
        double n_out = 1;
        for(int j = (int)(n1-n2); j <= n1; j++){
            n_out = n_out * j;
        }
        return n_out;
    }

    public double ncr(double n1, double n2) {
        double n_out, temp;
        n_out = npr(n1, n2);
        temp = factorial(n2);
        n_out = n_out / temp;
        return n_out;
    }
}

/*
    DONE:
    . Basic arithmetic
    . power functions
    TODO:
    . combinatorial functions (incomplete)
    . Activity Lifecycle Handles
    . Error handling
        . portrait and landscape mode GUI change handling
        . Float <-> fixed point conversion errors
    . Trigonometery functions
    . Extras: switch deg to rad; switch base (dec, oct, bin, etc); add mode button
    . GUI update
    . Menu update, with button to change from on the fly computation to editable computation
    . Implement Shunting Yard algo to convert string to RPM and solver to solve the RPN
    . longer expressions with parentheses available
    . arrow keys for navigation and editing
    . equation solving (multivariable, higher degree)
    . Statistical analysis
    . Graphing
    . Functions, Complex, Calculus
    . Basic conversions (currency, weight, temperature, length, pressure, etc)
    . Matrices and Linear algebra functions

 */