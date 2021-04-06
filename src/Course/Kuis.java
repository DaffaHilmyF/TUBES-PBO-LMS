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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author daffa
 */
public class Kuis implements GetData, DeleteData{
    private static final AtomicInteger count = new AtomicInteger(0);
    @SerializedName("id")
    private final int idKuis;
    @SerializedName("QuizName")
    private String namaKuis;
    @SerializedName("Course")
    private String mataKuliah;
    @SerializedName("CreateBy")
    private final String createBy;
    @SerializedName("CreateAt")
    private final String createAt;
    @SerializedName("Question")
    private List<Soal> listSoal;

    public Kuis(MataKuliah matkul, Dosen dosen, String namaKuis) {
        this.namaKuis = namaKuis;
        this.createBy = dosen.getNamaPegawai();
        this.mataKuliah = matkul.getKelasMataKuliah();
        this.listSoal = new ArrayList<>();
        this.idKuis = count.incrementAndGet();
        this.createAt = LocalTime.now().toString();
    }
    
    //Method
    public void addSoal(Soal ...givenInput){
        this.listSoal.addAll(Arrays.asList(givenInput));
    }
    
    
    
    @Override
    public void getData(String searchData) {
        for(Soal data: this.listSoal){
            if(data.getIdSoal() == Integer.parseInt(searchData)){
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
        this.listSoal.removeIf(data -> data.getIdSoal() == Integer.parseInt(searchData));
    }

    @Override
    public void deleteAllData() {
        this.listSoal.removeAll(listSoal);
    }
    
    
    //Getter Setter 

    public String getNamaKuis() {
        return namaKuis;
    }

    public void setNamaKuis(String namaKuis) {
        this.namaKuis = namaKuis;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public List<Soal> getListSoal() {
        return listSoal;
    }

    public void setListSoal(List<Soal> listSoal) {
        this.listSoal = listSoal;
    }
    
    
}
