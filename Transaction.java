public class Transaction {

    StoreAccount users = new StoreAccount();

    
    
    
    public void send(int senderAccountNumber,int recipientAccountNumber,float amount){

        int senderAccountIndex = users.getAccountIndexInStore(senderAccountNumber);
        int recipientAccountIndex = users.getAccountIndexInStore(recipientAccountNumber);
        
        if(senderAccountIndex < 0){
            System.out.println("Invalid Sender Account Number");
            return;
        }

        else if(recipientAccountIndex < 0){
            System.out.println("Invalid Destination Account Number");
            return;
        }
        else{
            
            users.verifyTranser(senderAccountIndex, recipientAccountIndex, amount);
            
        }
        
    }

    public void deposit(int _accountNumber,float _amount){

        int userIndex = users.getAccountIndexInStore(_accountNumber);

        if(userIndex >= 0){
            users.updateUserBalance(userIndex, _amount);
            users.addTransactionHistory(_accountNumber, _accountNumber, _amount, "deposit");
        }

        else{
            System.out.println("user not found");
        }

    }

    public void receive(int _accountNumber,float _amount){

    }

}
