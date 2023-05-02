public class TransactionHistory {

    private static Helper helper = new Helper();
    private String transactionType;
    private float transactionAmount;
    private int destinationAccountNumber;
    private int originAccountNumber;
    private String transactionTime;

    TransactionHistory(int _origin,int _destination,float _amount,String _transactionType){
        originAccountNumber = _origin;
        destinationAccountNumber = _destination;
        transactionAmount = _amount;

        transactionTime = helper.getCurrentDate();

        transactionType = _transactionType;

    }

    public int getOriginAccount(){
        return originAccountNumber;
    }

    public int getReceiverAccount(){
        return destinationAccountNumber;
    }

    public void getHistory(){
        System.out.println("Transaction Type: "+transactionType);
        System.out.println("Transaction Time: "+transactionTime);
        System.out.println("Sender Account: "+originAccountNumber);

        if(transactionType.equals("transfer") || transactionType.equals("receive")){
            System.out.println("Receiver Account: "+destinationAccountNumber);
        }

        System.out.println("Transaction Amount: "+transactionAmount);
        System.out.println("-------------------------------------------");
    }

    
    


}
