package com.helpdesk.HelpDesk.Controllers;

import com.helpdesk.HelpDesk.Forms.*;
import com.helpdesk.HelpDesk.Repository.*;
import com.helpdesk.HelpDesk.Models.Request;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainControllers {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;


}

