package com.valid.ui.component.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.task.ui.base.BaseActivity
import com.valid.R
import com.valid.data.Resource
import com.valid.data.dto.ResponseGetTop
import com.valid.databinding.ActivityMainBinding
import com.valid.ui.ViewModelFactory
import com.valid.util.*
import javax.inject.Inject

class ArtistsActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    var isLastPage: Boolean = false
    var isLoading: Boolean = false


    @Inject
    lateinit var recipesViewModel: RecipesListViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun initializeViewModel() {
        recipesViewModel = viewModelFactory.create(recipesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.toolbarLayout.icToolbarSetting.setOnClickListener {
            if (!(binding.etSearch.text?.toString().isNullOrEmpty())) {
                binding.pbLoading.visibility = View.VISIBLE
                recipesViewModel.onSearchClick(binding.etSearch.text?.toString()!!)
            }
        }
        val layoutManager = LinearLayoutManager(this)
        binding.rvRecipesList.layoutManager = layoutManager
        binding.rvRecipesList.setHasFixedSize(true)

        recipesViewModel.getRecipes()


    }

    private fun bindListData(recipeItem: ResponseGetTop) {
        if (!(recipeItem.topartists!!.artist.isNullOrEmpty())) {
            val RecipesAdapter =
                RecipesAdapter(
                    recipesViewModel,
                    recipeItem.topartists!!.artist
                )
            binding.rvRecipesList.adapter = RecipesAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }

    }

    private fun navigateToDetailsScreen(navigateEvent: Event<ResponseGetTop>) {
//        navigateEvent.getContentIfNotHandled()?.let {
//                        val nextScreenIntent = Intent(this, DetailsActivity::class.java).apply {
//                putExtra(RECIPES_ITEM_KEY, it.id)
//            }
//            startActivity(nextScreenIntent)
//        }
    }

    private fun observeSnackBarMessages(event: LiveData<Event<Int>>) {
        binding.rlRecipesList.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }

    private fun observeToast(event: LiveData<Event<Any>>) {
        binding.rlRecipesList.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun showSearchError() {
        recipesViewModel.showSnackbarMessage(R.string.search_error)
    }

    private fun showDataView(show: Boolean) {
        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
        binding.rlRecipesList.visibility = if (show) View.VISIBLE else View.GONE
        binding.pbLoading.toGone()
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.rlRecipesList.toGone()
    }


    private fun showSearchResult(RecipesItem: ResponseGetTop) {
        recipesViewModel.openRecipesDetails(RecipesItem)
        binding.pbLoading.toGone()
    }

    private fun noSearchResult(unit: Unit) {
        showSearchError()
        binding.pbLoading.toGone()
    }

    private fun handleRecipesList(RecipeItem: Resource<ResponseGetTop>) {
        when (RecipeItem) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> RecipeItem.data?.let {
                bindListData(recipeItem = it)
            }
            is Resource.DataError -> {
                showDataView(false)
                RecipeItem.errorCode?.let { recipesViewModel.showToastMessage(it) }
            }
        }

    }



    override fun observeViewModel() {
        observe(recipesViewModel.recipesLiveData, ::handleRecipesList)
        observe(recipesViewModel.recipesSearchFound, ::showSearchResult)
        observe(recipesViewModel.noSearchFound, ::noSearchResult)
        observeEvent(recipesViewModel.openRecipesDetails, ::navigateToDetailsScreen)
        observeSnackBarMessages(recipesViewModel.showSnackBar)
        observeToast(recipesViewModel.showToast)

    }
}

