import java.util.ArrayList;


public class StoreAccount {
    
    private static ArrayList <Account> users = new ArrayList<Account>();
    private static ArrayList <TransactionHistory> history = new ArrayList<TransactionHistory>();

    public void storeUserData(Account account){
        users.add(account);
    }

    public int getUserCount(){
        return users.size();
    }

    public int getAccountIndexInStore(int _accountNumber){

        for(int i = 0;i<users.size();i++){
            if(users.get(i).getAccountNumber() == _accountNumber){
                return i;
            }
        }
        
        return -1;

    }

    public boolean login(String name,String password){
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }

    public Account getAccount(String name,String password){
        for(int i = 0; i<users.size();i++){
            if(users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)){
                return users.get(i);
            }
        }

        return null;
    }


    public void verifyTranser(int senderIndex,int receiverIndex,float amount){
        Account senderAccount = users.get(senderIndex);
        Account receiverAccount = users.get(receiverIndex);

        if((senderAccount.getCurrentBalance() - amount) < 0 ){
            System.out.println("can't proceed transaction, not enough balance");
            return;
        }

        else{
            updateUserBalance(receiverIndex, amount);
            updateUserBalance(senderIndex, (amount*-1));

            addTransactionHistory(senderAccount.getAccountNumber(), receiverAccount.getAccountNumber(), amount, "transfer");
            addTransactionHistory(receiverAccount.getAccountNumber(), senderAccount.getAccountNumber(), amount, "receive");
            System.out.println("succesfully sending "+amount +" from "+senderAccount.getAccountNumber()+" to "+receiverAccount.getAccountNumber());
        }
    }

    public void addTransactionHistory(int origin,int destination,float amount,String type){

        TransactionHistory transfer = new TransactionHistory(origin, destination, amount, type);
        history.add(transfer);
    }

    public void getTransactionHistoryByAccountNumber(int accountNumber){
        for(int i = 0;i<history.size();i++){
            if((history.get(i).getOriginAccount() == accountNumber) ){
                history.get(i).getHistory();
            }
        }
    }

    public void updateUserBalance(int dataIndex, float amount){
        
        Account account = users.get(dataIndex);

        account.setNewBalance(amount);

        users.set(dataIndex, account);

    }

    public void showAllDataInStore(){
        for(int i = 0;i<users.size();i++){
            users.get(i).getUserDetail();
            System.out.println("---------------------");
        }
    }

    public void getAllTransactionHistory(){

        System.out.println("All Transaction History");
        System.out.println("---------------------");
        for(int i = 0;i<history.size();i++){
            history.get(i).getHistory();
        }
    }

    

}
