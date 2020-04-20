package hcmute.edu.vn.calculator_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.DoubleBuffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnZero, btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnPoint,btnClear;

    private TextView txtMainCal, txtLog;
    private String sign;
    private BigDecimal rs;
    private boolean newNumber;
    private boolean formated;
    private String txtNumber;
    private boolean calculated;
    DecimalFormatSymbols symbols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButton();
        clear();
        symbols = new DecimalFormatSymbols(Locale.ENGLISH);
    }

    private void setupButton()
    {
        btnZero =(Button) findViewById(R.id.btn0);
        btnOne =(Button) findViewById(R.id.btn1);
        btnTwo =(Button) findViewById(R.id.btn2);
        btnThree =(Button) findViewById(R.id.btn3);
        btnFour =(Button) findViewById(R.id.btn4);
        btnFive =(Button) findViewById(R.id.btn5);
        btnSix =(Button) findViewById(R.id.btn6);
        btnSeven =(Button) findViewById(R.id.btn7);
        btnEight =(Button) findViewById(R.id.btn8);
        btnNine =(Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub =(Button) findViewById(R.id.btnSub);
        btnMul =(Button) findViewById(R.id.btnMul);
        btnDiv =(Button) findViewById(R.id.btnDiv);
        btnEqual =(Button) findViewById(R.id.btnEqual);
        btnPoint =(Button) findViewById(R.id.btnPoint);
        btnClear =(Button) findViewById(R.id.btnClear);
        txtMainCal =(TextView) findViewById(R.id.txtMainCal);
//        txtLog =(TextView) findViewById(R.id.txtLog);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    public void setError()
    {
        clear();
        txtMainCal.setText("Overflow");
    }
    public void clear()
    {
        txtMainCal.setText("");
        sign = "";
        newNumber = true;
        rs = new BigDecimal("0");
        formated = false;
        txtNumber ="";
        calculated = false;
    }
    public void equal()
    {
        if(!txtNumber.equals(""))
        {
            if(sign.equals("") && !formated)
            {
                rs = getNumber();
            }
            else
            {
                calculate();
            }
            setResult();
        }
        newNumber = true;
        sign = "";
    }
    public void setResult()
    {
        //if(BigDecimal.(rs))
//        {
//            setError();
//            return;
//        }
        String temp = new DecimalFormat("##.##########",symbols).format(rs);
        txtNumber = temp;
        if(temp.contains("."))
        {
            if(temp.indexOf('.')>7)
                temp = format(rs, temp.indexOf('.'));
            else if(temp.length()>9)
            {
                int x = temp.indexOf('.');
                x = 8 - x;
                String pattern = "##.";
                for(int i = 0;i < x;i++)
                    pattern = pattern + "#";
                temp = new DecimalFormat(pattern,symbols).format(rs);
            }
        }
        else if( temp.length() > 8)
        {
            temp = format(rs, temp.length());
        }
        txtMainCal.setText(temp);
        formated = true;
    }
    public String format(BigDecimal rs, int length)
    {
        rs = rs.divide(new BigDecimal(pow(10,length-1)),20, RoundingMode.CEILING);
        String temp = new DecimalFormat("#.#######",symbols).format(rs);
        if( temp.equals("10"))
        {
            return "1e" + String.valueOf(length);
        }
        temp =temp+ "e"+ String.valueOf(length-1);
        return temp;
    }

    public BigDecimal getNumber()
    {
        if(txtNumber.contains("."))
        {
            txtNumber = "0" + txtNumber + "0";
        }
        return new BigDecimal(txtNumber);
    }
    public void calculate()
    {
        BigDecimal temp = getNumber();
        if (sign.equals("+"))
        {
            rs = rs.add(temp);
        }
        else if (sign.equals("-"))
        {
            rs = rs.subtract(temp);
        }
        else if (sign.equals("*"))
        {
            rs = rs.multiply(temp);
        }
        else if (sign.equals("/"))
        {
            rs = rs.divide(temp,20, RoundingMode.CEILING);
        }

    }
    public void setupCalculate(String sign)
    {
        if(!txtMainCal.getText().equals(""))
        {
            newNumber = true;
            this.sign = sign;
        }
    }
    public void inputNumber(String number)
    {
        if(newNumber)
        {
            txtMainCal.setText(number);
            txtNumber = number;
            newNumber = false;
        }
        else
        {
            if(number.equals(".") && txtNumber.contains("."))
                return;
            txtNumber = txtNumber + number;
            txtMainCal.setText(txtNumber);
        }
        formated = false;
        calculated = false;
    }
    @Override
    public void onClick(View v)
    {
        Button btn = (Button)v;
        String txt = btn.getText().toString().trim();
        if(txt.equals("C"))
        {
            clear();
        }
        else if(txt.equals("="))
        {
            equal();
        }
        else if(txt.equals("+") || txt.equals("-") || txt.equals("*") || txt.equals("/"))
        {
            if(!calculated)
            {
                equal();
                calculated = true;
            }
            setupCalculate(txt);
        }
        else
            inputNumber(txt);
    }
}
