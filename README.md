# Great Adventure

面向大学生与年轻人的 Android 城市散步探索项目，计划结合高德地图、天气推荐与本地足迹日记。

## 当前状态

初始工程包含 Kotlin、Android Views/XML、Material Components、View Binding、ViewModel 和 repository 接口。首页三个入口展示开发状态。真实地图、定位、天气、推荐算法和 Room 尚未接入，不会生成虚假的到访记录。

## 在 Android Studio 中打开

1. 克隆本仓库，或使用已有本地副本。
2. 选择 **Open**，打开包含 `settings.gradle.kts` 的根目录，不是 `app` 子目录。
3. 使用支持 AGP 9.3 的 Android Studio，安装 SDK Platform 37 和 Build Tools 36.0.0。当前 Studio 生成的 `gradle/gradle-daemon-jvm.properties` 将 Gradle 运行环境固定为 JDK 25，可以使用对应 Studio 自带的 JDK；Java 源代码兼容级别为 17。
4. 等待 Gradle Sync 完成；首次同步需要连接 Google Maven、Maven Central 和 Gradle 分发服务。
5. 选择 `app` 和 API 26 或以上的模拟器或真机，点击 Run。

Android Studio 会维护本机的 `local.properties`（SDK 路径），不要提交该文件。

命令行验证（需配置 `JAVA_HOME` 和 SDK 路径）：

```sh
./gradlew :app:assembleDebug :app:lintDebug
```

Windows 使用 `gradlew.bat`。安装包位于 `app/build/outputs/apk/debug/app-debug.apk`。

## 工程约定

- 应用 ID / namespace：`com.lemanty.greatadventure`
- 最低版本 API 26，编译 / 目标版本 API 37
- AGP 9.3.3、Gradle 9.5.0；依赖集中在 `gradle/libs.versions.toml`
- 使用 AGP 内置 Kotlin 支持，不重复添加 `org.jetbrains.kotlin.android` 插件
- UI 使用 XML Views，便于后续接入地图 MapView 和 RecyclerView

```text
app/src/main/java/com/lemanty/greatadventure/
├── ui/                   # Activity、ViewModel，后续添加页面
├── domain/model/         # 地点、天气及带坐标系的位置模型
└── data/repository/      # POI 与天气接口、统一请求结果
app/src/main/res/layout/  # XML 页面布局
```

## Luozizhen 从哪里开始

1. 阅读 `data/repository/PlaceRepository.kt` 和 `WeatherRepository.kt`，和队友确认输入输出。
2. 用测试区域的固定坐标验证高德 POI 和 OpenWeather 的覆盖、凭证与返回字段。
3. 添加 Retrofit / Gson 和相应 DTO、服务及 repository 实现，把服务商响应转换为 `domain/model` 中的模型；高德 SDK 调用遵循官方接入方式。
4. 处理超时、空列表、缺失字段和天气未知，不吞掉协程取消异常。页面离开时取消无用请求，避免每次位置变化都请求天气。
5. 接入 ViewModel，与队友联调地图和卡片；推荐排序逻辑单独放在 domain 层。

位置必须注明 WGS84 或 GCJ02，在服务边界显式转换，距离计算不得混用。搜索和到访记录共用稳定 POI ID。测试数据明确标注，不能当作实时接口结果。

## 后续团队模块

- UI：地图容器、基础迷雾、推荐卡片、日记页和解锁反馈。
- MAP：前台定位、POI、天气、推荐与接近判定。
- DATA：Room 到访和网格记录、DataStore 设置、去重与持久化。

在 GitHub issues 中确认具体负责人；以上为模块边界，不代表已经确定个人分工。Room、DataStore、高德、Retrofit、Gson、Lottie 等在各自集成验证时加入并固定版本。

## 凭证和贡献

不要把 API Key、签名文件或密码写入代码或 Git。后续可使用被忽略的 `secrets.properties`，完成读取配置的代码后接入。本版本没有读取或打包 API Key。客户端打包的 Key 并非服务器秘密，还应使用服务商提供的包名、签名等限制。

保留有意义的个人提交，新增外部代码、SDK 和素材时记录版本、来源、许可证与修改。本工程沿用仓库现有 MIT LICENSE；依赖遵循各自许可证。

配置依据：[AGP 9.3 官方说明](https://developer.android.com/build/releases/agp-9-3-0-release-notes)、[内置 Kotlin 支持](https://developer.android.com/build/migrate-to-built-in-kotlin)。

## 初始化验证

2026-10-12：本地执行 `:app:assembleDebug :app:lintDebug` 成功，已生成 Debug APK。尚未进行模拟器或真机运行验证，也未测试尚未接入的外部服务。
