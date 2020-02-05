package com.machamasisuraj.socialapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.BaseUrl.Url;
import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.TpViewHolder> {

    private Context mContext;
    private List<Trip> tripList;

    public TripListAdapter(Context mContext, List<Trip> tripList) {
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
    public void onBindViewHolder(@NonNull TpViewHolder holder, int position) {
        Trip trip = tripList.get(position);
        Picasso.get().load(Url.base_url+"/uploads"+trip.getImage()).into(holder.tripImage);
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
            }
        });




    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class TpViewHolder extends RecyclerView.ViewHolder{
        private TextView tripName, difficulty,address;
        private ImageView favourite,book,tripImage;
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
        }
    }
}
