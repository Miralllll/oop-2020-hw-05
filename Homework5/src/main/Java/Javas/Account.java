package Javas;

/** Simple class for saving information about user's account */
public class Account {

    String name, password;

    public Account(String name, String password){
        this.name = name;
        this.password = password;
    }

    /* returns - name */
    public String getName() {
        return name;
    }

    /* returns - password */
    public String getPassword(){
        return password;
    }
}
