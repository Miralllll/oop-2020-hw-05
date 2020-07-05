package Javas;

import java.util.HashMap;

/** Manager class - contains users' database, and methods for adding,
 *  removing and searching current users. */
public class AccountManager {

    // mini-database :))
    private HashMap<String, String> users;

    public AccountManager(){
        users = new HashMap<>();
        users.put("Patrick", "1234");
        users.put("Molly", "FloPup");
    }

    /* checks if someone has these username and password in database */
    public boolean containsUser(Account account){
        Object password = users.get(account.getName());
        if(password == null || !((String)password).equals(account.getPassword())) return false;
        return true;
    }

    /* adds new user in database */
    public void addUser(Account account){
        if(!containsUser(account))
            users.put(account.getName(), account.getPassword());
    }

    /* checks if someone has this name already */
    public boolean containsName(Account account){
        return users.containsKey(account.getName());
    }

    public static final String NAME = "AccountManager";
}

