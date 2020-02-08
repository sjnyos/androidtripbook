package com.machamasisuraj.socialapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Model.User;
import com.machamasisuraj.socialapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserListAdapter  extends RecyclerView.Adapter<UserListAdapter.UserViewHolder>{

    private Context mContext;
    private List<User> userList;
    public UserListAdapter(Context mContext , List<User> userList ){
        this.mContext=mContext;
        this.userList=userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.userchat_circle_layout, parent,false);
       return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final User user = userList.get(position);

        Picasso.get().load(BaseUrl.base_url+"/uploads/"+user.getImage()).into(  holder.userheads);
        holder.chatheadName.setText(user.getUsername());
        holder.userheads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, user.getUsername()+ "you clicked this", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView userheads;
        private TextView chatheadName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userheads= itemView.findViewById(R.id.userheads);
            chatheadName= itemView.findViewById(R.id.chatheadName);
        }
    }
}
