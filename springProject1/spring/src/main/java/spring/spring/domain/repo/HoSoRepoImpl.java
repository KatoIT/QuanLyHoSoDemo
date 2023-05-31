package spring.spring.domain.repo;

import org.springframework.stereotype.Repository;
import spring.spring.domain.entities.HoSo;
import spring.spring.service.HoSoService;
import spring.spring.service.HoSoServiceImpl;

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
        HoSoService hoSoService = new HoSoServiceImpl(new HoSoRepoImpl());
        if (hoSoService.checkData(hoSo, hoSoList)) {
            hoSoList.add(hoSo);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateHoSo(HoSo hoSo) {
        HoSoService hoSoService = new HoSoServiceImpl(new HoSoRepoImpl());
        if (hoSoService.checkData(hoSo, hoSoList)) {
            for (int i = 0; i<hoSoList.size(); i++) {
                if (hoSoList.get(i).getMaHoSo() == hoSo.getMaHoSo()) {
                    hoSoList.set(i, hoSo);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateHoSo(List<HoSo> hoSo) {
        HoSoService hoSoService = new HoSoServiceImpl(new HoSoRepoImpl());
        for (HoSo hoso :
                hoSo) {
            if (hoSoService.checkData(hoso, hoSoList)) {
                for (int i = 0; i<hoSoList.size(); i++) {
                    if (hoSoList.get(i).getMaHoSo() == hoso.getMaHoSo()) {
                        hoSoList.set(i, hoso);
                    }
                    else return false;
                }
            }
        }

        return true;
    }

    @Override
    public Boolean deleteHoSo(int maHoSo) {
        HoSoService hoSoService = new HoSoServiceImpl(new HoSoRepoImpl());
        if (hoSoService.checkMaHoSo(maHoSo, hoSoList)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteHoSo(List<Integer> maHoSo) {
        HoSoService hoSoService = new HoSoServiceImpl(new HoSoRepoImpl());
        for (Integer idHoSo :
                maHoSo) {
            if (hoSoService.checkMaHoSo(idHoSo, hoSoList)) {

            }
            else return false;
        }
        return true;
    }
    @Override
    public List<HoSo> getAllHoSo() {
        return hoSoList;
    }

//    @Override
//    public List<HoSo> findHoSoByMaHoSo() {
//        return null;
//    }
//
//    @Override
//    public List<HoSo> findHoSoByMaHoSoIn() {
//        return null;
//    }
//
//    @Override
//    public List<HoSo> findHoSoByThuTuNguyenVong() {
//        return null;
//    }
//
//    @Override
//    public List<HoSo> findHoSoBySoCCCD() {
//        return null;
//    }
//
//    @Override
//    public List<HoSo> findHoSoByMaHocSinh() {
//        return null;
//    }
//
//    @Override
//    public List<HoSo> findHoSoByTenHocSinh() {
//        return null;
//    }

}
