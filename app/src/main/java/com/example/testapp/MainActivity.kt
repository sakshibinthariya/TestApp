package com.example.testapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.viewpager2.widget.ViewPager2
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.repository.DataRepository
import com.example.testapp.viewmodel.CuisineViewModal
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataRepository: DataRepository = DataRepository()
 private val viewModel: CuisineViewModal by viewModels { CuisineViewModal.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setState()
        setSublistItems()
        searchData()
    }

    private fun setSublistItems() {
        binding.recyclerView.adapter = viewModel.subListAdapter
    }

    private fun setState() {
        binding.viewPager.adapter = viewModel.imageSliderAdapter
        TabLayoutMediator( binding.tabLayout,  binding.viewPager) { tab, position ->
            viewModel.subListAdapter.updateData(dataRepository.getCuisineList()[position].sublistItems)

        }.attach()


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.subListAdapter.updateData(dataRepository.getCuisineList()[position].sublistItems)

            }

        })
    }

    private fun searchData(){
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.subListAdapter.filter.filter(newText.toString())
                return true
            }

        })
    }
}