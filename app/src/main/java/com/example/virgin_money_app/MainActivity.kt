package com.example.virgin_money_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virgin_money_app.Adapter.PeopleAdapter
import com.example.virgin_money_app.Viewmodel.PeopleViewModel
import com.example.virgin_money_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var peopleadapter: PeopleAdapter
    private val viewModel: PeopleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        peopleadapter = PeopleAdapter()
        binding.RecyclerView.apply {
            adapter = peopleadapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        viewModel.responsePeople.observe(this, { response ->

            if (response != null){
                peopleadapter.submitList(response)
            }
        })
    }
}