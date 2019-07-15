package a.a.sheng.shengnews.core.http;

import java.util.List;

import a.a.sheng.shengnews.core.bean.BaseResponse;
import a.a.sheng.shengnews.core.bean.hierarchy.KnowledgeHierarchyData;
import a.a.sheng.shengnews.core.bean.main.banner.BannerData;
import a.a.sheng.shengnews.core.bean.main.collect.FeedArticleListData;
import a.a.sheng.shengnews.core.bean.main.login.LoginData;
import a.a.sheng.shengnews.core.bean.main.search.TopSearchData;
import a.a.sheng.shengnews.core.bean.main.search.UsefulSiteData;
import a.a.sheng.shengnews.core.bean.navigation.NavigationListData;
import a.a.sheng.shengnews.core.bean.project.ProjectClassifyData;
import a.a.sheng.shengnews.core.bean.project.ProjectListData;
import a.a.sheng.shengnews.core.bean.wx.WxAuthor;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HttpHelper {

    //获取feed文章列表
    Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum);

    //获取搜索的文章列表
    Observable<BaseResponse<FeedArticleListData>> getSearchList(int pageNum, String k);

    //热搜
    Observable<BaseResponse<List<TopSearchData>>> getTopSearchData();

    //常用网站
    Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites();

    //知识体系
    Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowLedgeHierarchyData();

    //知识体系下的文章
    Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(int page, int cid);

    //导航
    Observable<BaseResponse<List<NavigationListData>>> getNavigationListData();

    //项目分类
    Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData();

    //项目类别数据
    Observable<BaseResponse<ProjectListData>> getProjectListData(int page, int cid);

    //获取公众号列表
    Observable<BaseResponse<List<WxAuthor>>> getWxAuthorListData();

    //获取当前公众号某页的数据
    Observable<BaseResponse<FeedArticleListData>> getWxSumData(int id, int page);

    //指定搜索内容，搜索当前公众号的某页的此类数据
    Observable<BaseResponse<FeedArticleListData>> getWxSearchSumData(int id, int page, String k);

    //登陆
    Observable<BaseResponse<LoginData>> getLoginData(String username, String password);

    //注册
    Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword);

    //退出登陆
    @GET("user/logout/json")
    Observable<BaseResponse<LoginData>> logout();

    //收藏站内文章
    Observable<BaseResponse<FeedArticleListData>> addCollectArticle(int id);

    //收藏站外文章
    Observable<BaseResponse<FeedArticleListData>> addCollectOutSideArticle(String title, String author, String link);

    //获取收藏列表
    Observable<BaseResponse<FeedArticleListData>> getCollectList(int page);

    //取消收藏页面站内文章
    Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(int id);

    //取消站内文章
    Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(int id);

    //广告栏
    Observable<BaseResponse<List<BannerData>>> getBannerData();
}
