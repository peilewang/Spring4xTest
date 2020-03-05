package com.peilw.child.mydesign.adapter.object_adapter;

import java.util.HashMap;
import java.util.Map;

public class OuterUserOfficeInfo implements IOuterUserOfficeInfo{
    @Override
    public Map getUserOfficeInfo() {
        HashMap hashMap=new HashMap();
        hashMap.put("jobPosition","这个人的职位是boss");
        hashMap.put("officeTelNumber","员工的办公电话是");
        return hashMap;
    }
}
