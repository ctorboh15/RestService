package com.webservice.app.database;

import com.webservice.app.model.bean.BaseBean;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DataBaseManager<T>
{
    @Autowired
    SessionFactory sessionFactory;

    /**
     * Executes a passed in query object.
     * @param query
     * @return
     */

    public List<T> executeQuery(Query query)
    {
        @SuppressWarnings("unchecked")
        List<T> beanList = (List<T>) query.list();
        return beanList;
    }

    /**
     * Creates a query object based on inputted queryString
     * @param queryString
     * @return
     */
    public List<T> executeQuery(String queryString)
    {
        Query query = createQuery(queryString);
        @SuppressWarnings("unchecked")
        List<T> beanList = (List<T>) query.list();
        return beanList;
    }

    /**
     * Creates a query object to add object parameters too in future use.
     * @param queryName
     * @return
     */
    public Query createQuery(String queryName)
    {
       return sessionFactory.getCurrentSession().createQuery(queryName);
    }



    public Transaction beginTransaction()
    {
       return sessionFactory.getCurrentSession().beginTransaction();
    }

    public void saveBean(BaseBean bean)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(bean);
    }
}

