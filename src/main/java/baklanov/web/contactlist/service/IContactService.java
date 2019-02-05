package baklanov.web.contactlist.service;

import baklanov.web.contactlist.model.Contact;

public interface IContactService {
    void addContact(Contact contact);
    void updateContact(Contact contact);
    void removeContactById(Integer id);
    void getContactById(Integer id);

    Iterable<Contact> getAllContacts();
    Iterable<Contact> findContacts(String string);
}
