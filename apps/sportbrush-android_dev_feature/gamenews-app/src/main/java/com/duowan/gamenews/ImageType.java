// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class ImageType
{
    private static ImageType[] __values = new ImageType[2];
    private int __value;
    private String __T = new String();

    public static final int _IMAGE_TYPE_SMALL = 1;
    public static final ImageType IMAGE_TYPE_SMALL = new ImageType(0,_IMAGE_TYPE_SMALL,"IMAGE_TYPE_SMALL");
    public static final int _IMAGE_TYPE_BIG = 2;
    public static final ImageType IMAGE_TYPE_BIG = new ImageType(1,_IMAGE_TYPE_BIG,"IMAGE_TYPE_BIG");

    public static ImageType convert(int val)
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

    public static ImageType convert(String val)
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

    private ImageType(int index, int val, String s)
    {
        __T = s;
        __value = val;
        __values[index] = this;
    }

}
