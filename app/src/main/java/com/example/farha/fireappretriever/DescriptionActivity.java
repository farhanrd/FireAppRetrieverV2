
package com.example.farha.fireappretriever;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by USERR on 26 Apr 2016.
 */
public class DescriptionActivity extends AppCompatActivity {

   // int i = 0;
   // int posisiItemRecycler;
    private String mpost_key = null;
    private DatabaseReference mdatabase;

    TextView judulide,
            namapembuat,
            tanggalpenemuan,
            lokasipenemuan,
            nrp,
            dept,
            hubpenemuan,
            masalah,
            uraianmasalah,
            ide,
            sifatperbaikan,
            uraianproses,
            evaluasihasil;
    //  TextView linklink;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_description);


        String mpost_key = getIntent().getExtras().getString("posisiItemRecycler");
        final String bool=" ";

        namapembuat = (TextView) findViewById(R.id.namapembuatsp);
        judulide = (TextView) findViewById(R.id.judulidesp);

        tanggalpenemuan = (TextView) findViewById(R.id.tanggalpenemuansp);
        lokasipenemuan = (TextView) findViewById(R.id.lokasipenemuansp);
        nrp = (TextView) findViewById(R.id.nrpsp);
        dept = (TextView) findViewById(R.id.deptsp);
        hubpenemuan = (TextView) findViewById(R.id.hubpenemuansp);
        masalah = (TextView) findViewById(R.id.masalahsp);
        uraianmasalah = (TextView) findViewById(R.id.uraianmasalahsp);
        ide = (TextView) findViewById(R.id.idesp);
        sifatperbaikan = (TextView) findViewById(R.id.sifatperbaikansp);
        uraianproses = (TextView) findViewById(R.id.uraianprosessp);
       evaluasihasil = (TextView) findViewById(R.id.evaluasihasilsp);

        //    linklink = (TextView) findViewById(R.id.linkurl);


        mdatabase = FirebaseDatabase.getInstance().getReference().child("chat");

        mdatabase.child(mpost_key).addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String post_namapembuat = (String) dataSnapshot.child("namapembuat").getValue();
                String post_judulide = (String) dataSnapshot.child("judulide").getValue();
                String post_tanggalpenemuan = (String) dataSnapshot.child("tanggalpenemuan").getValue();
                String post_lokasipenemuan = (String) dataSnapshot.child("lokasipenemuan").getValue();
                String post_dept = (String) dataSnapshot.child("dept").getValue();
                String post_nrp = (String) dataSnapshot.child("nrp").getValue();
                String post_hubpenemuan = (String) dataSnapshot.child("hubpenemuan").getValue();
                String post_masalah = (String) dataSnapshot.child("masalah").getValue();
                String post_uraianmasalah = (String) dataSnapshot.child("uraianmasalah").getValue();
                String post_ide = (String) dataSnapshot.child("ide").getValue();
                String post_sifatperbaikan = (String) dataSnapshot.child("sifatperbaikan").getValue();
                String post_uraianproses = (String) dataSnapshot.child("uraianproses").getValue();
                String post_evaluasihasil = (String) dataSnapshot.child("evaluasihasil").getValue();
                String post_bool = (String) dataSnapshot.child("Likes").getValue();

                namapembuat.setText(post_namapembuat);
                judulide.setText(post_judulide);
                tanggalpenemuan.setText(post_tanggalpenemuan);
                lokasipenemuan.setText(post_lokasipenemuan);
                dept.setText(post_dept);
                nrp.setText(post_nrp);
                hubpenemuan.setText(post_hubpenemuan);
                masalah.setText(post_masalah);
                uraianmasalah.setText(post_uraianmasalah);
                ide.setText(post_ide);
                sifatperbaikan.setText(post_sifatperbaikan);
                uraianproses.setText(post_uraianproses);
                evaluasihasil.setText(post_evaluasihasil);
                //bool.s.(post_bool);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









    }

    /*

    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.activity_description);

        databaseReference.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot   : dataSnapshot.getChildren()) {
                    Chat post = postSnapshot.getValue(Chat.class);
//                    System.out.println(i + " " + post.getTitle() + " - " + post.getUsername());
//                    post.getDate();
//                    post.getTime();
//                    post.getDesc();
//                    post.getTitle();
//                    post.getUsername();
//                    post.getPhone();

                    if (i == posisiItemRecycler) {

//                        System.out.println(i + " " + post.getTitle() + " - " + post.getUsername());
                        namapembuat.setText(post.getNamapembuat());
                        judulide.setText(post.getJudulide());
                        tanggalpenemuan.setText(post.getTanggalpenemuan());
                        lokasipenemuan.setText(post.getLokasipenemuan());
                        dept.setText(post.getDept());
                        nrp.setText(post.getNrp());
                        hubpenemuan.setText(post.getHubpenemuan());
                        masalah.setText(post.getMasalah());
                        uraianmasalah.setText(post.getUraianmasalah());
                        ide.setText(post.getIde());
                        sifatperbaikan.setText(post.getSifatperbaikan());
                        uraianproses.setText(post.getUraianproses());
                        evaluasihasil.setText(post.getEvaluasihasil());


                    }
                    i++;
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });} */
        }
