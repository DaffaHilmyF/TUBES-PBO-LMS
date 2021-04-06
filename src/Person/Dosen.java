/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Course.*;
import Function.JSON;
import Function.Validate;
import Interface.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author daffa
 */
public class Dosen extends Pegawai implements GetData, DeleteData {
    @Expose
    @SerializedName("NIDN")
    private String nidnDosen;
    @Expose
    @SerializedName("Education")
    private String pendidikanDosen;
    @Expose
    @SerializedName("LecturerCode")
    private String kodeDosen;
    @Expose
    @SerializedName("Faculty")
    private String fakultasDosen;
    @Expose
    @SerializedName("Study Program")
    private String homeBaseDosen;
    @Expose
    @SerializedName("Course")
    private List<String> kodeMataKuliah;

    //Constructor
    public Dosen(String namaPegawai, String alamatPegawai, String nidnDosen, String pendidikanDosen, String kodeDosen, int gajiPegawai) {
        super(namaPegawai, alamatPegawai, gajiPegawai);
        
        try{
            Validate.sanitizeInputStringNotNull(nidnDosen, pendidikanDosen, kodeDosen);
            this.nidnDosen = nidnDosen;
            this.kodeDosen = kodeDosen;
            this.pendidikanDosen = pendidikanDosen;
            this.kodeMataKuliah = new ArrayList<>();
            
        }catch(NullPointerException e){
            System.out.println("Input should not null");
            System.err.println(e);
        }
    }

    
    //Add course information
    public void addCourse(MataKuliah ...givenInput){
        for(MataKuliah data: givenInput){
             //Add course code to dosen's course list
            this.kodeMataKuliah.add(data.getKodeMataKuliah());
            
            //Add dosen pengampu to mata kuliah attribute
            data.setNamaDosen(super.getNamaPegawai());
        }
           
    }
   
   
    @Override
    public void getData(String searchData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllData() {
        //Get data from this class
        JSON.printJSON(this);
    }
    
     @Override
    public void deleteData(String searchData) {
        this.kodeMataKuliah.removeIf(data -> data.contains(searchData));
    
    }

    @Override
    public void deleteAllData() {
        this.kodeMataKuliah.removeAll(kodeMataKuliah);
    }

    
    
    
    
    
    //Setter Getter
    public String getNidnDosen() {
        return nidnDosen;
    }

    public void setNidnDosen(String nidnDosen) {
        this.nidnDosen = nidnDosen;
    }

    public String getPendidikanDosen() {
        return pendidikanDosen;
    }

    public void setPendidikanDosen(String pendidikanDosen) {
        this.pendidikanDosen = pendidikanDosen;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }

    public String getFakultasDosen() {
        return fakultasDosen;
    }

    public void setFakultasDosen(String fakultasDosen) {
        this.fakultasDosen = fakultasDosen;
    }

    public String getHomeBaseDosen() {
        return homeBaseDosen;
    }

    public void setHomeBaseDosen(String homeBaseDosen) {
        this.homeBaseDosen = homeBaseDosen;
    }
    
    public List<String> getKodeMataKuliah() {
        return kodeMataKuliah;
    }

    public void setKodeMataKuliah(List<String> kodeMataKuliah) {
        this.kodeMataKuliah = kodeMataKuliah;
    }
}
