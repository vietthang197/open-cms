package vn.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.neo.entity.Words;
import vn.neo.services.DataService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private final DataService dataService;

    public HomeController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public String index(@RequestParam(required = false) String searchEn, @RequestParam(required = false) String searchVi, @RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, Model model) throws ParseException {
        List<Words> words = dataService.findAllWords(searchEn, searchVi, fromDate, toDate);
        model.addAttribute("words", words);
        return "index";
    }

    @PostMapping
    public String postindex(String en, String vi) {
        Words words = new Words();
        words.setEn(en.toLowerCase());
        words.setVi(vi.toLowerCase());
        words.setCreatedDate(new Date());
        dataService.saveWords(words);
        return "redirect:/";
    }

    @PostMapping("/delete-word")
    public String deleteindex(Long id) {
        dataService.deleteWord(id);
        return "redirect:/";
    }

}
