package com.atldy.dao;

import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.ComputerType;
import com.atldy.domain.Coumpetrs;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 唐多山
 * @create 2020-09-30 9:21
 */
public interface IComputerDao {


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
     * 查询全部配件
     * @param id
     * @return
     */
    ComputerAccessories findAccessoriesById(Integer id);

    /**
     * 根据id查询电脑
     * @param id
     * @return
     */
    Coumpetrs findCoumpetrsByid(Integer id);


    /**
     * 根据id查询分类
     * @param typeId
     * @return
     */
    ComputerType findTypeById(Integer typeId);
}
