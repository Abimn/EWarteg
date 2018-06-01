package id.co.abimcode.e_warteg.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.co.abimcode.e_warteg.R;
import id.co.abimcode.e_warteg.activity.DetailMakanan;
import id.co.abimcode.e_warteg.helper.MyConstans;
import id.co.abimcode.e_warteg.model.Makanan;

/**
 * Created by Abimanyu on 5/30/18.
 */

// Class ini berfungsi sebagai adapter untuk list view kita

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<Makanan> datamakanan;

    public RecyclerViewAdapter (Context context, List<Makanan> datamakanan) {
        this.context = context;
        this.datamakanan = datamakanan;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_makanan, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txtNama.setText(datamakanan.get(position).getNama1());
        holder.txtHarga.setText(datamakanan.get(position).getHarga1());
        holder.txtStatus.setText(datamakanan.get(position).getStatus1());
                Picasso.with(context)
                        .load(MyConstans.IMAGE_URL + datamakanan.get(position).getGambar1())
                        .error(R.mipmap.ic_launcher)
                        .into(holder.imgMakanan);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (context, DetailMakanan.class);

                            intent.putExtra("nm", datamakanan.get(position).getNama1());
                            intent.putExtra("hm", datamakanan.get(position).getHarga1());
                            intent.putExtra("sm", datamakanan.get(position).getStatus1());
                            intent.putExtra("dm", datamakanan.get(position).getDetail1());
                            intent.putExtra("gm", datamakanan.get(position).getGambar1());
                            context.startActivity(intent);
                        }
                    });
    }

    @Override
    public int getItemCount() {
        return datamakanan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama, txtHarga, txtStatus;
        ImageView imgMakanan;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgMakanan = (ImageView) itemView.findViewById(R.id.imgMakanan);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtHarga = (TextView) itemView.findViewById(R.id.txtHarga);
            txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
        }
    }
}
