package id.co.abimcode.e_warteg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.abimcode.e_warteg.R;
import id.co.abimcode.e_warteg.helper.MyConstans;

// Class ini untuk menampilkan detail makanan
public class DetailMakanan extends AppCompatActivity {

    @BindView(R.id.imgMakanan)
    ImageView imgMakanan;
    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtHarga)
    TextView txtHarga;
    @BindView(R.id.txtStatus)
    TextView txtStatus;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        ButterKnife.bind(this);

        Intent i = getIntent();
        txtNama.setText(i.getStringExtra("nm"));
        txtHarga.setText(i.getStringExtra("hm"));
        txtStatus.setText(i.getStringExtra("sm"));
        txtDetail.setText(i.getStringExtra("dm"));
        Picasso.with(this)
                .load(MyConstans.IMAGE_URL + i.getStringExtra("gm"))
                .error(R.mipmap.ic_launcher_round)
                .into(imgMakanan);
    }
}
