package com.atldy.service;

import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.ComputerType;
import com.atldy.domain.Coumpetrs;

import java.util.List;
import java.util.Map;

/**
 * @author 唐多山
 * @create 2020-09-30 9:06
 */
public interface IComputerService {

    /**
     * 查询全部分类
     * @return
     */
    List<ComputerType> findAllType();

    /**
     * 添加电脑配件
     */
    void saveAccessories(ComputerAccessories accessories);

    /**
     * 查询电脑配置列表
     */
    List<ComputerAccessories> findAllAccessories();

    /**
     * 查询全部电脑
     * @return
     */
    List<Coumpetrs>findAllCoumpetrs();

    /**
     * 添加电脑
     */
    void saveCoumpetrs(Coumpetrs coumpetrs);

    /**
     * 修改电脑
     */
    void  updateCoumpetrs(Coumpetrs coumpetrs);

    /**
     * 删除电脑
     */
    void delete(Integer id);


    /**
     * 根据id查询电脑
     * @param id
     * @return
     */
    Coumpetrs findCoumpetrsByid(Integer id);

     List<Map<String, Object>> findAllAccessoriesMap();

}
