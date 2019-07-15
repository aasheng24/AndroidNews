package a.a.sheng.shengnews.core.http;

import java.util.List;

import javax.inject.Inject;

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
import a.a.sheng.shengnews.core.http.api.GeeksApis;
import io.reactivex.Observable;

public class HttpHelperImpl implements HttpHelper {
    private GeeksApis mGeeksApis;

    @Inject
    HttpHelperImpl (GeeksApis geeksApis) {
        mGeeksApis = geeksApis;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum) {
        return mGeeksApis.getFeedArticleList(pageNum);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getSearchList(int pageNum, String k) {
        return mGeeksApis.getSearchList(pageNum,k);
    }

    @Override
    public Observable<BaseResponse<List<TopSearchData>>> getTopSearchData() {
        return mGeeksApis.getTopSearchData();
    }

    @Override
    public Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites() {
        return mGeeksApis.getUsefulSites();
    }

    @Override
    public Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowLedgeHierarchyData() {
        return mGeeksApis.getKnowledgeHierarchyData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(int page, int cid) {
        return mGeeksApis.getKnowledgeHierarchyDetailData(page, cid);
    }

    @Override
    public Observable<BaseResponse<List<NavigationListData>>> getNavigationListData() {
        return mGeeksApis.getNavigationListData();
    }

    @Override
    public Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData() {
        return mGeeksApis.getProjectClassifyData();
    }

    @Override
    public Observable<BaseResponse<ProjectListData>> getProjectListData(int page, int cid) {
        return mGeeksApis.getProjectListData(page, cid);
    }

    @Override
    public Observable<BaseResponse<List<WxAuthor>>> getWxAuthorListData() {
        return mGeeksApis.getWxAuthorListData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getWxSumData(int id, int page) {
        return mGeeksApis.getWxSumData(id, page);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getWxSearchSumData(int id, int page, String k) {
        return mGeeksApis.getWxSearchSumData(id, page, k);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return mGeeksApis.getLoginData(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword) {
        return mGeeksApis.getRegisterData(username, password, rePassword);
    }

    @Override
    public Observable<BaseResponse<LoginData>> logout() {
        return mGeeksApis.logout();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectArticle(int id) {
        return mGeeksApis.addCollectArticle(id);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectOutSideArticle(String title, String author, String link) {
        return mGeeksApis.addCollectOutsideArticle(title, author, link);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getCollectList(int page) {
        return mGeeksApis.getCollectList(page);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(int id) {
        return mGeeksApis.cancelCollectPageArticle(id, -1);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(int id) {
        return mGeeksApis.cancelCollectArticle(id, -1);
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mGeeksApis.getBannerData();
    }
}
