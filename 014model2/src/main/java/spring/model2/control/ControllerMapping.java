package spring.model2.control;

import spring.model2.service.user.view.HomeController;
import spring.model2.service.user.view.LogonActionController;
import spring.model2.service.user.view.LogonController;

public class ControllerMapping {

    private static ControllerMapping controllerMapping;

    private ControllerMapping(){
    }
    
    // if controllerMapping == null 없으면 new ControllerMapping 만들고 리턴
    // 있으면  controllerMapping 리턴 
    public static ControllerMapping getInstance(){
        if(controllerMapping == null){
            controllerMapping = new ControllerMapping();
        }
        return controllerMapping;
    }

    public Controller getController(String actionPage) {
        System.out.println("[ControllerMappinggetController() start.....]");

        Controller controller = null;

        if(actionPage.equals("logon")){
            controller = new LogonController();
        }else if(actionPage.equals("logonAction")){
            controller = new LogonActionController();
        }else if(actionPage.equals("home")){
            controller = new HomeController();
        }
        /*
        }else if (actionPage.equals("member")){
            action = new MemberAction();
        }else if (actionPage.equals("logout")){
            action = new LogoutAction();
        }
         */

        System.out.println("[ ControllerMapping.getController() end .......]");

        return controller;
    }
}