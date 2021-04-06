/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivermain;
import Course.*;
import Course.
import Person.*;
import Fakultas.*;
/**
 *
 * @author daffa
 */
public class DriverMain {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Faculty
        Fakultas FIF = new Fakultas("Informatika", "2016", "Salah satu fakultas yang ada di telkom");
       
        //Study Program
        Prodi RPL = new Prodi("S1 Rekayasa Perangkat Lunak", "2019", "Prodi");
        Prodi IF = new Prodi("S1 Informatika", "1993", "Prodi");
        Prodi IT = new Prodi("S1 Teknologi Informasi", "2017", "Prodi");
        
        
        
        //Lecturer
        Dosen JTI = new Dosen("Jati Hiliamsyah Husen", "Jl. Buah Batu", "20920040", "Waseda University", "JTI", 7000000);
        Dosen DAS = new Dosen("Dana Sulistiyo Kusumo", "Jl. Buah Batu", "0411027801", "The University Of New South Wales", "DAS", 7500000);
        Dosen ERW = new Dosen("Erwin Budi Setiawan", "Jl. Buah Batu", "0405117601", "Institut Teknologi Bandung", "ERW", 7500000);
        
        //Class
        Kelas SE01 = new Kelas("SE-43-01", ERW.getNamaPegawai());
        
        //Course
        MataKuliah PPL = new MataKuliah("CRI1C3", "Software Process");
        MataKuliah KPL = new MataKuliah("CRI2C4", "Software Construction");
        
       
        
        //Students
        Mahasiswa mhs1 = new Mahasiswa("Daffa Hilmy Fadhlurrohman","1302194004", "2019");
        Mahasiswa mhs2 = new Mahasiswa("Fathuddin Ashari Amir","1302194013", "2019");
        Mahasiswa mhs3 = new Mahasiswa("Daffa Malik Syaifurahman","1302190101", "2019");
        Mahasiswa mhs4 = new Mahasiswa("Kevin Reihan Ghazali Adam","1302190019", "2019");
        Mahasiswa mhs5 = new Mahasiswa("Neng Annisha Setyawati","1302194063", "2019");
        
        //Forum
        Forum forum1 = new Forum(KPL, mhs1, "Software Engineering", "What is software engineering?");
        
         //Reply
        Reply rply = new Reply(mhs1.getNamaMahasiswa(), "Software engineering is defined as a process of analyzing user requirements and then designing, building, and testing software application which will satisfy those requirements.");
        Reply rply1 = new Reply(mhs2.getNamaMahasiswa(), "Software engineering is a branch of computer science which includes the development and building of computer systems software and applications software.");
        
        
        //CREATE METHOD
        //Add mahasiswa to faculty's list
        FIF.addMahasiswa(mhs1, mhs2, mhs3, mhs4, mhs5);
        //Add prodi to faculty's list
        FIF.addProdi(IF, IT, RPL);
        //Add dosen to prodi
        RPL.addDosen(JTI, DAS);
        IF.addDosen(ERW);
        
        
        //Add mahasiswa to Kelas
        SE01.addMahasiswa(mhs1, mhs2, mhs3, mhs4, mhs5);
        
        //Add mahasiswa to faculty
        RPL.addMahasiswa(mhs1, mhs2, mhs3, mhs4, mhs5);
        
        //Add mahasiswa to matakuliah
        PPL.addMahasiswa(mhs1, mhs2, mhs3, mhs4, mhs5);
        KPL.addMahasiswa(mhs1, mhs2);
        
        //
        JTI.addCourse(KPL);
        DAS.addCourse(KPL, PPL);
        
        
        
        //READ METHOD
        //Get spesific data from prodi
        //RPL.getData("20920040");
        //RPL.getAllData();
        
        //Get spesific data from prodi
        //PPL.getData("1302194013");
        //PBO.getAllData();
        
        
        
        //DELETE METHOD
        //Delete spesific data from Course
       // PBO.deleteData("Daffa Hilmy Fadhlurrohman");
        //PBO.deleteAllData();
        //Delete
        
        //PBO.getAllData();
        //RPL.addDataDosen(JTI);
       
        //JSON.printJSONExclude(JTI);
       
        
        
    } 
}
