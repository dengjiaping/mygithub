// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class ArticleCategory extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.ArticleCategory";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.ArticleCategory";
    }

    public int id = 0;

    public String name = "";

    public String url = "";

    public int getId()
    {
        return id;
    }

    public void  setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void  setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void  setUrl(String url)
    {
        this.url = url;
    }

    public ArticleCategory()
    {
        setId(id);
        setName(name);
        setUrl(url);
    }

    public ArticleCategory(int id, String name, String url)
    {
        setId(id);
        setName(name);
        setUrl(url);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ArticleCategory t = (ArticleCategory) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(id, t.id) && 
            com.duowan.taf.jce.JceUtil.equals(name, t.name) && 
            com.duowan.taf.jce.JceUtil.equals(url, t.url) );
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
        _os.write(id, 0);
        if (null != name)
        {
            _os.write(name, 1);
        }
        if (null != url)
        {
            _os.write(url, 2);
        }
    }


    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setId((int) _is.read(id, 0, false));

        setName( _is.readString(1, false));

        setUrl( _is.readString(2, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(id, "id");
        _ds.display(name, "name");
        _ds.display(url, "url");
    }

}
