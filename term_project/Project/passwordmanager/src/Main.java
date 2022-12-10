import java.sql.SQLException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws SQLException {
        MyJDBC myJDBC = new MyJDBC();
        myJDBC.initializeConnection();
//        List<Vault> vaultsForUser = myJDBC.viewAllVaultsForUser("rohan123");
//        for(Vault vault : vaultsForUser) {
//            System.out.println(vault.getVaultName());
//        }
//        List<Credential> credentialList = myJDBC.viewAllCredentialsForVault("rohan123", "Banking_Details");
//        for(Credential credential : credentialList) {
//            System.out.println(credential.getCredentialTitle());
//            System.out.println(credential.getCredentialUsername());
//            System.out.println(credential.getCredentialPassword());
//        }

//        List<Note> noteList = myJDBC.viewAllNotesForVault("rohan123", "Banking_Details");
//        for(Note note : noteList) {
//            System.out.println(note.getNoteTitle());
//        }

        myJDBC.createNoteForVault("purvi890", "Test123", "HelloWorld");

        System.out.println(myJDBC.checkLogin("rohan123", "hello09moxy"));
        System.out.println(myJDBC.checkLogin("rohan123", "wjfoidjfiwde"));
    }
}

