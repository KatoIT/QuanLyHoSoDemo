package spring.spring.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import spring.spring.domain.entities.HoSo;
import spring.spring.domain.response.BaseResponse;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/hoso")
public class HomeController {
    List<HoSo> hoSoList = new ArrayList<>();

    @PostMapping("/create")
    public BaseResponse addHoSo(@RequestBody HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây
            validateData(hoSo, response);
            if (response.getCode() == 0) {
                hoSoList.add(hoSo);
            }

        } catch (Exception e) {
            response.setFail();
        }
        return response;
    }

    @PutMapping("/update")
    public BaseResponse updateHoSo(@RequestBody HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây
            validateData(hoSo, response);
            if (response.getCode() == 0) {
                for (int i = 0; i < hoSoList.size(); i++) {
                    if (hoSoList.get(i).getMaHoSo() == hoSo.getMaHoSo()) {
                        hoSoList.set(i, hoSo);
                        return response.setSuccess();
                    }
                }
            }
        } catch (Exception e) {
            response.setFail();
        }
        return response;
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteHoSo(@RequestParam int maHoSo) {
        BaseResponse response = new BaseResponse();
        if (hoSoList.size() <= 0) {
            return response.setFail("Danh sách hồ sơ trống!");
        }
        try {
            // TODO xử lý nghiệp vụ tại đây
            for (int i = 0; i < hoSoList.size(); i++) {
                if (hoSoList.get(i).getMaHoSo() == maHoSo) {
                    hoSoList.remove(i);
                    return response.setSuccess();
                }
            }

        } catch (Exception e) {
            response.setFail("Ko tìm đc mã hồ sơ!!!");
        }
        return response;
    }

    @GetMapping("/get")
    public List<HoSo> getHoSo() {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây
            response.setSuccess();
        } catch (Exception e) {
            response.setFail();
        }
        return hoSoList;
    }

    public void validateData(HoSo hoSo, BaseResponse response) {
        if (hoSo.getMaHoSo() < 0) {
            response.setFail("Mã hồ sơ ko hợp lệ!");
        } else {
            for (HoSo hoso :
                    hoSoList) {
                if (hoSo.getMaHoSo() == hoso.getMaHoSo()) {
                    response.setFail("Mã hồ sơ đã tồn tại!");
                }
            }
        }
        if (!hoSo.getMaHocSinh().matches("[A-Z]{2}[1-9]{5}")) {
            response.setFail("Mã học sinh ko hợp lệ!");
        } else {
            for (HoSo hoso :
                    hoSoList) {
                if (hoSo.getMaHocSinh().equals(hoso.getMaHocSinh())) {
                    response.setFail("Mã học sinh đã tồn tại!");
                }
            }
        }
        if (hoSo.getTuoi() < 18 || hoSo.getTuoi() > 60) {
            response.setFail("Tuổi của b ko hợp lệ!");
        } else {
            Math.floor(hoSo.getTuoi());
        }
        if (!hoSo.getCccd().matches("[0-9]{12}")) {
            response.setFail("CCCD ko hợp lệ!");
        } else {
            for (HoSo hoso :
                    hoSoList) {
                if (hoSo.getCccd().equals(hoso.getCccd())) {
                    response.setFail("CCCD đã tồn tại!");
                }
            }
        }
        if (hoSo.getListNguyenVong().size() <= 0 || hoSo.getListNguyenVong().size() >= 20) {
            response.setFail("Nguyện vọng ko đc để trống và ko đc quá 20!");
        }
    }
}
