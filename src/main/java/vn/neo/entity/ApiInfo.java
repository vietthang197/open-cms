package vn.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@Entity
@Table(name = "api_info")
public class ApiInfo extends AbstractEntity implements Serializable {
    @Id
    private Long apiId;
    private String name;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "method", nullable = false)
    private String method;

    public ApiInfo() {
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
