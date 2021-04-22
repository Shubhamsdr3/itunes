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
        val wrapperType: String = "",

        @SerializedName("kind")
        @ColumnInfo(name = "kind", defaultValue = "")
        val kind: String = "",

        @SerializedName("artistId")
        @ColumnInfo(name = "artistId", defaultValue = "")
        val artistId: Long,

        @SerializedName("trackId")
        @ColumnInfo(name = "trackId", defaultValue = "")
        val trackId: Long,

        @SerializedName("artistName")
        @ColumnInfo(name = "artistName", defaultValue = "")
        val artistName: String = "",

        @SerializedName("collectionName")
        @ColumnInfo(name = "collectionName", defaultValue = "")
        val collectionName: String = "",

        @SerializedName("trackName")
        @ColumnInfo(name = "trackName", defaultValue = "")
        val trackName: String = "",

        @SerializedName("collectionPrice")
        @ColumnInfo(name = "collectionPrice", defaultValue = "")
        val collectionPrice: String = "",

        @SerializedName("releaseDate")
        @ColumnInfo(name = "releaseDate", defaultValue = "")
        val releaseDate: String = "",

        @SerializedName("collectionCensoredName")
        @ColumnInfo(name = "collectionCensoredName", defaultValue = "")
        val collectionCensoredName: String = "",

        @SerializedName("artworkUrl100")
        @ColumnInfo(name = "artworkUrl100", defaultValue = "")
        val previewImage: String = "",

        @SerializedName("previewUrl")
        @ColumnInfo(name = "previewUrl", defaultValue = "")
        val previewUrl: String = ""

): Serializable