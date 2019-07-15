package a.a.sheng.shengnews.core.dao;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HistoryData {
    private int id;
    private long date;
    private String data;
    @Generated(hash = 416000527)
    public HistoryData(int id, long date, String data) {
        this.id = id;
        this.date = date;
        this.data = data;
    }
    @Generated(hash = 422767273)
    public HistoryData() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getDate() {
        return this.date;
    }
    public void setDate(long date) {
        this.date = date;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
