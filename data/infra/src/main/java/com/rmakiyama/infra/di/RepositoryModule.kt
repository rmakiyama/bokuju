package com.rmakiyama.infra.di

import com.rmakiyama.infra.product.ProductRepository
import com.rmakiyama.bokuju.data.access.ProductRepository as IProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideProductRepository(bind: ProductRepository): IProductRepository
}
