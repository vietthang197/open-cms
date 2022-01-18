package vn.neo.services;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import vn.neo.exception.BusinessException;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
public interface DataService {
    @Retryable(value = BusinessException.class, maxAttempts = 100, backoff = @Backoff(value = 2000))
    int testNow(String session) throws BusinessException;
}
