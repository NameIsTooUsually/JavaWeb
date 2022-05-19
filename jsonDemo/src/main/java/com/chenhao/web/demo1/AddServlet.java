package com.chenhao.web.demo1;

        import com.alibaba.fastjson.JSON;
        import com.chenhao.pojo.Brand;
        import com.chenhao.service.impl.BrandServiceImpl;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.BufferedReader;
        import java.io.IOException;

@WebServlet("/AddServlet1")
public class AddServlet extends HttpServlet {
    BrandServiceImpl brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        //获取参数，用json方式获取参数，就不能用getparameter方法了
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //将获取到的json数据转换成对象
        Brand brand = JSON.parseObject(s, Brand.class);

        //调用方法
        brandService.add(brand);

        //添加成功后，响应数据
        response.getWriter().write("success");
    }
}
