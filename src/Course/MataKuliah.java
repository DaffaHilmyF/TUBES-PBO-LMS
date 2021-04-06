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

/**
 *
 * @author daffa
 */
public class MataKuliah implements CreateData, GetData, DeleteData{
    @SerializedName("CouseCode")
    private String kodeMataKuliah;
    @SerializedName("Name")
    private String namaMataKuliah;
    @SerializedName("Class")
    private String kelasMataKuliah;
    @SerializedName("Lecturer")
    private String namaDosen;
    @SerializedName("CreateAt")
    private String createAt;
    @SerializedName("Participants")
    List<Mahasiswa> mahasiswa;   

    public MataKuliah(String kodeMataKuliah, String namaMataKuliah) {
        
        this.kodeMataKuliah = kodeMataKuliah;
        this.namaMataKuliah = namaMataKuliah;
        this.createAt = LocalDateTime.now().toString();
        this.mahasiswa = new ArrayList<>();
    }

    @Override
    public void addMahasiswa(Mahasiswa... givenInput) {
        
        //Add all data to list
        this.mahasiswa.addAll(Arrays.asList(givenInput));
    
    }
    
    
    
     @Override
    public void getData(String searchData) {
        
        //Search for spesific data from mahasiswa
        for(Mahasiswa data : this.mahasiswa){
            if((data.getNimMahasiswa() == searchData) || (data.getNamaMahasiswa().equalsIgnoreCase(searchData))){
                JSON.printJSON(data);
            }
        }
        
        
    }

    @Override
    public void getAllData() {
        
        //Print participant of this course
        JSON.printJSON(this.mahasiswa);

    }

    @Override
    public void deleteData(String searchData) {
        //Delete for spesific data from mahasiswa
        this.mahasiswa.removeIf(data -> (data.getNimMahasiswa() == searchData) || (data.getNamaMahasiswa() == searchData));
    }

    @Override
    public void deleteAllData() {
        //Delete all data
        this.mahasiswa.removeAll(mahasiswa);
    }

    
    
    //Setter Getter
    public String getKodeMataKuliah() {
        return kodeMataKuliah;
    }

    public void setKodeMataKuliah(String kodeMataKuliah) {
        this.kodeMataKuliah = kodeMataKuliah;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public String getKelasMataKuliah() {
        return kelasMataKuliah;
    }

    public void setKelasMataKuliah(String kelasMataKuliah) {
        this.kelasMataKuliah = kelasMataKuliah;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public List<Mahasiswa> getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(List<Mahasiswa> mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

  
   

    
    
    
}
