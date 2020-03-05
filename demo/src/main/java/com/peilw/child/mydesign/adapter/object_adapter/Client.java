package com.peilw.child.mydesign.adapter.object_adapter;

public class Client {
    public static void main(String[] args){
        IOuterUserOfficeInfo iOuterUserOfficeInfo=new OuterUserOfficeInfo();
        IOuterUserHomeInfo iOuterUserHomeInfo=new OuterUserHomeInfo();
        IOuterUserBaseInfo iOuterUserBaseInfo=new OuterUserBaseInfo();
        IUserInfo outerUserInfo=new OuterUserInfo(iOuterUserBaseInfo,iOuterUserHomeInfo,iOuterUserOfficeInfo);
        outerUserInfo.getMobileNumber();
    }
}
