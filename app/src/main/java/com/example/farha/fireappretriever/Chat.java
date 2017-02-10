package com.example.farha.fireappretriever;



import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by felix on 23 Okt 2016.
 */

public class  Chat {
    private String judulide, namapembuat, tanggalpenemuan, lokasipenemuan, nrp, dept, hubpenemuan, masalah, uraianmasalah, ide, sifatperbaikan, uraianproses, evaluasihasil, bool  ;


    public Chat() {
    }

    public Chat(String judulide,
                String namapembuat,
                String tanggalpenemuan,
                String lokasipenemuan,
                String nrp,
                String dept,
                String hubpenemuan,
                String masalah,
                String uraianmasalah,
                String ide,
                String sifatperbaikan,
                String uraianproses,
                String evaluasihasil,
                String bool
    ) {
        this.judulide = judulide;
        this.namapembuat = namapembuat;
        this.tanggalpenemuan = tanggalpenemuan;
        this.lokasipenemuan = lokasipenemuan;
        this.nrp = nrp;
        this.dept = dept;
        this.hubpenemuan = hubpenemuan;
        this.masalah = masalah;
        this.uraianmasalah = uraianmasalah;
        this.ide = ide;
        this.sifatperbaikan = sifatperbaikan;
        this.uraianproses = uraianproses;
        this.evaluasihasil = evaluasihasil;
        this.bool=bool;



    }

    public String getJudulide() {
        return judulide;
    }
    public String getNamapembuat() {
        return namapembuat;
    }
    public String getTanggalpenemuan() {return tanggalpenemuan;}
    public String getLokasipenemuan() {return lokasipenemuan;}
    public String getDept() {return dept;}
    public String getNrp() {return nrp;}
    public String getHubpenemuan() {return hubpenemuan;}
    public String getMasalah() {return masalah;}
    public String getUraianmasalah() {return uraianmasalah;}
    public String getIde() {return ide;}
    public String getSifatperbaikan() {return sifatperbaikan;}
    public String getUraianproses() {return uraianproses;}
    public String getEvaluasihasil() {return evaluasihasil;}
    public String getBool() {return bool;}


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("judulide", judulide);
        result.put("namapembuat", namapembuat);
        result.put("tanggalpenemuan", tanggalpenemuan);
        result.put("lokasipenemuan", lokasipenemuan);
        result.put("dept", dept);
        result.put("nrp", nrp);
        result.put("hubpenemuan", hubpenemuan);
        result.put("masalah", masalah);
        result.put("uraianmasalah", uraianmasalah);
        result.put("ide", ide);
        result.put("sifatperbaikan", sifatperbaikan);
        result.put("uraianproses", uraianproses);
        result.put("evaluasihasil", evaluasihasil);
        result.put("Likes", bool);


        return result;
    }

}