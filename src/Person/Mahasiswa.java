/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;
import Function.*;
import Interface.GetData;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

/**
 *
 * @author daffa
 */

//Mahasiswa implemets GetData
public class Mahasiswa implements GetData {
    
    @SerializedName("Name")
    private String namaMahasiswa;
    @SerializedName("NIM")
    private String nimMahasiswa;
    @SerializedName("Fakultas")
    private String fakultasMahasiswa;
    @SerializedName("Prodi")
    private String prodiMahasiswa;
    @SerializedName("Class")
    private String kelasMahasiswa;
    @SerializedName("Angkatan")
    private String tahunAngkatan;
    @SerializedName("CreateAt")
    private String createAt;

    public Mahasiswa() {}
    
    public Mahasiswa(String namaMahasiswa, String nimMahasiswa, String tahunAngkatan) {
        try {

            Validate.sanitizeInputStringNotNull(namaMahasiswa, nimMahasiswa, tahunAngkatan);
            this.namaMahasiswa = namaMahasiswa;
            this.nimMahasiswa = nimMahasiswa;
            this.tahunAngkatan = tahunAngkatan;
            this.createAt = this.createAt = LocalDateTime.now().toString();
            
            
        } catch (NullPointerException e) {
            System.out.println("Input should not null");
            System.err.println(e);
        }
    }
    
   
    //Method
    @Override
    public void getAllData() {
        //Get data from this class
        JSON.printJSON(this);
    }

    
    //Method not used
    @Override
    public void getData(String searchData) { }


  

   
    //Setter Getter
    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public void setNimMahasiswa(String nimMahasiswa) {
        Validate.sanitizeInputStringNotNull(nimMahasiswa);
        this.nimMahasiswa = nimMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        Validate.sanitizeInputStringNotNull(namaMahasiswa);
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getFakultasMahasiswa() {
        return fakultasMahasiswa;
    }

    public void setFakultasMahasiswa(String fakultasMahasiswa) {
        Validate.sanitizeInputStringNotNull(fakultasMahasiswa);
        this.fakultasMahasiswa = fakultasMahasiswa;
    }

    public String getProdiMahasiswa() {
        return prodiMahasiswa;
    }

    public void setProdiMahasiswa(String prodiMahasiswa) {
        Validate.sanitizeInputStringNotNull(prodiMahasiswa);
        this.prodiMahasiswa = prodiMahasiswa;
    }

    public String getTahunAngkatan() {
        return tahunAngkatan;
    }

    public void setTahunAngkatan(String tahunAngkatan) {
        Validate.sanitizeInputStringNotNull(tahunAngkatan);
        this.tahunAngkatan = tahunAngkatan;
    }

    public String getKelasMahasiswa() {
        return kelasMahasiswa;
    }

    public void setKelasMahasiswa(String kelasMahasiswa) {
        this.kelasMahasiswa = kelasMahasiswa;
    }

   


}
