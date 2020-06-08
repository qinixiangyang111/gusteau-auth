package net.xinhuamm.auth.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据库树形结构路径枚举工具类，组装路径枚举
 *
 * @author zhuqingcheng
 */
public class PathEnumerationsUtils {

    private static final String PATH_SEPARATOR = "-";

    private static final String PATH_REGEX_PREFIX = "^";

    private static final String PATH_REGEX_OR = "|";

    /**
     * 组装路径枚举
     *
     * @param id 当前记录id
     * @return
     */
    public static String buildPath(long id) {
        return buildPath("", id);
    }

    /**
     * 组装路径枚举
     *
     * @param parentPath 上级路径枚举
     * @param id         当前记录id
     * @return
     */
    public static String buildPath(String parentPath, long id) {
        return parentPath + id + PATH_SEPARATOR;
    }

    /**
     * 用于组装同时查询满足多个路径枚举的数据，对应数据库查询方式为 REGEXP
     * 查询单个时请直接使用 like
     *
     * @param paths 路径枚举列表
     * @return
     */
    public static String buildPathRegex(List<String> paths) {
        if (CollectionUtils.isEmpty(paths)) {
            throw new IllegalArgumentException("参数paths为空");
        }

        List<String> pathRegexList = paths.stream().distinct()
                .map(x -> PATH_REGEX_PREFIX + x).collect(Collectors.toList());
        return Joiner.on(PATH_REGEX_OR).join(pathRegexList);
    }

    /**
     * 指定level对每个path做处理，只取给定层级的path
     *
     * @param paths 路径枚举列表
     * @param level 层级
     * @return
     */
    public static List<String> analysisPath(List<String> paths, int level) {
        if (CollectionUtils.isEmpty(paths) || level < 0) {
            throw new IllegalArgumentException("参数paths为空或level小于1");
        }

        List<String> pathsForLevel = Lists.newArrayList();
        for (String path : paths) {
            List<String> pathNodes = Arrays.asList(StringUtils.split(path, PATH_SEPARATOR));
            List<String> levelPathNodes = pathNodes.subList(0, level + 1);
            String levelPath = Joiner.on(PATH_SEPARATOR).join(levelPathNodes);
            pathsForLevel.add(levelPath + PATH_SEPARATOR);
        }

        return pathsForLevel;
    }

}
