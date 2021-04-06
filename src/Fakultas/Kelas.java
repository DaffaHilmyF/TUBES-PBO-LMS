/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fakultas;

import Function.JSON;
import Interface.*;
import Person.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author daffa
 */
public class Kelas implements CreateData, GetData, DeleteData{
    @Expose
    @SerializedName("ClassName")
    private String namaKelas;
    @Expose
    @SerializedName("AcademicAdviser")
    private String waliDosen;
    @Expose
    @SerializedName("Member")
    private List<Mahasiswa> anggotaKelas;
   

    public Kelas(String namaKelas, String waliDosen) {
        this.namaKelas = namaKelas;
        this.waliDosen = waliDosen;
        this.anggotaKelas = new LinkedList<>();
    }

    
    //Method
    @Override
    public void addMahasiswa(Mahasiswa... givenInput) {
        for(Mahasiswa data: givenInput){
            //Set prodi name to mahasiswa's prodi attribute
            data.setKelasMahasiswa(namaKelas);
            
            //Set mahasiswa to prodi's mahasiswa list
            this.anggotaKelas.add(data);
        }
    }

    @Override
    public void getData(String searchData) { }

    @Override
    public void getAllData() {
        JSON.printJSON(this);
    }

    @Override
    public void deleteData(String searchData) {
        this.anggotaKelas.removeIf(data -> (data.getNimMahasiswa() == searchData) 
            || (data.getNamaMahasiswa().equalsIgnoreCase(searchData)));
    }

    @Override
    public void deleteAllData() {
        this.anggotaKelas.removeAll(anggotaKelas);
    }
    
    
    //Getter Setter
    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public List<Mahasiswa> getAnggotaKelas() {
        return anggotaKelas;
    }

    public void setAnggotaKelas(List<Mahasiswa> anggotaKelas) {
        this.anggotaKelas = anggotaKelas;
    }

    public String getWaliDosen() {
        return waliDosen;
    }

    public void setWaliDosen(String waliDosen) {
        this.waliDosen = waliDosen;
    }
}
