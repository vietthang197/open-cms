package vn.neo.services.impl;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.stereotype.Service;
import vn.neo.exception.BusinessException;
import vn.neo.services.DataService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@Service
public class DataServiceImpl implements DataService {

    private final AtomicInteger counter;

    public DataServiceImpl(Enforcer enforcer) {
        this.counter = new AtomicInteger();
    }

    @Override
    public int testNow(String session) throws BusinessException {
        counter.incrementAndGet();
        if (counter.get() == 1)
            throw new BusinessException("xxx");
        return counter.get();
    }
}
