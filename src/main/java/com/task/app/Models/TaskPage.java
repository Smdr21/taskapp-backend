package com.task.app.Models;

import org.springframework.data.domain.Sort;


public class TaskPage {
    private int pageNumber =1;
    private int pageSize =5;
    private Sort.Direction sortDirection = Sort.Direction.DESC;
    private String sortBy = "dateDue";

    public int getPageNumber() {
        return pageNumber;
    }

    public TaskPage(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
