package com.deepakjohn141.kotlinapp.network.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deepakjohn141.kotlinapp.database.constant.DBConstants
import com.deepakjohn141.kotlinapp.network.constant.ApiConstants
import com.google.gson.annotations.SerializedName

data class FactsResponse(

	@SerializedName(ApiConstants.TITLE)
	var title: String? = "",

	@SerializedName(ApiConstants.ROWS)
	var rows: List<Fact> = mutableListOf()
)

@Entity(tableName = DBConstants.TABLE_FACT_NAME)
data class Fact(
	@PrimaryKey(autoGenerate = true)
	val id: Int
){
	@SerializedName(ApiConstants.IMAGE_URL)
	@ColumnInfo(name = DBConstants.IMAGE_URL)
	var imageUrl: String? = null

	@ColumnInfo(name = DBConstants.DESCRIPTON)
	var description: String? = null

	@SerializedName(ApiConstants.TITLE)
	@ColumnInfo(name = DBConstants.FACT_TITLE)
	var title: String? = null

	@ColumnInfo(name = DBConstants.TITLE)
	var mainTitle: String? = null

	fun isEmpty() = title.isNullOrBlank() && description.isNullOrBlank() && imageUrl.isNullOrBlank()

}
