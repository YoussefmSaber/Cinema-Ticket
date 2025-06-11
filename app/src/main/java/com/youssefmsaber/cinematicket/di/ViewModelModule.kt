package com.youssefmsaber.cinematicket.di

import com.youssefmsaber.cinematicket.home.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}