package com.qf.domain;

import java.util.List;

/**
 * Created by 54110 on 2019-05-29.
 */
public class ShopNode extends QfShop {
    List<ShopNode> children;

    public List<ShopNode> getChildren() {
        return children;
    }

    public void setChildren(List<ShopNode> children) {
        this.children = children;
    }
}
