package utilities;
/**
 * @author 882199
 */
public class AccountService {
    public User login(String username, String password){
        User user = new User(username);
        
        if(username.equals("abe") && password.equals(user.getPassword())){
            user.setPassword(null);
            return user;
        }
        if(username.equals("barb") && password.equals(user.getPassword())){
            user.setPassword(null);
            return user;
        }
        else{
            return null;
        }
    }  
}
