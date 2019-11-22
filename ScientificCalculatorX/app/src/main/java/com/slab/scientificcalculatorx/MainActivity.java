package com.slab.scientificcalculatorx;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    CalcIO calculator = new CalcIO();
    MessagesAndStrings msg = new MessagesAndStrings();
    SharedPreferences preferencesTheme;



    Button btn0,btn1, btn2, btn3, btn4 ,btn5, btn6,btn7,btn8,btn9,
            btnMul,btnC, btnDiv,btnPa, btnPb,btnPlus, btnSub, btnEqu,
            btnSin, btnCos, btnTan, btnDot, btnPow, btnRoot, btnFact,
            btnLn, btnLog, btnNCR, btnNPR;
    TextView calcView, invView, ansView;
    public boolean operatorFlag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencesTheme = getApplicationContext().getSharedPreferences(msg.preferenceTheme, MODE_PRIVATE);
        setViews();
        ///////////////////////////////


        calcView.setOnLongClickListener(
               new TextView.OnLongClickListener(){

                   @Override
                   public boolean onLongClick(View v) {
                       AlertDialog.Builder saveDialog = new AlertDialog.Builder(MainActivity.this);
                       saveDialog.setTitle("Save Answer?");
                       saveDialog.setMessage("yes it works");
                       saveDialog.show();
                       return true;
                   }
               }

        );

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("1", "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("2", "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("3", "3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("4", "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("5", "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("6", "6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("7", "7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("8", "8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("9", "9");

            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("0", "0");

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("+", " + ");


            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("-", " - ");

            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("x", " * ");


            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("÷", " / ");


            }
        });
        btnPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("(", " ( ");


            }
        });
        btnPb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(")", " ) ");


            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SharedPreferences sp =getApplicationContext().getSharedPreferences(msg.preference, MODE_PRIVATE);
                calcView.setText(sp.getString(msg.lastAnswer, null));

            }
        });
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("^", " ^ ");
            }
        });
//        btnRoot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                int i = invView.getText().length();
////                if (invView.getText().charAt(i)==' '){
////                    setNumber("√", "0 √ ");
////                }
//                setNumber("√", "0 √ ");
//            }
//        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText("");
                invView.setText("");
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               setNumber("sin", "0 sin ");
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("cos", "0 cos ");
            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("tan", "0 tan ");
            }
        });
        btnNCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("C", " C ");
            }
        });
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("!", "0 ! ");
            }
        });
        btnNPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber("P", " P ");
            }
        });
        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcView.setText(calculator.processInput((String) invView.getText()));
                invView.setText(calcView.getText());
                SharedPreferences preferences = getApplicationContext().getSharedPreferences(msg.preference, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(msg.lastAnswer, (String) calcView.getText());
                editor.apply();

            }
        });


     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle("Exit?");
        exitDialog.setMessage(msg.EXIT_MESSAGE);
        exitDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();

            }
        });
        exitDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }

        });
        exitDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("About");
                builder.setMessage(msg.about);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                builder.show();
                return true;
            case R.id.action_settings:
                Class settingsClass = null;
                try {
                    settingsClass = Class.forName("com.slab.scientificcalculatorx.Settings");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this,settingsClass );
                        startActivity(intent);
                return  true;
        }




        return super.onOptionsItemSelected(item);
    }
    public void setViews(){
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btnMul = (Button)findViewById(R.id.buttonMul);
        btnDiv = (Button)findViewById(R.id.buttonDiv);
        btnC = (Button)findViewById(R.id.buttonAC);
        btnPa = (Button)findViewById(R.id.Pa);
        btnPb = (Button)findViewById(R.id.buttonPb);
        btnPlus = (Button)findViewById(R.id.buttonPlus);
        btnSub = (Button)findViewById(R.id.buttonMinus);
        btnEqu = (Button)findViewById(R.id.buttonequ);
        btn0 = (Button)findViewById(R.id.buttonZero);
        btnDot = (Button)findViewById(R.id.buttonDot);
        btnPow = (Button)findViewById(R.id.buttonPow);
        btnLog = (Button)findViewById(R.id.buttonLog);
        btnLn = (Button)findViewById(R.id.buttonLn);
        btnFact = (Button)findViewById(R.id.buttonFact);
//        btnRoot = (Button)findViewById(R.id.buttonRoot);
        calcView = (TextView)findViewById(R.id.calcView);


        invView = (TextView)findViewById(R.id.mainView);
        btnTan = (Button) findViewById(R.id.buttonTan);
        btnSin = (Button) findViewById(R.id.buttonSin);
        btnCos = (Button) findViewById(R.id.buttonCos);
        btnNCR = (Button) findViewById(R.id.buttonNCR);
        btnNPR = (Button) findViewById(R.id.buttonNPR);

    }
    public void setNumber(String num, String hiddenNum){
        calcView.setText(calcView.getText()+ num);
        invView.setText(invView.getText()+ hiddenNum);


    }

    public void setNumberAndOperatorV2(String num, String hiddenNum){
    int i = invView.getText().length();
        if (invView.getText().charAt(i) != ' '){
            calcView.setText(calcView.getText()+ num);
            invView.setText(invView.getText()+" *"+ hiddenNum);
        }else{
            calcView.setText(calcView.getText()+ num);
            invView.setText(invView.getText()+"0"+ hiddenNum);
        }

    }

    @Override
    public void onClick(View v) {



    }




}
