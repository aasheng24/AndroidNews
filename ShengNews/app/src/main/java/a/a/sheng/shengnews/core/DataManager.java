package a.a.sheng.shengnews.core;

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
import a.a.sheng.shengnews.core.dao.HistoryData;
import a.a.sheng.shengnews.core.db.DbHelper;
import a.a.sheng.shengnews.core.http.HttpHelper;
import a.a.sheng.shengnews.core.prefs.PreferenceHelper;
import io.reactivex.Observable;

public class DataManager implements HttpHelper, DbHelper, PreferenceHelper {
    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferenceHelper = preferencesHelper;
    }

    @Override
    public List<HistoryData> addHistoryData(String data) {
        return null;
    }

    @Override
    public void clearHistoryData() {

    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum) {
        return mHttpHelper.getFeedArticleList(pageNum);
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getSearchList(int pageNum, String k) {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<TopSearchData>>> getTopSearchData() {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites() {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowLedgeHierarchyData() {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(int page, int cid) {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<NavigationListData>>> getNavigationListData() {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData() {
        return null;
    }

    @Override
    public Observable<BaseResponse<ProjectListData>> getProjectListData(int page, int cid) {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<WxAuthor>>> getWxAuthorListData() {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getWxSumData(int id, int page) {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getWxSearchSumData(int id, int page, String k) {
        return null;
    }

    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return null;
    }

    @Override
    public Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword) {
        return null;
    }

    @Override
    public Observable<BaseResponse<LoginData>> logout() {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectArticle(int id) {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> addCollectOutSideArticle(String title, String author, String link) {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getCollectList(int page) {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(int id) {
        return null;
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(int id) {
        return null;
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHttpHelper.getBannerData();
    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public void setLoginPassword(String password) {

    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    @Override
    public String getLoginPassword() {
        return null;
    }

    @Override
    public void setLoginStatus(boolean isLogin) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public void setCookie(String domain, String cookie) {

    }

    @Override
    public String getCookie(String domain) {
        return null;
    }

    @Override
    public void setCurrentPage(int position) {

    }

    @Override
    public int getCurrentPage() {
        return 0;
    }

    @Override
    public void setProjectCurrentPage(int position) {

    }

    @Override
    public int getProjectCurrentPage() {
        return 0;
    }

    @Override
    public boolean getAutoCacheState() {
        return false;
    }

    @Override
    public boolean getNoImageState() {
        return false;
    }

    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setNightModeState(boolean b) {

    }

    @Override
    public void setNoImageState(boolean b) {

    }

    @Override
    public void setAutoCacheState(boolean b) {

    }
}
