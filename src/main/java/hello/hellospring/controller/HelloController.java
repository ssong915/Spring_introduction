package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody //HTTP body에 내용을 직접 넣어주겠다!
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
        //그럼 위에 넘이랑 차이는? 태그들 하나도없이 return값만 전달되는 것
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
