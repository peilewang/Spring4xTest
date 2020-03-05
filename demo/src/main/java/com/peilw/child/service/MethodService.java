package com.peilw.child.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MethodService {
    @Secured("ROLE_ADMIN")
    public String admin(){
        return "hello admin";
    }
    @PreAuthorize("hasRole('ADMIN') and hasRole('DBA')")
    public String dba(){
        return "hello dba";
    }
}
