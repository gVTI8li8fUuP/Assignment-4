package org.example.DailyQuotes;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class DailyQuoteService {
    private static final String[] happyQuotes = {
            "Happiness is not something ready made. It comes from your own actions. - Dalai Lama",
            "The only way to do great work is to love what you do. – Steve Jobs",
            "Success is not the key to happiness. Happiness is the key to success. – Albert Schweitzer"
    };

    private static final String[] sadQuotes = {
            "The best way to cheer yourself up is to try to cheer somebody else up. - Mark Twain",
            "Tears come from the heart and not from the brain. - Leonardo da Vinci",
            "Sadness flies away on the wings of time. - Jean de La Fontaine"
    };

    private static final String[] inspirationalQuotes = {
            "Believe you can and you're halfway there. – Theodore Roosevelt",
            "It does not matter how slowly you go as long as you do not stop. – Confucius",
            "The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt"
    };

    private static final String[] randomQuotes = {
            "The only way to do great work is to love what you do. – Steve Jobs",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill",
            "Believe you can and you're halfway there. – Theodore Roosevelt",
            "It does not matter how slowly you go as long as you do not stop. – Confucius",
            "The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt",
            "Happiness is not something ready made. It comes from your own actions. - Dalai Lama",
            "The best way to cheer yourself up is to try to cheer somebody else up. - Mark Twain",
            "The most wasted of all days is one without laughter. - E.E. Cummings"
    };

    public String getRandomQuote(String mood) {
        Random rand = new Random();
        return switch (mood.toLowerCase()) {
            case "happy" -> happyQuotes[rand.nextInt(happyQuotes.length)];
            case "sad" -> sadQuotes[rand.nextInt(sadQuotes.length)];
            case "inspirational" -> inspirationalQuotes[rand.nextInt(inspirationalQuotes.length)];
            default -> randomQuotes[rand.nextInt(randomQuotes.length)];
        };
    }
}
