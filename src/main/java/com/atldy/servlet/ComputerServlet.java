package com.atldy.servlet;

import com.atldy.domain.CommonResult;
import com.atldy.domain.ComputerAccessories;
import com.atldy.domain.Coumpetrs;
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
import java.util.List;
import java.util.Map;

/**
 * @author 唐多山
 * @create 2020-10-05 15:15
 */
@WebServlet("/computer")
public class ComputerServlet extends HttpServlet {

    private IComputerService computerService = new ComputerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断功能
        String action = request.getParameter("action");
        //查询全部配件
        if (action.equals("listAccessories")) {
            List<ComputerAccessories> allAccessories = computerService.findAllAccessories();
            //序列化json
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(), allAccessories);
        }

        //添加电脑
        if (action.equals("save")) {
            try {
                Coumpetrs coumpetrs = new Coumpetrs();
                Map<String, String[]> parameterMap = request.getParameterMap();
                BeanUtils.populate(coumpetrs, parameterMap);
                System.out.println(coumpetrs);
                computerService.saveCoumpetrs(coumpetrs);
                CommonResult commonResult = new CommonResult(200, "添加配件失败--->o(╥﹏╥)o");
                ObjectMapper mapper = new ObjectMapper();
                response.setContentType("application/json;charset=utf-8");
                mapper.writeValue(response.getOutputStream(), commonResult);
            } catch (Exception e) {
                throw new RuntimeException("封装数据失败了");
            }
        }

    }
}
