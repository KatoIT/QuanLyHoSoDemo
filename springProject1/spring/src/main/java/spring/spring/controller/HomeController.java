package spring.spring.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import spring.spring.domain.entities.HoSo;
import spring.spring.domain.response.BaseResponse;

@Log4j2
@RestController
@RequestMapping("/hoso")
public class HomeController {
    @PostMapping("/create")
    public BaseResponse addHoSo(@RequestBody HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây

            response.setSuccess();
        } catch (Exception e) {
            response.setFail();
        }
        return response;
    }

    @PostMapping("/update")
    public BaseResponse updateHoSo(@RequestBody HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây

            response.setSuccess();
        } catch (Exception e) {
            response.setFail();
        }
        return response;
    }
    @DeleteMapping("/delete")
    public BaseResponse deleteHoSo(@RequestParam String maHoSo) {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây

            response.setSuccess();
        } catch (Exception e) {
            response.setFail();
        }
        return response;
    }
    @PostMapping("/get")
    public BaseResponse getHoSo(@RequestBody HoSo hoSo) {
        BaseResponse response = new BaseResponse();
        try {
            // TODO xử lý nghiệp vụ tại đây

            response.setSuccess();
        } catch (Exception e) {
            response.setFail();
        }
        return response;
    }

}
