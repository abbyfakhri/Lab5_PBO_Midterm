import java.util.Scanner;

public class Menu {
    
    private static Scanner scan = new Scanner(System.in);
    private static StoreAccount storage = new StoreAccount();
    private static Transaction transaction = new Transaction();

    public void showMenu(){
        
        System.out.println("Welcome to IKLC Bank");
        System.out.println("Enjoy Your Next Level Banking Experience");
        System.out.println("-------------------------------------------");
        
            System.out.println("Here's the Menu");

            System.out.println("1. Log in to Your Account");
            System.out.println("2. Create New Account");
            System.out.println("3. Exit");
            System.out.print("Enter Option: ");

            int input = getNumberInput();
            // clear buffer
            scan.nextLine();

            // check the input if it's an integer
    
                if(input == 1){
                    // login to account
                    System.out.println("you are logging in");
                    login();
                }
    
                else if(input == 2){
                    // create new account
                    createNewAccount();
                    showMenu();
                }
                
                else if(input == 3){
                    System.out.println("Thank You for Banking With Us, See You Again :)");
                }

                else{
                    System.out.println("Can't find the menu");
                    showMenu();
                }
    
    }

    private void login(){
        System.out.println("-------------------------------------------");

        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        if(storage.login(name, password)){
            // show login menu

            System.out.println("succesfully login");
            showTransactionMenu(name,password);
        }

        else{
            System.out.println("can't find account");

            showMenu();
        }
        System.out.println("-------------------------------------------");

    }

    private void showTransactionMenu(String name, String password){

        System.out.println("-------------------------------------------");


        Account myAccount = storage.getAccount(name, password);
        

        System.out.println("your account details: ");
        //myAccount.getUserDetail();

        System.out.println("Transaction Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Send");
        System.out.println("3. Check Balance");
        System.out.println("4. Get Account Details");
        System.out.println("5. Logout, and back to main menu");

        System.out.print("pick menu: ");

        int input = getNumberInput();

        switch(input){
            case 1:

            System.out.println("deposit");
            System.out.print("Enter deposit Amount: ");
            float inputAmount = getFloatInput();
            transaction.deposit(myAccount.getAccountNumber(), inputAmount);
            System.out.println("Succesfully Deposit "+inputAmount+" to "+myAccount.getAccountNumber());
            showTransactionMenu(name, password);

            break;

            case 2:
            System.out.println("Send money");
            
            System.out.print("destination account number: ");
            int destinationAccountNumber = getNumberInput();

            System.out.print("enter the amount of money you want to send: ");
            float sendAmount = getFloatInput();

            transaction.send(myAccount.getAccountNumber(), destinationAccountNumber, sendAmount);

            showTransactionMenu(name, password);

            break;

            case 3:
            System.out.println("Check balance");
            System.out.println("Your current balance is: "+myAccount.getCurrentBalance());
            showTransactionMenu(name, password);
            break;

            case 4:
            System.out.println("Get Account Details");
            myAccount.getUserDetail();
            showTransactionMenu(name, password);
            break;
            

            case 5:
            showMenu();
            break;

            default:
            System.out.println("can't find menu");
        }

        System.out.println("-------------------------------------------");


    }




    private void createNewAccount(){

        System.out.println("-------------------------------------------");

        System.out.println("Create your Account");

        System.out.println("-------------------------------------------");

        System.out.print("Enter your Name: ");
        String name = scan.nextLine();
        System.out.println("-------------------------------------------");

        System.out.print("Create your Password: ");
        String password = scan.nextLine();

        Account newAccount = new Account();
        newAccount.setName(name);
        newAccount.setPassword(password);
        System.out.println("-------------------------------------------");


        System.out.println("Account Created");
        System.out.println("Here's the detail of your account");
        System.out.println("-------------------------------------------");

        newAccount.getUserDetail();
        System.out.println("-------------------------------------------");

        // store user data to temporary storage
        storage.storeUserData(newAccount);


    }
    private int getNumberInput(){

        if(scan.hasNextInt()){
            int input = scan.nextInt();

            return input;
        }
        else{
            System.out.println("invalid input");
            return -1;
        }


    }
    
    private float getFloatInput(){
        if(scan.hasNextFloat()){
            float input = scan.nextFloat();

            if(input > 0){
                return input;
            }

            System.out.println("Input cannot be negative amount");
            return -1;
        }
        else{
            System.out.println("Please enter a valid input");
            return -1;
        }
    }


        




}
