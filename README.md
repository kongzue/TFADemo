# TFADemo
两步验证Demo（two-factor authentication）与Google的两步验证工具保持一致

![two-factor authentication](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/tfa_demo.jpg)

## 两步验证

以下科普介绍来源 https://www.iplaysoft.com/two-factor-authentication.html

### 什么是两步验证（two-factor authentication）？

国内很多网络服务 (如淘宝、银行)，除了正确的帐号密码之外，常常还需要额外给你发一条手机短信验证码，以此进一步确认你是帐号的真正主人。

这其实就是「两步验证」或者叫做「双因素验证」的一种实现方式，它这里第二步验证是靠手机短信来发送验证码的。而国外更多的网站/网络服务还会使用一种叫“身份验证器”或叫“虚拟 MFA”的二步验证方式，它是利用一种“随时间变化的验证码”来取代手机短信，不仅更安全，而且可离线使用，通用性也更强……

和短信验证码一样道理，这里的两步验证也是相当于给帐号多加一把“锁”(多一步的验证)，在输入正确的账号密码之后，用户同样还需要额外输入一个每 30 秒自动变化一次的 6 位数字「二步验证码」才能完成登录。

所以即使你的帐号和密码不慎泄露了，别人在没有这个数字验证码也是无法登录你的账号的，这可以大大提高破解的难度和帐号的安全性。所以建议所有能开启二步验证的重要网络帐号都要全部开启。

### 二步验证和手机短信验证码有什么区别？

手机短信验证码和两步验证的目的和作用基本一致，不过很多的 (国外) 网络服务并不支持发送手机短信验证码，主要是短信成本高，而且有安全性风险 (比如 2G 网络下黑客可以利用 GSM 漏洞监听截取到用户的手机号码和短信内容)。

而本文所说的二步验证是指虚拟 MFA，或者说是“身份验证器”，是基于时间和加密算法生成“每 30 秒变化一次的 6 位数字验证码”，也叫做 TOTP (Time-Based One-time Password) 或 OTP 一次性密码。它的优点是使用时无需联网、仅需时间进行计算、速度快、可离线使用、没有额外成本、算法协议公开通用，开发和使用上都很简单，可以用小型硬件 (实体的密码器) 或纯软件 APP 来实现，因此更多的网站会支持这种方式。

## 项目简介

本项目中使用的是基于时间 TOTP 算法生成 6 位验证码的，每 30 秒变化一次，结果可与 Google 官方的二步验证工具保持一致。

## 开源许可

```
Copyright TFADemo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```