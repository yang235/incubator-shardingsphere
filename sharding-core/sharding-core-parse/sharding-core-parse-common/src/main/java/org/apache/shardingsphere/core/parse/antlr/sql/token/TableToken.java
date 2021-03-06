/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.parse.antlr.sql.token;

import lombok.Getter;
import lombok.ToString;
import org.apache.shardingsphere.core.parse.antlr.constant.QuoteCharacter;
import org.apache.shardingsphere.core.parse.util.SQLUtil;

/**
 * Table token.
 *
 * @author zhangliang
 * @author panjuan
 */
@ToString
public final class TableToken extends SQLToken {
    
    @Getter
    private final String tableName;
    
    @Getter
    private final QuoteCharacter quoteCharacter;
    
    private final int ownerLength;
    
    public TableToken(final int startIndex, final String tableName, final int ownerLength) {
        super(startIndex);
        this.tableName = SQLUtil.getExactlyValue(tableName);
        this.quoteCharacter = QuoteCharacter.getQuoteCharacter(tableName);
        this.ownerLength = ownerLength;
    }
    
    /**
     * Get table token length.
     * 
     * @return table token length
     */
    public int getLength() {
        return ownerLength + tableName.length() + quoteCharacter.getStartDelimiter().length() + quoteCharacter.getEndDelimiter().length();
    }
}
