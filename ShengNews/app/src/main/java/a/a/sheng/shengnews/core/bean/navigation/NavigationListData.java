package a.a.sheng.shengnews.core.bean.navigation;

import java.io.Serializable;
import java.util.List;

import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleData;

public class NavigationListData implements Serializable {
    /**
     * "articles": [],
     * "cid": 272,
     * "name": "常用网站"
     */

    private List<FeedArticleData> articles;
    private int cid;
    private String name;

    public List<FeedArticleData> getArticles() {
        return articles;
    }

    public void setArticles(List<FeedArticleData> articles) {
        this.articles = articles;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
