// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class ServiceType
{
    private static ServiceType[] __values = new ServiceType[4];
    private int __value;
    private String __T = new String();

    public static final int _ST_GET_SUGGEST_LIST = 1;
    public static final ServiceType ST_GET_SUGGEST_LIST = new ServiceType(0,_ST_GET_SUGGEST_LIST,"ST_GET_SUGGEST_LIST");
    public static final int _ST_GET_RECOMMEND_LIST = 2;
    public static final ServiceType ST_GET_RECOMMEND_LIST = new ServiceType(1,_ST_GET_RECOMMEND_LIST,"ST_GET_RECOMMEND_LIST");
    public static final int _ST_GET_ACTIVE_LIST = 4;
    public static final ServiceType ST_GET_ACTIVE_LIST = new ServiceType(2,_ST_GET_ACTIVE_LIST,"ST_GET_ACTIVE_LIST");
    public static final int _ST_GET_TOP_lIST = 8;
    public static final ServiceType ST_GET_TOP_lIST = new ServiceType(3,_ST_GET_TOP_lIST,"ST_GET_TOP_lIST");

    public static ServiceType convert(int val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].value() == val)
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public static ServiceType convert(String val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].toString().equals(val))
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public int value()
    {
        return __value;
    }

    public String toString()
    {
        return __T;
    }

    private ServiceType(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
