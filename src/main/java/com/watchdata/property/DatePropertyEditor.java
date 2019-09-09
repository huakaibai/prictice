package com.watchdata.property;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhibin.wang
 * @create 2019-06-03 15:11
 * @desc 属性编辑器
 **/
public class DatePropertyEditor extends PropertyEditorSupport {

    private String format = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.setValue(date);
    }
}
