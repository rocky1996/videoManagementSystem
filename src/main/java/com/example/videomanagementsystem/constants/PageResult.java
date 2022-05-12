package com.example.videomanagementsystem.constants;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private int pageNum;

    private int pageSize;

    private long itemCount;

    private int pageCount;

    private List<T> items;

    public static <T> PageResult<T> fromPageResult(List<T> list, PageResult pageResult) {
        PageResult<T> result = new PageResult();
        result.setItems(list);
        result.setPageCount(pageResult.getPageCount());
        result.setPageNum(pageResult.getPageNum());
        result.setPageSize(pageResult.getPageSize());
        result.setItemCount(pageResult.getItemCount());
        return result;
    }

    public static <T> PageResult<T> fromList(List<T> list) {
        PageInfo<T> info = new PageInfo(list);
        PageResult<T> result = new PageResult();
        result.setItems(info.getList());
        result.setPageCount(info.getPages());
        result.setPageNum(info.getPageNum());
        result.setPageSize(info.getPageSize());
        result.setItemCount(info.getTotal());
        return result;
    }

    public static <T> PageResult<T> create(PageInfo info, List<T> data) {
        PageResult<T> result = new PageResult();
        result.setItems(data);
        result.setPageCount(info.getPages());
        result.setPageNum(info.getPageNum());
        result.setPageSize(info.getPageSize());
        result.setItemCount(info.getTotal());
        return result;
    }

    public static <T> PageInfo<T> createPageInfo(int start, int limit, int size) {
        PageInfo<T> pageInfo = new PageInfo();
        int pages = size % limit == 0 ? size / limit : size / limit + 1;
        pageInfo.setPages(pages);
        int pageNum = start % limit == 0 ? start / limit : start / limit + 1;
        pageInfo.setPageNum(pageNum);
        int pageSize = start + limit > size ? size - start : limit;
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal((long)size);
        return pageInfo;
    }
}

