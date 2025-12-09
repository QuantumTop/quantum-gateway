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
package org.apache.dubbo.cache;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;
public class CacheFactory$Adaptive implements org.apache.dubbo.cache.CacheFactory {
public org.apache.dubbo.cache.Cache getCache(org.apache.dubbo.common.URL arg0, org.apache.dubbo.rpc.Invocation arg1)  {
if (arg0 == null) throw new IllegalArgumentException("url == null");
org.apache.dubbo.common.URL url = arg0;
if (arg1 == null) throw new IllegalArgumentException("invocation == null"); String methodName = arg1.getMethodName();
String extName = url.getMethodParameter(methodName, "cache", "lru");
if(extName == null) throw new IllegalStateException("Failed to get extension (org.apache.dubbo.cache.CacheFactory) name from url (" + url.toString() + ") use keys([cache])");
ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), org.apache.dubbo.cache.CacheFactory.class);
org.apache.dubbo.cache.CacheFactory extension = (org.apache.dubbo.cache.CacheFactory)scopeModel.getExtensionLoader(org.apache.dubbo.cache.CacheFactory.class).getExtension(extName);
return extension.getCache(arg0, arg1);
}
}
