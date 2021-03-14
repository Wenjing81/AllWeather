package com.allweather.ui.place

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.allweather.R
import com.allweather.model.Place
import com.allweather.model.QueryPlaceResult
import com.allweather.network.Resource
import com.allweather.network.Status
import com.allweather.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.fragment_place.*


class PlaceFragment : Fragment() {

    val placeViewModel by lazy { ViewModelProvider(this).get(PlaceViewModel::class.java) }
    private lateinit var adapter: PlaceAdapter
    var placeList = mutableListOf<Place>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = layoutManager
        adapter = PlaceAdapter(this, placeList)
        recycler_view.adapter = adapter

        Log.d("PlaceFragment", "1. list count: ${placeList.count()}")

        searchPlaceEdit.addTextChangedListener { editable ->
            val content = editable.toString()

            if (content.isNotEmpty()) {
                placeViewModel.searchPlaces(content)
                Log.d("PlaceFragment", "2.input is not empty")
            } else {
                recycler_view.visibility = View.GONE
                bgImageView.visibility = View.VISIBLE
                placeList.clear()
                adapter.notifyDataSetChanged()
                Log.d("PlaceFragment", "3.input is empty")
            }
        }

        placeViewModel.searchPlace.observe(viewLifecycleOwner, {
            handleSearchPlace(it)
        })
    }

    private fun handleSearchPlace(it: Resource<QueryPlaceResult>) {

        println(it)

        when (it.status) {
            Status.SUCCESS -> {
                recycler_view.visibility = View.VISIBLE
                bgImageView.visibility = View.GONE

                val result = it.data as QueryPlaceResult

                placeList.clear()
                placeList = result.places.toMutableList()

                //update the placeList
                adapter.update(placeList)
                Log.d("PlaceFragment", "4.Search place sucessfully.")

            }
            Status.ERROR -> {

                Log.d("PlaceFragment", "5.Search place error.")
                //Toast.makeText(activity, "can not find any address.", Toast.LENGTH_SHORT).show()
                //result.exceptionOrNull()?.printStackTrace()
            }
            Status.LOADING -> {
                Log.d("PlaceFragment", "6.Search place loading.")
            }
        }
    }
}
