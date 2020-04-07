package hcmute.edu.vn.calculator_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnZero, btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
    private Button btnAdd,btnSub,btnMul,btnDiv,btnEqual;
    private Button btnPoint,btnReset;
    private TextView txtMainCal;
    private String sign ;

    private  double val1;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButton();
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
        btnReset.setOnClickListener(this);

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
        btnReset =(Button) findViewById(R.id.btnReset);
        txtMainCal =(TextView) findViewById(R.id.txtMainCal);
    }
    private void setupButtonPoint()
    {
        String s = txtMainCal.getText().toString();
        if(s.contains(".")){
            btnPoint.setEnabled(false);
        }
        else
            btnPoint.setEnabled(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                txtMainCal.setText(txtMainCal.getText().toString()+"0");
                break;
            case R.id.btn1:
                txtMainCal.setText(txtMainCal.getText().toString()+"1");
                break;
            case R.id.btn2:
                txtMainCal.setText(txtMainCal.getText().toString()+"2");
                break;
            case R.id.btn3:
                txtMainCal.setText(txtMainCal.getText().toString()+"3");
                break;
            case R.id.btn4:
                txtMainCal.setText(txtMainCal.getText().toString()+"4");
                break;
            case R.id.btn5:
                txtMainCal.setText(txtMainCal.getText().toString()+"5");
                break;
            case R.id.btn6:
                txtMainCal.setText(txtMainCal.getText().toString()+"6");
                break;
            case R.id.btn7:
                txtMainCal.setText(txtMainCal.getText().toString()+"7");
                break;
            case R.id.btn8:
                txtMainCal.setText(txtMainCal.getText().toString()+"8");
                break;
            case R.id.btn9:
                txtMainCal.setText(txtMainCal.getText().toString()+"9");
                break;
            case R.id.btnPoint:
                if(txtMainCal.getText().toString()=="")
                    txtMainCal.setText(txtMainCal.getText().toString() +"0.");
                else
                    txtMainCal.setText(txtMainCal.getText().toString() +".");
                setupButtonPoint();
                break;
            case R.id.btnAdd:
                sign="+";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
                setupButtonPoint();
                break;
            case R.id.btnSub:
                sign="-";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
                setupButtonPoint();
                break;
            case R.id.btnMul:
                sign="*";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
                setupButtonPoint();
                break;
            case R.id.btnDiv:
                sign="/";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
                setupButtonPoint();
                break;
            case R.id.btnEqual:
                val2=Double.parseDouble(txtMainCal.getText().toString());
                if (sign == "+")
                {
                    val1 = val1 + val2;
                    txtMainCal.setText(String.valueOf(val1));
                }
                else if (sign == "-")
                {
                    val1 = val1 - val2;
                    txtMainCal.setText(String.valueOf(val1));
                }
                else if (sign == "*")
                {
                    val1 = val1 * val2;
                    txtMainCal.setText(String.valueOf(val1));
                }
                else
                {
                    if(val2==0)
                        Toast.makeText(MainActivity.this, "Can not divide by Zero",Toast.LENGTH_SHORT).show();
                    else {
                        val1 = val1 / val2;
                        txtMainCal.setText(String.valueOf(val1));
                    }
                }
                break;
            case R.id.btnReset:
                val1=0;
                val2=0;
                txtMainCal.setText("");
                setupButtonPoint();
                break;
        }
    }
}
