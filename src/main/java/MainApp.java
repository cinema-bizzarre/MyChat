import server.AuthService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainApp implements AuthService {
    private static final String users = "main.db";
    private static Connection connection;
    private static Statement stmt;

    @Override
  public void start(){
    try{
        this.connect(users);
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }catch (SQLException e){
        e.printStackTrace();
    }
}
@Override
public void stop(){
    disconnect();
    }

    private void connect(String users) throws ClassNotFoundException,SQLException{
        Class.forName("org.sqlite.JDBC");

        String url = "jdbc:sqlite:";
        this.connection = DriverManager.getConnection(url);

        if (this.connection != null){
            this.connection.createStatement().execute("Create table if not Exists users (" +
                    "login TEXT UNIQUE,"+
                    "password TEXT)");
        }
    }

    private void disconnect(){
        try {
            this.connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getUsersList() {
        return null;
    }

    @Override
    public String addLoginPass(String login, String pass) {
        return null;
    }

    @Override
    public void deleteByLogin(String login) {

    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        return null;
    }


}