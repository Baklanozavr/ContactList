package baklanov.web.contactlist.controller;

import baklanov.web.contactlist.model.Contact;
import baklanov.web.contactlist.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ContactsController {
    @Autowired
    private IContactService contactService;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("contacts", contactService.getAllContacts());

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name,
                      @RequestParam String email,
                      @RequestParam String phone, Map<String, Object> model) {
        contactService.addContact(new Contact(name, email, phone));

        model.put("contacts", contactService.getAllContacts());

        return "main";
    }

    @PostMapping("update")
    public String update(@RequestParam Integer id,
                         @RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String phone, Map<String, Object> model) {
        return "main";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer id, Map<String, Object> model) {
        contactService.removeContactById(id);

        model.put("contacts", contactService.getAllContacts());

        return "main";
    }

    @PostMapping("find")
    public String delete(@RequestParam String stringForSearch, Map<String, Object> model) {
        model.put("contacts", contactService.findContacts(stringForSearch));

        return "main";
    }
}