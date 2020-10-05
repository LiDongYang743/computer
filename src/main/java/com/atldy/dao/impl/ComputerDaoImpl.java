package com.atldy.dao.impl;

import com.atldy.dao.IComputerDao;
import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.ComputerType;
import com.atldy.domain.Coumpetrs;
import com.atldy.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 唐多山
 * @create 2020-09-30 9:22
 */
@Repository
public class ComputerDaoImpl implements IComputerDao {


    private JdbcTemplate jdbcTemplate = JDBCUtil.getJdbcTemplate();

    /**
     * 查询全部分类
     *
     * @return
     */
    public List<ComputerType> findAllType() {
        List<ComputerType> computerTypes = jdbcTemplate.query("select * from computer_type", new BeanPropertyRowMapper<ComputerType>(ComputerType.class));
        return computerTypes;
    }

    /**
     * 添加电脑配件
     *
     * @param accessories
     */
    public void saveAccessories(ComputerAccessories accessories) {
        jdbcTemplate.update("insert into computer_accessories(Type_id,Component_name,capacity,price) values (?,?,?,?)",
                accessories.getComputerType().getTypeId(), accessories.getComponentName(), accessories.getCapacity(), accessories.getPrice());
    }

    /**
     * 查询电脑配置列表
     *
     * @return
     */
    public List<ComputerAccessories> findAllAccessories() {
        List<ComputerAccessories> query = jdbcTemplate.query("SELECT * FROM computer_accessories", new BeanPropertyRowMapper<ComputerAccessories>(ComputerAccessories.class));
        return query;
    }

    /**
     * 查询全部电脑
     *
     * @return
     */
    public List<Coumpetrs> findAllCoumpetrs() {
        List<Coumpetrs> coumpetrs = jdbcTemplate.query("SELECT * FROM  coumpetrs", new BeanPropertyRowMapper<Coumpetrs>(Coumpetrs.class));
        return coumpetrs;
    }

    /**
     * 添加电脑
     *
     * @param coumpetrs
     */
    public void saveCoumpetrs(Coumpetrs coumpetrs) {
        jdbcTemplate.update("INSERT INTO coumpetrs (Computer_name,MEMORY,cpu,videocard,display,hdd,price) VALUES (?,?,?,?,?,?,?)",
                coumpetrs.getComputerName(), coumpetrs.getMemory(), coumpetrs.getCpu(), coumpetrs.getVideocard(), coumpetrs.getDisplay(), coumpetrs.getHdd(), coumpetrs.getPrice());
    }

    /**
     * 修改电脑
     *
     * @param coumpetrs
     */
    public void updateCoumpetrs(Coumpetrs coumpetrs) {

    }

    /**
     * 删除电脑
     *
     * @param id
     */
    public void delete(Integer id) {
        jdbcTemplate.update("delete from coumpetrs where computer_id ", id);
    }


    /**
     * 询配件的价格
     *
     * @param id
     * @return
     */
    public ComputerAccessories findAccessoriesById(Integer id) {
        try {
            List<ComputerAccessories> ComputerAccessories = jdbcTemplate.query("SELECT computer_accessories.* FROM computer_accessories,coumpetrs WHERE computer_accessories.component_id=?", new BeanPropertyRowMapper<ComputerAccessories>(ComputerAccessories.class), id);
            if (ComputerAccessories.size() >= 1 || ComputerAccessories != null) {
                return ComputerAccessories.get(0);
            } else {
                throw new RuntimeException("你的返回值为空");
            }
        } catch (Exception e) {
            throw new RuntimeException("你的返回值异常");
        }
    }

    /**
     * 根据id查询电脑
     *
     * @param id
     * @return
     */
    public Coumpetrs findCoumpetrsByid(Integer id) {
        try {
            List<Coumpetrs> Coumpetrs = jdbcTemplate.query("SELECT computer_accessories.* FROM coumpetrs WHERE  computer_id=?", new BeanPropertyRowMapper<Coumpetrs>(Coumpetrs.class), id);
            if (Coumpetrs.size() == 1) {
                return Coumpetrs.get(0);
            } else {
                throw new RuntimeException("你的返回值异常");
            }
        } catch (Exception e) {
            throw new RuntimeException("你的返回值异常");
        }
    }

    /**
     * 根据id查询类别
     * @param typeId
     * @return
     */
    public ComputerType findTypeById(Integer typeId) {
        ComputerType computerType = jdbcTemplate.queryForObject("select * from computer_type where Type_id=? ", new BeanPropertyRowMapper<ComputerType>(ComputerType.class), typeId);
        return computerType;
    }

}
