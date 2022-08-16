package com.insurance.calculator.MVCservice;

import com.insurance.calculator.models.Book;
import org.springframework.security.acls.model.Permission;

public interface PermissionService {

    void addPermissionForUser(Book book, Permission permission, String username);
}
