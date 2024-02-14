import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dailyquote")
public class DailyQuoteService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String[] quotes = {
            "The only way to do great work is to love what you do. – Steve Jobs",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill",
            "Believe you can and you're halfway there. – Theodore Roosevelt",
            "It does not matter how slowly you go as long as you do not stop. – Confucius",
            "The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt"
    };

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Daily Quote Service</title></head><body>");
        out.println("<h1>Daily Quote of Inspiration</h1>");
        out.println("<p>" + getRandomQuote() + "</p>");
        out.println("</body></html>");
    }

    private String getRandomQuote() {
        Random rand = new Random();
        int index = rand.nextInt(quotes.length);
        return quotes[index];
    }
}
