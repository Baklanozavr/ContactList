package baklanov.web.contactlist.repository;

import baklanov.web.contactlist.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactsRepository extends CrudRepository<Contact, Integer> {
    List<Contact> findByNameLike(String stringForFinding);
    List<Contact> findByEmailLike(String stringForFinding);
    List<Contact> findByPhoneLike(String stringForFinding);
}