
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
    public int generateAccountNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // generates a number between 100000 and 999999
        //System.out.println("Random six-digit number: " + randomNumber);
        return randomNumber;
    }

    public String getCurrentDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
        //System.out.println("Current date and time: " + formattedDateTime);
    }
}
