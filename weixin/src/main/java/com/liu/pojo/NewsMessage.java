package com.liu.pojo;

import java.util.List;

/**
 * Created by anybody on 2017/1/4.
 */
public class NewsMessage extends BaseMessage {
    //图文消息的数量
    private int ArticleCount;

    //图文消息的内容
    private List<News> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}
