import javax.swing.*;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class ViewOperations {
    private MyJDBC myJDBC;

    public ViewOperations() {
        try {
            myJDBC = new MyJDBC();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void reDisplayScreen(JPanel parentPanel, JPanel screenToDisplay) {
        parentPanel.removeAll();
        parentPanel.add(screenToDisplay);
        parentPanel.repaint();
        parentPanel.revalidate();
    }

    public boolean loginButtonActionPerformed(String username, String password) throws SQLException {
        return myJDBC.checkLogin(username, password);
    }

    public void registerButtonActionPerformed(String username, String password) throws SQLException {
        myJDBC.registerUser(username, password);
    }

    public List<String> viewAllVaultsForUser(String username) {
        return myJDBC.viewAllVaultsForUser(username);
    }

    public void createNewVault(String username, String vaultName) throws SQLException {
        myJDBC.createVault(username, vaultName);
    }

    public void createCredential(String username, String vaultName, String credentialTitle, String credentialUsername, String credentialPassword) {
        myJDBC.createCredentialForVault(username, vaultName, credentialTitle, credentialUsername, credentialPassword);
    }

    public List<String> viewCredentials(String username, String vaultName) {
        return myJDBC.viewAllCredentialsForVault(username, vaultName);
    }

    public Credential viewCredential(String username, String vaultName, String credentialTitle) {
        return myJDBC.getCredential(username,vaultName,credentialTitle);
    }

    public void shareVault(String username, String vaultName) {

        myJDBC.shareVaultForUsers(username, vaultName);
    }



    public List<String> viewNotes(String username, String vaultName) {
        return myJDBC.viewAllNotesForVault(username, vaultName);
    }

    public Note viewNote(String username, String vaultName, String noteTitle) {
        return myJDBC.getNote(username,vaultName, noteTitle);
    }

    public boolean createNoteWithTitle(String username, String vaultName,String notesTitle) {
        return myJDBC.createNoteForVault(username, vaultName, notesTitle);
    }

    public boolean createNoteWithContent(String username, String vaultName,String notesTitle, String notesContent) {
        return myJDBC.createNoteWithContentForVault(username, vaultName,notesTitle, notesContent);
    }

   public String generateRandomPassword() {
        GenerateRandomPassword grp = new GenerateRandomPassword();
        return grp.generateRandomPassword();
   }
}
