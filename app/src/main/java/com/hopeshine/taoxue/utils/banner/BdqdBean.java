package com.hopeshine.taoxue.utils.banner;

/**
 * Created by User on 2017/11/7.
 */

public class BdqdBean {
    /**
     * discription :
     * file_type : video
     * id :
     * resource_picture : http://117.71.57.47:10000/resource/uploadFiles/2017/07/17/1500274330465028110_150.png
     * title : 古诗学堂第一部2
     */

    private String discription = "";
    private String file_type = "";
    private String id;
    private String resource_picture = "";
    private String title = "";
    private int collection_num;
    private int visit_num;

    public int getCollection_num() {
        return collection_num;
    }

    public void setCollection_num(int collection_num) {
        this.collection_num = collection_num;
    }

    public int getVisit_num() {
        return visit_num;
    }

    public void setVisit_num(int visit_num) {
        this.visit_num = visit_num;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResource_picture() {
        return resource_picture;
    }

    public void setResource_picture(String resource_picture) {
        this.resource_picture = resource_picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
