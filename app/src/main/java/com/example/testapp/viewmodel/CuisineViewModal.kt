package com.example.testapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.testapp.adapter.ItemListAdapter
import com.example.testapp.adapter.SlideAdapter
import com.example.testapp.repository.DataRepository

class CuisineViewModal(
    private val dataRepository: DataRepository,
) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val dataRepository = DataRepository()

                CuisineViewModal(
                    dataRepository = dataRepository
                )
            }
        }
    }

    var imageSliderAdapter = SlideAdapter(dataRepository.getCuisineList())
    var subListAdapter = ItemListAdapter(dataRepository.getIndianCuisine())


}