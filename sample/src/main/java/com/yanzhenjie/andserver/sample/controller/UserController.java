/*
 * Copyright 2018 Yan Zhenjie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yanzhenjie.andserver.sample.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.RestController;
import com.yanzhenjie.andserver.sample.entity.UserInfo;
import com.yanzhenjie.andserver.sample.util.AppUtils;
import com.yanzhenjie.andserver.sample.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by YanZhenjie on 2018/6/7.
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    /**
     * Login.
     * @param account account.
     * @param password password.
     * @return json text.
     */
    @PostMapping(path = "/login", produces = Constants.CONTENT_JSON)
    public String login(@RequestParam(name = "account") String account,
                        @RequestParam(name = "password") String password) {
        if ("andserver".equals(account) && "andserver".equals(password)) {
            return AppUtils.successfulJsonData("Login successful.");
        }
        return AppUtils.failedJsonData(0, "Account or password error.");
    }

    /**
     * Getting user list.
     * @return json text.
     */
    @GetMapping(path = "/list", produces = Constants.CONTENT_JSON)
    public String userList() {
        List<UserInfo> infoList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(Integer.toString(i));
            userInfo.setUserName(String.format(Locale.getDefault(), "User %1$d", i));
            infoList.add(userInfo);

        }
        return JSON.toJSONString(infoList);
    }

}