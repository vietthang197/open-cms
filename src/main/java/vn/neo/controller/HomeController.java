package vn.neo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.neo.exception.BusinessException;
import vn.neo.services.DataService;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private final DataService dataService;

    public HomeController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public int test() throws BusinessException, InterruptedException {
        return dataService.testNow(getSession());
    }

    private String getSession() throws InterruptedException {
        Thread.sleep(10_000);
        return "xxx";
    }
}
