import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);


        while (!command.equals("End")){
            String [] commandSplit = command.split("\\s+");

            if (commandSplit[0].equals("Translate")){
            input = sb.toString();
            String getChar = commandSplit[1];
            String replacement = commandSplit[2];
            input = input.replaceAll(getChar,replacement);
            sb = new StringBuilder(input);
                System.out.println(sb);

            }else if (commandSplit[0].equals("Includes")){
                String substring = commandSplit[1];
                input = sb.toString();
                if (input.contains(substring)){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }
            }else if (commandSplit[0].equals("Start")){
                String start = commandSplit[1];
                int length = start.length();
                String check = sb.substring(0,length);
                if (check.equals(start)){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }

            }else if (commandSplit[0].equals("Lowercase")){
                input = sb.toString();
               input = input.toLowerCase();
                sb = new StringBuilder(input);
                System.out.println(input);
            }else if (commandSplit[0].equals("FindIndex")){
                String character = commandSplit[1];
                int index = sb.lastIndexOf(character);
                System.out.println(index);


            }else if (commandSplit[0].equals("Remove")){
                int startIndex = Integer.parseInt(commandSplit[1]);
                int count = Integer.parseInt(commandSplit[2]);
                int endIndex = startIndex + count;

                sb.delete(startIndex,endIndex);

                System.out.println(sb);

            }
            command = scanner.nextLine();
        }
    }
}