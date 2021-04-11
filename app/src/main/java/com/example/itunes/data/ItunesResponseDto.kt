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
        @ColumnInfo(name = "wrapperType")
        val wrapperType: String = "",

        @SerializedName("kind")
        @ColumnInfo(name = "kind")
        val kind: String = "",

        @SerializedName("artistId")
        @ColumnInfo(name = "artistId")
        val artistId: Long,

        @SerializedName("trackId")
        @ColumnInfo(name = "trackId")
        val trackId: Long,

        @SerializedName("artistName")
        @ColumnInfo(name = "artistName")
        val artistName: String = "",

        @SerializedName("collectionName")
        @ColumnInfo(name = "collectionName")
        val collectionName: String = "",

        @SerializedName("trackName")
        @ColumnInfo(name = "trackName")
        val trackName: String = "",

        @SerializedName("collectionPrice")
        @ColumnInfo(name = "collectionPrice")
        val collectionPrice: String = "",

        @SerializedName("releaseDate")
        @ColumnInfo(name = "releaseDate")
        val releaseDate: String = "",

        @SerializedName("collectionCensoredName")
        @ColumnInfo(name = "collectionCensoredName")
        val collectionCensoredName: String = "",

        @SerializedName("artworkUrl100")
        @ColumnInfo(name = "artworkUrl100")
        val previewImage: String = ""

): Serializable