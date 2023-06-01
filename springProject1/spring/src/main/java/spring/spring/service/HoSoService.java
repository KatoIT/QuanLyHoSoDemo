package spring.spring.service;

import spring.spring.domain.entities.HoSo;
import spring.spring.domain.repo.HoSoRepo;
import spring.spring.domain.response.BaseResponse;

import java.util.List;

public interface HoSoService {
    List<HoSo> getData();

    BaseResponse insertHoSo(HoSo hoSo);

    BaseResponse updateHoSo(HoSo hoSo);

    BaseResponse updateHoSo(List<HoSo> hoSoList);

    BaseResponse deleteHoSo(int maHoSo);

    BaseResponse deleteHoSo(List<Integer> listMaHoSo);

    boolean checkData(HoSo hoSo, List<HoSo> hoSoList);

    boolean checkMaHoSo(int maHoSo, List<HoSo> listHoSo);

    //    BaseResponse findHoSo();

    //    BaseResponse findAllHoSo();
    HoSo findHoSoByMaHoSo(int maHoSo, List<HoSo> hoSoList);

//    List<HoSo> findHoSoByMaHoSoIn();

    List<HoSo> findHoSoByThuTuNguyenVong(String maTruong, int thuTuNguyenVong, List<HoSo> hoSoList);


    HoSo findHoSoBySoCCCD(String cccd, List<HoSo> hoSoList);

    HoSo findHoSoByMaHocSinh(String maHocSinh, List<HoSo> hoSoList);

    List<HoSo> findHoSoByTenHocSinh(String hoTenHocSinh, List<HoSo> hoSoList);
}
