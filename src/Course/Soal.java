/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import Function.JSON;
import Interface.*;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author daffa
 */
public class Soal implements GetData{
    private static final AtomicInteger count = new AtomicInteger(0);
    @SerializedName("id")
    private final int idSoal;
    @SerializedName("Description")
    private String deskripsiSoal;

    public Soal(String deskripsiSoal) {
        this.deskripsiSoal = deskripsiSoal;
        this.idSoal = count.incrementAndGet();
    }
    
    
    //Unused methos
    @Override
    public void getData(String searchData) { }

    @Override
    public void getAllData() {
        JSON.printJSON(this);
    }


    public String getDeskripsiSoal() {
        return deskripsiSoal;
    }

    public void setDeskripsiSoal(String deskripsiSoal) {
        this.deskripsiSoal = deskripsiSoal;
    }

    public int getIdSoal() {
        return idSoal;
    }
    
    
    
    
}
