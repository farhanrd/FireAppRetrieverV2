package com.example.farha.fireappretriever;



import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farha.fireappretriever.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.facebook.FacebookSdk.getApplicationContext;

public  class MessageViewHolder extends RecyclerView.ViewHolder {
    public View mView;
    ImageButton mLikebtn;
    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseChat;
    DatabaseReference mDatabaseLike;
    String post_key;

    TextView mJudulide, mNamapembuat, mTanggalpenemuan, mLokasipenemuan, mNrp, mDept, mHubpenemuan, mMasalah, mUraianmasalah, mIde, mSifatperbaikan, mUraianproses, mEvaluasihasil;

    public MessageViewHolder(final View v) {
        super(v);
        mView = v;

        mJudulide = (TextView) v.findViewById(R.id.judulidesp);
        mNamapembuat = (TextView) v.findViewById(R.id.namapembuatsp);
        mTanggalpenemuan = (TextView) v.findViewById(R.id.tanggalpenemuansp);
        mLokasipenemuan = (TextView) v.findViewById(R.id.lokasipenemuansp);
        mNrp = (TextView) v.findViewById(R.id.nrpsp);
        mDept = (TextView) v.findViewById(R.id.deptsp);
        mHubpenemuan = (TextView) v.findViewById(R.id.hubpenemuansp);
        mMasalah = (TextView) v.findViewById(R.id.masalahsp);
        mUraianmasalah = (TextView) v.findViewById(R.id.uraianmasalahsp);
        mIde = (TextView) v.findViewById(R.id.idesp);
        mSifatperbaikan = (TextView) v.findViewById(R.id.sifatperbaikansp);
        mUraianproses = (TextView) v.findViewById(R.id.uraianprosessp);
        mEvaluasihasil = (TextView) v.findViewById(R.id.evaluasihasilsp);
        mLikebtn = (ImageButton) v.findViewById(R.id.like);

        mDatabase = FirebaseDatabase.getInstance(); //getReference();
        mDatabaseChat = mDatabase.getReference("chat");

    }

    public void setmLikebtn(final String post_key){
        mDatabaseChat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(post_key).child("Likes").getValue().toString().equals("false")) {
                  mLikebtn.setImageResource(R.mipmap.ic_thumb_up_white_24dp);
                } else {
                    mLikebtn.setImageResource(R.mipmap.ic_thumb_up_black_24dp);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setJudulide(String Judulide) {
        TextView field1 = (TextView) mView.findViewById(R.id.judulidesp);
        field1.setText(Judulide);
    }

    public void setNamapembuat(String Namapembuat) {
        TextView field2 = (TextView) mView.findViewById(R.id.namapembuatsp);
        field2.setText(Namapembuat);
    }

    public void setTanggalpenemuan(String Tanggalpenemuan) {
        TextView field1 = (TextView) mView.findViewById(R.id.tanggalpenemuansp);
        field1.setText(Tanggalpenemuan);
    }

    public void setLokasipenemuan(String Lokasipenemuan) {
        TextView field1 = (TextView) mView.findViewById(R.id.lokasipenemuansp);
        field1.setText(Lokasipenemuan);
    }

    public void setNrp(String Nrp) {
        TextView field1 = (TextView) mView.findViewById(R.id.nrpsp);
        field1.setText(Nrp);
    }

    public void setDept(String Dept) {
        TextView field1 = (TextView) mView.findViewById(R.id.deptsp);
        field1.setText(Dept);
    }

    public void setHubpenemuan(String Hubpenemuan) {
        TextView field1 = (TextView) mView.findViewById(R.id.hubpenemuansp);
        field1.setText(Hubpenemuan);
    }

    public void setMasalah(String Masalah) {
        TextView field1 = (TextView) mView.findViewById(R.id.masalahsp);
        field1.setText(Masalah);
    }

    public void setUraianmasalah(String Uraianmasalah) {
        TextView field1 = (TextView) mView.findViewById(R.id.uraianmasalahsp);
        field1.setText(Uraianmasalah);
    }

    public void setIde(String Ide) {
        TextView field1 = (TextView) mView.findViewById(R.id.idesp);
        field1.setText(Ide);
    }

    public void setSifatperbaikan(String Sifatperbaikan) {
        TextView field1 = (TextView) mView.findViewById(R.id.sifatperbaikansp);
        field1.setText(Sifatperbaikan);
    }

    public void setUraianproses(String Uraianproses) {
        TextView field1 = (TextView) mView.findViewById(R.id.uraianprosessp);
        field1.setText(Uraianproses);
    }

    public void setEvaluasihasil(String Evaluasihasil) {
        TextView field1 = (TextView) mView.findViewById(R.id.evaluasihasilsp);
        field1.setText(Evaluasihasil);
    }

}


