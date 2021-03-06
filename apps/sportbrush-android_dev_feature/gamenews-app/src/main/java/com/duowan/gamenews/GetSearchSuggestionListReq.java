// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class GetSearchSuggestionListReq extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.GetSearchSuggestionListReq";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.GetSearchSuggestionListReq";
    }

    public String attachInfo = "";

    public int count = 0;

    public String getAttachInfo()
    {
        return attachInfo;
    }

    public void  setAttachInfo(String attachInfo)
    {
        this.attachInfo = attachInfo;
    }

    public int getCount()
    {
        return count;
    }

    public void  setCount(int count)
    {
        this.count = count;
    }

    public GetSearchSuggestionListReq()
    {
        setAttachInfo(attachInfo);
        setCount(count);
    }

    public GetSearchSuggestionListReq(String attachInfo, int count)
    {
        setAttachInfo(attachInfo);
        setCount(count);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        GetSearchSuggestionListReq t = (GetSearchSuggestionListReq) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(attachInfo, t.attachInfo) && 
            com.duowan.taf.jce.JceUtil.equals(count, t.count) );
    }

    public int hashCode()
    {
        try
        {
            throw new Exception("Need define key first!");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
    public java.lang.Object clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void writeTo(com.duowan.taf.jce.JceOutputStream _os)
    {
        if (null != attachInfo)
        {
            _os.write(attachInfo, 0);
        }
        _os.write(count, 1);
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setAttachInfo( _is.readString(0, false));

        setCount((int) _is.read(count, 1, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(attachInfo, "attachInfo");
        _ds.display(count, "count");
    }

}

