package md.leonis.template.service;

import md.leonis.template.dao.test.DictionaryDAO;
import md.leonis.template.domain.test.Dictionary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final DictionaryDAO dictionaryDAO;

    public TestService(DictionaryDAO dictionaryDAO) {
        this.dictionaryDAO = dictionaryDAO;
    }

    public List<Dictionary> getDictionaries() {
        return dictionaryDAO.findAll();
    }

    public void saveDictionary(Dictionary dictionary) {
        dictionaryDAO.save(dictionary);
    }

    public void deleteDictionary(Long id) {
        dictionaryDAO.deleteById(id);
    }

    public void deleteAllDictionaries(List<Dictionary> dictionaries) {
        dictionaryDAO.deleteAll(dictionaries);
    }
}
