import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password_P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^(?<symbols>\\S+)>(?<numbers>\\d{3})\\|(?<lower>[a-z]{3})\\|(?<upper>[A-Z]{3})\\|(?<last>[^<>]{3})<\\1$");

        for (int i = 0; i <n ; i++) {
         String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            String concatenate = "";
            if (matcher.find()){
                concatenate = matcher.group("numbers") + matcher.group("lower") + matcher.group("upper") +
                        matcher.group("last");
                System.out.println("Password: " + concatenate);

            }else {
                System.out.println("Try another password!");
            }
        }
    }
}
