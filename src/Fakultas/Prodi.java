/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fakultas;

import Interface.CreateData;
import Function.*;
import Interface.*;
import Person.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author daffa
 */
public class Prodi implements CreateData, GetData, DeleteData {
    @Expose
    @SerializedName("Name")
    private String namaProdi;
    @Expose
    @SerializedName("Year")
    private String tahunProdi;
    @Expose
    @SerializedName("Description")
    private String deskripsiProdi;
    @Expose
    @SerializedName("CreateAt")
    private String createAt;
   
    @SerializedName("Dosen")
    private LinkedList<Dosen> listDosen;
    @SerializedName("Mahasiswa")
    private LinkedList<Mahasiswa> listMahasiswa;
   
    
    
     public Prodi(String namaProdi, String tahunProdi, String deskripsiProdi) {
        try {
            Validate.sanitizeInputStringNotNull(namaProdi, tahunProdi, deskripsiProdi);
            
            this.namaProdi = namaProdi;
            this.tahunProdi = tahunProdi;
            this.deskripsiProdi = deskripsiProdi;
            this.createAt = this.createAt = LocalDateTime.now().toString();
            
            this.listDosen = new LinkedList<>();
            this.listMahasiswa = new LinkedList<>();
            
            
        } catch (NullPointerException e) {
            System.out.println("Input should not null");
            System.err.println(e);
        }
    }
     
    //Method 
    @Override
    public void addMahasiswa(Mahasiswa... givenInput) {
        for(Mahasiswa data: givenInput){
            //Set prodi name to mahasiswa's prodi attribute
            data.setProdiMahasiswa(getNamaProdi());
            
            //Set mahasiswa to prodi's mahasiswa list
            listMahasiswa.add(data);
        }
    
    }
    
    public void addDosen(Dosen... givenInput) {
        for(Dosen data: givenInput){
            //Set prodi name to dosen's prodi attribute
            data.setHomeBaseDosen(getNamaProdi());
            
            //Set dosen to prodi's dosen list
            listDosen.add(data);
        }
    
    }
    
    
     @Override
    public void getData(String searchData) {
        //Search for spesific data from mahasiswa or dosen
        for(Mahasiswa data : this.listMahasiswa){
            if(data.getNimMahasiswa() == searchData){
                JSON.printJSON(data);
            }
        }
        
        for(Dosen data: this.listDosen){
            if(data.getNidnDosen() == searchData){
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
     
        this.listMahasiswa.removeIf(data -> (data.getNimMahasiswa() == searchData) 
            || (data.getNamaMahasiswa().equalsIgnoreCase(searchData)));
        
        this.listDosen.removeIf(data -> (data.getNidnDosen() == searchData) 
            || data.getNamaPegawai().equalsIgnoreCase(searchData));      
        
    }

    @Override
    public void deleteAllData() {
        this.listDosen.removeAll(listDosen);
        this.listMahasiswa.removeAll(listMahasiswa);
    }
   


    //Getter Setter
    public String getNamaProdi() {
        return namaProdi;
    }

    public String getTahunProdi() {
        return tahunProdi;
    }

    public String getDeskripsiProdi() {
        return deskripsiProdi;
    }
    public void setDeskripsiProdi(String deskripsiProdi) {
        this.deskripsiProdi = deskripsiProdi;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

}
