package iziPak.controller;

import iziPak.entity.NewAccountForm;
import iziPak.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserEditorController {

    /*Add users attribute with accounts from database to show it on system.jsp*/

    @Autowired
    private AccountService accountService;


    @GetMapping("/systems")
    public String showSystems(Model model) {

        model.addAttribute("users", accountService.getAccounts());

        return "systems";
    }

    @GetMapping("/showFormForUpdate")
    public String formUpdate(Model model) {

        model.addAttribute("users", accountService.getAccounts());

        return "systems";

    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") String username, Model model) {

        accountService.deleteAccount(username);
        model.addAttribute("users", accountService.getAccounts());

        return "systems";

    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") String username, Model model) {

        NewAccountForm account = new NewAccountForm ();
        account.setAccount(accountService.getAccount(username));
        model.addAttribute("account", account);

        return "add-account";

    }

    @GetMapping("/addNewAccount")
    public String addNewAccount(Model model) {

        NewAccountForm account = new NewAccountForm ();
        model.addAttribute("account",account);

        return "add-account";

    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("account") NewAccountForm account,
                              Model model) {

        accountService.registerAccount(account.getAccount());
        model.addAttribute("users", accountService.getAccounts());

        return "systems";

    }

}
