/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Interface.ShowData;

/**
 *
 * @author daffa
 */
public class Admin extends Pegawai implements ShowData {
    private String nikAdmin;
    private int levelAkses;

    public Admin(String namaPegawai, String alamatPegawai, int gajiPegawai, String nikAdmin, int levelAkses) {
        super(namaPegawai, alamatPegawai, gajiPegawai);
        this.nikAdmin = nikAdmin;
        this.levelAkses = levelAkses;
    }

    public String getNikAdmin() {
        return nikAdmin;
    }

    public void setNikAdmin(String nikAdmin) {
        this.nikAdmin = nikAdmin;
    }

    public int getLevelAkses() {
        return levelAkses;
    }

    public void setLevelAkses(int levelAkses) {
        this.levelAkses = levelAkses;
    }

    
    
    @Override
    public void showInfo() {
        System.out.println("Nama                :" + super.getNamaPegawai());
        System.out.println("Alamat              :" + super.getAlamatPegawai());
        System.out.println("Gaji                :" + super.getGajiPegawai());
        System.out.println("NIK                 :" + this.nikAdmin);
        System.out.println("Level Akses         :" + this.levelAkses);
    }

    
    
    
}
