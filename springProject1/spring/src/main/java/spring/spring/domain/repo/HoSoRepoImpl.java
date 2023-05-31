package spring.spring.domain.repo;

import org.springframework.stereotype.Repository;
import spring.spring.domain.entities.HoSo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HoSoRepoImpl implements HoSoRepo {
    List<HoSo> hoSoList= new ArrayList<>();

    public List<HoSo> getHoSoList() {
        return hoSoList;
    }

    public void setHoSoList(List<HoSo> hoSoList) {
        this.hoSoList = hoSoList;
    }

    @Override
    public Boolean insertHoSo(HoSo hoSo) {
        return null;
    }

    @Override
    public Boolean updateHoSo(HoSo hoSo) {
        return null;
    }

    @Override
    public Boolean updateHoSo(List<HoSo> hoSo) {
        return null;
    }

    @Override
    public Boolean deleteHoSo(String maHoSo) {
        return null;
    }

    @Override
    public Boolean deleteHoSo(List<String> maHoSo) {
        return null;
    }
    @Override
    public List<HoSo> getAllHoSo() {
        return null;
    }

    @Override
    public List<HoSo> findHoSoByMaHoSo() {
        return null;
    }

    @Override
    public List<HoSo> findHoSoByMaHoSoIn() {
        return null;
    }

    @Override
    public List<HoSo> findHoSoByThuTuNguyenVong() {
        return null;
    }

    @Override
    public List<HoSo> findHoSoBySoCCCD() {
        return null;
    }

    @Override
    public List<HoSo> findHoSoByMaHocSinh() {
        return null;
    }

    @Override
    public List<HoSo> findHoSoByTenHocSinh() {
        return null;
    }

}
