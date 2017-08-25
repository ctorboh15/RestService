package com.webservice.app.model.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBean implements BaseBean
{
    @Column(name="activeIND")
    private String activeIND;

    public String getActiveIND() {
        return activeIND;
    }

    public void setActiveIND(String activeIND) {
        this.activeIND = activeIND;
    }
}
