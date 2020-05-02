package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    @RequestMapping({"owners", "owners/index", "owner/index.html"})
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
