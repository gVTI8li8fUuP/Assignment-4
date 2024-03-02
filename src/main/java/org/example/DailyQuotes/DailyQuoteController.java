package org.example.DailyQuotes;

import org.example.Entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dailyquote")
public class DailyQuoteController {

    @Autowired
    private DailyQuoteService dailyQuoteService;
//    @GetMapping("/addQuote")
//    public void addQuote(@RequestBody String user) {
////        DailyQuoteService.addQuote(user);
////        return HttpStatus.CREATED;
//    }
    @GetMapping("/{mood}")
    public String getDailyQuote(@PathVariable String mood) {
        return "<html><head><title>Daily Quote Service</title></head><body>"
                + "<h1>Daily Quote of " + mood + "</h1>"
                + "<p>" + dailyQuoteService.getRandomQuote(mood) + "</p>"
                + "</body></html>";
    }
}
