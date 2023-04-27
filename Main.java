class Main{

    public void demoCreateUser(){

        for(int i = 0;i<10;i++){
    
            System.out.println("creating new account demo");
    
            Account newAccount = new Account();
            newAccount.setName("abby");
    
            newAccount.getUserDetail();
    
            System.out.println("---------------------------");
        }
    }

    

    public static void main(String[] args) {

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

        storage.showAllDataInStore();




    }
}