package com.roger.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, bplus, bminus,
            bproduct, bdivide, bdot, bequal, bc, bclear;
    TextView t, tr;
    static final char ADD = '+';
    static final char MUL = '*';
    static final char DIV = '/';
    static final char SUB = '-';
    int flag = 0;
    static final char EQUAL = '=';
    char fun;
    String pattern = "###,###.###";
    DecimalFormat d = new DecimalFormat(pattern);
    double d1 = Double.NaN;
    double d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.num1);
        b2 = (Button) findViewById(R.id.num2);
        b3 = (Button) findViewById(R.id.num3);
        b4 = (Button) findViewById(R.id.num4);
        b5 = (Button) findViewById(R.id.num5);
        b6 = (Button) findViewById(R.id.num6);
        b7 = (Button) findViewById(R.id.num7);
        b8 = (Button) findViewById(R.id.num8);
        b9 = (Button) findViewById(R.id.num9);
        b10 = (Button) findViewById(R.id.num0);
        bplus = (Button) findViewById(R.id.plus);
        bminus = (Button) findViewById(R.id.minus);
        bproduct = (Button) findViewById(R.id.product);
        bdivide = (Button) findViewById(R.id.divide);
        bdot = (Button) findViewById(R.id.dot);
        bclear = (Button) findViewById(R.id.clear);
        bequal = (Button) findViewById(R.id.equal);
        t = (TextView) findViewById(R.id.textInput);
        tr = (TextView) findViewById(R.id.result);
        bc = (Button) findViewById(R.id.backspace);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "9");
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText().toString() + "0");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText(t.getText() + ".");
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tr.setText(null);
                t.setText(null);
                d1 = Double.NaN;
                d2 = Double.NaN;
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.length() > 0) {
                    CharSequence name = t.getText().toString();
                    t.setText(name.subSequence(0, name.length() - 1));
                    d1 = Double.NaN;
                    d2 = Double.NaN;
                } else if (t.length() == 0) {
                    if (tr.length() > 0) {
                        String i = tr.getText().toString();
                        tr.setText(null);
                        t.setText(i);
                        d1 = Double.NaN;
                        d2 = Double.NaN;
                    }
                } else {
                    t.setText(null);
                    tr.setText(null);
                    d1 = Double.NaN;
                    d2 = Double.NaN;
                }
            }
        });
        bproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.getText() == null && tr.getText() == null) {
                    t.setText(null);
                    tr.setText(null);
                    return;
                } else {
                    try {
                        function();
                        fun = MUL;
                        t.setText(null);
                        tr.setText(d.format(d1) + "*");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.getText() == null && tr.getText() == null) {
                    t.setText(null);
                    tr.setText(null);
                    return;
                } else {
                    try {
                        function();
                        fun = ADD;
                        t.setText(null);
                        tr.setText(d.format(d1) + "+");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.getText() == null && tr.getText() == null) {
                    t.setText(null);
                    tr.setText(null);
                    return;
                } else {
                    try {
                        function();
                        fun = SUB;
                        t.setText(null);
                        tr.setText(d.format(d1) + "-");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.getText() == null && tr.getText() == null) {
                    t.setText(null);
                    tr.setText(null);
                    return;
                } else {
                    try {
                        function();
                        fun = DIV;
                        t.setText(null);
                        tr.setText(d.format(d1) + "/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    function();
                    fun = EQUAL;
                    if (flag == 0) {
                        String s = tr.getText().toString();
                        tr.setText(s + t.getText());
                        t.setText(null);
                        t.setText(d.format(d1));

                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void function() {
        if (!Double.isNaN(d1)) {
            d2 = Double.parseDouble(t.getText().toString());
            switch (fun) {
                case ADD:
                    d1 = d1 + d2;
                    flag = 0;
                    break;
                case DIV:
                    try {
                        d1 = d1 / d2;
                        flag = 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case MUL:
                    d1 = d1 * d2;
                    if(d1==-0){
                        d1=0;
                    }
                    flag = 0;
                    break;
                case SUB:
                    d1 = d1 - d2;
                    flag = 0;
                    break;
                case EQUAL:
                    flag++;
                    break;
            }
        } else {
            try {
                d1 = Double.parseDouble(t.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}