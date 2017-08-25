package com.webservice.app.model.dao;

import com.webservice.app.model.bean.BaseBean;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractBaseBeanDAO<T extends BaseBean>
{
    /**
    @Autowired
    SessionFactory sessionFactory;
**/
    @Transactional
    protected List<T> listAll()
    {
        /**
        String hql = "from " + getTableName() +" where activeIND ='Y' " ;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<T> beanList = (List<T>) query.list();

        return beanList;**/
        return null;
    }

    protected abstract String getTableName();
}
