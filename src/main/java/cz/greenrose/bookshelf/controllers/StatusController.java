package cz.greenrose.bookshelf.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/status")
    public String status()  {
        return "{status: \"ok\"}";
    }
}
