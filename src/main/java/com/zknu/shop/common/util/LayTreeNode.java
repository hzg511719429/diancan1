package com.zknu.shop.common.util;

import java.util.List;

/**
 * @Description: layui的树结构
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/5/19
 */

public class LayTreeNode {
    private String name;
    private Short id;
    private Short parentId;

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    private List<LayTreeNode> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LayTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<LayTreeNode> children) {
        this.children = children;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }
}
