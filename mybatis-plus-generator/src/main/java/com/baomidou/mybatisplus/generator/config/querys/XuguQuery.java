/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.generator.config.querys;

import com.baomidou.mybatisplus.annotation.DbType;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>
 * MySql 表数据查询
 * </p>
 *
 * @author hubin
 * @since 2018-01-16
 */
public class XuguQuery extends AbstractDbQuery {


    @Override
    public DbType dbType() {
        return DbType.XUGU;
    }


    @Override
    public String tablesSql() {
        return "SELECT TABLE_NAME,COMMENTS FROM all_tables  WHERE schema_id = (SELECT schema_id FROM all_schemas WHERE schema_name = '%s')";
    }


    @Override
    public String tableFieldsSql() {
        return "SELECT COL_NAME,TYPE_NAME,COMMENTS,(CASE WHEN a.SERIAL_ID != 0 THEN 'PRI' ELSE '' END ) AS KEY  FROM ALL_COLUMNS a WHERE a.TABLE_ID = (SELECT TABLE_ID FROM ALL_TABLES  WHERE TABLE_NAME = '%s') ";
    }


    @Override
    public String tableName() {
        return "TABLE_NAME";
    }


    @Override
    public String tableComment() {
        return "COMMENTS";
    }


    @Override
    public String fieldName() {
        return "COL_NAME";
    }


    @Override
    public String fieldType() {
        return "TYPE_NAME";
    }


    @Override
    public String fieldComment() {
        return "COMMENTS";
    }


    @Override
    public String fieldKey() {
        return "KEY";
    }

}
