package vn.neo.services.impl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import vn.neo.entity.Words;
import vn.neo.repository.WordsRepository;
import vn.neo.services.DataService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@Service
public class DataServiceImpl implements DataService {

    private final WordsRepository wordsRepository;
    private EntityManagerFactory emf;

    public DataServiceImpl(WordsRepository wordsRepository, EntityManagerFactory emf) {
        this.wordsRepository = wordsRepository;
        this.emf = emf;
    }

    @Override
    public void saveWords(Words words) {
        wordsRepository.save(words);
    }

    @Override
    public List<Words> findAllWords(String searchEn, String searchVi, String fromDate, String toDate) throws ParseException {
        StringBuilder sql = new StringBuilder("SELECT * FROM words WHERE 1 = 1 ");
        List<Object> valueSearch = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (Strings.isNotBlank(searchEn)) {
            sql.append(" AND en LIKE ?");
            valueSearch.add("%" + searchEn + "%");
        }
        if (Strings.isNotBlank(searchVi)) {
            sql.append(" AND vi LIKE ?");
            valueSearch.add("%" + searchVi + "%");
        }
        if (Strings.isNotBlank(fromDate)) {
            sql.append(" AND created_date >= ?");
            valueSearch.add(sdf.parse(fromDate));
        }
        if (Strings.isNotBlank(toDate)) {
            sql.append(" AND créated_date <= ?");
            valueSearch.add(sdf.parse(toDate));
        }
        sql.append(" ORDER BY created_date desc");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createNativeQuery(sql.toString(), Words.class);
            for (int i = 0; i < valueSearch.size(); i++) {
                query = query.setParameter((i + 1), valueSearch.get(i));
            }
            return (List<Words>)query.getResultList();
        } finally {
            if (em != null)
                em.close();
        }
    }

    @Override
    public void deleteWord(Long id) {
        wordsRepository.deleteById(id);
    }
}
