package baklanov.web.contactlist.service;

import baklanov.web.contactlist.model.Contact;
import baklanov.web.contactlist.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ContactService implements IContactService {
    @Autowired
    private ContactsRepository contactsRepository;
    private StringSQLFriendlyConverter stringSQLFriendlyConverter = new StringSQLFriendlyConverter();

    @Override
    public void addContact(Contact contact) {
        contactsRepository.save(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        contactsRepository.save(contact);
    }

    @Override
    public void removeContactById(Integer id) {
        contactsRepository.deleteById(id);
    }

    @Override
    public void getContactById(Integer id) {
        contactsRepository.findById(id);
    }

    @Override
    public Iterable<Contact> getAllContacts() {
        return contactsRepository.findAll();
    }

    @Override
    public Iterable<Contact> findContacts(String string) {
        Iterable<Contact> foundContacts;

        if (string != null && !string.isEmpty()) {
            String stringForFinding = "%" + stringSQLFriendlyConverter.modifyString(string) + "%";

            HashSet<Integer> foundContactsId = new HashSet<>();

            for (Contact contact : contactsRepository.findByNameLike(stringForFinding)) {
                foundContactsId.add(contact.getId());
            }
            for (Contact contact : contactsRepository.findByEmailLike(stringForFinding)) {
                foundContactsId.add(contact.getId());
            }
            for (Contact contact : contactsRepository.findByPhoneLike(stringForFinding)) {
                foundContactsId.add(contact.getId());
            }

            foundContacts = contactsRepository.findAllById(foundContactsId);
        } else {
            foundContacts = contactsRepository.findAll();
        }

        return foundContacts;
    }
}
