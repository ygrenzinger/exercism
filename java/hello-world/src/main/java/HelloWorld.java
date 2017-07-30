public class HelloWorld {
    public static String hello(String who) {
        if (who == null || who.trim().isEmpty()) {
            who = "World";
        }
        return "Hello, " + who + "!";
    }
}
