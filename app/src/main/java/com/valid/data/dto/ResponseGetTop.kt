package com.valid.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResponseGetTop(

	@Json(name="topartists")
	val topartists: Topartists? = null
)
@JsonClass(generateAdapter = true)

data class Attr1(

	@Json(name="country")
	val country: String? = null,

	@Json(name="total")
	val total: String? = null,

	@Json(name="perPage")
	val perPage: String? = null,

	@Json(name="totalPages")
	val totalPages: String? = null,

	@Json(name="page")
	val page: String? = null
)
@JsonClass(generateAdapter = true)

data class ArtistItem(

	@Json(name="image")
	val image: List<ImageItem1?>? = null,

	@Json(name="mbid")
	val mbid: String? = null,

	@Json(name="listeners")
	val listeners: String? = null,

	@Json(name="streamable")
	val streamable: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="url")
	val url: String? = null
)
@JsonClass(generateAdapter = true)

data class ImageItem1(

	@Json(name="#text")
	val text: String? = null,

	@Json(name="size")
	val size: String? = null
)
@JsonClass(generateAdapter = true)

data class Topartists(

	@Json(name="@attr")
	val attr: Attr1? = null,

	@Json(name="artist")
	val artist: List<ArtistItem?>? = null
)
