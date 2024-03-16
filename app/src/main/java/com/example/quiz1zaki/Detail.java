package com.example.quiz1zaki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Detail extends AppCompatActivity {

    public static final String keyObj = "KEY_OBJ";
    private TextView slmtDtg,tipeMembership,kodeBrg,namaBrg,hargaBrg,totHarga,diskHarga,diskMember,jlhBayar;
    private Button btShare;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        slmtDtg = findViewById(R.id.tvSlmtDtg);
        tipeMembership = findViewById(R.id.tvTipeMember);
        kodeBrg = findViewById(R.id.tvKodeBrg);
        namaBrg= findViewById(R.id.tvNamaBrg);
        hargaBrg = findViewById(R.id.tvHargaBrg);
        totHarga = findViewById(R.id.tvTotHarga);
        diskHarga = findViewById(R.id.tvDiskHarga);
        diskMember = findViewById(R.id.tvDiskMember);
        jlhBayar = findViewById(R.id.tvJlhBayar);
        btShare = findViewById(R.id.btShare);

        Barang barang;
        if (Build.VERSION.SDK_INT > 33){
            barang = getIntent().getParcelableExtra(keyObj, Barang.class);
        }else {
            barang = getIntent().getParcelableExtra(keyObj);
        }

        slmtDtg.setText("Selamat Datang " + barang.getNama());
        tipeMembership.setText("Tipe Membership : " + barang.getTipeMember());
        kodeBrg.setText("Kode Barang : " + barang.getKodeBrg());
        namaBrg.setText("Nama Barang : " + barang.getNamaBrg());
        hargaBrg.setText("Harga Barang Rp : " + barang.getHargaBrg());
        totHarga.setText("Total Harga Barang Rp : " + formatter.format(Double.parseDouble(barang.getTotHarga())));
        diskHarga.setText("Diskon Harga Rp : " + formatter.format(Double.parseDouble(barang.getDiskHarga())));
        diskMember.setText("Diskon Membership Rp : " + formatter.format(Double.parseDouble(barang.getDiskMember())));
        jlhBayar.setText("Jumlah Bayar Rp : " + formatter.format(Double.parseDouble(barang.getJlhBayar())));

        btShare.setOnClickListener(click -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareMessage = "Nama :" + barang.getNama() +
                    "\nTipe Membership: "+ barang.getTipeMember() +
                    "\nKode Barang: " + barang.getKodeBrg() +
                    "\nNama Barang: " + barang.getNamaBrg() +
                    "\nHarga Barang: " + barang.getHargaBrg() +
                    "\nTotal Harga: " + formatter.format(Double.parseDouble(barang.getTotHarga())) +
                    "\nDiskon Harga: " + formatter.format(Double.parseDouble(barang.getDiskHarga()))+
                    "\nDiskon Membership: " + formatter.format(Double.parseDouble(barang.getDiskMember())) +
                    "\nJumlah Bayar: " + formatter.format(Double.parseDouble(barang.getJlhBayar()));
            intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(intent, "Bagikan melalui"));
        });
    }
}