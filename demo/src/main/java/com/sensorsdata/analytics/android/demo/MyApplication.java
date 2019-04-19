/*
 * Created by wangzhuozhou on 2016/11/12.
 * Copyright 2015－2019 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.sensorsdata.analytics.android.demo;

import android.app.Application;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    /**
     * Sensors Analytics 采集数据的地址
     */
    private final static String SA_SERVER_URL = "http://sdkdebugtest.datasink.sensorsdata.cn/sa?project=default&token=cfb8b60e42e0ae9b";

    @Override
    public void onCreate() {
        super.onCreate();
        initSensorsDataAPI();
    }

    /**
     * 初始化 Sensors Analytics SDK
     */
    private void initSensorsDataAPI() {
        SensorsDataAPI.sharedInstance(
                this,                               // 传入 Context
                SA_SERVER_URL);                     // Debug 模式选项
        // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
        List<SensorsDataAPI.AutoTrackEventType> eventTypeList = new ArrayList<>();
        // $AppStart
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_START);
        // $AppEnd
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_END);
        // $AppViewScreen
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN);
        // $AppClick
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_CLICK);
        SensorsDataAPI.sharedInstance(this).enableAutoTrack(eventTypeList);
    }
}
