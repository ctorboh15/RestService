package com.webservice.app.model.dao;

import com.webservice.app.Utils.AppConstants;
import com.webservice.app.Utils.QueryBuilder;
import com.webservice.app.database.DataBaseManager;
import com.webservice.app.model.bean.BaseBean;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract DAO Class
 * @param <T>
 */
public abstract class AbstractBaseBeanDAO<T extends BaseBean>
{

    @Autowired
    DataBaseManager dataBaseManager;

    @Autowired
    protected QueryBuilder queryBuilder;

    /**
     * Generic List All method that implements
     * @return
     */
    protected List<T> listAll()
    {
        Map<String,String> args = new HashMap<String, String>();
        args.put(AppConstants.ARG_TABLE_NAME, getTableName());

        String hql = queryBuilder.buildQuery(AppConstants.QUERY_NAME_FIND_ALL_ACTIVE, AppConstants.QUERY_FIND_ALL_ACTIVE,args);
        Query query = dataBaseManager.createQuery(hql);
        return dataBaseManager.executeQuery(query);
    }

    protected T findByID(int id)
    {
        Map<String,String> args = new HashMap<String, String>();
        args.put(AppConstants.ARG_TABLE_NAME, getTableName());
        args.put(AppConstants.ARG_TABLE_ID, getTableName()+"ID");
        args.put(AppConstants.ARG_VALUE,Integer.toString(id));

        String hql = queryBuilder.buildQuery(AppConstants.QUERY_NAME_FIND_BY_ID, AppConstants.QUERY_FIND_BY_ID,args);
        Query query = dataBaseManager.createQuery(hql);
        List<T> beans = dataBaseManager.executeQuery(query);
        if (beans != null && !beans.isEmpty())
        {
            return beans.get(0);
        }

        return null;
    }


    protected void saveOrUpdate(BaseBean baseBean)
    {
        dataBaseManager.saveBean(baseBean);
    }



    protected abstract String getTableName();
}
