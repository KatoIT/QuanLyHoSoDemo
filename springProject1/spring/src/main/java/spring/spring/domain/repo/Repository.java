package spring.spring.domain.repo;

import spring.spring.domain.entities.HoSo;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<HoSo> hoSoList= new ArrayList<>();

    public List<HoSo> getHoSoList() {
        return hoSoList;
    }

    public void setHoSoList(List<HoSo> hoSoList) {
        this.hoSoList = hoSoList;
    }
}
