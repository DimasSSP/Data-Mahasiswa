/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.text.ParseException;
/**
 *
 * @author LENOVO
 */
public class MenuUtama {
    ArrayList<String> name = new ArrayList();
    ArrayList<String> nim = new ArrayList();
    ArrayList<Date> tglLahir = new ArrayList();
    ArrayList<Integer> gender = new ArrayList();
    Scanner input = new Scanner(System.in);
    
    void pilihMenu() throws ParseException{
        OUTER:
        while(true){
            System.out.println("+-------------------------+");
            System.out.println("|        Menu Utama       |");
            System.out.println("+-------------------------+");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari data");
            System.out.println("4. Tampil Data");
            System.out.println("5. Keluar");
            System.out.println("---------------------------");
            System.out.print("Pilih Menu Nomor : ");
            int pilih = input.nextInt();
            
            if (pilih == 1){
                System.out.println("------------------------");
                System.out.println("|    Menu Tambah Data   |");
                System.out.println("------------------------");
                System.out.println("Masukan Data yang akan ditambahkan");
                System.out.print("Masukan Nim : ");
                String nimx = input.next();
                nim.add(nimx);
                System.out.print("Masuka Nama : ");
                String nama = input.next();
                name.add(nama);
                System.out.print("Masukan tanggal Lahir (dd/mm/yy) : ");
                String tanggal = input.next();
                SimpleDateFormat F1 = new SimpleDateFormat("dd/MM/yy");
                Date date1 = F1.parse(tanggal);
                tglLahir.add(date1);
                System.out.print("Jenis Kelamin (0:Laki-laki / 1:Perempuan ) :");
                int kelamin = input.nextInt();
                gender.add(kelamin);
                
            }else if(pilih == 2){
                System.out.println("--------------------------");
                System.out.println("|     Menu Hapus Data     |");
                System.out.println("--------------------------");
                System.out.println("Masukan NIM yang akan dihapus datanya");
                System.out.print("Nim : ");
                String nimx = input.next();
                int data = Collections.binarySearch(nim, nimx);
                name.remove(data);
                nim.remove(data);
                tglLahir.remove(data);
                gender.remove(data);
                
            }else if(pilih == 3){
                System.out.println("--------------------------");
                System.out.println("|      Menu Cari Data     |");
                System.out.println("--------------------------");
                System.out.println("Pilih cara pencarian :");
                System.out.println("1. Cari berdasarkan Gender");
                System.out.println("2. Cari berdasarkan NIM");
                System.out.print("Pilihan : ");
                int pilihan = input.nextInt();
                switch (pilihan){
                    case 1 :
                        System.out.println("\\-- Berdasarkan Gender --\\");
                        System.out.print("Masukan Gender (0:Laki-laki / 1:Perempuan) : ");
                        int kelamin = input.nextInt();
                        for(int x = 0; x < nim.size(); x++){
                            if(gender.get(x) == kelamin){
                                System.out.println("-------------------");
                                System.out.println("Nim : " + nim.get(x));
                                System.out.println("Nama : " + name.get(x));
                                System.out.println("Tanggal lahir : " + tglLahir.get(x));
                                System.out.println("Jenis Kelamin : " + gender.get(x));
                                System.out.println("");
                            } else if(gender.get(x) == kelamin){
                                System.out.println("-------------------");
                                System.out.println("Nim : " + nim.get(x));
                                System.out.println("Nama : " + name.get(x));
                                System.out.println("Tanggal lahir : " + tglLahir.get(x));
                                System.out.println("Jenis Kelamin : " + gender.get(x));
                                System.out.println("");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\\-- Berdasarkan NIM --\\");
                        System.out.print("Masukan Nim :");
                        String nimx = input.next();
                        int data = Collections.binarySearch(nim, nimx);
                        String cariNama = name.get(data);
                        String cariNim = nim.get(data);
                        Date cariTanggal = tglLahir.get(data);
                        int cariGender = gender.get(data);
                        System.out.println("-------------------");
                        System.out.println("Nim : " + cariNim);
                        System.out.println("Nama : " + cariNama);
                        System.out.println("Tanggal lahir : " + cariTanggal);
                        System.out.println("Jenis Kelamin : " + cariGender);
                        System.out.println("");
                        
                    default :
                        System.out.println("Mohon Maaf, Perintah yang anda masukan Salah");
                        
                } break;
                
            }else if(pilih == 4){
                System.out.println(" ---------------------------- ");
                System.out.println("|      Menu Tampil Data      |");
                System.out.println(" ---------------------------- ");
                    if(nim.size() <= 0){
                        System.out.println("| Maaf Data Masih Kosong!!!|");
                    } else {
                        System.out.println("| Menampilkan Data Mahasiswa |");
                        for(int x = 0; x < nim.size(); x++){
                            System.out.println(" ---------------------------- ");
                            System.out.println("NIM : "+nim.get(x));
                            System.out.println("Nama : "+name.get(x));
                            System.out.println("Tanggal Lahir : "+tglLahir.get(x));                        
                            if (gender.get(x) ==0 ) {
                                String genders = "Laki-laki";
                                System.out.println("Jenis Kelamin : " + genders);
                            } else if (gender.get(x) == 1) {
                                String genders = "Perempuan";
                                System.out.println("Jenis Kelamin : " + genders);
                            }                                                
                        }
                        System.out.println("Jumlah Mahasiswa : " + nim.size());
                        System.out.println(" ---------------------------- ");
                    }
            }else if(pilih == 5){
                System.out.println("Selamat Tinggal");
                break;
            }
        }
        
    }
}
