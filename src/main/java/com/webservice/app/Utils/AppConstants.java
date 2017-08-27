package com.webservice.app.Utils;

public class AppConstants
{
    public static final String ARG_TABLE_NAME = "tableName";
    public static final String ARG_TABLE_ID = "tableID";
    public static final String ARG_VALUE = "value";




    public static final String QUERY_NAME_FIND_ALL_ACTIVE = "findAllActive";
    public static final String QUERY_NAME_FIND_BY_ID = "findByID";

    public static final String QUERY_FIND_ALL_ACTIVE = "from $tableName where activeIND = 'Y'";
    public static final String QUERY_FIND_BY_ID = "from $tableName where $tableID = $value AND  activeIND = 'Y'";
}