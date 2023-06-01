package spring.spring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring.spring.domain.entities.HoSo;
import spring.spring.domain.entities.NguyenVong;
import spring.spring.domain.repo.HoSoRepo;
import spring.spring.domain.repo.HoSoRepoImpl;
import spring.spring.domain.response.BaseResponse;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class HoSoServiceImpl implements HoSoService {
    private final HoSoRepo hoSoRepo;


    public HoSoServiceImpl(HoSoRepoImpl hoSoRepo) {
        this.hoSoRepo = hoSoRepo;
    }
//    public HoSoServiceImpl() {}

    @Override
    public List<HoSo> getData() {
        return hoSoRepo.getAllHoSo();
    }

    @Override
    public BaseResponse insertHoSo(HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        response.setFail();
        if (hoSoRepo.insertHoSo(hoSo)) {
            response.setSuccess();
        }
        return response;
    }

    @Override
    public BaseResponse updateHoSo(HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        response.setFail();
        if (hoSoRepo.updateHoSo(hoSo)) {
            response.setSuccess();
        }
        return response;
    }

    @Override
    public BaseResponse updateHoSo(List<HoSo> hoSoList) {
        BaseResponse response = new BaseResponse();
        response.setFail();
        if (hoSoRepo.updateHoSo(hoSoList)) {
            response.setSuccess();
        }
        return response;
    }

    @Override
    public BaseResponse deleteHoSo(int maHoSo) {
        BaseResponse response = new BaseResponse();
        response.setFail();
        if (hoSoRepo.deleteHoSo(maHoSo)) {
            response.setSuccess();
        }
        return response;
    }

    @Override
    public BaseResponse deleteHoSo(List<Integer> listMaHoSo) {
        BaseResponse response = new BaseResponse();
        response.setFail();
        if (hoSoRepo.deleteHoSo(listMaHoSo)) {
            response.setSuccess();
        }
        return response;
    }

//    @Override
//    public BaseResponse findHoSo() {
//        return null;
//    }
//
//    @Override
//    public BaseResponse findAllHoSo() {
//        return null;
//    }

    @Override
    public boolean checkData(HoSo hoSo, List<HoSo> hoSoList) {
        boolean result = true;
        if (hoSo.getMaHoSo() < 0) {
            log.info("Mã hồ sơ ko hợp lệ!");
            result = false;
        }
//        else {
//            for (HoSo hoso :
//                    hoSoList) {
//                if (hoSo.getMaHoSo() == hoso.getMaHoSo()) {
//                    log.info("Mã hồ sơ đã tồn tại!");
//                    result = false;
//                }
//            }
//        }
        if (!hoSo.getMaHocSinh().matches("[A-Z]{2}[1-9]{5}")) {
            log.info("Mã học sinh ko hợp lệ!");
            result = false;
        } else {
            for (HoSo hoso :
                    hoSoList) {
                if (hoSo.getMaHocSinh().equals(hoso.getMaHocSinh())) {
                    log.info("Mã học sinh đã tồn tại!");
                    result = false;
                }
            }
        }
        if (hoSo.getTuoi() < 18 || hoSo.getTuoi() > 60) {
            log.info("Tuổi của b ko hợp lệ!");
            result = false;
        } else {
            Math.floor(hoSo.getTuoi());
        }
        if (!hoSo.getCccd().matches("[0-9]{12}")) {
            log.info("CCCD ko hợp lệ!");
            result = false;
        } else {
            for (HoSo hoso :
                    hoSoList) {
                if (hoSo.getCccd().equals(hoso.getCccd())) {
                    log.info("CCCD đã tồn tại!");
                    result = false;
                }
            }
        }
        if (hoSo.getListNguyenVong().size() <= 0 || hoSo.getListNguyenVong().size() >= 20) {
            log.info("Nguyện vọng ko đc để trống và ko đc quá 20!");
            result = false;
        }
        return result;
    }

    @Override
    public boolean checkMaHoSo(int maHoSo, List<HoSo> listHoSo) {
        for (HoSo hoSo :
                listHoSo) {
            if (hoSo.getMaHoSo() == maHoSo) {
                listHoSo.remove(hoSo);
                return true;
            }
        }
        return false;
    }

    @Override
    public HoSo findHoSoByMaHoSo(int maHoSo, List<HoSo> hoSoList) {
        for (HoSo hoSo :
                hoSoList) {
            if (hoSo.getMaHoSo() == maHoSo) {
                return hoSo;
            }
        }
        log.info("Ko tìm thấy hồ sơ nào!");
        return null;
    }

    @Override
    public List<HoSo> findHoSoByMaHoSoIn(List<HoSo> hoSoList, int[] listMaHoSo) {
        List<HoSo> hoSoTimThay = new ArrayList<>();
        for (int maHoSo :
                listMaHoSo) {
            for (HoSo hoSo :
                    hoSoList) {
                if (hoSo.getMaHoSo() == maHoSo) {
                    hoSoTimThay.add(hoSo);
                    break;
                }
            }
        }
        return hoSoTimThay;
    }

    @Override
    public List<HoSo> findHoSoByThuTuNguyenVong(String maTruong, int thuTuNguyenVong, List<HoSo> hoSoList) {
        List<HoSo> hoSoTimThay = new ArrayList<>();
        for (HoSo hoSo : hoSoList
        ) {
            for (NguyenVong nguyenVong :
                    hoSo.getListNguyenVong()) {
                if (nguyenVong.getMaTruong().equals(maTruong) && nguyenVong.getThuTu() == thuTuNguyenVong) {
                    hoSoTimThay.add(hoSo);
                    break;
                }
            }
        }
        return hoSoTimThay;
    }

    @Override
    public HoSo findHoSoBySoCCCD(String cccd, List<HoSo> hoSoList) {
        for (HoSo hoSo :
                hoSoList) {
            if (hoSo.getCccd().equals(cccd)) {
                return hoSo;
            }
        }
        return null;
    }

    @Override
    public HoSo findHoSoByMaHocSinh(String maHocSinh, List<HoSo> hoSoList) {
        for (HoSo hoSo :
                hoSoList) {
            if (hoSo.getMaHocSinh().equals(maHocSinh)) {
                return hoSo;
            }
        }
        return null;
    }

    @Override
    public List<HoSo> findHoSoByTenHocSinh(String hoTenHocSinh, List<HoSo> hoSoList) {
        List<HoSo> hoSoTimThay = new ArrayList<>();
        for (HoSo hoSo :
                hoSoList) {
            if (hoSo.getHoTenHocSinh().equals(hoTenHocSinh)) {
                hoSoTimThay.add(hoSo);
            }
        }
        return hoSoTimThay;
    }
}
