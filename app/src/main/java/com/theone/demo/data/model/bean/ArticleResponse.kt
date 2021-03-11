package com.theone.demo.data.model.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import android.service.quicksettings.Tile
import android.text.TextUtils
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

/**
 * 文章
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class ArticleResponse(
    var apkLink: String,
    var author: String,//作者
    var chapterId: Int,
    var chapterName: String,
    var collect: Boolean,//是否收藏
    var courseId: Int,
    var desc: String,
    var envelopePic: String,
    var fresh: Boolean,
    var id: Int,
    var link: String,
    var niceDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var superChapterId: Int,
    var superChapterName: String,
    var shareUser: String,
    var tags: List<TagsResponse>?,
    var title: String,
    var type: Int,
    var userId: Int,
    var visible: Int,
    var zan: Int
) : IWeb, Parcelable {

    override fun getWebUrl(): String = link

    override fun getWebTitle(): String = title

    fun showTags(): Boolean {
        return null != tags && tags!!.isNotEmpty()
    }
}
