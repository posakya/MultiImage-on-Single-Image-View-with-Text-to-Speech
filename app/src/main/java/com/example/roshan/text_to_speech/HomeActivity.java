package com.example.roshan.text_to_speech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_patan,btn_ktm,btn_bkt,btn_tokha,btn_siddhipur,btn_lamatar,btn_bouddha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_bkt = (Button) findViewById(R.id.btn_bhaktapur);
        btn_ktm = (Button) findViewById(R.id.btn_ktm_durbar);
        btn_patan = (Button) findViewById(R.id.btn_patan);
        btn_bouddha = (Button) findViewById(R.id.btn_bouddha);
        btn_tokha = (Button) findViewById(R.id.btn_tokha);
        btn_siddhipur = (Button) findViewById(R.id.btn_siddhipur);
        btn_lamatar = (Button) findViewById(R.id.btn_lamatar);

        btn_patan.setOnClickListener(this);
        btn_bkt.setOnClickListener(this);
        btn_ktm.setOnClickListener(this);
        btn_lamatar.setOnClickListener(this);
        btn_bouddha.setOnClickListener(this);
        btn_siddhipur.setOnClickListener(this);
        btn_tokha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btn_bkt){
            startActivity(new Intent(getApplicationContext(),Bhaktapur_Durbar_Square.class));
        }else if (view == btn_patan){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }else if(view == btn_ktm){
            startActivity(new Intent(getApplicationContext(),Kathmandu_Durbar_Square.class));
        }else if(view == btn_bouddha){
            startActivity(new Intent(getApplicationContext(),Bouddha.class));
        }else if(view == btn_siddhipur){
            startActivity(new Intent(getApplicationContext(),Siddhipur.class));
        }else if(view == btn_lamatar){
            startActivity(new Intent(getApplicationContext(),Lamatar.class));
        }else if(view == btn_tokha){
            startActivity(new Intent(getApplicationContext(),Tokha.class));
        }

    }
}
