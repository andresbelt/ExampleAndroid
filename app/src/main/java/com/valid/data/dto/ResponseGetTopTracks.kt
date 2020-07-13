package com.valid.data.dto

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseGetTopTracks(
	@field:SerializedName("tracks")
	val tracks: Tracks?
)
@JsonClass(generateAdapter = true)

data class Tracks(

	@field:SerializedName("@attr")
	val attr: Attr? = null,

	@field:SerializedName("track")
	val track: List<TrackItem?>? = null
)
@JsonClass(generateAdapter = true)

data class Attr(

	@field:SerializedName("rank")
	val rank: String? = null
)
@JsonClass(generateAdapter = true)

data class Artist(

	@field:SerializedName("mbid")
	val mbid: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
@JsonClass(generateAdapter = true)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String? = null,

	@field:SerializedName("size")
	val size: String? = null
)
@JsonClass(generateAdapter = true)

data class TrackItem(

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("image")
	val image: List<ImageItem?>? = null,

	@field:SerializedName("@attr")
	val attr: Attr? = null,

	@field:SerializedName("mbid")
	val mbid: String? = null,

	@field:SerializedName("listeners")
	val listeners: String? = null,

	@field:SerializedName("streamable")
	val streamable: Streamable? = null,

	@field:SerializedName("artist")
	val artist: Artist? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
@JsonClass(generateAdapter = true)

data class Streamable(

	@field:SerializedName("#text")
	val text: String? = null,

	@field:SerializedName("fulltrack")
	val fulltrack: String? = null
)