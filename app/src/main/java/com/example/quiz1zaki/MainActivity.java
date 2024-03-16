package com.example.quiz1zaki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText Name,kodeBrg,jlhBrg;
    private RadioButton rbGold,rbSilver,rbBiasa;
    private Button btProses;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        kodeBrg = findViewById(R.id.etKodeBrg);
        jlhBrg = findViewById(R.id.etJlhBrg);
        btProses = findViewById(R.id.btProses);
        rbGold = findViewById(R.id.rbGold);
        rbSilver = findViewById(R.id.rbSilver);
        rbBiasa = findViewById(R.id.rbBiasa);

        Name.setHint("Nama");
        kodeBrg.setHint("Kode Barang");
        jlhBrg.setHint("Jumlah Barang");

        btProses.setOnClickListener(click -> {

            if (kodeBrg.getText().toString().equals("IPX")){
                double jumlah = Double.parseDouble(jlhBrg.getText().toString());
                String total = hitungTotalHarga(5725300, jumlah);
                String diskonHarga = cekJumlahBarangDiatas10(Double.parseDouble(total));
                String diskonMember = "";
                String jumlahBayar = "";
                String tipeMembership = "";

                if (rbGold.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.1);
                    tipeMembership = "Gold";
                } else if (rbSilver.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.05);
                    tipeMembership = "Silver";
                } else if (rbBiasa.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.02);
                    tipeMembership = "Biasa";
                }

                jumlahBayar = hitungJumlahBayar(Double.parseDouble(total), Double.parseDouble(diskonMember), Double.parseDouble(diskonHarga));

                Barang barang = new Barang();
                barang.setNama(Name.getText().toString());
                barang.setNamaBrg("Iphone X");
                barang.setKodeBrg("IPX");
                barang.setHargaBrg("Rp.5.725.300");
                barang.setTotHarga(total);
                barang.setDiskHarga(diskonHarga);
                barang.setDiskMember(diskonMember);
                barang.setJlhBayar(jumlahBayar);
                barang.setTipeMember(tipeMembership);

                Intent intent = new Intent(this, Detail.class);
                intent.putExtra(Detail.keyObj, barang);
                startActivity(intent);

            } else if (kodeBrg.getText().toString().equals("O17")) {

                double jumlah = Double.parseDouble(jlhBrg.getText().toString());
                String total = hitungTotalHarga(2500999, jumlah);
                String diskonHarga = cekJumlahBarangDiatas10(Double.parseDouble(total));
                String diskonMember = "";
                String jumlahBayar = "";
                String tipeMember = "";

                if (rbGold.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.1);
                    tipeMember = "Gold";
                } else if (rbSilver.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.05);
                    tipeMember = "Silver";
                } else if (rbBiasa.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.02);
                    tipeMember = "Biasa";
                }

                jumlahBayar = hitungJumlahBayar(Double.parseDouble(total), Double.parseDouble(diskonMember), Double.parseDouble(diskonHarga));

                Barang barang = new Barang();
                barang.setNama(Name.getText().toString());
                barang.setNamaBrg("Oppo A17");
                barang.setKodeBrg("O17");
                barang.setHargaBrg("Rp.2.500.999");
                barang.setTotHarga(total);
                barang.setDiskHarga(diskonHarga);
                barang.setDiskMember(diskonMember);
                barang.setJlhBayar(jumlahBayar);
                barang.setTipeMember(tipeMember);

                Intent intent = new Intent(this, Detail.class);
                intent.putExtra(Detail.keyObj, barang);
                startActivity(intent);

            } else if (kodeBrg.getText().toString().equals("MP3")) {

                double jumlah = Double.parseDouble(jlhBrg.getText().toString());
                String total = hitungTotalHarga(28999999, jumlah);
                String diskonHarga = cekJumlahBarangDiatas10(Double.parseDouble(total));
                String diskonMember = "";
                String jumlahBayar = "";
                String tipeMember = "";

                if (rbGold.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.1);
                    tipeMember = "Gold";
                } else if (rbSilver.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.05);
                    tipeMember = "Silver";
                } else if (rbBiasa.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.02);
                    tipeMember = "Biasa";
                }

                jumlahBayar = hitungJumlahBayar(Double.parseDouble(total), Double.parseDouble(diskonMember), Double.parseDouble(diskonHarga));

                Barang barang = new Barang();
                barang.setNama(Name.getText().toString());
                barang.setNamaBrg("Macbook Pro M3");
                barang.setKodeBrg("MP3");
                barang.setHargaBrg("28.999.999");
                barang.setTotHarga(total);
                barang.setDiskHarga(diskonHarga);
                barang.setDiskMember(diskonMember);
                barang.setJlhBayar(jumlahBayar);
                barang.setTipeMember(tipeMember);

                Intent intent = new Intent(this, Detail.class);
                intent.putExtra(Detail.keyObj, barang);
                startActivity(intent);
            }

        });
    }

    private String hitungTotalHarga(double harga, double jumlah){
        double totalHarga = harga * jumlah;
        return String.valueOf(totalHarga);
    }

    private String cekJumlahBarangDiatas10(Double total){
        String diskonHarga = "0";
        if(total > 10000000){
            diskonHarga = "100000";
            return diskonHarga;
        }
        return diskonHarga;
    }

    private String hitungDiskonMember(double total, double diskon){
        double hargaSetelahDiskon = total * (1 - diskon);
        double diskonMember = total - hargaSetelahDiskon;
        return String.valueOf(diskonMember);
    }

    private String hitungJumlahBayar(double total, double diskonMember, double diskon){
        double totalBayar = total - diskonMember - diskon;
        return String.valueOf(totalBayar);
    }

}