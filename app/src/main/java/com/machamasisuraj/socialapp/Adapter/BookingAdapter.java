package com.machamasisuraj.socialapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.BLL.ReservationBLL;
import com.machamasisuraj.socialapp.Model.ShowReservation;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.custom.CustomDialogClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.Viewholder> {
    private Context mContext;
    private List<ShowReservation> reservationList;

    public BookingAdapter(Context mContext, List<ShowReservation> reservationList) {
        this.mContext = mContext;
        this.reservationList = reservationList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_recycler, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, final int position) {
        final ShowReservation showReservation = reservationList.get(position);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String arrivalDate = dateFormat.format(showReservation.getStartDate());
        String departureDate = dateFormat.format(showReservation.getStartDate());

        holder.tripdays.setText("Trip Days : " + showReservation.getTrip().getTripDays() + "");
        holder.startDate.setText("Start :" + arrivalDate + "");
        holder.endDate.setText("End :" + departureDate + "");
        holder.booktravallercount.setText("total Travellers :" + showReservation.getTravellerCount() + "");
        holder.bookadult.setText("Adult : " + showReservation.getAdult() + "");
        holder.bookchild.setText("Child: " + showReservation.getChild() + "");
        holder.bookpickupAddress.setText("Pick up: " + showReservation.getPickupAddress() + "");
        holder.bookhotel.setText("Hotel :" + showReservation.getAccomodation());
        holder.bookPrice.setText("Price :" + showReservation.getPrice() + "");

        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CustomDialogClass cdd = new CustomDialogClass(mContext);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
                cdd.yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "this is yes", Toast.LENGTH_SHORT).show();
                        ReservationBLL reservationBLL = new ReservationBLL();
                        reservationBLL.DeleteReservation(showReservation.get_id());
                        notifyDataSetChanged();
                        cdd.dismiss();
                    }
                });

                cdd.no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "this is no", Toast.LENGTH_SHORT).show();
                        cdd.dismiss();
                    }
                });


            }
        });
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView bookingName, tripdays, startDate, endDate, booktravallercount, bookadult, bookchild, bookpickupAddress, bookhotel, bookPrice;
        private Button btnedit, btndelete;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            bookingName = itemView.findViewById(R.id.bookingName);
            tripdays = itemView.findViewById(R.id.tripdays);
            startDate = itemView.findViewById(R.id.startDate);
            endDate = itemView.findViewById(R.id.endDate);
            booktravallercount = itemView.findViewById(R.id.booktravallercount);
            bookadult = itemView.findViewById(R.id.bookadult);
            bookchild = itemView.findViewById(R.id.bookchild);
            bookpickupAddress = itemView.findViewById(R.id.bookpickupAddress);
            bookhotel = itemView.findViewById(R.id.bookhotel);
            bookPrice = itemView.findViewById(R.id.bookPrice);
            btndelete = itemView.findViewById(R.id.btndelete);

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

}
