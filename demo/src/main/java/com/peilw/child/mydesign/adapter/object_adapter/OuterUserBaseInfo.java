package com.peilw.child.mydesign.adapter.object_adapter;

import java.util.HashMap;
import java.util.Map;

public class OuterUserBaseInfo implements IOuterUserBaseInfo{
    @Override
    public Map getUserBaseInfo() {
        HashMap hashMap=new HashMap();
        hashMap.put("userName","名字");
        hashMap.put("mobileNumber","电话");
        return hashMap;
    }
}
