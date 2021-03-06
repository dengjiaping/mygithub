// **********************************************************************
// This file was generated by a TAF parser!
// TAF version 2.1.4.3.
// Generated from `gamenews.jce'
// **********************************************************************

package com.duowan.gamenews;

public final class ArticleInfo extends com.duowan.taf.jce.JceStruct implements java.lang.Cloneable
{
    public String className()
    {
        return "gamenews.ArticleInfo";
    }

    public String fullClassName()
    {
        return "com.duowan.gamenews.ArticleInfo";
    }

    public long id = 0;

    public String title = "";

    public java.util.ArrayList<String> imageList = null;

    public java.util.ArrayList<String> videoList = null;

    public String sourceName = "";

    public int time = 0;

    public int commentCount = 0;

    public int articleType = 0;

    public String sourceUrl = "";

    public String channelName = "";

    public long flag = 0;

    public java.util.Map<Long, String> extraInfo = null;

    public int praiseCount = 0;

    public long getId()
    {
        return id;
    }

    public void  setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void  setTitle(String title)
    {
        this.title = title;
    }

    public java.util.ArrayList<String> getImageList()
    {
        return imageList;
    }

    public void  setImageList(java.util.ArrayList<String> imageList)
    {
        this.imageList = imageList;
    }

    public java.util.ArrayList<String> getVideoList()
    {
        return videoList;
    }

    public void  setVideoList(java.util.ArrayList<String> videoList)
    {
        this.videoList = videoList;
    }

    public String getSourceName()
    {
        return sourceName;
    }

    public void  setSourceName(String sourceName)
    {
        this.sourceName = sourceName;
    }

    public int getTime()
    {
        return time;
    }

    public void  setTime(int time)
    {
        this.time = time;
    }

    public int getCommentCount()
    {
        return commentCount;
    }

    public void  setCommentCount(int commentCount)
    {
        this.commentCount = commentCount;
    }

    public int getArticleType()
    {
        return articleType;
    }

    public void  setArticleType(int articleType)
    {
        this.articleType = articleType;
    }

    public String getSourceUrl()
    {
        return sourceUrl;
    }

    public void  setSourceUrl(String sourceUrl)
    {
        this.sourceUrl = sourceUrl;
    }

    public String getChannelName()
    {
        return channelName;
    }

    public void  setChannelName(String channelName)
    {
        this.channelName = channelName;
    }

    public long getFlag()
    {
        return flag;
    }

    public void  setFlag(long flag)
    {
        this.flag = flag;
    }

    public java.util.Map<Long, String> getExtraInfo()
    {
        return extraInfo;
    }

    public void  setExtraInfo(java.util.Map<Long, String> extraInfo)
    {
        this.extraInfo = extraInfo;
    }

    public int getPraiseCount()
    {
        return praiseCount;
    }

    public void  setPraiseCount(int praiseCount)
    {
        this.praiseCount = praiseCount;
    }

    public ArticleInfo()
    {
        setId(id);
        setTitle(title);
        setImageList(imageList);
        setVideoList(videoList);
        setSourceName(sourceName);
        setTime(time);
        setCommentCount(commentCount);
        setArticleType(articleType);
        setSourceUrl(sourceUrl);
        setChannelName(channelName);
        setFlag(flag);
        setExtraInfo(extraInfo);
        setPraiseCount(praiseCount);
    }

    public ArticleInfo(long id, String title, java.util.ArrayList<String> imageList, java.util.ArrayList<String> videoList, String sourceName, int time, int commentCount, int articleType, String sourceUrl, String channelName, long flag, java.util.Map<Long, String> extraInfo, int praiseCount)
    {
        setId(id);
        setTitle(title);
        setImageList(imageList);
        setVideoList(videoList);
        setSourceName(sourceName);
        setTime(time);
        setCommentCount(commentCount);
        setArticleType(articleType);
        setSourceUrl(sourceUrl);
        setChannelName(channelName);
        setFlag(flag);
        setExtraInfo(extraInfo);
        setPraiseCount(praiseCount);
    }

    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        ArticleInfo t = (ArticleInfo) o;
        return (
            com.duowan.taf.jce.JceUtil.equals(id, t.id) && 
            com.duowan.taf.jce.JceUtil.equals(title, t.title) && 
            com.duowan.taf.jce.JceUtil.equals(imageList, t.imageList) && 
            com.duowan.taf.jce.JceUtil.equals(videoList, t.videoList) && 
            com.duowan.taf.jce.JceUtil.equals(sourceName, t.sourceName) && 
            com.duowan.taf.jce.JceUtil.equals(time, t.time) && 
            com.duowan.taf.jce.JceUtil.equals(commentCount, t.commentCount) && 
            com.duowan.taf.jce.JceUtil.equals(articleType, t.articleType) && 
            com.duowan.taf.jce.JceUtil.equals(sourceUrl, t.sourceUrl) && 
            com.duowan.taf.jce.JceUtil.equals(channelName, t.channelName) && 
            com.duowan.taf.jce.JceUtil.equals(flag, t.flag) && 
            com.duowan.taf.jce.JceUtil.equals(extraInfo, t.extraInfo) && 
            com.duowan.taf.jce.JceUtil.equals(praiseCount, t.praiseCount) );
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
        if (null != title)
        {
            _os.write(title, 1);
        }
        if (null != imageList)
        {
            _os.write(imageList, 2);
        }
        if (null != videoList)
        {
            _os.write(videoList, 3);
        }
        if (null != sourceName)
        {
            _os.write(sourceName, 4);
        }
        _os.write(time, 5);
        _os.write(commentCount, 6);
        _os.write(articleType, 7);
        if (null != sourceUrl)
        {
            _os.write(sourceUrl, 8);
        }
        if (null != channelName)
        {
            _os.write(channelName, 9);
        }
        _os.write(flag, 10);
        if (null != extraInfo)
        {
            _os.write(extraInfo, 11);
        }
        _os.write(praiseCount, 12);
    }

    static java.util.ArrayList<String> cache_imageList;
    static java.util.ArrayList<String> cache_videoList;
    static java.util.Map<Long, String> cache_extraInfo;

    public void readFrom(com.duowan.taf.jce.JceInputStream _is)
    {
        setId((long) _is.read(id, 0, false));

        setTitle( _is.readString(1, false));

        if(null == cache_imageList)
        {
            cache_imageList = new java.util.ArrayList<String>();
            String __var_7 = "";
            ((java.util.ArrayList<String>)cache_imageList).add(__var_7);
        }
        setImageList((java.util.ArrayList<String>) _is.read(cache_imageList, 2, false));

        if(null == cache_videoList)
        {
            cache_videoList = new java.util.ArrayList<String>();
            String __var_8 = "";
            ((java.util.ArrayList<String>)cache_videoList).add(__var_8);
        }
        setVideoList((java.util.ArrayList<String>) _is.read(cache_videoList, 3, false));

        setSourceName( _is.readString(4, false));

        setTime((int) _is.read(time, 5, false));

        setCommentCount((int) _is.read(commentCount, 6, false));

        setArticleType((int) _is.read(articleType, 7, false));

        setSourceUrl( _is.readString(8, false));

        setChannelName( _is.readString(9, false));

        setFlag((long) _is.read(flag, 10, false));

        if(null == cache_extraInfo)
        {
            cache_extraInfo = new java.util.HashMap<Long, String>();
            Long __var_9 = 0L;
            String __var_10 = "";
            cache_extraInfo.put(__var_9, __var_10);
        }
        setExtraInfo((java.util.Map<Long, String>) _is.read(cache_extraInfo, 11, false));

        setPraiseCount((int) _is.read(praiseCount, 12, false));

    }

    public void display(java.lang.StringBuilder _os, int _level)
    {
        com.duowan.taf.jce.JceDisplayer _ds = new com.duowan.taf.jce.JceDisplayer(_os, _level);
        _ds.display(id, "id");
        _ds.display(title, "title");
        _ds.display(imageList, "imageList");
        _ds.display(videoList, "videoList");
        _ds.display(sourceName, "sourceName");
        _ds.display(time, "time");
        _ds.display(commentCount, "commentCount");
        _ds.display(articleType, "articleType");
        _ds.display(sourceUrl, "sourceUrl");
        _ds.display(channelName, "channelName");
        _ds.display(flag, "flag");
        _ds.display(extraInfo, "extraInfo");
        _ds.display(praiseCount, "praiseCount");
    }

}

