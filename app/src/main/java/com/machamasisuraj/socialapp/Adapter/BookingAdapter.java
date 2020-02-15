package com.machamasisuraj.socialapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.Model.ShowReservation;
import com.machamasisuraj.socialapp.R;

import java.util.List;

public class BookingAdapter  extends  RecyclerView.Adapter<BookingAdapter.Viewholder> {
    private Context mContext;
    private List<ShowReservation> reservationList;

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_recycler,parent,false);
        return  new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ShowReservation showReservation=  reservationList.get(position);
        bookingName= itemView.findViewById(R.id.bookingName);
        tripdays= itemView.findViewById(R.id.tripdays);
        startDate= itemView.findViewById(R.id.startDate);
        endDate= itemView.findViewById(R.id.endDate);
        booktravallercount= itemView.findViewById(R.id.booktravallercount);
        bookadult= itemView.findViewById(R.id.bookadult);
        bookchild= itemView.findViewById(R.id.bookchild);
        bookpickupAddress= itemView.findViewById(R.id.bookpickupAddress);
        bookhotel= itemView.findViewById(R.id.bookhotel);
        bookPrice= itemView.findViewById(R.id.bookPrice);
        btnedit= itemView.findViewById(R.id.btnedit);
        btndelete=itemView.findViewById(R.id.btndelete);
        holder.tripdays.setText(showReservation.getTrip().getTripDays()+"");
        holder.startDate.setText();

    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView bookingName,tripdays,startDate,endDate,booktravallercount
                ,bookadult,bookchild,bookpickupAddress,bookhotel,bookPrice;
        private Button btnedit,btndelete;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            bookingName= itemView.findViewById(R.id.bookingName);
            tripdays= itemView.findViewById(R.id.tripdays);
            startDate= itemView.findViewById(R.id.startDate);
            endDate= itemView.findViewById(R.id.endDate);
            booktravallercount= itemView.findViewById(R.id.booktravallercount);
            bookadult= itemView.findViewById(R.id.bookadult);
            bookchild= itemView.findViewById(R.id.bookchild);
            bookpickupAddress= itemView.findViewById(R.id.bookpickupAddress);
            bookhotel= itemView.findViewById(R.id.bookhotel);
            bookPrice= itemView.findViewById(R.id.bookPrice);
            btnedit= itemView.findViewById(R.id.btnedit);
            btndelete=itemView.findViewById(R.id.btndelete);

        }
    }
}
