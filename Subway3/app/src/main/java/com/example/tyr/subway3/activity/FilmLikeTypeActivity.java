package com.example.tyr.subway3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.tyr.subway3.R;

/**
 * Created by tyr on 2017/5/31.
 */
public class FilmLikeTypeActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;

    private ImageView like_back;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Button change_btn;
    int[] like = new int[6];
    private Toolbar like_top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_type_main);
        sharedPreferences = getSharedPreferences("filmlike", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        initCheckBox();
        initDate();
        for (int i=0;i<6;i++){
            if (like[i]==1){
                changecheck(i);
            }
        }

        change_btn = (Button)findViewById(R.id.chgbtn);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    private void changecheck(int n){
        switch (n){
            case 0:
                checkBox1.setChecked(true);
                break;
            case 1:
                checkBox2.setChecked(true);
                break;
            case 2:
                checkBox3.setChecked(true);
                break;
            case 3:
                checkBox4.setChecked(true);
                break;
            case 4:
                checkBox5.setChecked(true);
                break;
            case 5:
                checkBox6.setChecked(true);
                break;
        }
    }

    private void initDate() {
        like[0] = sharedPreferences.getInt("爱情", 0);
        like[1] = sharedPreferences.getInt("喜剧", 0);
        like[2] = sharedPreferences.getInt("古装",0);
        like[3] = sharedPreferences.getInt("科幻",0);
        like[4] = sharedPreferences.getInt("恐怖",0);
        like[5] = sharedPreferences.getInt("悬疑",0);

    }

    private void initCheckBox() {
        checkBox1 = (CheckBox)findViewById(R.id.film_checkbox11);
        checkBox2 = (CheckBox)findViewById(R.id.film_checkbox21);
        checkBox3 = (CheckBox)findViewById(R.id.film_checkbox31);
        checkBox4 = (CheckBox)findViewById(R.id.film_checkbox41);
        checkBox5 = (CheckBox)findViewById(R.id.film_checkbox51);
        checkBox6 = (CheckBox)findViewById(R.id.film_checkbox61);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox1.isPressed()) {
                    editor.putInt("爱情", 1);
                } else if (!isChecked){
                    editor.putInt("爱情", 0);
                }
                editor.commit();
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox2.isPressed()){
                    editor.putInt("喜剧",1);
                }else if (!isChecked){
                    editor.putInt("喜剧",0);
                }
                editor.commit();
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox3.isPressed()){
                    editor.putInt("古装",1);
                }else if (!isChecked){
                    editor.putInt("古装",0);
                }
                editor.commit();
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox4.isPressed()) {
                    editor.putInt("科幻", 1);
                } else if (!isChecked){
                    editor.putInt("科幻", 0);
                }
                editor.commit();
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox5.isPressed()) {
                    editor.putInt("恐怖", 1);
                } else if (!isChecked){
                    editor.putInt("恐怖", 0);
                }
                editor.commit();
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&checkBox6.isPressed()) {
                    editor.putInt("悬疑", 1);
                } else if (!isChecked&&checkBox6.isPressed()){
                    editor.putInt("悬疑", 0);
                }
                editor.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
