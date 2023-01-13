import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Scanner;

public class MessagesManager_P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());

        Map<String , Integer> sent = new LinkedHashMap<>();
        Map<String , Integer> received = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("Statistics")){
            String [] commandSplit = command.split("=");

            if (commandSplit[0].equals("Add")){
                String username = commandSplit[1];
                int currentSent = Integer.parseInt(commandSplit[2]);
                int currentReceived = Integer.parseInt(commandSplit[3]);

                if (!sent.containsKey(username)){
                    sent.put(username,currentSent);
                    received.put(username,currentReceived);
                }
            }else if (commandSplit[0].equals("Message")){
             String sender = commandSplit[1];
             String receiver = commandSplit[2];

             if (sent.containsKey(sender) && received.containsKey(receiver)){
                 boolean removedSender = false;
                 boolean removedReceiver = false;
              int currentSend = sent.get(sender);
              currentSend += received.get(sender) + 1;
              int currentReceived = received.get(receiver);
              currentReceived += sent.get(receiver) + 1;
              if (currentSend >= capacity){
                  sent.remove(sender);
                  received.remove(sender);
                  System.out.printf("%s reached the capacity!%n",sender);
                 removedSender = true;
              }
              if (currentReceived >= capacity){
                  received.remove(receiver);
                  sent.remove(receiver);
                  System.out.printf("%s reached the capacity!%n",receiver);
                  removedReceiver = true;
              }

             if (!removedSender){
                 sent.put(sender,sent.get(sender) + 1);
             }
              if (!removedReceiver) {
                  received.put(receiver, received.get(receiver) + 1);
              }
             }
            }else if (commandSplit[0].equals("Empty")){
                String username = commandSplit[1];

                if (username.equals("All")){
                    sent.clear();
                    received.clear();
                }else{
                    if (sent.containsKey(username)){
                        received.remove(username);
                        sent.remove(username);
                    }

                    if (received.containsKey(username)) {
                        received.remove(username, received.get(username));
                    }
                }

            }
            command = scanner.nextLine();
        }

        Map <String , Integer > output = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : sent.entrySet()) {
            String currentUsername = stringIntegerEntry.getKey();
                    int sentMessage = stringIntegerEntry.getValue();
                    int receivedMessage = 0;
                    if (received.containsKey(currentUsername)){
                        receivedMessage = received.get(currentUsername);
                    }
                output.put(currentUsername,sentMessage + receivedMessage);
       count++;
        }


        System.out.printf("Users count: %d%n",count);
        for (Map.Entry<String, Integer> stringIntegerEntry : output.entrySet()) {
            System.out.printf("%s - %d%n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue());


        }
    }
}
