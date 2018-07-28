package springdubbo.springdubbofilter.contreller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyController {

    @GetMapping("/testUrl")
    public String testUrl(HttpServletRequest request){
        request.getAttribute("data");
        System.out.println(request.getAttribute("data"));
        return "test";
    }
}
