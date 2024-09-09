package de.WaDelch.RequestCatcher.Controller;


import de.WaDelch.RequestCatcher.Model.Request;
import de.WaDelch.RequestCatcher.Repository.ReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ReqRepository reqRepos;

    @GetMapping("/")
    public String loadIndex(Model model) {
        List<Request> reqList = (List<Request>)reqRepos.findAll();
        model.addAttribute("reqList", reqList);
        model.addAttribute("numReq", reqRepos.count());
        return "index";
    }
}