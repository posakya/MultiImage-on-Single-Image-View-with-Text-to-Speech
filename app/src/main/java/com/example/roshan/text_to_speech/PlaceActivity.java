package com.example.roshan.text_to_speech;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PlaceActivity extends AppCompatActivity {
    private List<Spots> spotsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlaceAdapter pAdapter;
    private Context context;
 final private    int ArrayImage[] = {R.drawable.museum,R.drawable.krishna_mandir,R.drawable.golden_temple,R.drawable.banglamukhi_mandrir};
    final private    int Place[] = {R.id.at_museum,R.id.at_krishna_mandir,R.id.at_golder_temple,R.id.banglamukhi_temple};

public PlaceActivity(){

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ArrayList spots1 = prepareData();
        pAdapter = new PlaceAdapter(getApplicationContext(),spots1);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        PlaceActivity.this.setTitle("Spots");
        
        pAdapter.notifyDataSetChanged();

    }

    private ArrayList prepareData(){

        ArrayList spot = new ArrayList<>();
        for(int i = 0; i< Place.length; i++){
            Spots spots = new Spots();
            spots.setSpots_Name(Place[i]);
            spots.setImage(ArrayImage[i]);
            spot.add(spots);
        }
        return spot;
    }


    public interface ClickListener {
        void onLongClick(View child, int childPosition);

        void onClick(View child, int childPosition);
    }

    public void onBackPressed() {
        //  super.onBackPressed();
//        moveTaskToBack(true);
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}
