package vn.neo.entity;

import java.util.Date;

/**
 * @author thanglv on 1/18/2022
 * @project open-cms
 */
public abstract class AbstractEntity {
    private Date createdDate;
    private Date editDate;
    private Long editBy;
    private Long updateBy;

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

    public Long getEditBy() {
        return editBy;
    }

    public void setEditBy(Long editBy) {
        this.editBy = editBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}
