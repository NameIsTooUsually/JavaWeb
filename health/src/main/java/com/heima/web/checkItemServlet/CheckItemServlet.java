package com.heima.web.checkItemServlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.QueryDTO;
import com.heima.pojo.PageBeanResult;
import com.heima.service.CheckItemService;
import com.heima.service.impl.CheckItemServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkitem/findPage.do")
public class CheckItemServlet extends HttpServlet {
    CheckItemService checkItemService = new CheckItemServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //获取参数
        QueryDTO queryDTOJson = JSON.parseObject(request.getReader().readLine(), QueryDTO.class);


        //调用方法
        PageBeanResult pageBeanResult = checkItemService.selectByPage(queryDTOJson);
        pageBeanResult.setFlag(true);
        pageBeanResult.setMessage("成功");

        //转换成json
        String checkItemJsonStr = JSON.toJSONString(pageBeanResult);

        //响应数据
        response.getWriter().write(checkItemJsonStr);

    }
}
