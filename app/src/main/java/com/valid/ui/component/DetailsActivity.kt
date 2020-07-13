package com.valid.ui.component

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.valid.data.Resource
import com.valid.databinding.DetailsactivityBinding
import com.valid.ui.ViewModelFactory
import com.valid.util.Constants
import com.valid.util.Event
import com.valid.util.observe
import com.google.android.material.snackbar.Snackbar
import com.task.ui.base.BaseActivity
import com.valid.util.showToast
import javax.inject.Inject


class DetailsActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: DetailsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: DetailsactivityBinding


    override fun initViewBinding() {
        binding = DetailsactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val id =  intent.getStringExtra(Constants.RECIPES_ITEM_KEY)
        //viewModel.getDetailRecipe(id)
    }

    override fun observeViewModel() {
       // observe(viewModel.recipeDetailItemLiveData, ::handleRecipesList)
    }

    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(viewModel::class.java)
    }


//    private fun handleRecipesList(RecipeItem: Resource<RecipeDetailItem>) {
//        when (RecipeItem) {
//            is Resource.Loading -> showLoadingView()
//            is Resource.Success -> RecipeItem.data?.let {
//                initializeView(recipeItem = it)
//            }
//            is Resource.DataError -> {
//                showDataView(false)
//                RecipeItem.errorCode?.let { viewModel.showToastMessage(it) }
//            }
//        }
//
//    }


 //   private fun initializeView(recipeItem: RecipeDetailItem) {
//        binding.tvTitle.text = recipeItem.title
//        binding.tvDescription.text = recipeItem.title
//        if (!recipeItem.image.isNullOrEmpty()) {
//            Picasso.get().load(recipeItem.image).placeholder(R.drawable.news)
//                    .into(binding.img_url)
//        }
   // }

    private fun observeToast(event: LiveData<Event<Any>>) {
        binding.rlDetails.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun showDataView(show: Boolean) {
//        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
//        binding.rlRecipesList.visibility = if (show) View.VISIBLE else View.GONE
//        binding.pbLoading.toGone()
    }

    private fun showLoadingView() {
//        binding.pbLoading.toVisible()
//        binding.tvNoData.toGone()
//        binding.rlRecipesList.toGone()
    }



}
