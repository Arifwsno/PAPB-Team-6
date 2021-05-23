package com.example.projectfoodpedia.utils

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

// ketika udah jalan fungsi disposablenya dihapus

abstract class BaseViewModel: ViewModel() {
    val disposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}