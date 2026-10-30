package tugaskuliah;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<tugas> daftarTugas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            tampilMenu();
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    tambahTugas();
                    break;
                case 2:
                    lihatTugas();
                    break;
                case 3:
                    tandaiSelesai();
                    break;
                case 0:
                    System.out.println("Terima kasih, semangat kuliahnya!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 0);
    }

    static void tampilMenu() {
        System.out.println("\n=== APLIKASI TUGAS KULIAH ===");
        System.out.println("1. Tambah tugas");
        System.out.println("2. Lihat daftar tugas");
        System.out.println("3. Tandai tugas selesai");
        System.out.println("0. Keluar");
    }

    static void tambahTugas() {
        System.out.print("Judul tugas   : ");
        String judul = input.nextLine();
        System.out.print("Mata kuliah   : ");
        String mk = input.nextLine();
        System.out.print("Deadline      : ");
        String deadline = input.nextLine();

        daftarTugas.add(new tugas(judul, mk, deadline));
        System.out.println("Tugas berhasil ditambahkan!");
    }

    static void lihatTugas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.");
            return;
        }

        System.out.println("\n--- Daftar Tugas ---");
        for (int i = 0; i < daftarTugas.size(); i++) {
            tugas t = daftarTugas.get(i);
            String status = t.isSelesai() ? "[Selesai]" : "[Belum]";
            System.out.println((i + 1) + ". " + status + " " + t.getJudul()
                    + " (" + t.getMataKuliah() + ") - Deadline: " + t.getDeadline());
        }
    }

    static void tandaiSelesai() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.");
            return;
        }

        lihatTugas();
        System.out.print("Nomor tugas yang selesai: ");

        try {
            int nomor = Integer.parseInt(input.nextLine());
            if (nomor >= 1 && nomor <= daftarTugas.size()) {
                daftarTugas.get(nomor - 1).setSelesai(true);
                System.out.println("Tugas ditandai selesai!");
            } else {
                System.out.println("Nomor tidak ada di daftar.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka.");
        }
    }
}