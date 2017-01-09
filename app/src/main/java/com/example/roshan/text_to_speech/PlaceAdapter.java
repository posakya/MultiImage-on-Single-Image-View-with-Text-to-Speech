package com.example.roshan.text_to_speech;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshan.text_to_speech.patan_durbar_square.Golden_Temple;
import com.example.roshan.text_to_speech.patan_durbar_square.Krishna_Mandir;
import com.example.roshan.text_to_speech.patan_durbar_square.MainActivity;
import com.example.roshan.text_to_speech.patan_durbar_square.Museum;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by roshan on 1/5/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder>{
    private ArrayList<Spots> spotsList;
    private ImageLoader imageLoader;
    private Context context;
    

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_spot;
        public ImageView spot_image;

        public MyViewHolder(View view) {
            super(view);

            spot_image = (ImageView) view.findViewById(R.id.spot_image);
            txt_spot = (TextView) view.findViewById(R.id.txt_spot_name);
            context = view.getContext();
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            final Intent intent;
          //  Toast.makeText(view.getContext(), DataProvider.JAVA_BOOKS[getAdapterPosition()], Toast.LENGTH_SHORT).show();
            String item= txt_spot.getText().toString();
            Toast.makeText(view.getContext(),"You Clicked : "+item,Toast.LENGTH_SHORT).show();

            switch (getAdapterPosition()){


                case 0:
                    intent =  new Intent(context, Museum.class);
                    break;
                case 1:
                    intent =  new Intent(context, Krishna_Mandir.class);
                    break;
                case 2:
                    intent =  new Intent(context, Golden_Temple.class);
                    break;
                case 3:
                    intent =  new Intent(context, MainActivity.class);
                    break;

                default:
                    intent =  new Intent(context, MainActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }


    public PlaceAdapter(Context context, ArrayList<Spots> spotsList) {
        this.spotsList = spotsList;
        this.context =context;

    }



    @Override
    public PlaceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .build();
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context.getApplicationContext())
//                .defaultDisplayImageOptions(defaultOptions)
//                .build();
//        ImageLoader.getInstance().init(config);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PlaceAdapter.MyViewHolder holder, int position) {

        holder.txt_spot.setText(spotsList.get(position).getSpots_Name());
       // holder.spot_image.setImageResource(spots.getImage());
      //ImageLoader.getInstance().displayImage(spotsList.get(position).getImage()), holder.spot_image);
//        ImageLoader.getInstance().displayImage(spotsList.get(position).getImage(), holder.spot_image);
        holder.spot_image.setImageResource(spotsList.get(position).getImage());
    }



    @Override
    public int getItemCount() {
        return spotsList.size();
    }



}
