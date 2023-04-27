public class Transaction {

    StoreAccount users = new StoreAccount();

    
    
    
    public void send(int _accountNumber,float _amount){

        
        
    }

    public void deposit(int _accountNumber,float _amount){
        
        int userIndex = users.getAccountIndexInStore(_accountNumber);

        if(userIndex >= 0){
            users.updateUserBalance(userIndex, _amount);
        }

        else{
            System.out.println("user not found");
        }

    }

    public void receive(int _accountNumber,float _amount){

    }

}
