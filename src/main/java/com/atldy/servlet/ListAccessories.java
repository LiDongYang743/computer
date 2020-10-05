package com.atldy.servlet;

import com.atldy.domain.ComputerAccessories;
import com.atldy.service.IComputerService;
import com.atldy.service.impl.ComputerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 唐多山
 * @create 2020-10-04 19:12
 */
@WebServlet("/list_accessories")
public class ListAccessories extends HttpServlet {

    private IComputerService computerService = new ComputerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询全部配件
        List<ComputerAccessories> allAccessories = computerService.findAllAccessories();
        //序列化json
        ObjectMapper mapper = new ObjectMapper();
        //把返回数据写到前台
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), allAccessories);
    }
}
