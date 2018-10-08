package iziPak.entity;

import java.util.ArrayList;


/*This class allow to make account and its authorities in one form*/
public class NewAccountForm {

    Account account;

    public NewAccountForm(){
        account = new Account();
    }

    public String getUsername() {
        return account.getUsername();
    }

    public void setUsername(String login) {
            account.setUsername(login);
    }

    public String getPassword() {
        return account.getPassword();
    }

    public void setPassword(String password) {
        account.setPassword("{noop}" + password);
    }

    public boolean getEnabled() {
         return account.getEnabled();
    }

    public void setEnabled(boolean enabled) {
        account.setEnabled(enabled);
    }

    public void setAuhorities(String[] auhorities){
        for(String auhority : auhorities)
        account.add(new Authority(auhority));
    }

    public String[] getAuhorities(){

        int i=0;
        ArrayList<String> result = new ArrayList<>();
        for(Authority authority :account.getAuthorities())
        {
            result.add(authority.getAuthority());
        }
        return result.toArray(new String[0]);

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
