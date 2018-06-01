package id.co.abimcode.e_warteg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abimanyu on 5/30/18.
 */

public class ModelMakanan {
    @SerializedName("makanan")
    @Expose
    private List<Makanan> makanen = null;

    @SerializedName("pesan")
    @Expose
    private String pesan;

    @SerializedName("sukses")
    @Expose
    private String sukses;
    private boolean status;

    public List<Makanan> getMakanen() {
        return makanen;
    }

    public void setMakanen(List<Makanan> makanen) {
        this.makanen = makanen;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getSukses() {
        return sukses;
    }

    public void setSukses(String sukses) {
        this.sukses = sukses;
    }


}
