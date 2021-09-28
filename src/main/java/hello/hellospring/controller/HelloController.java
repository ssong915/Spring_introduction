package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") // "/hello"
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //localhost:8080/hello-mvc?name=songkyung
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // RequestParam : 외부에서 string 받기
        model.addAttribute("name", name);
        return "hello-template";
    }
}
