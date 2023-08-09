package com.example.a68.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.a68.R
import com.example.a68.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding //lateinit es responsabilidad del desarrollador
    private val razaPerrosViewModel: RazaPerrosViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.rvRazasPerros.setOnClickListener{
            razaPerrosViewModel.getAllRazas()
        }
        return binding.root
    }

    private fun initAdapter() {
        val adapterRazaPerros = AdapterRazaPerros()
        binding.rvRazasPerros.adapter = adapterRazaPerros
        razaPerrosViewModel.razaPerrosLiveData().observe(viewLifecycleOwner){
            adapterRazaPerros.setData(it)
        }
    }
}