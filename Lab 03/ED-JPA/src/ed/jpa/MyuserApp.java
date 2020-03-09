package ed.jpa;

public class MyuserApp {

    private MyuserDB mydb;
    public MyuserApp() {
        mydb = new MyuserDB();
    }
    public static void main(String[] args) {
        MyuserApp client = new MyuserApp();
//        // assuming inputs from keyboard or any GUI
//        MyuserDTO myuserDTO = new MyuserDTO("000001", "Peter Smith", "123456",
//                "psmith@swin.edu.au", "9876543210", "Swinburne EN510f",
//                "What is my name?", "Peter");
//        boolean result = client.createRecord(myuserDTO);
//        client.showCreateResult(result, myuserDTO);
//        // assuming inputs from keyboard or any GUI
        MyuserDTO myuserDTO2 = new MyuserDTO("000006", "Test", "1000",
                "100080646@swin.edu.au", "0123456789", "Swinburne EN510g",
                "What is my name?", "David");
        boolean result = client.updateRecord(myuserDTO2);
        client.deleteRecord("000007");
        client.showCreateResult(result, myuserDTO2);
          
    }
    public void showCreateResult(boolean result, MyuserDTO myuserDTO) {
        if (result) {
            System.out.println("Record with primary key " + myuserDTO.getUserid()
                    + " has been created in the database table.");
        } else {
            System.out.println("Record with primary key " + myuserDTO.getUserid()
                    + " could not be created in the database table!");
        }
    }
    public boolean createRecord(MyuserDTO myuserDTO) {
        return mydb.createRecord(myuserDTO);
    }
    
    public MyuserDTO getRecord(MyuserDTO myuserDTO) {
        return mydb.getRecord(myuserDTO.getUserid());
    }
    
    public boolean updateRecord(MyuserDTO myuserDTO) {
        return mydb.updateRecord(myuserDTO);
    }

    public boolean deleteRecord(String userId) {
        return mydb.deleteRecord(userId);
    }
}
