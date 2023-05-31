package spring.spring.domain.repo;

import spring.spring.domain.entities.HoSo;

import java.util.List;

public interface HoSoRepo {
    Boolean insertHoSo(HoSo hoSo);

    Boolean updateHoSo(HoSo hoSo);

    Boolean updateHoSo(List<HoSo> hoSo);

    Boolean deleteHoSo(String maHoSo);

    Boolean deleteHoSo(List<String> maHoSo);

    List<HoSo> getAllHoSo();

    List<HoSo> findHoSoByMaHoSo();

    List<HoSo> findHoSoByMaHoSoIn();

    List<HoSo> findHoSoByThuTuNguyenVong();

    List<HoSo> findHoSoBySoCCCD();

    List<HoSo> findHoSoByMaHocSinh();

    List<HoSo> findHoSoByTenHocSinh();

}
