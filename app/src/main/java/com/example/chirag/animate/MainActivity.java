package com.example.chirag.animate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.Random;

public class MainActivity extends Activity implements OnClickListener{

    ImageView img = null,imgDice=null;
    Button btnUp = null,btnDwn = null,btnLeft = null,btnRight = null,btnRoll = null;
    TextView lblDiceNo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=(ImageView)findViewById(R.id.img1);
        img.setOnClickListener(this);
        btnUp = (Button)findViewById(R.id.btnUp);
        btnUp.setOnClickListener(this);
        btnDwn = (Button)findViewById(R.id.btnDwn);
        btnDwn.setOnClickListener(this);
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(this);
        btnRight = (Button)findViewById(R.id.btnRight);
        btnRight.setOnClickListener(this);
        btnRoll = (Button)findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(this);
        imgDice = (ImageView)findViewById(R.id.imgDice);
        lblDiceNo = (TextView) findViewById(R.id.lblDiceNo);
        imgDice.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this,"methodInvoked",Toast.LENGTH_LONG).show();
        //img.animate().translationY(-100);
        //img.setX(img.getX()-100);
        if (v.getId() == R.id.btnUp)
            img.setY(img.getY() - 10);
        if (v.getId() == R.id.btnDwn)
            img.setY(img.getY() + 10);
        if (v.getId() == R.id.btnLeft)
            img.setX(img.getX() - 10);
        if (v.getId() == R.id.btnRight)
            img.setX(img.getX() + 10);
        if (v.getId() == R.id.img1){
            Toast.makeText(MainActivity.this,"Image clicked",Toast.LENGTH_LONG).show();
            img.animate().//translationX(10).//translationY(-200f).
                    rotationY(360f).setDuration(5000);
        }
        if (
                (v.getId() == R.id.btnRoll)
                        ||
                (v.getId() == R.id.imgDice)
            ) {
                Random rnd = new Random();
                int rndId = rnd.nextInt(6) + 1;
                String imgName = "d" + rndId;
                int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
                lblDiceNo.setText(imgName.substring(1));
                imgDice.setImageResource(id);
        }
    }
}
