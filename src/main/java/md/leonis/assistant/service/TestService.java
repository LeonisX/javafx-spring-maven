package md.leonis.assistant.service;

import md.leonis.assistant.dao.test.DictionaryDAO;
import md.leonis.assistant.domain.test.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private DictionaryDAO dictionaryDAO;

    public void echo() {
        System.out.println("ECHO");
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
