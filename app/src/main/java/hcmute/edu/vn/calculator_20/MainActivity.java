package hcmute.edu.vn.calculator_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.DoubleBuffer;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnZero, btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnPoint,btnClear;

    private TextView txtMainCal, txtLog;
    private String sign;
    private boolean flagEquals;
    private boolean flagPoint;

    private  double num1;
    private double num2;
    private double rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButton();
        initValue();
    }

    private void initValue() {
        num1 = Double.NaN;
        num2= Double.NaN;
        rs= Double.NaN;
        flagEquals =false;
        flagPoint =false;
        sign="";
        txtMainCal.setText("");
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
    @Override
    public void onClick(View v) {
        Button btn = (Button)v;
        if (btn.getText().equals("=")){
            if (sign.equals("")){
                rs = Double.parseDouble(txtMainCal.getText().toString().trim());
            }else {
                num2 = Double.parseDouble(txtMainCal.getText().toString().trim());
                if (sign.equals("+")){
                    rs = num1+num2;
                }else
                if (sign.equals("-")){
                    rs = num1-num2;
                }else
                if (sign.equals("*")){
                    rs = num1*num2;
                }else
                if (sign.equals("/")){
                    rs = num1/num2;
                }

            }
            txtMainCal.setText(new DecimalFormat("##.###").format(rs));
            sign="";
            flagEquals = true;
        }else
        if (btn.getText().equals(".")) {
            if (!txtMainCal.getText().toString().contains(".")){
                if (flagEquals)
                    initValue();
                txtMainCal.setText(txtMainCal.getText()+btn.getText().toString().trim());
            }
        }else
        if (btn.getText().equals("C")){
            initValue();
        }else
        if (btn.getText().equals("+")||
                btn.getText().equals("-")||
                btn.getText().equals("*")||
                btn.getText().equals("/")){
            if (flagEquals){
                num1 = rs;
                num2 = Double.NaN;
                rs = Double.NaN;
                sign = btn.getText().toString().trim();
                txtMainCal.setText("");
                flagEquals = false;
            }else
                if (txtMainCal.getText() !=""){
                    if (sign == ""){
                    num1 = Double.parseDouble(txtMainCal.getText().toString().trim());
                    num2 = Double.NaN;
                    sign = btn.getText().toString().trim();
                    txtMainCal.setText("");
                    }else{
                        btnEqual.performClick();
                        sign = btn.getText().toString().trim();
                    }
                }
                else
                    if(num1 != Double.NaN){
                        sign = btn.getText().toString().trim();
                    }
        }
        else{
            if (flagEquals)
                initValue();
            txtMainCal.setText(txtMainCal.getText()+btn.getText().toString().trim());
        } /////// number
    }
}
