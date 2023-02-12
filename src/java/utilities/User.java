package utilities;
/**
 * @author 882199
 */
public class User {
    private String username;
    private String password = "password";
    
    public User(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
