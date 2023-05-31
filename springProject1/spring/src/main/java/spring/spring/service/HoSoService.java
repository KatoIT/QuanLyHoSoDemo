package spring.spring.service;

import spring.spring.domain.entities.HoSo;
import spring.spring.domain.response.BaseResponse;

import java.util.List;

public interface HoSoService {
    List<HoSo> getData();
    BaseResponse insertHoSo(HoSo hoSo);
    BaseResponse updateHoSo(HoSo hoSo);
    BaseResponse updateHoSo(List<HoSo> hoSoList);
    BaseResponse deleteHoSo(int maHoSo);
    BaseResponse deleteHoSo(List<Integer> listMaHoSo);
//    BaseResponse findHoSo();
//    BaseResponse findAllHoSo();

    boolean checkData(HoSo hoSo, List<HoSo> hoSoList);
    boolean checkMaHoSo(int maHoSo, List<HoSo> listHoSo);
}
