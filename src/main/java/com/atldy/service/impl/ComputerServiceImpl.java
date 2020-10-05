package com.atldy.service.impl;

import com.atldy.dao.IComputerDao;
import com.atldy.dao.impl.ComputerDaoImpl;
import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.ComputerType;
import com.atldy.domain.Coumpetrs;
import com.atldy.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐多山
 * @create 2020-09-30 9:17
 */
@Service
public class ComputerServiceImpl implements IComputerService {

    @Autowired
    private IComputerDao computerDao = new ComputerDaoImpl();

    /**
     * 查询全部分类
     *
     * @return
     */
    public List<ComputerType> findAllType() {
        return computerDao.findAllType();
    }

    /**
     * 添加电脑配件
     *
     * @param accessories
     */
    public void saveAccessories(ComputerAccessories accessories,Integer typeId) {
        ComputerType typeById = computerDao.findTypeById(typeId);
        accessories.setComputerType(typeById);
        computerDao.saveAccessories(accessories);
    }

    /**
     * 查询电脑配置列表
     *
     * @return
     */
    public List<ComputerAccessories> findAllAccessories() {
        return computerDao.findAllAccessories();
    }

    public List<Coumpetrs> findAllCoumpetrs() {
        return computerDao.findAllCoumpetrs();
    }

    /**
     * 添加电脑
     *
     * @param coumpetrs
     */
    public void saveCoumpetrs(Coumpetrs coumpetrs) {
        Integer memory = coumpetrs.getMemory();
        Integer cpu = coumpetrs.getCpu();
        Integer display = coumpetrs.getDisplay();
        Integer hdd = coumpetrs.getHdd();
        Integer videocard = coumpetrs.getVideocard();
        List<Integer> list = new ArrayList<Integer>();
        list.add(memory);
        list.add(cpu);
        list.add(display);
        list.add(videocard);
        list.add(hdd);
        computerDao.saveCoumpetrs(coumpetrs);
    }

    /**
     * 修改电脑
     *
     * @param coumpetrs
     */
    public void updateCoumpetrs(Coumpetrs coumpetrs) {
        computerDao.updateCoumpetrs(coumpetrs);
    }

    /**
     * 删除电脑
     *
     * @param id
     */
    public void delete(Integer id) {
        computerDao.delete(id);
    }

    /**
     * 根据id查询电脑
     * @param id
     * @return
     */
    public Coumpetrs findCoumpetrsByid(Integer id) {
        return computerDao.findCoumpetrsByid(id);
    }


}
