package com.atldy.servlet;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.atldy.domain.CommonResult;
import com.atldy.domain.ComputerType;
import com.atldy.service.IComputerService;
import com.atldy.service.impl.ComputerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 唐多山
 * @create 2020-09-29 21:57
 */
@WebServlet("/type")
public class TypeServlet extends HttpServlet {

    private IComputerService computerService=new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        获取分类数据
        List<ComputerType> allType = computerService.findAllType();
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),allType);
    }
}
