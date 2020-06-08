package net.xinhuamm.auth.utils;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import net.xinhuamm.noah.common.model.PageResult;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author yangyongping
 */
@Slf4j
public class PageUtils {


    public static <T> PageResult<T> toPageResult(PageInfo<T> pageInfo) {
        log.debug(JSON.toJSONString(pageInfo));
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCurrent(pageInfo.getPageNum());
        pageResult.setRecords(pageInfo.getList());
        pageResult.setSize(pageInfo.getPageSize());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setPages(pageInfo.getPages());
        log.debug(JSON.toJSONString(pageResult));
        return pageResult;
    }

    public static <T, R> PageResult<R> toPageResult(PageResult<T> page, Function<T, R> function) {
        log.debug(JSON.toJSONString(page));

        PageResult<R> pageResult = new PageResult<>();
        List<R> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(page.getRecords())) {
            for (T t : page.getRecords()) {
                list.add(function.apply(t));
            }
        }
        pageResult.setCurrent(page.getCurrent());
        pageResult.setRecords(list);
        pageResult.setSize(page.getSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());
        log.debug(JSON.toJSONString(pageResult));
        return pageResult;
    }

    public static <T, R> PageResult<R> toPageResult(PageInfo<T> pageInfo, Function<T, R> function) {
        PageResult<R> pageResult = new PageResult<>();
        pageResult.setCurrent(pageInfo.getPageNum());
        List<R> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(pageInfo.getList())) {
            for (T t : pageInfo.getList()) {
                list.add(function.apply(t));
            }
        }
        pageResult.setRecords(list);
        pageResult.setSize(pageInfo.getPageSize());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setPages(pageInfo.getPages());
        return pageResult;
    }
}
