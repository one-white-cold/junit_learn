/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.handlers;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;

import java.util.Arrays;
import java.util.List;

/**
 * @author wang shu long
 * @since 2024/10/15
 */
public class YearTableNameHandler implements TableNameHandler {
    private List<String> tableNames;
    private static final ThreadLocal<String> YEAR_DATA = new ThreadLocal<>();

    public static void setYearData(String year) {
        YEAR_DATA.set(year);
    }

    public static void removeYearData() {
        YEAR_DATA.remove();
    }

    public YearTableNameHandler(String... tableName) {
        this.tableNames = Arrays.asList(tableName);
    }

    @Override
    public String dynamicTableName(String sql, String tableName) {
        if (this.tableNames.contains(tableName)) {
            if (YEAR_DATA.get() != null) {
                return tableName + "_" + YEAR_DATA.get();
            } else {
                return tableName;
            }
        } else {
            return tableName;
        }
    }
}
