package id.co.abimcode.e_warteg.network;

import id.co.abimcode.e_warteg.model.ModelMakanan;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abimanyu on 5/31/18.
 */

public interface RestAPI {
    // @TIPEMETHOD("API_END_POINT")
    @GET ("koneksi.php")
    // <ModelData> nama_method()
    Call<ModelMakanan> getMakanan();

}
