package com.hola.mysdkutils;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by Administrator on 2017/4/14.
 */

public class NoteTypeConverter implements PropertyConverter<NoteType,String> {

    @Override
    public NoteType convertToEntityProperty(String databaseValue) {
        return NoteType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(NoteType entityProperty) {
        return entityProperty.name();
    }
}
