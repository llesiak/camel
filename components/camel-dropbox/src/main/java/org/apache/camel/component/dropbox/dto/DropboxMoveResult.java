/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.dropbox.dto;

import org.apache.camel.Exchange;
import org.apache.camel.component.dropbox.util.DropboxResultHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DropboxMoveResult extends DropboxResult {

    private static final transient Logger LOG = LoggerFactory.getLogger(DropboxMoveResult.class);

    /**
     * Object payload contained in Exchange
     * Exchange Header and Body contains the mode path
     * @param exchange
     */
    @Override
    public void populateExchange(Exchange exchange) {
        String movedPath = (String)resultEntries;
        exchange.getIn().setHeader(DropboxResultHeader.MOVED_PATH.name(), movedPath);
        exchange.getIn().setBody(movedPath);
    }
}
