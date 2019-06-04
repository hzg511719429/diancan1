package com.zknu.shop.common.util;

import java.util.List;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/5/18
 */
public  class TNode{
    int id;
    int pId;//父亲id
    String name;//节点名称
    List<String> td; //其他需要显示的字段

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTd() {
        return td;
    }

    public void setTd(List<String> td) {
        this.td = td;
    }
}
