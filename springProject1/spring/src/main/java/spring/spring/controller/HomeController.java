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
        return hoSoService.insertHoSo(hoSo);
    }
    @GetMapping("/getData")
    public List<HoSo> getData() {
        return hoSoService.getData();
    }

    @PutMapping("/edit")
    public BaseResponse edit(@RequestBody HoSo hoSo) {
        return hoSoService.updateHoSo(hoSo);
    }
    @PutMapping("/editMany")
    public BaseResponse editMany(@RequestBody List<HoSo> hoSoList) {
        return hoSoService.updateHoSo(hoSoList);
    }

    @DeleteMapping("/delete")
    public BaseResponse delete(@RequestParam int maHoSo) {
        return hoSoService.deleteHoSo(maHoSo);
    }
    @DeleteMapping("/deleteMany")
    public BaseResponse deleteMany(@RequestParam List<Integer> listMaHoSo) {
        return hoSoService.deleteHoSo(listMaHoSo);
    }

    @GetMapping("/findByMaHoSo")
    public HoSo findByMaHoSo(@RequestParam int maHoSo) {
        return hoSoService.findHoSoByMaHoSo(maHoSo, hoSoService.getData());
    }

    @GetMapping("/findByNguyenVong")
    public List<HoSo> findHoSoByThuTuNguyenVong(@RequestParam String maTruong, @RequestParam int thuTuNguyenVong) {
        return hoSoService.findHoSoByThuTuNguyenVong(maTruong, thuTuNguyenVong, hoSoService.getData());
    }

    @GetMapping("/findByCccd")
    public HoSo findByCccd(@RequestParam String soCccd) {
        return hoSoService.findHoSoBySoCCCD(soCccd, hoSoService.getData());
    }
}
