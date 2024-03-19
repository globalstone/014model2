package spring.model2.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class DispatcherServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
        System.out.println("\n [DispatcherServlet.servicE() start.......]");

        String actionPage = this.getURI(req.getRequestURI());
        System.out.println("::URI ? => "+req.getRequestURI());
        System.out.println("::client�� �䱸������? : "+actionPage);

        req.setCharacterEncoding("euc-kr");

        Controller controller = null;

        ControllerMapping cf = ControllerMapping.getInstance();
        controller = cf.getController(actionPage);

//        ����� �κ�
//        controller.execute(req,res);
        
        ModelAndView modelAndView = controller.execute(req,res);
        new ViewResolver().forward(req,res,modelAndView);
        System.out.println("[DispatcherServlet.service() end.....]");
    }

    private String getURI(String requestURI) {
        int start = requestURI.lastIndexOf('/')+1;
        int end = requestURI.lastIndexOf(".do");
        String actionPage = requestURI.substring(start,end);
        return actionPage;
    }
}