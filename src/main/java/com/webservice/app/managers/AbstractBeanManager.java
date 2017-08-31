package com.webservice.app.managers;

import com.webservice.app.forms.BaseBeanForm;
import com.webservice.app.model.bean.BaseBean;
import org.springframework.ui.ModelMap;

import java.text.ParseException;
import java.util.List;

public abstract class AbstractBeanManager<T extends BaseBean>
{
    public static final String MODEL_MAP_ARG_ERRORS = "errors";


    protected abstract List<String> validate(BaseBeanForm form);
    protected abstract void doBeanSave(T t);
    protected abstract void doBeanUpdate(T t);
    protected abstract T copyFormToBean(BaseBeanForm form) throws ParseException;
    protected abstract T copyFormToBean(T t,BaseBeanForm form);

    protected boolean doValidation(ModelMap modelMap,BaseBeanForm form)
    {
        List<String> errors = validate(form);

        if (errors!= null && !errors.isEmpty())
        {
            modelMap.addAttribute(MODEL_MAP_ARG_ERRORS, errors);
            return true;
        }
        return false;
    }


}
