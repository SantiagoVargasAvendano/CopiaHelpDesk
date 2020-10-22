package com.helpdesk.HelpDesk.Controllers;

import com.helpdesk.HelpDesk.Forms.CreateRequestForm;
import com.helpdesk.HelpDesk.Forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainControllers {

    // Vistas del Login

    @GetMapping("/login")
    public String loginDefault(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(@ModelAttribute LoginForm form, Model model){
        if(form.getUserName().equals("savargas")){
            return "redirect:/create-request-user";
        }else if(form.getUserName().equals("rcalvom")){
            return "redirect:/requestAgent";
        }// Es necesario hacer acá el login con respecto a la BD
        return "login";
    }

        // Controladores del Usuario

    //Crear solicitud
    @GetMapping("/create-request-user")
    public String createRequestUserDefault(Model model){
        model.addAttribute("createRequestForm", new CreateRequestForm());
        List<String> categorias = new ArrayList<String>();
        categorias.add("Juan");
        // La lista va a ser la busqueda de las categorias en la BD
        model.addAttribute("opcionesCategorias", categorias);
        return "create-request-user";
    }
    @PostMapping("/create-request-user")
    public String createRequestUserPost(@ModelAttribute CreateRequestForm form, Model model){
        return "redirect:/myRequestsUser";
    }

    //Mis solicitudes
    @GetMapping("/myRequestsUser")
    public String myRequestsUserDefault(Model model){
        /* List<car> list = new ArrayList<car>();
        list.add(new car("IWR","Rojo"));
        list.add(new car("IRS","Azul"));
        Lista con las solicitudes de la base de datos filtrada por el usuario
        model.addAttribute("Requests", list);*/
        return "myRequestsUser";
    }
    @PostMapping("/myRequestsUser")
    public String myRequestsUserPost(Model model){
        return "myRequestsUser";
    }
}
