package spring.spring.service;

import java.util.*;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import spring.spring.domain.entities.HoSo;
import spring.spring.domain.entities.NguyenVong;

@RestController
@Log4j2
public class QuanLyHoSo {
    Scanner sc = new Scanner(System.in);

    private List<HoSo> listHoSo = new ArrayList<>();
    private List<NguyenVong> listNguyenVong = new ArrayList<>();

    private int maHoSoMoi = 0;

    public QuanLyHoSo() {
        this.listHoSo = new ArrayList<>();
    }
    public List<HoSo> getListHoSo() {
        return listHoSo;
    }

    public void setListHoSo(List<HoSo> listHoSo) {
        this.listHoSo = listHoSo;
    }

    @PostMapping("/hoSo")
    public HoSo addHoSo(@RequestBody HoSo hoSo) {

        listHoSo.add(hoSo);
        return hoSo;
    }

    @GetMapping("/listHoSo")
    public List<HoSo> showHoSo() {
        return listHoSo;
    }

    @PutMapping("/hoSo")
    public HoSo suaDoiHoSo(@RequestBody HoSo hoSo) {
        for (int i =0; i<listHoSo.size(); i++) {
            if (listHoSo.get(i).getMaHoSo() == hoSo.getMaHoSo()) {
                listHoSo.set(i, hoSo);
                break;
            }
        }
        return hoSo;
    }

    @DeleteMapping("/user")
    public void xoaHoSo(@RequestParam(name = "maHoSo") int maHoSo) {
        try {
            listHoSo.remove(listHoSo.indexOf(maHoSo));
        }
        catch (Exception ex) {
            log.info("Hồ sơ ko tồn tại!");
        }
    }

    public List<HoSo> sapXepNoiBotTangDan(int doiTuongSapXep) {
        List<HoSo> copyListHoSo = new ArrayList<>();
        Collections.copy(copyListHoSo, getListHoSo());
        for (int i = 0; i < copyListHoSo.size() - 1; i++) {
            for (int j = copyListHoSo.size() - 1; j > i; j--) {
                if (doiTuongSapXep == 4) {
                    for (int k = 0; k < copyListHoSo.get(0).getMaHocSinh().length(); k++) {
                        if (copyListHoSo.get(j).getMaHocSinh().charAt(k) == copyListHoSo.get(j - 1).getMaHocSinh().charAt(k)) {
                            continue;
                        } else if (copyListHoSo.get(j).getMaHocSinh().charAt(k) < copyListHoSo.get(j - 1).getMaHocSinh().charAt(k)) {
                            HoSo bienLuuTru = copyListHoSo.get(j);
                            copyListHoSo.set(j, copyListHoSo.get(j - 1));
                            copyListHoSo.set(j - 1, bienLuuTru);
                        }
                        break;
                    }
                }else

                if (doiTuongSapXep == 6) {
                    if (copyListHoSo.get(j).getTuoi() < copyListHoSo.get(j - 1).getTuoi()) {
                        HoSo bienLuuTru = copyListHoSo.get(j);
                        copyListHoSo.set(j, copyListHoSo.get(j - 1));
                        copyListHoSo.set(j - 1, bienLuuTru);
                    }
                    else if (copyListHoSo.get(j).getTuoi() == copyListHoSo.get(j - 1).getTuoi()) {
                        if (copyListHoSo.get(j).getMaHoSo() < copyListHoSo.get(j-1).getMaHoSo()) {
                            HoSo bienLuuTru = copyListHoSo.get(j);
                            copyListHoSo.set(j, copyListHoSo.get(j - 1));
                            copyListHoSo.set(j - 1, bienLuuTru);
                        }
                    }
                }
            }
        }
        return copyListHoSo;
    }

    public List<HoSo> sapXepLuaChonGiamDan(int doiTuongSapXep) {
        List<HoSo> copyListHoSo = new ArrayList<>();
        Collections.copy(copyListHoSo, getListHoSo());
        for (int i = 0; i < copyListHoSo.size() - 1; i++) {
            for (int j = i + 1; j < copyListHoSo.size(); j++) {
                if (doiTuongSapXep == 3) {
                    if (copyListHoSo.get(i).getMaHoSo() < copyListHoSo.get(j).getMaHoSo()) {
                        HoSo bienLuuTru = copyListHoSo.get(i);
                        copyListHoSo.set(i, copyListHoSo.get(j));
                        copyListHoSo.set(j, bienLuuTru);
                    }
                }else

                if (doiTuongSapXep == 5) {
                    for (int k = 0; k < copyListHoSo.get(0).getMaHocSinh().length(); k++) {
                        if (copyListHoSo.get(i).getMaHocSinh().charAt(k) == copyListHoSo.get(j).getMaHocSinh().charAt(k)) {
                            continue;
                        } else if (copyListHoSo.get(i).getMaHocSinh().charAt(k) < copyListHoSo.get(j).getMaHocSinh().charAt(k)) {
                            HoSo bienLuuTru = copyListHoSo.get(i);
                            copyListHoSo.set(i, copyListHoSo.get(j));
                            copyListHoSo.set(j, bienLuuTru);
                        }
                        break;
                    }
                }else

                if (doiTuongSapXep == 7) {
                    if (copyListHoSo.get(i).getTuoi() < copyListHoSo.get(j).getTuoi()) {
                        HoSo bienLuuTru = copyListHoSo.get(i);
                        copyListHoSo.set(i, copyListHoSo.get(j));
                        copyListHoSo.set(j, bienLuuTru);
                    } else
                        if (copyListHoSo.get(i).getTuoi() == copyListHoSo.get(j).getTuoi()) {
                            if (copyListHoSo.get(i).getMaHoSo() < copyListHoSo.get(j).getMaHoSo()) {
                                HoSo bienLuuTru = copyListHoSo.get(i);
                                copyListHoSo.set(i, copyListHoSo.get(j));
                                copyListHoSo.set(j, bienLuuTru);
                            }
                        }
                }
            }
        }
        return copyListHoSo;
    }

    public List<HoSo> timKiemHoSo() {
        List<HoSo> hoSoTimThay = new ArrayList<>();

        log.info("=============================================");
        log.info("\t1. Tìm kiếm theo mã hồ sơ\t");
        log.info("\t2. Tìm kiếm theo mã học sinh\t");
        log.info("\t3. Tìm kiếm theo số CCCD\t");
        log.info("\t4. Tìm kiếm theo tên\t");
        log.info("\t5. Tìm kiếm theo nguyện vọng\t");
        log.info("=============================================");
        log.info("Mời lựa chọn: ");
        int choose;
        while (true) {
            try {
                choose = Integer.parseInt(sc.nextLine());
                if (choose >= 1 && choose <= 5) break;
                else throw new Exception();
            } catch (Exception ex) {
                log.info("Lựa chọn không hợp lệ! Mời chọn lại: ");
            }
        }
        switch (choose) {
            case 1:
                log.info("-Nhập mã hồ sơ: ");
                try {
                    int maHoSoTimKiem = Integer.parseInt(sc.nextLine());
//                    hoSoTimThay = new ArrayList<>();
                    for (HoSo hoSo :
                            getListHoSo()) {
                        if (hoSo.getMaHoSo() == maHoSoTimKiem) {
                            hoSoTimThay.add(hoSo);
                            return hoSoTimThay;
                        }
                    }
                } catch (Exception ex) {
                    log.info("Không tìm thấy mã hồ sơ!!!");
                }
                log.info("Không tìm thấy hồ sơ!!!");
                break;
            case 2:
                log.info("-Nhập mã học sinh: ");

                String maHocSinhTimKiem = sc.nextLine();
//                hoSoTimThay = new ArrayList<>();
                for (HoSo hoSo :
                        getListHoSo()) {
                    if (hoSo.getMaHocSinh().equals(maHocSinhTimKiem)) {
                        hoSoTimThay.add(hoSo);
                        return hoSoTimThay;
                    }
                }
                log.info("Không tìm thấy hồ sơ!!!");
                break;
            case 3:
                log.info("-Nhập số CCCD: ");

                String soCccdTimKiem = sc.nextLine();
//                hoSoTimThay = new ArrayList<>();
                for (HoSo hoSo :
                        getListHoSo()) {
                    if (hoSo.getCccd().equals(soCccdTimKiem)) {
                        hoSoTimThay.add(hoSo);
                        return hoSoTimThay;
                    }
                }
                log.info("Không tìm thấy hồ sơ!!!");
                break;
            case 4:
                log.info("-Nhập họ tên học sinh: ");
                String hoTenTimKiem = sc.nextLine();
                for (HoSo hoSo :
                        getListHoSo()) {
                    if (hoSo.getHoTenHocSinh().equals(hoTenTimKiem)) {
                        hoSoTimThay.add(hoSo);
                    }
                }
                if (hoSoTimThay.size() > 0)
                return hoSoTimThay;
                else {
                    log.info("Không tìm thấy hồ sơ!!!");
                    break;
                }
            case 5:
                log.info("-Nhập mã trường đăng ký nguyện vọng: ");
                String maTruongTimKiem = sc.nextLine();
                log.info("-Nhập thứ tự nguyện vọng đăng ký mã trường "+maTruongTimKiem+" : ");
                int thuTuTimKiem = 0;
                try {
                    thuTuTimKiem = Integer.parseInt(sc.nextLine());
                }
                catch (Exception ex) {
                    log.info("Lỗi nhập dữ liệu!");
                }
                for (HoSo hoSo :
                        getListHoSo()) {
                    for (NguyenVong nguyenVong :
                            hoSo.getListNguyenVong()) {
                        if (nguyenVong.getMaTruong().equals(maTruongTimKiem) && nguyenVong.getThuTu() == thuTuTimKiem) {
                            hoSoTimThay.add(hoSo);
                            break;
                        }
                    }
                }
                if (hoSoTimThay.size() > 0) return hoSoTimThay;
                else {
                    log.info("Không tìm thấy hồ sơ!!!");
                    break;
                }
        }

        return hoSoTimThay;
    }

}
