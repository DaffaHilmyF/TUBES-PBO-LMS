/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import Function.JSON;
import Interface.GetData;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author daffa
 */
public class Reply implements GetData {
    private static final AtomicInteger count = new AtomicInteger(0);
    @SerializedName("Id")
    private final int idReply;
    @SerializedName("Name")
    private String namaPenjawab;
    @SerializedName("Description")
    private String deksripsi;
    @SerializedName("CreateAt")
    private final String createAt;

    public Reply(String namaPenjawab, String deksripsi) {
        this.namaPenjawab = namaPenjawab;
        this.deksripsi = deksripsi;
        this.createAt = LocalDateTime.now().toString();
        this.idReply = count.incrementAndGet();
    }
    
    
    //Method
    //Unused method
    @Override
    public void getData(String searchData) { }

    @Override
    public void getAllData() {
        JSON.printJSON(this);
    
    }
    
    
    
    
    
    //Getter Setter
    public int getIdReply() {
        return idReply;
    }
    public String getNamaPenjawab() {
        return namaPenjawab;
    }

    public void setNamaPenjawab(String namaPenjawab) {
        this.namaPenjawab = namaPenjawab;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }

    
}
