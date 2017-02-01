package com.example.farha.fireappretriever;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    int recyclerItemPosition;
    LinearLayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    LinearLayoutManager linearLayoutManager;
    TextView mjudulide,
            mnamapembuat,
            mtanggalpenemuan,
            mlokasipenemuan,
            mnrp,
            mdept,
            mhubpenemuan,
            mmasalah,
            muraianmasalah,
            mide,
            msifatperbaikan,
            muraianproses,
            mevaluasihasil;

    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseChat;
    DatabaseReference mDatabaseLike;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    private boolean mProcessLike = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Firebase.setAndroidContext(this);
        mjudulide = (TextView) findViewById(R.id.judulidesp);
        mnamapembuat = (TextView) findViewById(R.id.namapembuatsp);
        mide = (TextView) findViewById(R.id.idesp);
        mnrp = (TextView) findViewById(R.id.nrpsp);
        mtanggalpenemuan = (TextView) findViewById(R.id.tanggalpenemuansp);
        mlokasipenemuan = (TextView) findViewById(R.id.lokasipenemuansp);
        mdept = (TextView) findViewById(R.id.deptsp);
        mhubpenemuan = (TextView) findViewById(R.id.hubpenemuansp);
        muraianmasalah = (TextView) findViewById(R.id.uraianmasalahsp);
        muraianproses = (TextView) findViewById(R.id.uraianprosessp);
        mevaluasihasil = (TextView) findViewById(R.id.evaluasihasilsp);
        msifatperbaikan = (TextView) findViewById(R.id.sifatperbaikansp);
        mmasalah = (TextView) findViewById(R.id.masalahsp);

        linearLayoutManager = new LinearLayoutManager(this);

        mDatabase = FirebaseDatabase.getInstance(); //getReference();
        mDatabaseChat = mDatabase.getReference("chat");
       // mDatabaseLike = FirebaseDatabase.getInstance().getReference().child("Likes");

//        mDatabaseLike.keepSynced(true);
        mDatabaseChat.keepSynced(true);






        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(linearLayoutManager);




    }


    @Override
    public void onStart() {
        super.onStart();

        //    Log.d("nsja",mDatabase.toString());

        FirebaseRecyclerAdapter<Chat, MessageViewHolder> adapter = new FirebaseRecyclerAdapter<Chat, MessageViewHolder>(
                Chat.class,
                R.layout.layout,
                MessageViewHolder.class,
                mDatabaseChat
        ) {
            @Override
            protected void populateViewHolder(MessageViewHolder viewHolder, Chat chat, final int position) {
                final String post_key = getRef(position).getKey();
                //final String post_key1 = getRef(position).getKey();
                     //viewHolder.setName(Chat.getName());
                //    viewHolder.setText(Chat.getText());
                viewHolder.setJudulide(chat.getJudulide());
//                Log.d("nanananana",chat.getName());
                 viewHolder.setNamapembuat(chat.getNamapembuat());
               /*    viewHolder.setTanggalpenemuan(chat.getTanggalpenemuan());
                viewHolder.setLokasipenemuan(chat.getLokasipenemuan());
                viewHolder.setNrp(chat.getNrp());
                viewHolder.setDept(chat.getDept());
                viewHolder.setHubpenemuan(chat.getHubpenemuan());
                viewHolder.setMasalah(chat.getMasalah());
                viewHolder.setUraianmasalah(chat.getUraianmasalah());
                viewHolder.setIde(chat.getIde());
                viewHolder.setSifatperbaikan(chat.getSifatperbaikan());
                viewHolder.setUraianproses(chat.getUraianproses());
                viewHolder.setEvaluasihasil(chat.getEvaluasihasil()); */

             //   viewHolder.setLikeBtn(post_key);

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // Toast.makeText(MainActivity.this,"post_key",Toast.LENGTH_LONG).show();

                        Intent desc = new Intent(MainActivity.this,DescriptionActivity.class);
                        desc.putExtra("posisiItemRecycler",post_key);
                        startActivity(desc);
                    }
                });

                /*

               viewHolder.mLikebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mProcessLike = true;
                        if(mProcessLike) {

                            mDatabaseLike.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.child(post_key).hasChild(mAuth.getCurrentUser().getRef(position()).getKey())){


                                    }    else {
                                        mDatabaseLike.child(post_key).child(mAuth.getCurrentUser().getUid().setValue("Random Values"));
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }

                    }
                }); */
            }
        };
        mRecyclerView.setAdapter(adapter);

   /*     ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
             // Toast.makeText(MainActivity.this, "Posisi ke "+position, Toast.LENGTH_SHORT).show();
             //   Log.d("test","success");
                recyclerItemPosition = position;

                Intent desc = new Intent(MainActivity.this,DescriptionActivity.class);
                desc.putExtra("posisiItemRecycler",recyclerItemPosition);
              startActivity(desc);

            }
        }); */

    }
    }

