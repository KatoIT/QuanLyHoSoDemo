package spring.spring.domain.entities;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Log4j2
public class NguyenVong {
    private int thuTu;
    private String maNganh;
    private String tenNganh;
    private String maTruong;
    private String tenTruong;

    public NguyenVong() {

    }
    public NguyenVong(int thuTu, String maNganh, String tenNganh, String maTruong, String tenTruong) {
        this.thuTu = thuTu;
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
    }
    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }
    public int getThuTu() {
        return thuTu;
    }
    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
    public String getMaNganh() {
        return maNganh;
    }
    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }
    public String getTenNganh() {
        return tenNganh;
    }
    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }
    public String getMaTruong() {
        return maTruong;
    }
    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }
    public String getTenTruong() {
        return tenTruong;
    }
    public List<NguyenVong> nhapNguyenVong() {
        Scanner sc = new Scanner(System.in);
        log.info("-Mời bạn nhập số lượng nguyện vọng(Tối đa 20): ");
        int soNguyenVong = sc.nextInt();
        while (soNguyenVong <= 0 || soNguyenVong > 20) {
            log.info("Vui lòng nhập lại số lượng nguyện vọng: ");
            soNguyenVong = sc.nextInt();
        }
        log.info("\nBạn hãy điền đầy đủ vào các nguyện vọng: ");
        List<Integer> nguyenVongDaTao = new ArrayList<>(soNguyenVong);
        List<NguyenVong> listNguyenVong = new ArrayList<>(soNguyenVong);
        for (int i = 0; i < soNguyenVong; i++) {
            log.info("\nNguyện vọng số: ");
            while (true) {
                this.thuTu = sc.nextInt();
                if(this.thuTu <= 0 || this.thuTu > soNguyenVong) {
                    log.info("Nguyện vọng ko hợp lệ! Vui lòng nhập lại: ");
                    continue;
                }else
                if(nguyenVongDaTao.contains(this.thuTu)) {
                    log.info("Nguyện vọng " + this.thuTu + " đã tồn tại! Vui lòng nhập lại: ");
                    continue;
                }
                nguyenVongDaTao.add(this.thuTu);
                break;
            }
            sc.nextLine(); //chẳng may trôi lệnh

            log.info("\tMã ngành: ");
            this.maNganh = sc.nextLine();
            log.info("\tTên ngành(độ dài 2 ký tự trở lên, chỉ gồm các ký tự a-z, A-Z, 1-9, dấu cách): ");
            String regexTenNganh = "[a-zA-Z1-9 ]{2,}";
            this.tenNganh = sc.nextLine();
            while (!this.tenNganh.matches(regexTenNganh)) {
                log.info("Tên ngành ko hợp lệ! Vui lòng nhập lại: ");
                this.tenNganh = sc.nextLine();
            }
            log.info("\tMã trường: ");
            this.maTruong = sc.nextLine();
            log.info("\tTên trường(độ dài 2 ký tự trở lên, chỉ gồm các ký tự a-z, A-Z, 1-9, dấu cách): ");
            String regexTenTruong = "[a-zA-Z1-9 ]{2,}";
            this.tenTruong = sc.nextLine();
            while (!this.tenTruong.matches(regexTenTruong)) {
                log.info("Tên trường ko hợp lệ! Vui lòng nhập lại: ");
                this.tenTruong = sc.nextLine();
            }
            NguyenVong newNguyenVong = new NguyenVong(thuTu, maNganh, tenNganh, maTruong, tenTruong);
            listNguyenVong.add(newNguyenVong);
        }
        return listNguyenVong;
    }
    public List<NguyenVong> nhapNguyenVongTest() {
        List<NguyenVong> listNguyenVong = new ArrayList<>();
        NguyenVong newNguyenVong = new NguyenVong(1, "IT12345", "CNTT", "", "1");
        listNguyenVong.add(newNguyenVong);
        return listNguyenVong;
    }

    @Override
    public String toString() {
        String s = "\t+Nguyện vọng: "+getThuTu()+"\t Mã ngành: "+getMaNganh()+"\t Tên ngành: "+getTenNganh()+"\t Mã trường: "+getMaTruong()+"\t Tên trường: "+getTenTruong()+"\n";
        return s;
    }


}
