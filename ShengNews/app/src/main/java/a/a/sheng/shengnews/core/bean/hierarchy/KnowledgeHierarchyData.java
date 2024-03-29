package a.a.sheng.shengnews.core.bean.hierarchy;

import java.io.Serializable;
import java.util.List;

public class KnowledgeHierarchyData implements Serializable {
    /**
     *  "children": [],
     "courseId": 13,
     "id": 150,
     "name": "开发环境",
     "order": 1,
     "parentChapterId": 0,
     "visible": 1
     */

     private List<KnowledgeHierarchyData> children;
     private int courseId;
     private int it;
     private String name;
     private int order;
     private int parentChapterId;
     private int visible;

    public List<KnowledgeHierarchyData> getChildren() {
        return children;
    }

    public void setChildren(List<KnowledgeHierarchyData> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
