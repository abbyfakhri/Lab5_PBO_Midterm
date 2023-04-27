public class Account {
    private String name;
    private int accountNumber;
    private float balance;
    private String registrationDate;

    Account(){
        Helper helper = new Helper();
        accountNumber = helper.generateAccountNumber();
        registrationDate = helper.getCurrentDate();
        balance = 0;
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

    public void getUserDetail(){
        System.out.println("account holder: "+name);
        System.out.println("account number: "+accountNumber);
        System.out.println("register date: "+registrationDate);
        System.out.println("current balance: "+balance);
    }
}
