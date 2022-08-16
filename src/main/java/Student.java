public class Student {
    private  int id;
    private String hoTen;
    private float chieuCao;
    private float canNang;

    public Student(int id, String hoTen, float chieuCao, float canNang) {
        this.id = id;
        this.hoTen = hoTen;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public float getCanNang() {
        return canNang;
    }

    public void setCanNang(float canNang) {
        this.canNang = canNang;
    }

    @Override
    public String toString() {
        return String.valueOf(id) +';' + hoTen + ';' + chieuCao + ';' + canNang;
    }
    public String toPrint(){
        String string = String.format("%-4d%-16s%-12.2f%.2f", id, hoTen, chieuCao, canNang);
        return string;
    }
}
