package net.xinhuamm.auth.utils;

import java.util.Objects;

/**
 *
 * @author zhouzhou
 * @date 2019/1/31
 */
public class NumberUtil {

    private NumberUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Long parseLong(String v) {
        if (null == v) {
            return null;
        }
        String str = String.valueOf(v);

        if (Objects.isNull(str) || str.trim().length() == 0) {
            return null;
        }
        return Long.parseLong(str);
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNullOrLteZero(Long value) {
        if (Objects.isNull(value)) {
            return true;
        }
        if (0 >= value.longValue()) {
            return true;
        }
        return false;
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNotNullOrLteZero(Long value) {
        return !isNullOrLteZero(value);
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNullOrLteZero(Integer value) {
        if (Objects.isNull(value)) {
            return true;
        }
        if (0 >= value.intValue()) {
            return true;
        }
        return false;
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNotNullOrLteZero(Integer value) {
        return !isNullOrLteZero(value);
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNullOrLteZero(Float value) {
        if (Objects.isNull(value)) {
            return true;
        }
        if (0 >= value.intValue()) {
            return true;
        }
        return false;
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNotNullOrLteZero(Float value) {
        return !isNullOrLteZero(value);
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNullOrLteZero(Double value) {
        if (Objects.isNull(value)) {
            return true;
        }
        if (0 >= value.intValue()) {
            return true;
        }
        return false;
    }

    /**
     * 判读数字是否为空, 是否小于等于0
     * @return
     */
    public static boolean isNotNullOrLteZero(Double value) {
        return !isNullOrLteZero(value);
    }

}
