import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
    private Connection connection;

    public MyJDBC() throws SQLException {
        initializeConnection();
    }

    public void initializeConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin123");
        System.out.println(connection.isClosed());
    }

    public boolean checkLogin(String username, String password) throws SQLException{
        int i=0;
        String query = "SELECT * from users where username = '" + username + "' && password = '" + password + "'";
        Statement statement = connection.createStatement();
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();
        if(resultSet.next())
            i ++;
        if (i!=0)
            return true;
        else
            return false;
    }

    public void registerUser(String username, String password) throws SQLException {
        String query = "INSERT into users(username,password) VALUES ('" + username + "','" + password + "')";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }



    public List<String> viewAllVaultsForUser(String userName) {
        List<String> allVaultsForUser = new ArrayList<>();
        try {
            String query = "SELECT vaultName from vaults where username = '" + userName + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                allVaultsForUser.add(resultSet.getString("vaultName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(allVaultsForUser);
        return allVaultsForUser;
    }

    public void createVault(String username, String vaultName) throws SQLException {
        String query = "INSERT into vaults(vaultName, username) VALUES('" + vaultName + "','" + username + "')";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public List<String> viewAllCredentialsForVault(String username, String vaultName) {
        List<String> allCredentialsForVault = new ArrayList<>();
        try {
            String query = "SELECT credentialTitle, credentialUsername, credentialPassword from credentials where vaultName = '" + vaultName + "' && username = '" + username + "'";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Credential credential = new Credential(resultSet.getString("credentialTitle"),resultSet.getString("credentialUsername"), resultSet.getString("credentialPassword"), vaultName);
                allCredentialsForVault.add(credential.getCredentialTitle());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allCredentialsForVault;
    }

    public List<String> viewAllNotesForVault(String username, String vaultName) {
        List<String> allNotesForVault = new ArrayList<>();
        try {
            String query = "SELECT noteTitle from notes where vaultName = '" + vaultName + "' && username = '" + username + "'";
//            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Note note = new Note(resultSet.getString("noteTitle"));
                allNotesForVault.add(note.getNoteTitle());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allNotesForVault;
        }

        public boolean createNoteForVault(String username, String vaultName, String notesTitle) {
            try {
                String query = "INSERT INTO notes (username, vaultName, noteTitle) VALUES ('" + username + "','" + vaultName + "','" + notesTitle + "')";
                System.out.println(query);
                Statement statement = connection.createStatement();
                statement.execute(query);
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return true;
    }

    public boolean createNoteWithContentForVault(String username, String vaultName,String notesTitle, String notesContent) {
        try {
            String query = "INSERT INTO notes (username, vaultName, noteTitle, noteContent) VALUES ('" + username + "','" + vaultName + "','" + notesTitle + "','" + notesContent + "')";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean createCredentialForVault(String username, String vaultName,String credentialTitle, String credentialUsername, String credentialPassword) {
        try {
            String query = "INSERT INTO credentials (username, vaultName, credentialTitle, credentialUsername, credentialPassword) VALUES ('" + username + "','" + vaultName + "','" + credentialTitle + "','" + credentialUsername + "','" + credentialPassword + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Credential getCredential(String username, String vaultName, String credentialTitle) {
        Credential credential = null;
        try {
            String query = "SELECT * from credentials  WHERE username = '" + username + "' && vaultName = '" + vaultName + "' && credentialTitle = '" + credentialTitle +"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String credentialUserName = resultSet.getString("credentialUsername");
                String credentialPassword = resultSet.getString("credentialPassword");
                credential = new Credential(credentialTitle, credentialUserName, credentialPassword, vaultName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return credential;
    }
    public Note getNote(String username, String vaultName, String noteTitle) {
        Note note = null;
        try {
            String query = "SELECT * from notes  WHERE username = '" + username + "' && vaultName = '" + vaultName + "' && noteTitle = '" + noteTitle +"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String noteContent = resultSet.getString("noteContent");
                if (noteContent == null || noteContent.isEmpty()) {
                    note = new Note(noteTitle);
                }
                else{
                    note = new Note(noteTitle,noteContent);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return note;
    }

        public boolean shareVaultForUsers (String username, String vaultName) {
        try {
            String query = "INSERT INTO vaults (username, vaultName)  VALUES ('" + username + "','" + vaultName + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return true;
        }

    }

