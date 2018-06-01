package id.co.abimcode.e_warteg;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.abimcode.e_warteg.adapter.RecyclerViewAdapter;
import id.co.abimcode.e_warteg.helper.MyConstans;
import id.co.abimcode.e_warteg.model.Makanan;
import id.co.abimcode.e_warteg.model.ModelMakanan;
import id.co.abimcode.e_warteg.network.RestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listMakanan)
    RecyclerView listMakanan;
    RecyclerView.LayoutManager layoutManager;
    List<Makanan> datamakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        listMakanan.setLayoutManager(layoutManager);

        getMakanan();
    }

    private void getMakanan() {
       final ProgressDialog loading = ProgressDialog.show(this, null, "Mengambil data. .");
        // Inisialisasi retrofit
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyConstans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                RestAPI api = retrofit.create(RestAPI.class);
        // Siapkan request
        Call<ModelMakanan> modelMakananCall = api.getMakanan();
        // Kirim request
        modelMakananCall.enqueue(new Callback<ModelMakanan>() {
            @Override
            public void onResponse(@NonNull Call<ModelMakanan> call, @NonNull Response<ModelMakanan> response) {
                String pesan = response.body().getPesan();
                String sukses = response.body().getSukses();
                // Pastikan response sukses
                if (sukses.equals("true")) {
                    Toast.makeText(MainActivity.this, ""+pesan, Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                    datamakanan = response.body().getMakanen();

                    tampildatamakanan();
                } else {
                    Toast.makeText(MainActivity.this, "tidak ada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ModelMakanan> call, Throwable t) {
                // print ke log jika error
                t.printStackTrace();
            }
        });
    }

    private void tampildatamakanan() {
        String items[] = new String[datamakanan.size()];
        for (int i = 0; i < datamakanan.size(); i++) {
            items[i] = datamakanan.get(i).getNama1();
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, datamakanan);
        listMakanan.setAdapter(adapter);
    }
}
