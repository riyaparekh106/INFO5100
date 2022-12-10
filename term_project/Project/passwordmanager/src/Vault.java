
public class Vault {
    private String vaultName;
    private String userName;


    public Vault(String vaultName, String userName) {
        this.vaultName = vaultName;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getVaultName() {
        return vaultName;
    }

    //
//    public Vault createVault(String vaultName) {
//
//    }
//
//    public Vault searchVault(String vaultName) {
//
//    }
//
//    public boolean shareVault(String user, String userEmail) {
//
//    }

}
