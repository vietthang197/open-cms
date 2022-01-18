package vn.neo.controller;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private final Enforcer enforcer;

    public HomeController(Enforcer enforcer) {
        this.enforcer = enforcer;
    }

    @GetMapping
    public boolean test() {
        return enforcer.enforce("p", "c");
    }
}
