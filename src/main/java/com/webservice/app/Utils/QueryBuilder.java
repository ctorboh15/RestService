package com.webservice.app.Utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.Map;

/**
 * Uses Apache Velocity to do parameter replacement... thus allowing for clean sql or hql to be passed to the databaseManger.
 * preferred using this over parameter setting in the query object becuase it is easier to debug than "?" based queries.
 */
@Component
public class QueryBuilder

{
    static
    {
        Velocity.init();
    }



    /**
     * Dynamically builds queries so they are not hardcoded in DAO
     *
     * @param queryName
     * @param query
     * @param args
     * @return
     */
    public String buildQuery(String queryName, String query, Map<String,String> args)
    {
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        for(String s : args.keySet())
        {
            context.put(s,args.get(s));
        }
        Velocity.evaluate(context, writer, queryName, query);
        return String.valueOf(writer);
    }




}
