package tugaskuliah;

public class tugas {
    private String judul;
    private String mataKuliah;
    private String deadline;
    private boolean selesai;

    public tugas(String judul, String mataKuliah, String deadline) {
        this.judul = judul;
        this.mataKuliah = mataKuliah;
        this.deadline = deadline;
        this.selesai = false;
    }

    public String getJudul() {
        return judul;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void setSelesai(boolean selesai) {
        this.selesai = selesai;
    }
}