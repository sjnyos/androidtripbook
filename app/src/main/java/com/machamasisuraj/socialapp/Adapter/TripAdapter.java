package com.machamasisuraj.socialapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.GUI.BottomNavbarActivity;
import com.machamasisuraj.socialapp.GUI.CustomMapActivity;
import com.machamasisuraj.socialapp.GUI.MapsActivity;
import com.machamasisuraj.socialapp.GUI.TripDetailActvity;
import com.machamasisuraj.socialapp.Model.LatitudeLongitude;
import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

 public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TpViewHolder> {

    private Context mContext;
    private List<Trip> tripList;

    public TripAdapter(Context mContext, List<Trip> tripList) {
        this.mContext = mContext;
        this.tripList = tripList;
    }

    @NonNull
    @Override
    public TpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_layout,parent,false);
        return new TpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TpViewHolder holder, int position) {
        final Trip trip = tripList.get(position);

        Picasso.get().load(BaseUrl.base_url+"/uploads/"+trip.getImage()).into(holder.tripImage);
        holder.ratingBar.setNumStars(trip.getSize());
        holder.tripName.setText(trip.getTripName());
        holder.address.setText(trip.getDestination());
        holder.difficulty.setText(trip.getGrade());
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "book clicked", Toast.LENGTH_SHORT).show();
            }
        });
        holder.favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Favourite ", Toast.LENGTH_SHORT).show();
                holder.favourite.setImageResource(R.drawable.ic_favorite_all_black_24dp);
            }
        });
        holder.tripImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Image view Click", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(mContext, TripDetailActvity.class);
                intent.putExtra("id",trip.get_id());
                intent.putExtra("name",trip.getTripName());
                intent.putExtra("country",trip.getCountry());
                intent.putExtra("destination",trip.getDestination());
                intent.putExtra("duration",  trip.getDuration());
                intent.putExtra("arrivalDate",trip.getArrivalDate());
                intent.putExtra("departureDate",trip.getDepartureDate());
                intent.putExtra("itenerary",trip.getItenerary());
                intent.putExtra("receiveTransportation",false);
                intent.putExtra("food",trip.getFood());
                intent.putExtra("maproute",trip.getMaproute());
                intent.putExtra("price",trip.getPricePerEach());
                intent.putExtra("tripdays",trip.getTripDays());
                intent.putExtra("image",trip.getImage());
                intent.putExtra("size",trip.getSize());
                intent.putExtra("desc",trip.getDesc());
                intent.putExtra("grade",trip.getGrade());
                intent.putExtra("image", trip.getImage());
                 mContext.startActivity(intent);




            }
        });

        holder.ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Rating bar clicked", Toast.LENGTH_SHORT).show();
            }
        });
        holder.routeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatitudeLongitude.lat=27.7183924;
                LatitudeLongitude.lon=85.257141;
                LatitudeLongitude.marker="Trip to Here";
                Intent intent = new Intent(mContext,CustomMapActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class TpViewHolder extends RecyclerView.ViewHolder{
        private TextView tripName, difficulty,address;
        private ImageView tripImage,  favourite,book,routeLocation;
        private RatingBar ratingBar;

        public TpViewHolder(@NonNull View itemView) {
            super(itemView);
            tripImage= itemView.findViewById(R.id.tripImage);
            tripName = itemView.findViewById(R.id.tripName);
            difficulty =itemView.findViewById(R.id.difficulty);
            address=itemView.findViewById(R.id.address);
            favourite=itemView.findViewById(R.id.favourite);
            book=itemView.findViewById(R.id.book);
            ratingBar=itemView.findViewById(R.id.ratingBar);
            routeLocation=itemView.findViewById(R.id.routeLocation);
        }
    }
     private static String convertMongoDate(String val) {
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
         SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
         try {
             String finalStr = outputFormat.format(inputFormat.parse(val));
             System.out.println(finalStr);
             return finalStr;
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return "";
     }

     private static String convertMongoTime(String val) {
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
         SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
         try {
             String finalStr = outputFormat.format(inputFormat.parse(val));
             System.out.println(finalStr);
             return finalStr;
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return "";
     }
}

