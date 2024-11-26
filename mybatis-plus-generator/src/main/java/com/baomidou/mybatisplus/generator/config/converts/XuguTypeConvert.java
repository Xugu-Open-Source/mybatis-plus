/*
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
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
package com.baomidou.mybatisplus.generator.config.converts;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * <p>
 * MYSQL 数据库字段类型转换
 * </p>
 *
 * @author hubin
 * @since 2017-01-20
 */
public class XuguTypeConvert implements ITypeConvert {

    @Override
    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        String t = fieldType.toLowerCase();
        if (t.contains("char")) {
            return DbColumnType.STRING;
        } else if (t.contains("date") || t.contains("timestamp")) {
            switch (globalConfig.getDateType()) {
                case ONLY_DATE:
                    return DbColumnType.DATE;
                case SQL_PACK:
                    return DbColumnType.TIMESTAMP;
                case TIME_PACK:
                    return DbColumnType.LOCAL_DATE_TIME;
            }
        } else if (t.contains("numeric")) {
            if (t.matches("numeric\\(+\\d\\)")) {
                return DbColumnType.INTEGER;
            } else if (t.matches("numeric\\(+\\d{2}+\\)")) {
                return DbColumnType.LONG;
            }
            return DbColumnType.DOUBLE;
        } else if (t.contains("double")) {
            return DbColumnType.DOUBLE;
        } else if (t.contains("clob")) {
            return DbColumnType.CLOB;
        } else if (t.contains("blob")) {
            return DbColumnType.BLOB;
        } else if (t.contains("binary")) {
            return DbColumnType.BYTE_ARRAY;
        }else if (t.contains("boolean")){
            return DbColumnType.BOOLEAN;
        }else if(t.contains("smallint")){
            return DbColumnType.SHORT;
        }else if (t.contains("float")){
            return DbColumnType.FLOAT;
        }else if (t.contains("time")){
            return DbColumnType.DATE;
        }else if (t.contains("bigint")){
            return DbColumnType.LONG;
        }else if (t.contains("integer")){
            return DbColumnType.INTEGER;
        }

        return DbColumnType.STRING;
    }
}
