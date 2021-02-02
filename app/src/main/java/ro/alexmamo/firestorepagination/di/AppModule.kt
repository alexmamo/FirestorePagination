package ro.alexmamo.firestorepagination.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query.Direction.ASCENDING
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.firestorepagination.utils.Constants.NAME_PROPERTY
import ro.alexmamo.firestorepagination.utils.Constants.PAGE_SIZE
import ro.alexmamo.firestorepagination.utils.Constants.PRODUCTS_COLLECTION
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideQueryProductsByName() = FirebaseFirestore.getInstance()
            .collection(PRODUCTS_COLLECTION)
            .orderBy(NAME_PROPERTY, ASCENDING)
            .limit(PAGE_SIZE.toLong())
}