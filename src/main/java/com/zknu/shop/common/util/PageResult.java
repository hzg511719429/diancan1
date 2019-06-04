package com.zknu.shop.common.util;

import java.util.List;

/**
 * @Description: 分页返回最外层对象
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/3/19
 */
public class PageResult {
    private  int curr;//当前页
    private List objects;
    private  int pages;//总页数

    public PageResult(int curr, List objects, int pages) {
        this.curr = curr;
        this.objects = objects;
        this.pages = pages;
    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public List getObjects() {
        return objects;
    }

    public void setObjects(List objects) {
        this.objects = objects;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @param curr 当前页
     * @param objects 对象集合
     * @param pages  总页数
     * @return
     */
    public  static  PageResult buid(int curr, List objects, int pages){
        return  new PageResult(curr,objects,pages);
    }
}
