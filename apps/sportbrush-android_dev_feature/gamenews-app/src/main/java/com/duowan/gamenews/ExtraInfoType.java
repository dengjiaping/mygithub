// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class ExtraInfoType
{
    private static ExtraInfoType[] __values = new ExtraInfoType[1];
    private int __value;
    private String __T = new String();

    public static final int _EATRAINFO_TYPE_SUPRISE_AWARD = 1;
    public static final ExtraInfoType EATRAINFO_TYPE_SUPRISE_AWARD = new ExtraInfoType(0,_EATRAINFO_TYPE_SUPRISE_AWARD,"EATRAINFO_TYPE_SUPRISE_AWARD");

    public static ExtraInfoType convert(int val)
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

    public static ExtraInfoType convert(String val)
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

    private ExtraInfoType(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}