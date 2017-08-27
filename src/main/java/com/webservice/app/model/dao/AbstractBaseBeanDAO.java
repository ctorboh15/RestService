package com.webservice.app.model.dao;

import com.webservice.app.Utils.AppConstants;
import com.webservice.app.Utils.QueryBuilder;
import com.webservice.app.model.bean.BaseBean;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseBeanDAO<T extends BaseBean>
{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    protected QueryBuilder queryBuilder;

    @Transactional
    protected List<T> listAll()
    {
        Map<String,String> args = new HashMap<String, String>();
        args.put(AppConstants.ARG_TABLE_NAME, getTableName());
        String hql = queryBuilder.buildQuery(AppConstants.QUERY_NAME_FIND_ALL_ACTIVE, AppConstants.QUERY_FIND_ALL_ACTIVE,args);

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<T> beanList = (List<T>) query.list();

        return beanList;
    }

    protected T findByID()
    {
        String hql = queryBuilder.buildQuery(AppConstants.QUERY_NAME_FIND_BY_ID, AppConstants.QUERY_FIND_BY_ID,args);
        return null;

    }


    protected abstract String getTableName();
}
