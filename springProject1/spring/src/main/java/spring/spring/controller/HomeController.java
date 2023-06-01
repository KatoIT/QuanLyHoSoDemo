package spring.spring.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import spring.spring.domain.entities.HoSo;
import spring.spring.domain.repo.HoSoRepoImpl;
import spring.spring.domain.response.BaseResponse;
import spring.spring.service.HoSoService;
import spring.spring.service.HoSoServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/hoso")
public class HomeController {
    private final HoSoService hoSoService = new HoSoServiceImpl(new HoSoRepoImpl());

//    HomeController(HoSoServiceImpl hoSoService) {
//        this.hoSoService = hoSoService;
//    }

    @PostMapping("/create")
    public BaseResponse addHoSo(@RequestBody HoSo hoSo) {
        log.info("Add hồ sơ mới");
        return hoSoService.insertHoSo(hoSo);
    }
    @GetMapping("/getData")
    public List<HoSo> getData() {
        log.info("Hiển thị danh sách hồ sơ");
        if (hoSoService.getData().size() <= 0) {
            log.info("Danh sách hồ sơ trống!");
        }
        return hoSoService.getData();
    }

    @PutMapping("/edit")
    public BaseResponse edit(@RequestBody HoSo hoSo) {
        log.info("Update hồ sơ");
        return hoSoService.updateHoSo(hoSo);
    }
    @PutMapping("/editMany")
    public BaseResponse editMany(@RequestBody List<HoSo> hoSoList) {
        log.info("Update nhiều hồ sơ");
        return hoSoService.updateHoSo(hoSoList);
    }

    @DeleteMapping("/delete")
    public BaseResponse delete(@RequestParam int maHoSo) {
        log.info("Xóa hồ sơ");
        return hoSoService.deleteHoSo(maHoSo);
    }
    @DeleteMapping("/deleteMany")
    public BaseResponse deleteMany(@RequestParam List<Integer> listMaHoSo) {
        log.info("Xóa nhiều hồ sơ");
        return hoSoService.deleteHoSo(listMaHoSo);
    }

    @GetMapping("/findByMaHoSo")
    public HoSo findByMaHoSo(@RequestParam int maHoSo) {
        log.info("Tìm kiếm hồ sơ theo mã hồ sơ");
        return hoSoService.findHoSoByMaHoSo(maHoSo, hoSoService.getData());
    }

    @GetMapping("/findByMaHoSoIn")
    public List<HoSo> findHoSoByMaHoSoIn(@RequestParam int...listMaHoSo) {
        log.info("Tìm kiếm hồ sơ theo mã hồ sơ(có thể tìm nhiều mã)");
        return hoSoService.findHoSoByMaHoSoIn(hoSoService.getData(), listMaHoSo);
    }

    @GetMapping("/findByNguyenVong")
    public List<HoSo> findHoSoByThuTuNguyenVong(@RequestParam String maTruong, @RequestParam int thuTuNguyenVong) {
        log.info("Tìm kiếm hồ sơ theo nguyện vọng");
        return hoSoService.findHoSoByThuTuNguyenVong(maTruong, thuTuNguyenVong, hoSoService.getData());
    }

    @GetMapping("/findByCccd")
    public HoSo findByCccd(@RequestParam String soCccd) {
        log.info("Tìm kiếm hồ sơ theo số CCCD");
        return hoSoService.findHoSoBySoCCCD(soCccd, hoSoService.getData());
    }
}
