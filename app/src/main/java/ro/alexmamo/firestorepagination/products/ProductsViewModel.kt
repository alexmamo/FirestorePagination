package ro.alexmamo.firestorepagination.products

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.google.firebase.firestore.Query
import ro.alexmamo.firestorepagination.utils.Constants.PAGE_SIZE

class ProductsViewModel @ViewModelInject constructor(
    private val queryProductsByName: Query
) : ViewModel() {
    val flow = Pager(
            PagingConfig(
                    pageSize = PAGE_SIZE
            )
    ) {
        FirestorePagingSource(queryProductsByName)
    }.flow.cachedIn(viewModelScope)
}