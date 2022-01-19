package vn.neo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author thanglv on 1/19/2022
 * @project open-cms
 */
@Entity
@Table(name = "words", indexes = {
        @Index(name = "en_idx", columnList = "en"),
        @Index(name = "vi_idx", columnList = "vi"),
        @Index(name = "create_date_idx", columnList = "createdDate"),
        @Index(name = "edit_date_idx", columnList = "editDate"),
})
public class Words implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 5000, nullable = false)
    private String en;
    @Column(length = 5000, nullable = false)
    private String vi;
    private Date createdDate;
    private Date editDate;

    public Words() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}
