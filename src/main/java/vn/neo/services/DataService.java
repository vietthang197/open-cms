package vn.neo.services;

import vn.neo.entity.Words;

import java.text.ParseException;
import java.util.List;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
public interface DataService {
    void saveWords(Words words);

    List<Words> findAllWords(String searchEn, String searchVi, String fromDate, String toDate) throws ParseException;

    void deleteWord(Long id);
}
