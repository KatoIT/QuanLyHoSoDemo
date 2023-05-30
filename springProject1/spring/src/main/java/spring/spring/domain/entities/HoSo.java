package spring.spring.domain.entities;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Log4j2
public class HoSo {
    private int maHoSo;
    private String maHocSinh;
    private String hoTenHocSinh;
    private int tuoi;
    private String cccd;
    private List<NguyenVong> listNguyenVong = new ArrayList<>();

    public HoSo() {

    }

    public HoSo(int maHoSo, String maHocSinh, String hoTenHocSinh, int tuoi, String cccd, List<NguyenVong> listNguyenVong) {
        this.maHoSo = maHoSo;
        this.maHocSinh = maHocSinh;
        this.hoTenHocSinh = hoTenHocSinh;
        this.tuoi = tuoi;
        this.cccd = cccd;
        this.listNguyenVong = listNguyenVong;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(int maHoSo) {
        this.maHoSo = maHoSo;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getHoTenHocSinh() {
        return hoTenHocSinh;
    }

    public void setHoTenHocSinh(String hoTenHocSinh) {
        this.hoTenHocSinh = hoTenHocSinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public List<NguyenVong> getListNguyenVong() {
        return listNguyenVong;
    }

    public void setListNguyenVong(List<NguyenVong> listNguyenVong) {
        this.listNguyenVong = listNguyenVong;
    }

    public String xuatDanhSachNguyenVong() {
        String s = "";
        Iterator listNguyenVong = getListNguyenVong().iterator();
        while (listNguyenVong.hasNext()) {
            s += "\n" + listNguyenVong.next().toString();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "=====MÃ HỒ SƠ: " + getMaHoSo() + "\t-Mã học sinh: " + getMaHocSinh() + "\t-Họ tên học sinh: " + getHoTenHocSinh() + "\t-Tuổi: " + getTuoi() + "\t-Số CCCD: " + getCccd() + "\t-Danh sách nguyện vọng: " + xuatDanhSachNguyenVong();
        return s;
    }
}
