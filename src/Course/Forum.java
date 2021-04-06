/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import Function.JSON;
import Interface.*;
import Person.Mahasiswa;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author daffa
 */
public class Forum implements GetData, DeleteData{
    private static final AtomicInteger count = new AtomicInteger(0);
    @SerializedName("id")
    private final int idForum;
    @SerializedName("Topic")
    private String topikForum;
    @SerializedName("Description")
    private String deskripsiTopik;
    @SerializedName("Course")
    private String mataKuliah;
    @SerializedName("CreateBy")
    private final String createBy;
    @SerializedName("CreateAt")
    private final String createAt;
    @SerializedName("Reply")
    private List<Reply> replyForum;
    

    public Forum(MataKuliah matakuliah, Mahasiswa mahasiswa, String topikForum, String deskripsiTopik) {
        this.topikForum = topikForum;
        this.deskripsiTopik = deskripsiTopik;
        this.mataKuliah = matakuliah.getNamaMataKuliah();
        this.createBy = mahasiswa.getNamaMahasiswa();
        this.createAt = LocalDateTime.now().toString();
        this.replyForum = new ArrayList<>();
        this.idForum = count.incrementAndGet();
    }
    
    //Method
    public void addReply(Reply ...givenInput){
        this.replyForum.addAll(Arrays.asList(givenInput));
    }
    
    
    @Override
    public void getData(String searchData) {
        for(Reply data : this.replyForum){
            if(data.getIdReply() == Integer.parseInt(searchData)){
                JSON.printJSON(data);
            }
        }
    }

    @Override
    public void getAllData() {
        JSON.printJSON(this);
    }

    @Override
    public void deleteData(String searchData) {
        //Delete by id
        this.replyForum.removeIf(data -> data.getIdReply() == Integer.parseInt(searchData));
    }

    @Override
    public void deleteAllData() {
        this.replyForum.removeAll(replyForum);
    }
     
    //Getter Setter
    public String getTopikForum() {
        return topikForum;
    }

    public void setTopikForum(String topikForum) {
        this.topikForum = topikForum;
    }

    public String getDeskripsiTopik() {
        return deskripsiTopik;
    }

    public void setDeskripsiTopik(String deskripsiTopik) {
        this.deskripsiTopik = deskripsiTopik;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public List<Reply> getReplyForum() {
        return replyForum;
    }

    public void setReplyForum(List<Reply> replyForum) {
        this.replyForum = replyForum;
    }

    
    
    
}
