package vn.neo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.neo.exception.BusinessException;
import vn.neo.services.DataService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private final DataService dataService;
    private final EntityManagerFactory entityManagerFactory;

    public HomeController(DataService dataService, EntityManagerFactory entityManagerFactory) {
        this.dataService = dataService;
        this.entityManagerFactory = entityManagerFactory;
    }

    @GetMapping
    public List<Map<String, Object>> test() throws BusinessException, InterruptedException {
        EntityManager em = null;
        try {

            em = this.entityManagerFactory.createEntityManager();
            return (List<Map<String, Object>>) em.createNativeQuery("select * from api_info", Tuple.class).setFirstResult(1).setMaxResults(1).getResultStream().map(item -> {
                Tuple tuple = (Tuple) item;
                Map<String, Object> row = new WeakHashMap<>();
                List<TupleElement<?>> tupleElements = tuple.getElements();
                tupleElements.forEach(cell -> {
                    row.put(cell.getAlias(), ((Tuple) item).get(cell.getAlias()));
                });
                return row;
            }).collect(Collectors.toList());
        } finally {
            if (em != null)
                em.close();
        }
    }

    private String getSession() throws InterruptedException, BusinessException {
        throw new BusinessException("abc");
//        return "xxx";
    }
}
