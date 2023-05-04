
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
    public int generateAccountNumber(){

        SecureRandom random =  new SecureRandom();
        int randomNumber = random.nextInt(900000) + 100000; // generates a number between 100000 and 999999
        return randomNumber;
        
    }

    public String getCurrentDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
