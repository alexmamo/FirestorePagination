package ro.alexmamo.firestorepagination.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ro.alexmamo.firestorepagination.data.Product
import ro.alexmamo.firestorepagination.databinding.ProductDataBinding
import ro.alexmamo.firestorepagination.products.ProductsAdapter.*

class ProductsAdapter : PagingDataAdapter<Product, ProductViewHolder>(Companion) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding = ProductDataBinding.inflate(
                layoutInflater,
                parent,
                false
        )
        return ProductViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position) ?: return
        holder.bindProduct(product)
    }

    companion object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    inner class ProductViewHolder(
            private val dataBinding: ProductDataBinding
    ) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bindProduct(product: Product) {
            dataBinding.product = product
        }
    }
}