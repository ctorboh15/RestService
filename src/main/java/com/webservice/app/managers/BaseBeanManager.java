package com.webservice.app.managers;

import java.util.List;

public interface BaseBeanManager<T>
{
    public List<T> listAllActive();
}
