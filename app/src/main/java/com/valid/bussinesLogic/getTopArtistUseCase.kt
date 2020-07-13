package com.valid.bussinesLogic

import androidx.lifecycle.MutableLiveData
import com.valid.data.Resource
import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks
import com.valid.data.errors.ErrorEnum.Companion.NETWORK_ERROR
import com.valid.data.server.Source
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class getTopArtistUseCase
@Inject
constructor(private val dataRepository: Source, override val coroutineContext: CoroutineContext
) :
    topArtistCase,
    CoroutineScope {
    private val recipesMutableLiveData = MutableLiveData<Resource<ResponseGetTop>>()
    private val tracksMutableLiveData = MutableLiveData<Resource<ResponseGetTopTracks>>()
    override val recipesLiveData: MutableLiveData<Resource<ResponseGetTop>> = recipesMutableLiveData
    override val tracksLiveData: MutableLiveData<Resource<ResponseGetTopTracks>> = tracksMutableLiveData

    override fun getRecipes() {
        var serviceResponse: Resource<ResponseGetTop>
        recipesMutableLiveData.postValue(Resource.Loading())
        launch {
            try {
                serviceResponse = dataRepository.getTopArtists()
                recipesMutableLiveData.postValue(serviceResponse)
            } catch (e: Exception) {
                recipesMutableLiveData.postValue(Resource.DataError(NETWORK_ERROR))
            }
        }
    }


    override fun getTopTracks() {
        var serviceResponse: Resource<ResponseGetTopTracks>
        tracksMutableLiveData.postValue(Resource.Loading())
        launch {
            try {
                serviceResponse = dataRepository.getTopTracks()
                tracksMutableLiveData.postValue(serviceResponse)
            } catch (e: Exception) {
                tracksMutableLiveData.postValue(Resource.DataError(NETWORK_ERROR))
            }
        }
    }


    override fun searchByTitle(keyWord: String): ResponseGetTop? {
        TODO("Not yet implemented")
    }

//    override fun searchByTitle(keyWord: String): RecipeItem? {
////        val Recipes = RecipesMutableLiveData.value?.data?.RecipesItems
////        if (!Recipes.isNullOrEmpty()) {
////            for (RecipesItem in Recipes) {
////                if (RecipesItem.title.isNotEmpty() && RecipesItem.title.toLowerCase().contains(keyWord.toLowerCase())) {
////                    return RecipesItem
////                }
////            }
////        }
//        return null
//    }
}
