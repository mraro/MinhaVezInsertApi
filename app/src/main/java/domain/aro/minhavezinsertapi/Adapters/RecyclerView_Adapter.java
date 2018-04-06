package domain.aro.minhavezinsertapi.Adapters;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import domain.aro.minhavezinsertapi.Activity.Narutinho_Activity;
import domain.aro.minhavezinsertapi.Model.Narutinho;
import domain.aro.minhavezinsertapi.R;

/**
 * Created by alessandro.roliveir4 on 04/04/2018.
 */

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder>{

    private Context myContext;
    private List<Narutinho> mData;
    RequestOptions options;

    public RecyclerView_Adapter(Context myContext, List<Narutinho> mData){
        this.myContext = myContext;
        this.mData = mData;

        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        LayoutInflater inflater = LayoutInflater.from(myContext);

        view = inflater.inflate(R.layout.narutinho_row_item,parent,false);
        final  MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(myContext, Narutinho_Activity.class);
                i.putExtra("narutinho_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("name_personagem",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("narutinho_thumbnail",mData.get(viewHolder.getAdapterPosition()).getThumbnail());
                i.putExtra("narutinho_image",mData.get(viewHolder.getAdapterPosition()).getimage_url());
                myContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());

        Glide.with(myContext).load(mData.get(position).getThumbnail()).apply(options).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;

        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView){
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.nome_id);
            img_thumbnail = itemView.findViewById(R.id.thurmbnail_id);
        }
    }
}
