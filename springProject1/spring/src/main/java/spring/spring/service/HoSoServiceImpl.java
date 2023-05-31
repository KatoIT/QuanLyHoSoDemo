package spring.spring.service;

import org.springframework.stereotype.Service;
import spring.spring.domain.entities.HoSo;
import spring.spring.domain.repo.HoSoRepo;
import spring.spring.domain.repo.HoSoRepoImpl;
import spring.spring.domain.response.BaseResponse;

@Service
public class HoSoServiceImpl implements HoSoService {
    private final HoSoRepo hoSoRepo;

    HoSoServiceImpl(HoSoRepoImpl hoSoRepo) {
        this.hoSoRepo = hoSoRepo;
    }

    @Override
    public BaseResponse insertHoSo(HoSo hoSo) {
        return null;
    }

    @Override
    public BaseResponse updateHoSo(HoSo hoSo) {
        return null;
    }

    @Override
    public BaseResponse deleteHoSo(String maHoSo) {
        return null;
    }

    @Override
    public BaseResponse findHoSo() {
        return null;
    }

    @Override
    public BaseResponse findAllHoSo() {
        return null;
    }
}
