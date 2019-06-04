package com.zknu.shop.common.util;

import java.util.List;

/**
 * @Description: 封装 treegrid需要的数据格式
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/5/18
 */
public class TreeGridResult {
    List<String> heads; //表头
    List<TNode> tNodes; //节点集合

    public List<String> getHeads() {
        return heads;
    }

    public void setHeads(List<String> heads) {
        this.heads = heads;
    }

    public List<TNode> gettNodes() {
        return tNodes;
    }

    public void settNodes(List<TNode> tNodes) {
        this.tNodes = tNodes;
    }



}
