package ro.alexmamo.firestorepagination.products

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState.Loading
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ro.alexmamo.firestorepagination.R
import ro.alexmamo.firestorepagination.databinding.ActivityProductsBinding

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityProductsBinding
    private val viewModel by viewModels<ProductsViewModel>()
    private val adapter = ProductsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = setContentView(this, R.layout.activity_products)
        setProductsAdapter()
        getProducts()
        setProgressBarAccordingToLoadState()
    }

    private fun setProductsAdapter() {
        dataBinding.productsRecyclerView.adapter = adapter
    }

    private fun getProducts() {
        lifecycleScope.launch {
            viewModel.flow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun setProgressBarAccordingToLoadState() {
        lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest {
                dataBinding.progressBar.isVisible = it.append is Loading
            }
        }
    }
}