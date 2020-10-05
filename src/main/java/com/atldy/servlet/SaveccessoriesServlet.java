package com.atldy.servlet;

import com.atldy.domain.CommonResult;
import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.ComputerType;
import com.atldy.service.IComputerService;
import com.atldy.service.impl.ComputerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 唐多山
 * @create 2020-09-30 11:58
 */
@WebServlet("/saveCcessories")
public class SaveccessoriesServlet extends HttpServlet {

    private IComputerService computerService=new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取表单提交的数据
        Map<String, String[]> parameterMap = request.getParameterMap();

        ComputerAccessories computerAccessories = new ComputerAccessories();
        try {
            BeanUtils.populate(computerAccessories, parameterMap);
            System.out.println("computerAccessories = " + computerAccessories);
            computerService.saveAccessories(computerAccessories);
            CommonResult commonResult = new CommonResult(200,"添加配件失败--->o(╥﹏╥)o");
            ObjectMapper mapper=new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),commonResult);
        } catch (Exception e) {
            throw new RuntimeException("封装数据失败了");
        }


    }
}
