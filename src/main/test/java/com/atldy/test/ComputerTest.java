package com.atldy.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.atldy.dao.IComputerDao;
import com.atldy.domain.CommonResult;
import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.ComputerType;
import com.atldy.domain.Coumpetrs;
import com.atldy.service.IComputerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 唐多山
 * @create 2020-09-30 9:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ComputerTest {


    @Autowired
    private IComputerService computerService;

    @Autowired
    private IComputerDao computerDao;

    @Test
    public void testFindAllType() throws JsonProcessingException {
        List<ComputerType> allType = computerService.findAllType();
//        for (ComputerType computerType : allType) {
//            System.out.println("computerType = " + computerType.getTypeId()+"----"+computerType.getTypename());
//        }
//        JSON parse = JSONUtil.parse(allType);
//        System.out.println("parse = " + parse);
        //        把对象转为json
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonType = objectMapper.writeValueAsString(allType);
        System.out.println("jsonType = " + jsonType);
    }

    @Test
    public void testsaveAconsie() {
        ComputerAccessories accessories = new ComputerAccessories();
        accessories.setTypeId(1);
        accessories.setCapacity(null);
        accessories.setPrice(633);
        computerService.saveAccessories(accessories);
    }

    @Test
    public void testfindAllAccessories() {
        List<ComputerAccessories> allAccessories = computerService.findAllAccessories();
//        for (ComputerAccessories allAccessory : allAccessories) {
//            System.out.println("allAccessory = " + allAccessory);
//        }
        CommonResult<List<ComputerAccessories>> listCommonResult = new CommonResult<List<ComputerAccessories>>();
        listCommonResult.setCode(200);
        listCommonResult.setMessage("查询成功");
        listCommonResult.setData(allAccessories);
        JSON parse = JSONUtil.parse(listCommonResult);
        System.out.println("parse = " + parse);
    }

    @Test
    public void testfindCoumpetrs() {
        List<Coumpetrs> coumpetrsList = computerService.findAllCoumpetrs();

        Coumpetrs coumpetrs = coumpetrsList.get(0);
        System.out.println("coumpetrs = " + coumpetrs);
        Integer memory = coumpetrs.getMemory();
        Integer cpu = coumpetrs.getCpu();
        Integer display = coumpetrs.getDisplay();
        Integer videocard = coumpetrs.getVideocard();
        Integer hdd = coumpetrs.getHdd();
        List<Integer> list = new ArrayList<Integer>();
        list.add(memory);
        list.add(cpu);
        list.add(display);
        list.add(videocard);
        list.add(hdd);
        System.out.println(list);
    }

    @Test
    public void testFindByCoumputersId() {
        List<Coumpetrs> coumpetrsList = computerService.findAllCoumpetrs();

        Coumpetrs coumpetrs = coumpetrsList.get(0);

        Integer memory = coumpetrs.getMemory();
        Integer cpu = coumpetrs.getCpu();
        Integer display = coumpetrs.getDisplay();
        Integer videocard = coumpetrs.getVideocard();
        Integer hdd = coumpetrs.getHdd();
        List<Integer> list = new ArrayList<Integer>();
        list.add(memory);
        list.add(cpu);
        list.add(display);
        list.add(hdd);
        list.add(videocard);
        List<ComputerAccessories> accessories=new ArrayList<ComputerAccessories>();
        for (Integer integer : list) {
            ComputerAccessories ComputerAccessoriesById = computerDao.findAccessoriesById(integer);
            accessories.add(ComputerAccessoriesById);
        }
        System.out.println("accessories = " + accessories);
//        int sum=0;
//        for ( ComputerAccessories accessory : accessories) {
//            sum=sum+accessory.getPrice();
//        }
//        System.out.println("sum = " + sum);
    }
    @Test
    public void test(){
        List<Map<String, Object>> allAccessoriesMap = computerDao.findAllAccessoriesMap();
        System.out.println("allAccessoriesMap = " + allAccessoriesMap);
    }

}
