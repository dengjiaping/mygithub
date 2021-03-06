// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class AppInitReq extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.AppInitReq";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.AppInitReq";
    }

    public java.util.ArrayList<String> gameName = null;

    public int serviceType = 0;

    public java.util.ArrayList<com.duowan.gamenews.AdvIdInfo> advInfo = null;

    public java.util.ArrayList<String> getGameName()
    {
        return gameName;
    }

    public void  setGameName(java.util.ArrayList<String> gameName)
    {
        this.gameName = gameName;
    }

    public int getServiceType()
    {
        return serviceType;
    }

    public void  setServiceType(int serviceType)
    {
        this.serviceType = serviceType;
    }

    public java.util.ArrayList<com.duowan.gamenews.AdvIdInfo> getAdvInfo()
    {
        return advInfo;
    }

    public void  setAdvInfo(java.util.ArrayList<com.duowan.gamenews.AdvIdInfo> advInfo)
    {
        this.advInfo = advInfo;
    }

    public AppInitReq()
    {
        setGameName(gameName);
        setServiceType(serviceType);
        setAdvInfo(advInfo);
    }

    public AppInitReq(java.util.ArrayList<String> gameName, int serviceType, java.util.ArrayList<com.duowan.gamenews.AdvIdInfo> advInfo)
    {
        setGameName(gameName);
        setServiceType(serviceType);
        setAdvInfo(advInfo);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        AppInitReq t = (AppInitReq) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(gameName, t.gameName) && 
            com.duowan.taf.jce.JceUtil.equals(serviceType, t.serviceType) && 
            com.duowan.taf.jce.JceUtil.equals(advInfo, t.advInfo) );
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
        if (null != gameName)
        {
            _os.write(gameName, 0);
        }
        _os.write(serviceType, 1);
        if (null != advInfo)
        {
            _os.write(advInfo, 2);
        }
    }

    static java.util.ArrayList<String> cache_gameName;
    static java.util.ArrayList<com.duowan.gamenews.AdvIdInfo> cache_advInfo;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        if(null == cache_gameName)
        {
            cache_gameName = new java.util.ArrayList<String>();
            String __var_48 = "";
            ((java.util.ArrayList<String>)cache_gameName).add(__var_48);
        }
        setGameName((java.util.ArrayList<String>) _is.read(cache_gameName, 0, false));

        setServiceType((int) _is.read(serviceType, 1, false));

        if(null == cache_advInfo)
        {
            cache_advInfo = new java.util.ArrayList<com.duowan.gamenews.AdvIdInfo>();
            com.duowan.gamenews.AdvIdInfo __var_49 = new com.duowan.gamenews.AdvIdInfo();
            ((java.util.ArrayList<com.duowan.gamenews.AdvIdInfo>)cache_advInfo).add(__var_49);
        }
        setAdvInfo((java.util.ArrayList<com.duowan.gamenews.AdvIdInfo>) _is.read(cache_advInfo, 2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(gameName, "gameName");
        _ds.display(serviceType, "serviceType");
        _ds.display(advInfo, "advInfo");
    }

}

