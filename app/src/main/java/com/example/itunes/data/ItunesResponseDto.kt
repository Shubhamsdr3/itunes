package com.example.itunes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItunesResponseDto(

    val resultCount: Int,

    val results: List<ItuneDto>
): Serializable

@Entity(tableName = "video_detail")
data class ItuneDto(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val videoId: Int,

        @SerializedName("wrapperType")
        @ColumnInfo(name = "wrapperType", defaultValue = "")
        val wrapperType: String? = null,

        @SerializedName("kind")
        @ColumnInfo(name = "kind", defaultValue = "")
        val kind: String? = null,

        @SerializedName("artistId")
        @ColumnInfo(name = "artistId", defaultValue = "")
        val artistId: Long? = null,

        @SerializedName("trackId")
        @ColumnInfo(name = "trackId", defaultValue = "")
        val trackId: Long? = null,

        @SerializedName("artistName")
        @ColumnInfo(name = "artistName", defaultValue = "")
        val artistName: String? = null ,

        @SerializedName("collectionName")
        @ColumnInfo(name = "collectionName", defaultValue = "")
        val collectionName: String? = null,

        @SerializedName("trackName")
        @ColumnInfo(name = "trackName", defaultValue = "")
        val trackName: String? = null,

        @SerializedName("collectionPrice")
        @ColumnInfo(name = "collectionPrice", defaultValue = "")
        val collectionPrice: String? = null,

        @SerializedName("releaseDate")
        @ColumnInfo(name = "releaseDate", defaultValue = "")
        val releaseDate: String? = null,

        @SerializedName("collectionCensoredName")
        @ColumnInfo(name = "collectionCensoredName", defaultValue = "")
        val collectionCensoredName: String? = null,

        @SerializedName("artworkUrl100")
        @ColumnInfo(name = "artworkUrl100", defaultValue = "")
        val previewImage: String? = null,

        @SerializedName("previewUrl")
        @ColumnInfo(name = "previewUrl", defaultValue = "")
        val previewUrl: String? = null

): Serializable