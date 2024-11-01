import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {

    private Map<String, String> responseMap;

    public Chatbot() {
        responseMap = new HashMap<>();

        // Define basic responses
        responseMap.put("hello", "Hi! How can I assist you today?");
        responseMap.put("weather", "I'm unable to check the weather right now, but I can chat!");
        responseMap.put("name", "I am an AI Chatbot. What's your name?");
        responseMap.put("bye", "Goodbye! It was nice talking to you.");
        responseMap.put("how are you", "I'm just a chatbot, but thank you for asking!");
    }

    // Method to process input and generate response
    public String getResponse(String input) {
        // Convert input to lowercase for case-insensitive matching
        input = input.toLowerCase();

        // Check if any keyword in the input matches our predefined responses
        for (String key : responseMap.keySet()) {
            if (input.contains(key)) {
                return responseMap.get(key);
            }
        }

        // Default response if no keyword is found
        return "I'm sorry, I didn't understand that. Could you please rephrase?";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Chatbot chatbot = new Chatbot();
        
        System.out.println("Hello! I'm your chatbot. Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            // Check if the user wants to exit
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Bot: " + chatbot.getResponse("bye"));
                break;
            }

            // Get chatbot's response
            String response = chatbot.getResponse(userInput);
            System.out.println("Bot: " + response);
        }

        scanner.close();
    }
}
