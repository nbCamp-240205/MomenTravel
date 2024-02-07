package com.android.traveltube.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.traveltube.databinding.FragmentMyVideoBinding

class MyVideoFragment : Fragment() {

    private var binding: FragmentMyVideoBinding? = null
    private lateinit var adapter: MyVideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyVideoBinding.inflate(inflater, container, false)

        val recyclerView = binding?.rvMyVideoMyHistory
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.layoutManager = layoutManager

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}