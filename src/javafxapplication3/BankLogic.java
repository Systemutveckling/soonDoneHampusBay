/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.util.ArrayList;

/**
 *
 * @author skate
 */
public class BankLogic {

    private String name;

    private ArrayList<String> allNames = new ArrayList();
    private ArrayList<accounts> accounts = new ArrayList();
    private static BankLogic instance = null;

    
    private BankLogic() {
        // Exists only to defeat instantiation.
    }

    public static BankLogic getInstance() {
        if (instance == null) {
            instance = new BankLogic();
        }
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAllNames() {
        return allNames;
    }

    public void setAllNames(String name) {  
            allNames.add(name);
    }

    public ArrayList<accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(String name,String username,String password) {
        accounts.add(new accounts(name,username,password));
    }
    public ArrayList<String> getAllAccounts(){
        ArrayList<String> s = new ArrayList();
    for(accounts sa : accounts){
    s.add("name = " +sa.name + " username = " + sa.username + " password = " +sa.password);
    }
    return s;
    }
    
    

}
