
public class Credential {
    private String credentialTitle;
    private String credentialUsername;
    private String credentialPassword;
    private String vaultName;

    public Credential(String credentialTitle, String credentialUsername, String credentialPassword, String vaultName) {
        this.credentialTitle = credentialTitle;
        this.credentialUsername = credentialUsername;
        this.credentialPassword = credentialPassword;
        this.vaultName = vaultName;
    }


//
//    public boolean writeCredential(String user, Credential credential)
//
//    public Credential readCredential(String user, String title)
//
//    public String generateRandomPassword() {
//
//    }

    public String getCredentialTitle() {
        return credentialTitle;
    }

    public String getCredentialUsername() {
        return credentialUsername;
    }

    public String getCredentialPassword() {
        return credentialPassword;
    }
}

