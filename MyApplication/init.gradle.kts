// 全局 Gradle 配置 - 使用国内镜像源
allprojects {
    buildscript {
        repositories {
            maven { url = uri("https://maven.aliyun.com/repository/google") }
            maven { url = uri("https://maven.aliyun.com/repository/public") }
            maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
            maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
        }
    }
    
    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
    }
}

// 禁用 Gradle 源码下载以避免网络问题
gradle.taskGraph.whenReady {
    allprojects {
        tasks.withType<JavaCompile> {
            options.isVerbose = false
        }
    }
}
