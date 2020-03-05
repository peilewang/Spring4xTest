package com.peilw.child.mydesign.adapter.object_adapter;

import java.util.HashMap;
import java.util.Map;

public class OuterUserHomeInfo implements IOuterUserHomeInfo{
    @Override
    public Map getUserHomeInfo() {
        HashMap hashMap=new HashMap();
        hashMap.put("homeNumber","家庭电话");
        hashMap.put("homeAddress","家庭地址");
        return hashMap;
    }
}
