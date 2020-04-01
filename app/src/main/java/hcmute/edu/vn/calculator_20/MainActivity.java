package hcmute.edu.vn.calculator_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString()+"9");
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMainCal.setText(txtMainCal.getText().toString() +".");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign="+";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign="-";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign="*";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign="/";
                val1 = Double.parseDouble(txtMainCal.getText().toString());
                txtMainCal.setText("");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVal2();

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
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=0;
                val2=0;
                txtMainCal.setText("");
            }
        });
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
    private  void setVal2(){
        String s=txtMainCal.getText().toString();
        if(s==".")
            val2=0;
        else
            val2=Double.parseDouble(s);
    }
}
