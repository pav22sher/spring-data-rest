package com.example.springdatarest.event;

import com.example.springdatarest.entity.Company;
import com.example.springdatarest.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@RepositoryEventHandler
@Component
public class CompanyEventHandler {

    @HandleBeforeCreate // POST /companies
    public void handleBeforeCreate(Company company) {
        log.info("handleBeforeCreate");
    }

    @HandleAfterCreate // POST /companies
    public void handleAfterCreate(Company company) {
        log.info("handleAfterCreate");
    }

    @HandleBeforeSave // PUT, PATCH /companies
    public void handleBeforeSave(Company company) {
        log.info("handleBeforeSave");
    }

    @HandleAfterSave // PUT, PATCH /companies
    public void handleAfterSave(Company company) {
        log.info("handleAfterSave");
    }

    @HandleBeforeDelete // DELETE /companies
    public void handleBeforeDelete(Company company) {
        log.info("handleBeforeDelete");
    }

    @HandleAfterDelete // DELETE /companies
    public void handleAfterDelete(Company company) {
        log.info("handleAfterDelete");
    }

    @HandleBeforeLinkSave // PUT Content-Type: text/uri-list
    public void handleBeforeLinkSave(Company company, Department department) {
        log.info("handleBeforeLinkSave");
    }

    @HandleAfterLinkSave // PUT Content-Type: text/uri-list
    public void handleAfterLinkSave(Company company, Department department) {
        log.info("handleAfterLinkSave");
    }


    @HandleBeforeLinkDelete // PUT Content-Type: text/uri-list
    public void handleBeforeLinkDelete(Company company, Department department) {
        log.info("handleBeforeLinkDelete");
    }

    @HandleAfterLinkDelete // PUT Content-Type: text/uri-list
    public void handleAfterLinkDelete(Company company, Department department) {
        log.info("handleAfterLinkDelete");
    }
}
