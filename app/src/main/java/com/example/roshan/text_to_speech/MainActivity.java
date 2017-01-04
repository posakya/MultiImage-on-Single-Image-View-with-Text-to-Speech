package com.example.roshan.text_to_speech;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    TextView txt_deatil,txt_Speech;
    Button btn_next,btn_previous,btn_home;
    ImageView imageView,arrow_image,btn_detail;
    int ArrowLenght[]={R.drawable.west,R.drawable.west,R.drawable.turn,R.drawable.north,R.drawable.west,R.drawable.north,R.drawable.ahead,R.drawable.ahead,R.drawable.ahead,R.drawable.north};
    int Arrow=0;
    int ArrayImage[] = {R.drawable.hanuman,R.drawable.patan_durbar_square,R.drawable.museum,R.drawable.krishna_mandir,R.drawable.lalitpur,R.drawable.handicraft_house,R.drawable.golden_temple,R.drawable.way_to_banglamukhi,R.drawable.banglamukhi_back_door,R.drawable.banglamukhi_mandrir};
    int Array[] = {R.id.hanuman,R.id.patan,R.id.museum,R.id.krishna,R.id.lalitpur,R.id.handi,R.id.goldentemple,R.id.way,R.id.banglamuckhi,R.id.banglamukhimandir};
    int Text[]={R.id.at_mangal_bazar,R.id.patan_durbar,R.id.museum_gate,R.id.krishna_mandir,R.id.lalitpur_chamber,R.id.handi_craft,R.id.golden_temple,R.id.way_to_banglamukhi,R.id.banglamuckhi_backdoor, R.id.banglamukhi_mandir};
    int image=0;
    int text=0;
    int array=0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
       txt_deatil = (TextView) findViewById(R.id.txt_detail);
        txt_Speech = (TextView) findViewById(R.id.txt_speech);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_detail = (ImageView) findViewById(R.id.btn_detail);
        btn_previous = (Button) findViewById(R.id.btn_previous);
        imageView = (ImageView) findViewById(R.id.imageView);
        arrow_image = (ImageView) findViewById(R.id.arrow_image);

        txt_deatil.setMovementMethod(new ScrollingMovementMethod());
        MainActivity.this.setTitle("Lalitpur");
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
//                    t1.setPitch((float) 2.0);
                    t1.setSpeechRate((float) 0.8);
                    t1.setLanguage(Locale.US);
                }
            }
        });
        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_deatil.setVisibility(View.VISIBLE);
                String toSpeak = txt_deatil.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_previous.setVisibility(View.VISIBLE);
                text++;
                image = image % ArrayImage.length;
                 text = text % Text.length;
                array = array % Array.length;
                txt_deatil.setText(Array[array]);
                txt_Speech.setText(Text[text]);
                imageView.setImageResource(ArrayImage[image]);
                arrow_image.setImageResource(ArrowLenght[Arrow]);
                array++;
                Arrow ++;
                image++;
                String toSpeak = txt_Speech.getText().toString();

                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                if (image == 10){
                    btn_next.setVisibility(View.GONE);
                    btn_home.setVisibility(View.VISIBLE);
                    btn_previous.setVisibility(View.VISIBLE);
                }
            }

        }
        );

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_home.setVisibility(View.GONE);
                btn_next.setVisibility(View.VISIBLE);
                array--;
                image--;
                --Arrow;
                text = text % Text.length;
                text = (text + Text.length) % Text.length;
                txt_Speech.setText(Text[text]);
                array = (array + Array.length) % Array.length;
                Arrow = (Arrow + ArrowLenght.length)% ArrowLenght.length;
                image = (image + ArrayImage.length) % ArrayImage.length;
                txt_deatil.setText(Array[array]);
                arrow_image.setImageResource(ArrowLenght[Arrow]);
                imageView.setImageResource(ArrayImage[image]);

                --text;
                String toSpeak = txt_Speech.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                if (image == 0){
                   startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }
            }
        });

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
