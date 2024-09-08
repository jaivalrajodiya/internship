package com.example.internship_jaival.Sqliteexample;

import static com.example.internship_jaival.Sqliteexample.dare.dare_nodatafound;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class DareAdapter extends RecyclerView.Adapter<DareAdapter.ViewHolder> {

    Context context;
    ArrayList<StudentDataModel> arrayList;

    public DareAdapter(Context context, ArrayList<StudentDataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DareAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.truth_dare_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DareAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView.setText(arrayList.get(position).title);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper1 myDBHelper = new MyDBHelper1(context);
                Log.d("id", "onClick: "+arrayList.get(position).getTitle());
                myDBHelper.deleteStudentData(arrayList.get(position).id);
                arrayList.remove(arrayList.get(position));
                if(getItemCount() == 0){

                    dare_nodatafound.setVisibility(View.VISIBLE);

                }else {
                    dare_nodatafound.setVisibility(View.GONE);

                }
                notifyDataSetChanged();

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper1 myDBHelper = new MyDBHelper1(context);

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.truthdare_dialog);

                EditText title = dialog.findViewById(R.id.enter_title);
                Button btnsubmit = dialog.findViewById(R.id.truthdare_submit);
                ImageView close = dialog.findViewById(R.id.close_img);

                title.setText(arrayList.get(position).title);
                dialog.setCancelable(false);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!title.getText().toString().isEmpty()){
                            StudentDataModel model = new StudentDataModel();
                            Log.d("TAG", "onClick: "+arrayList.get(position));
                            Log.d("TAG", "onid: "+arrayList.get(position).id);
                            model.id = arrayList.get(position).getId();
                            model.title = title.getText().toString();
                            myDBHelper.updatestudentdata(model);
                            arrayList =  myDBHelper.fetchStudentData();
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }else {
                            Toast.makeText(context, "Please enter Detail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);






            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.truthdaretitle);
            imageView = itemView.findViewById(R.id.truthdare_delete);
        }
    }
}
