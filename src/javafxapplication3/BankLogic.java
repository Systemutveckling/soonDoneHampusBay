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
        boolean ifFoundName = true;
        for (String x : allNames) {

            if (x.equals(name)) {
                ifFoundName = false;
            }
        }

        if (ifFoundName) {
            allNames.add(name);
        }

    }

}
