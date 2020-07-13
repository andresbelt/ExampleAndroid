package com.valid.ui.component.main


import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.valid.bussinesLogic.errors.ErrorManager
import com.valid.bussinesLogic.getTopArtistUseCase
import com.valid.data.Resource
import com.valid.data.dto.ResponseGetTop
import com.valid.data.dto.ResponseGetTopTracks
import com.valid.data.errors.ErrorMapper
import com.valid.ui.base.BaseViewModel
import com.valid.util.Event
import javax.inject.Inject

class TracksListViewModel @Inject
constructor(private val recipesDataUseCase: getTopArtistUseCase) : BaseViewModel() {


    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())

    var tracksLiveData: MutableLiveData<Resource<ResponseGetTopTracks>> = recipesDataUseCase.tracksLiveData

    var recipesLiveData: MutableLiveData<Resource<ResponseGetTop>> = recipesDataUseCase.recipesLiveData

    private val recipesSearchFoundPrivate: MutableLiveData<ResponseGetTop> = MutableLiveData()
    val recipesSearchFound: LiveData<ResponseGetTop> get() = recipesSearchFoundPrivate

    private val noSearchFoundPrivate: MutableLiveData<Unit> = MutableLiveData()
    val noSearchFound: LiveData<Unit> get() = noSearchFoundPrivate

    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    private val openrecipesDetailsPrivate = MutableLiveData<Event<ResponseGetTop>>()
    val openRecipesDetails: LiveData<Event<ResponseGetTop>> get() = openrecipesDetailsPrivate

    /**
     * Error handling as UI
     */
    private val showSnackBarPrivate = MutableLiveData<Event<Int>>()
    val showSnackBar: LiveData<Event<Int>> get() = showSnackBarPrivate

    private val showToastPrivate = MutableLiveData<Event<Any>>()
    val showToast: LiveData<Event<Any>> get() = showToastPrivate


    fun getRecipes() {
        recipesDataUseCase.getRecipes()
    }


    fun getTracks() {
        recipesDataUseCase.getTopTracks()
    }

    fun openRecipesDetails(recipesItem: ResponseGetTop) {
        openrecipesDetailsPrivate.value = Event(recipesItem)
    }

    fun showSnackbarMessage(@StringRes message: Int) {
        showSnackBarPrivate.value = Event(message)
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = Event(error.description)
    }

    fun onSearchClick(recipesTitle: String) {
//        if (recipesTitle.isNotEmpty()) {
//            val recipesItem = recipesDataUseCase.searchByTitle(recipesTitle)
//            if (recipesItem != null) {
//                recipesSearchFoundPrivate.value = recipesItem
//            } else {
//                noSearchFoundPrivate.postValue(Unit)
//            }
//        } else {
//            noSearchFoundPrivate.postValue(Unit)
//        }
    }
}