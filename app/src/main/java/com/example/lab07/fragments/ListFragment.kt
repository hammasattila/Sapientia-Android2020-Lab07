package com.example.lab07.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab07.R
import com.example.lab07.adapters.MainRecyclerViewAdapter
import com.example.lab07.data.Food

class ListFragment : Fragment(), MainRecyclerViewAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_main)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MainRecyclerViewAdapter(arrayOf(), this)

        return view
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Item ${position} was clicked.", Toast.LENGTH_SHORT).show()
        findNavController().navigate(ListFragmentDirections.showDetails())
    }
}