package vn.neo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
@Entity
@Table(name = "api_info")
public class ApiInfo extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long apiId;
    private String name;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "method", nullable = false)
    private String method;

    public ApiInfo() {
    }

    public ApiInfo(Long apiId, String name, String url, String method) {
        this.apiId = apiId;
        this.name = name;
        this.url = url;
        this.method = method;
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
