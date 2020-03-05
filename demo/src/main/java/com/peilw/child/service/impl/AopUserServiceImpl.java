package com.peilw.child.service.impl;

import com.example.demo.annotation.OperationLogDetail;
import com.example.demo.enums.OperationType;
import com.example.demo.enums.OperationUnit;
import com.peilw.child.service.AopUserService;
import org.springframework.stereotype.Service;

@Service
public class AopUserServiceImpl implements AopUserService {

    @OperationLogDetail(detail = "通过手机号[{{tel}}]获取用户名",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public String findUserName(String tel) {
        System.out.println("tel:" + tel);
        return "zhangsan";
    }
}
