/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import Function.JSON;
import Interface.*;
import Person.Dosen;
import com.google.gson.annotations.SerializedName;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author daffa
 */
public class Tugas implements GetData{
    
    private static final AtomicInteger count = new AtomicInteger(0);
    @SerializedName("id")
    private final int idTugas;
    @SerializedName("TaskName")
    private String namaTugas;
    @SerializedName("Course")
    private String mataKuliah;
    @SerializedName("Description")
    private String deskripsiTugas;
    @SerializedName("CreateBy")
    private final String createBy;
    @SerializedName("CreateAt")
    private final String createAt;

    public Tugas(MataKuliah mataKuliah, Dosen createBy, String namaTugas, String deskripsiTugas) {
        this.namaTugas = namaTugas;
        this.deskripsiTugas = deskripsiTugas;
        this.mataKuliah = mataKuliah.getNamaMataKuliah();
        this.createBy = createBy.getNamaPegawai();
        this.createAt = LocalTime.now().toString();
        this.idTugas = count.incrementAndGet();
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getDeskripsiTugas() {
        return deskripsiTugas;
    }

    public void setDeskripsiTugas(String deskripsiTugas) {
        this.deskripsiTugas = deskripsiTugas;
    }
    
    
    
    
    
    // Method
    //Unused method
    @Override
    public void getData(String searchData) {}

    @Override
    public void getAllData() {
        JSON.printJSON(this);
    }

  
}
