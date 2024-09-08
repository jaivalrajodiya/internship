package com.example.internship_jaival.PUT_ApiCalling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.internship_jaival.Image_Loadder.Image_Model;
import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataAdapter extends RecyclerView.Adapter<GetDataAdapter.ViewHolder>{
    Context context;
    List<Get_Model> arrayList;

    public GetDataAdapter(Context context, List<Get_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public GetDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.getapi_rcv_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GetDataAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.body.setText(arrayList.get(position).getBody());
        holder.id.setText(String.valueOf(arrayList.get(position).getId()));
        holder.userid.setText(String.valueOf(arrayList.get(position).getUserId()));
        holder.title.setText(arrayList.get(position).getTitle());

       holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               PutApi_Interface  putApiInterface = PutApi_ApiClient.getRetrofit().create(PutApi_Interface.class);

               Call<Void> call = putApiInterface.deletedata(position);
               call.enqueue(new Callback<Void>() {
                   @Override
                   public void onResponse(Call<Void> call, Response<Void> response) {
                       arrayList.remove(position);
                       notifyDataSetChanged();
                   }

                   @Override
                   public void onFailure(Call<Void> call, Throwable t) {

                   }
               });
               return false;
           }
       });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id,userid,title,body;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.get_id);
            userid = itemView.findViewById(R.id.get_userid);
            title = itemView.findViewById(R.id.get_title);
            body = itemView.findViewById(R.id.get_body);



        }
    }
}
