package org.example.DailyQuotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dailyquote")
public class DailyQuoteController {

    @Autowired
    private DailyQuoteService dailyQuoteService;

    @GetMapping("/{mood}")
    public String getDailyQuote(@PathVariable String mood) {
        return "<html><head><title>Daily Quote Service</title></head><body>"
                + "<h1>Daily Quote of " + mood + "</h1>"
                + "<p>" + dailyQuoteService.getRandomQuote(mood) + "</p>"
                + "</body></html>";
    }
}
