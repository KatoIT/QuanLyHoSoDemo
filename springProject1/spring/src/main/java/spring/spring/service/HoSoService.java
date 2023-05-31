package spring.spring.service;

import spring.spring.domain.entities.HoSo;
import spring.spring.domain.response.BaseResponse;

public interface HoSoService {
    BaseResponse insertHoSo(HoSo hoSo);
    BaseResponse updateHoSo(HoSo hoSo);
    BaseResponse deleteHoSo(String maHoSo);
    BaseResponse findHoSo();
    BaseResponse findAllHoSo();
}
