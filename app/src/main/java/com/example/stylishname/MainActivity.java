package com.example.stylishname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    TextView textView;

    Button button;

    SharedPreferences sharedPreferences;

    Typeface style1, style2, style3, style4,style5;

    String fontSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);


        style1=Typeface.createFromAsset(getAssets(), "font/Kartina.ttf");
        style2=Typeface.createFromAsset(getAssets(), "font/Ceylonia.otf");
        style3=Typeface.createFromAsset(getAssets(), "font/Kind Heart.otf");
        style4=Typeface.createFromAsset(getAssets(), "font/EastmanTrial-Light.otf");
        style5=Typeface.createFromAsset(getAssets(), "font/hawthorn.ttf");

        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(MainActivity.this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameText=name.getText().toString();
                textView.setText(nameText);

                Intent intent=new Intent(MainActivity.this, Prefference.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        fontStyle();
        fontSize();
//        fontColor();
        colorFont();
    }

    //for the textStyle

    public void fontStyle() {
        boolean textStyle1;
        boolean textStyle2;
        boolean textStyle3;
        boolean textStyle4;


        textStyle1=sharedPreferences.getBoolean("FONT1", false);
        textStyle2=sharedPreferences.getBoolean("FONT2", false);
        textStyle3=sharedPreferences.getBoolean("FONT3", false);
        textStyle4=sharedPreferences.getBoolean("FONT4", false);


        if (textStyle1) {
            textView.setTypeface(style1);
        } else if (textStyle2) {
            textView.setTypeface(style2);
        } else if (textStyle3) {
            textView.setTypeface(style3);
        }
        else if (textStyle4)
        {
            textView.setTypeface(style5);
        }
        else {
            textView.setTypeface(style4);
        }

    }


    public void fontSize() {
        fontSize=sharedPreferences.getString("FONT_SIZE", "25");
        textView.setTextSize(Float.parseFloat(fontSize));
    }

//    public void fontColor()
//    {
//        color = sharedPreferences.getString("FONT_COLOR","#000");
//        textView.setTextColor(Integer.parseInt(color));
//    }

    public void colorFont() {
        boolean blue, yellow, red, orange, magenta, lavender;

        blue=sharedPreferences.getBoolean("BLUE", false);
        yellow=sharedPreferences.getBoolean("YELLOW", false);
        red=sharedPreferences.getBoolean("RED", false);
        orange=sharedPreferences.getBoolean("ORANGE", false);
        magenta=sharedPreferences.getBoolean("MAGENTA", false);
        lavender=sharedPreferences.getBoolean("LAVENDER", false);


        if (blue) {
            textView.setTextColor(Color.BLUE);
        }
        else if (yellow)
        {
            textView.setTextColor(Color.YELLOW);

        }
        else if (red)
        {
            textView.setTextColor(Color.RED);


        }
        else if (orange) {
            textView.setTextColor(Color.parseColor("#FFB347"));


//            textView.setTextColor(getResources().getColor(R.color.orange));
        }
        else if (magenta)
        {
            textView.setTextColor(Color.parseColor("#F49AC2"));

//
        }
        else if (lavender)
        {
            textView.setTextColor(Color.parseColor("#734F96"));
        }





    }

}
