public class Account {
    private String name;
    private int accountNumber;
    private float balance;
    private String registrationDate;
    private String password;

    private boolean hasSetPassword;

    Account(){
        Helper helper = new Helper();
        accountNumber = helper.generateAccountNumber();
        registrationDate = helper.getCurrentDate();
        balance = 0;
    }

    public void setPassword(String _password){
        if(hasSetPassword == false){
            password = _password;
            hasSetPassword = true;
            return;
        }
        
        System.out.println("you can't change your password");
        return;


    }

    public void setName(String _name){
        name = _name;
    }

    public float getCurrentBalance(){
        return balance;
    }

    public void setNewBalance(float amount){
        balance = balance + amount;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void getUserDetail(){
        System.out.println("account holder: "+name);
        System.out.println("account number: "+accountNumber);
        System.out.println("register date: "+registrationDate);
        System.out.println("current balance: "+balance);
    }
}
