package com.example.quiz1zaki;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Barang implements Parcelable {

    private String  nama,kodeBrg,namaBrg,hargaBrg,totHarga,diskHarga,diskMember,jlhBayar,tipeMember;

    public Barang() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKodeBrg() {
        return kodeBrg;
    }

    public void setKodeBrg(String kodeBrg) {
        this.kodeBrg = kodeBrg;
    }

    public String getNamaBrg() {
        return namaBrg;
    }

    public void setNamaBrg(String namaBrg) {
        this.namaBrg = namaBrg;
    }

    public String getHargaBrg() {
        return hargaBrg;
    }

    public void setHargaBrg(String hargaBrg) {
        this.hargaBrg = hargaBrg;
    }

    public String getTotHarga() {
        return totHarga;
    }

    public void setTotHarga(String totHarga) {
        this.totHarga = totHarga;
    }

    public String getDiskHarga() {
        return diskHarga;
    }

    public void setDiskHarga(String diskHarga) {
        this.diskHarga = diskHarga;
    }

    public String getDiskMember() {
        return diskMember;
    }

    public void setDiskMember(String diskMember) {
        this.diskMember = diskMember;
    }

    public String getJlhBayar() {
        return jlhBayar;
    }

    public void setJlhBayar(String jlhBayar) {
        this.jlhBayar = jlhBayar;
    }

    protected Barang(Parcel in) {
        nama = in.readString();
        kodeBrg = in.readString();
        namaBrg = in.readString();
        hargaBrg = in.readString();
        totHarga = in.readString();
        diskHarga = in.readString();
        diskMember = in.readString();
        jlhBayar = in.readString();
        tipeMember = in.readString();
    }

    public static final Creator<Barang> CREATOR = new Creator<Barang>() {
        @Override
        public Barang createFromParcel(Parcel in) {
            return new Barang(in);
        }

        @Override
        public Barang[] newArray(int size) {
            return new Barang[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTipeMember() {
        return tipeMember;
    }

    public void setTipeMember(String tipeMember) {
        this.tipeMember = tipeMember;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(kodeBrg);
        dest.writeString(namaBrg);
        dest.writeString(hargaBrg);
        dest.writeString(totHarga);
        dest.writeString(diskHarga);
        dest.writeString(diskMember);
        dest.writeString(jlhBayar);
        dest.writeString(tipeMember);
    }
}
