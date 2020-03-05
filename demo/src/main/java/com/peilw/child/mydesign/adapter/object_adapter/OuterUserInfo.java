package com.peilw.child.mydesign.adapter.object_adapter;

import java.util.Map;

//适配器
public class OuterUserInfo implements IUserInfo{
    private IOuterUserOfficeInfo iOuterUserOfficeInfo;
    private IOuterUserHomeInfo iOuterUserHomeInfo;
    private IOuterUserBaseInfo iOuterUserBaseInfo;
    private Map baseMap;
    private Map homeMap;
    private Map officeMap;
    public OuterUserInfo(IOuterUserBaseInfo iOuterUserBaseInfo,IOuterUserHomeInfo iOuterUserHomeInfo,IOuterUserOfficeInfo iOuterUserOfficeInfo){
        this.iOuterUserBaseInfo=iOuterUserBaseInfo;
        this.iOuterUserHomeInfo=iOuterUserHomeInfo;
        this.iOuterUserOfficeInfo=iOuterUserOfficeInfo;
        this.baseMap=this.iOuterUserBaseInfo.getUserBaseInfo();
        this.homeMap=this.iOuterUserHomeInfo.getUserHomeInfo();
        this.officeMap=this.iOuterUserOfficeInfo.getUserOfficeInfo();
    }
    @Override
    public String getUserName() {
        String userName= (String) this.baseMap.get("userName");
        return userName;
    }

    @Override
    public String getHomeAddress() {
       String homeAddress=(String)this.homeMap.get("homeAddress");
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        return null;
    }

    @Override
    public String getJobPosition() {
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        return null;
    }
}
