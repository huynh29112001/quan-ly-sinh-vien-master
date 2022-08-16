import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<Student>();

        while (true) {
            System.out.println("Chọn lệnh: ");
            System.out.println("1: Thêm sinh viên.");
            System.out.println("2: Sửa thông tin.");
            System.out.println("3: Xóa thông tin.");
            System.out.println("4: Hiển thị danh sách.");
            Scanner sc = new Scanner(System.in);
            int command = sc.nextInt();
            Main main = new Main();

            if (command == 1) {
                main.addStudent();

            } else if (command == 2) {
                main.editStudent();
            } else if (command == 3) {
                main.deleteStudent();
            }else if(command == 4){
                main.displayList();
            }

        }
    }

    public void addStudent() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Nhập id: ");
        int id = sc2.nextInt();

        System.out.print("Nhập họ tên: ");
        sc2.nextLine();
        String hoTen = sc2.nextLine();

        System.out.print("Nhập chiều cao: ");
        float chieuCao = sc2.nextFloat();

        System.out.print("Nhập cân nặng: ");
        float canNang = sc2.nextFloat();
        Student student = new Student(id, hoTen, chieuCao, canNang);

        try {
            FileWriter fw = new FileWriter("data.txt", true);
            BufferedWriter fbw = new BufferedWriter(fw);
            fbw.newLine();
            fbw.write(student.toString());

            fbw.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        System.out.println("Add done");
    }

    public void editStudent() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Nhap id cần sửa: ");
        int id = sc2.nextInt();

        System.out.print("Nhập họ tên: ");
        sc2.nextLine();
        String hoTen = sc2.nextLine();

        System.out.print("Nhập chiều cao: ");
        int chieuCao = sc2.nextInt();

        System.out.print("Nhập cân nặng: ");
        float canNang = sc2.nextFloat();
        Student student = new Student(id, hoTen, chieuCao, canNang);

        List<Student> lines = new ArrayList<>();
        editProcess(lines, student);

    }

    public void editProcess(List lines, Student student) {
        try {
            String line = "";
            File f1 = new File("data.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] token = line.split(";");
                int id = Integer.parseInt(token[0]);
                String hoTen = token[1];
                float chieuCao = Float.parseFloat(token[2]);
                float canNang = Float.parseFloat(token[3]);
                if (id == student.getId()) {
                    lines.add(student);
                } else lines.add(new Student(id, hoTen, chieuCao, canNang));
            }

            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for (Object s : lines){
                out.write(s.toString());
                out.newLine();
            }


            out.flush();
            out.close();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteStudent() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Nhap id cần xóa: ");
        int id = sc2.nextInt();

        List<Student> lines = new ArrayList<>();
        try {
            String line = "";
            File f1 = new File("data.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] token = line.split(";");
                int idFile = Integer.parseInt(token[0]);
                String hoTen = token[1];
                float chieuCao = Float.parseFloat(token[2]);
                float canNang = Float.parseFloat(token[3]);
                if (id != idFile) {
                    lines.add(new Student(idFile, hoTen, chieuCao, canNang));
                }
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for (Object s : lines){
                out.write(s.toString());
                out.newLine();
            }

            out.flush();
            out.close();
            fw.close();
            System.out.println("Delete Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void displayList() {
        List<Student> lines = new ArrayList<>();
        try {
            String line = "";
            File f1 = new File("data.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                String[] token = line.split(";");
                int idFile = Integer.parseInt(token[0]);
                String hoTen = token[1];
                float chieuCao = Float.parseFloat(token[2]);
                float canNang = Float.parseFloat(token[3]);

                lines.add(new Student(idFile, hoTen, chieuCao, canNang));
            }
        } catch (Exception e) {

        }
        System.out.printf("ID\tHọ tên\t\t\tChiều cao\tCân nặng\n");
        for (Student o : lines) {
            System.out.println(o.toPrint());
        }
    }
}
