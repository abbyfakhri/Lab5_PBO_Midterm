import java.util.ArrayList;

public class StoreAccount {
    
    private static ArrayList <Account> users = new ArrayList<Account>();

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
}
