package com.machamasisuraj.socialapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.Model.ShowReservation;
import com.machamasisuraj.socialapp.R;

import java.util.List;

public class BookingAdapter  extends  RecyclerView.Adapter<BookingAdapter.Viewholder> {
    private Context mContext;
    private List<ShowReservation> reservationList;

    public BookingAdapter(Context mContext, List<ShowReservation> reservationList) {
        this.mContext = mContext;
        this.reservationList = reservationList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_recycler,parent,false);
        return  new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ShowReservation showReservation=  reservationList.get(position);

        holder.tripdays.setText(showReservation.getTrip().getTripDays()+"");
        holder.startDate.setText("Start :"+showReservation.getStartDate()+"");
        holder.endDate.setText("End :"+showReservation.getEndDate()+"");
        holder.booktravallercount.setText("total Travellers :"+ showReservation.getTravellerCount()+"");
        holder.bookadult.setText("Adult : "+showReservation.getAdult()+"");
        holder.bookchild.setText( "Child: "+showReservation.getChild()+"");
        holder.bookpickupAddress.setText("Pick up: "+showReservation.getPickupAddress()+"");
        holder.bookhotel.setText("Hotel :"+showReservation.getAccomodation());
        holder.bookPrice.setText("Price :"+ showReservation.getPrice()+"");
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
            }
        });



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
             btndelete=itemView.findViewById(R.id.btndelete);

        }
    }
}
