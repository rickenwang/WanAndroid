package com.leaf.feature.common.services.server.wanandroid.entities


/**
 *
 * Created by leafwang on 2023/2/2.
 */

// {"data":
//   {"curPage":1,
//     "datas":[
//       {"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":25644,"isAdminAdd":false,"link":"https://juejin.cn/post/7195535228230975547","niceDate":"10小时前","niceShareDate":"10小时前","origin":"","prefix":"","projectLink":"","publishTime":1675391109000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1675391109000,"shareUser":"linversion","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android使用基准配置文件(Baseline Profile)方案提升启动速度记录","type":0,"userId":70466,"visible":1,"zan":0},
//       {"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":607,"chapterName":"网易云音乐技术团队","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":25636,"isAdminAdd":false,"link":"https://juejin.cn/post/7194630163924484155","niceDate":"21小时前","niceShareDate":"21小时前","origin":"","prefix":"","projectLink":"","publishTime":1675352354000,"realSuperChapterId":604,"selfVisible":0,"shareDate":1675352354000,"shareUser":"","superChapterId":605,"superChapterName":"大厂对外分享 - 学习路径","tags":[],"title":"Android 调试实战与原理详解","type":0,"userId":2,"visible":1,"zan":0}
//   "errorCode":0,"errorMsg":""}

data class ListArticleEntity (
    val errorCode: Int = 0,
    val errorMessage: String? = null,
    val data: ListArticleDataEntity,
)

data class ListArticleDataEntity(
    val curPage: Int,
    val datas: List<ListArticleDataDatasEntity>
)

data class ListArticleDataDatasEntity(
    val title: String,
    val author: String,
)
