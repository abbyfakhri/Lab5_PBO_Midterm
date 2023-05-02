import java.util.Scanner;

public class Demo {
    
    public void runDemo(){
        StoreAccount storage = new StoreAccount();
        Transaction transaction = new Transaction();

        System.out.println("creating new account demo");
        Account newAccount = new Account();
        newAccount.setName("abby");

        storage.storeUserData(newAccount);

        Account newAccount2 = new Account();
        
        newAccount2.setName("badang");
        storage.storeUserData(newAccount2);

        storage.showAllDataInStore();

        transaction.deposit(newAccount.getAccountNumber(), 10000);
        transaction.deposit(newAccount2.getAccountNumber(), 12500);
        transaction.deposit(newAccount.getAccountNumber(), 5000);

        transaction.send(newAccount.getAccountNumber(), newAccount2.getAccountNumber(), 15000);
        transaction.send(newAccount2.getAccountNumber(), newAccount.getAccountNumber(), 7500);

        storage.showAllDataInStore();

        //storage.getAllTransactionHistory();

       storage.getTransactionHistoryByAccountNumber(newAccount.getAccountNumber());
    }

    public void runMenuDemo(){
        Menu menu = new Menu();

        menu.showMenu();
    }

    public void demoCreateUser(){

        for(int i = 0;i<10;i++){
    
            System.out.println("creating new account demo");
    
            Account newAccount = new Account();
            newAccount.setName("abby");
    
            newAccount.getUserDetail();
    
            System.out.println("---------------------------");
        }
    }

    public  void inputExample(){
        Scanner scan = new Scanner(System.in);

        System.out.print("masukkan angka: ");

        if(scan.hasNextFloat()){
            float number =  scan.nextFloat();
            System.out.println("you entered a valid number: "+number);
        }
        else{
            String input = scan.next();
            System.out.println("invalid input: "+input+" is not a number");
        }
        
        scan.close();
    }

}
