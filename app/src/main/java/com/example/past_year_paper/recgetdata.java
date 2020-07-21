package com.example.past_year_paper;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recgetdata extends RecyclerView.Adapter<recgetdata.ViewHolder>{
    private List<recadaptar> listData;
    Context context;
    String userbk;
    public recgetdata(Context applicationContext, List<recadaptar> listData,String userbk) {
        this.listData = listData;
        this.context=applicationContext;
        this.userbk=userbk;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        recadaptar ld=listData.get(position);
        holder.txtid.setText(ld.getBoards());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent intent=new Intent(context,selectclass.class);
                    intent.putExtra("back",userbk);
                    intent.putExtra("sclick","Lahore");
                    intent.putExtra("pass","notok");
                    v.getContext().startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(context,selectclass.class);
                    intent.putExtra("sclick","Gujranwala");
                    intent.putExtra("back",userbk);
                    intent.putExtra("pass","notok");
                    v.getContext().startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent(context,selectclass.class);
                    intent.putExtra("sclick","Faisalabad");
                    intent.putExtra("back",userbk);
                    intent.putExtra("pass","notok");
                    v.getContext().startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent(context,selectclass.class);
                    intent.putExtra("sclick","Sargodha");
                    intent.putExtra("back",userbk);
                    intent.putExtra("pass","notok");
                    v.getContext().startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent(context,selectclass.class);
                    intent.putExtra("sclick","Federal");
                    intent.putExtra("back",userbk);
                    intent.putExtra("pass","notok");
                    v.getContext().startActivity(intent);
                }
                if(position==5){
                    Intent intent=new Intent(context,selectclass.class);
                    intent.putExtra("sclick","Rewalpindi");
                    intent.putExtra("back",userbk);
                    intent.putExtra("pass","notok");
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid;
        public ViewHolder(View itemView) {
            super(itemView);
            txtid=(TextView)itemView.findViewById(R.id.lah);
        }
    }

}

