package com.laptrinhjavaweb.command;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AbstractCommand<T> {
    protected T pojo;
    private List<T> listResult;
    private Integer maxPageItems = 5;
    private Integer totalItems = 0;
    private Integer firstItem = 0;
    private Integer page = 1;
    private Integer totalPages = 0;
    private String sortExpression;
    private String sortDirection;
    private String[] checkList;
}
