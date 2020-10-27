package com.helpdesk.HelpDesk.Controllers;

import com.helpdesk.HelpDesk.DAO.RequestDAO;
import com.helpdesk.HelpDesk.DAO.UserDAO;
import com.helpdesk.HelpDesk.Forms.CreateRequestForm;
import com.helpdesk.HelpDesk.Models.Request;
import com.helpdesk.HelpDesk.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RequestDAO requestDAO;

    //Crear solicitud
    @GetMapping("/user/create-request")
    public String createRequestUserDefault(Model model){
        model.addAttribute("createRequestForm", new CreateRequestForm());
        return "create-request-user";
    }

    @PostMapping("/user/create-request")
    public String createRequestUserPost(@ModelAttribute CreateRequestForm form, Model model){
        User user = userDAO.selectUser("rcalvom").iterator().next();
        Request request = new Request(form.getDescription(), user);
        request.setId("FI0001");
        boolean a = requestDAO.insert(request);

        return "redirect:/user/my-requests";
    }

    //Mis solicitudes
    @GetMapping("/user/my-requests")
    public String myRequestsUserDefault(Model model){
        // TODO: Hacer la busqueda de las solicitudes que ha pedido el usuario
        /* List<Request> requests = new ArrayList<Request>();
        requests = lista con las solicitudes de la base de datos filtrada por el usuario
        model.addAttribute("Requests", list);*/
        return "my-requests-user";
    }

    @PostMapping("/user/my-requests")
    public String myRequestsUserPost(Model model){
        // TODO: Revisar si este controlador sirve para algo
        return "my-requests-user";
    }

    //Detalles de la solicitud usuario
    @GetMapping("/user/details/{id}")
    public String requestDetailsUserDefault(@PathVariable("id") String id, Model model){
        // TODO: Con el id del formilario pasar toda la información a un objeto request
        // Request RequestDetail = Buscar la solicitud en la BD
        // model.addAttribute("requestDetail", RequestRetail;
        return "request-details-user";
    }

    @PostMapping("request-details-user/{id}")
    public String requestDetailsUserPost(@PathVariable("id") String id, Model model){
        return "request-details-user";
    }
}