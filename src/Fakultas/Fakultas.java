/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fakultas;
import Interface.*;
import Function.*;
import Interface.GetData;
import Person.Mahasiswa;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.LinkedList;
/**
 *
 * @author daffa
 */
public class Fakultas implements CreateData, GetData, DeleteData {
    @SerializedName("Name")
    private String namaFakultas;
    @SerializedName("Year")
    private String tahunFakultas;
    @SerializedName("Description")
    private String deskripsiFakultas;
    @SerializedName("Program Study")
    private LinkedList<Prodi> prodiList;
  

    public Fakultas(String namaFakultas, String tahunFakultas, String deskripsiFakultas) {
        try {
            Validate.sanitizeInputStringNotNull(namaFakultas, tahunFakultas, deskripsiFakultas);
            this.namaFakultas = namaFakultas;
            this.tahunFakultas = tahunFakultas;
            this.deskripsiFakultas = deskripsiFakultas;
            this.prodiList = new LinkedList<Prodi>();
            
        } catch (NullPointerException e) {
            System.out.println("Input should not null");
            System.err.println(e);
        }
    }
    
    //Method
    @Override
    public void addMahasiswa(Mahasiswa ...givenInput) {
        for(Mahasiswa data: givenInput){
            data.setFakultasMahasiswa(getNamaFakultas());
        }
    }
    
    public void addProdi(Prodi ...givenInput){
        this.prodiList.addAll(Arrays.asList(givenInput));
    }
    
    @Override
    public void getData(String searchData) {
        for(Prodi data: this.prodiList){
            if(data.getNamaProdi().equalsIgnoreCase(searchData)){
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
        this.prodiList.removeIf(data -> data.getNamaProdi().equalsIgnoreCase(searchData));
    }

    @Override
    public void deleteAllData() {
        this.prodiList.removeAll(prodiList);
    }

   
    
    
    
    
    
    
    
    //Setter Getter
    public String getNamaFakultas() {
        return namaFakultas;
    }

    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }

    public String getTahunFakultas() {
        return tahunFakultas;
    }

    public void setTahunFakultas(String tahunFakultas) {
        this.tahunFakultas = tahunFakultas;
    }

    public String getDeskripsiFakultas() {
        return deskripsiFakultas;
    }

    public void setDeskripsiFakultas(String deskripsiFakultas) {
        this.deskripsiFakultas = deskripsiFakultas;
    }

    public LinkedList<Prodi> getProdiList() {
        return prodiList;
    }

    public void setProdiList(LinkedList<Prodi> prodiList) {
        this.prodiList = prodiList;
    }
}
