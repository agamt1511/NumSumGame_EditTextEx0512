package com.example.numsumgame_edittextex0512;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    EditText et1, et2, et3;
    ImageView iv1, iv2, iv3;
    Button btn1, btn2, btn3;

    Random rnd;
    int hagrla1;
    int hagrla2;
    int sum;
    int uAnswer;
    String st1;
    int wins;
    int percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        btn1 = (Button) findViewById(R.id.btn1);

        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        et2 = (EditText) findViewById(R.id.et2);
        iv2 = (ImageView) findViewById(R.id.iv2);
        btn2 = (Button) findViewById(R.id.btn2);

        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        et3 = (EditText) findViewById(R.id.et3);
        iv3 = (ImageView) findViewById(R.id.iv3);
        btn3 = (Button) findViewById(R.id.btn3);

        rnd = new Random();
        restart();
    }

    private void restart() {
        hagrla1 = rnd.nextInt(90) + 10;
        hagrla2 = rnd.nextInt(90) + 10;

        tv1.setText(""+hagrla1);
        tv2.setText(""+hagrla2);

        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        wins = 0;
        sum = 0;

    }

    public void checking1(View view) {
        sum = hagrla1 + hagrla2;

        if (TextUtils.isEmpty(et1.getText().toString())) {
            iv1.setImageResource(R.drawable.axs);
        }
        else {
            st1 = et1.getText().toString();
            uAnswer = Integer.parseInt(st1);

            if (sum == uAnswer) {
                iv1.setImageResource(R.drawable.vi);
                wins +=1;
            }
            else {
                iv1.setImageResource(R.drawable.axs);
            }
        }

        et1.setEnabled(false);
        btn1.setEnabled(false);
        tv3.setText(""+sum);
        hagrla1 = rnd.nextInt(90) + 10;
        tv4.setText(""+hagrla1);
        btn2.setVisibility(View.VISIBLE);
        et2.setVisibility(View.VISIBLE);
    }

    public void checking2(View view) {
        sum = hagrla1 + sum;

        if (TextUtils.isEmpty(et2.getText().toString())){
            iv2.setImageResource(R.drawable.axs);
        }
        else {
            st1 = et2.getText().toString();
            uAnswer = Integer.parseInt(st1);

            if (sum == uAnswer) {
                iv2.setImageResource(R.drawable.vi);
                wins +=1;
            }
            else {
                iv2.setImageResource(R.drawable.axs);
            }
        }
        et2.setEnabled(false);
        btn2.setEnabled(false);
        tv5.setText(""+sum);
        hagrla1 = rnd.nextInt(90) + 10;
        tv6.setText(""+hagrla1);
        btn3.setVisibility(View.VISIBLE);
        et3.setVisibility(View.VISIBLE);
    }

    public void checking3(View view) {
        sum = hagrla1 + sum;

        if (TextUtils.isEmpty(et3.getText().toString())){
            iv3.setImageResource(R.drawable.axs);
        }
        else {
            st1 = et3.getText().toString();
            uAnswer = Integer.parseInt(st1);

            if (sum == uAnswer) {
                iv3.setImageResource(R.drawable.vi);
                wins +=1;
            }
            else {
                iv3.setImageResource(R.drawable.axs);
            }
        }
        et3.setEnabled(false);
        btn3.setEnabled(false);
        percent =(int) (100/3)*wins;
        if (wins == 3){
            percent = 100;
        }
        makeText(this, "" + percent +"%" + "       " +" 3/"+ wins, Toast.LENGTH_SHORT).show();

    }

    public void fornewgame(View view) {
        iv1.setImageResource(R.drawable.whitebackground);
        iv2.setImageResource(R.drawable.whitebackground);
        iv3.setImageResource(R.drawable.whitebackground);

        hagrla1 = rnd.nextInt(90) + 10;
        hagrla2 = rnd.nextInt(90) + 10;
        tv1.setText(""+hagrla1);
        tv2.setText(""+hagrla2);

        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");

        et1.setEnabled(true);
        et2.setEnabled(true);
        et3.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);

        et1.setText("");
        et2.setText("");
        et3.setText("");

        restart();
    }
}