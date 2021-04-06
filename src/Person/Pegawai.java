/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Function.Validate;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

/**
 *
 * @author daffa
 */
public class Pegawai{
    @Expose
    @SerializedName("Name")
    private String namaPegawai;
    @SerializedName("Address")
    private String alamatPegawai;
    @SerializedName("Salary")
    private int gajiPegawai;
    @Expose
    @SerializedName("CreateAt")
    private String createAt;
    
    //Constructor
    public Pegawai(String namaPegawai, String alamatPegawai, int gajiPegawai){
        try{
            //Validate input
            Validate.sanitizeInputStringNotNull(namaPegawai, alamatPegawai);
            Validate.sanitizeInputIntegerNotOverflow(gajiPegawai);

            this.gajiPegawai = gajiPegawai;
            this.alamatPegawai = alamatPegawai;
            this.namaPegawai = namaPegawai;
            this.createAt = LocalDateTime.now().toString();
            
        }catch(NullPointerException e){
            System.out.println("Input should not null");
            System.err.println(e);
        }catch(ArithmeticException e){
            System.out.println("Input is overflow");
            System.err.println(e);
        }
        
    }
    
    //Setter Getter
    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getAlamatPegawai() {
        return alamatPegawai;
    }

    public void setAlamatPegawai(String alamatPegawai) {
        this.alamatPegawai = alamatPegawai;
    }

    public int getGajiPegawai() {
        return gajiPegawai;
    }

    public void setGajiPegawai(int gajiPegawai) {
        this.gajiPegawai = gajiPegawai;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    
    
}
