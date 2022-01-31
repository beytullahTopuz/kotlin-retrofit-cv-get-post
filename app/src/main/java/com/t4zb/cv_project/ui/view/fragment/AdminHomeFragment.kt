package com.t4zb.cv_project.ui.view.fragment

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.t4zb.cv_project.R
import com.t4zb.cv_project.databinding.FragmentAdminHomeBinding
import com.t4zb.cv_project.modelLayer.rest.service.event.Cv
import com.t4zb.cv_project.modelLayer.rest.service.repo.PostCvApi
import com.t4zb.cv_project.ui.adapter.CvListAdapter
import com.t4zb.cv_project.ui.viewModel.SharedViewModel
import com.t4zb.cv_project.util.showLogDebug


class AdminHomeFragment : Fragment() {

    private lateinit var mBinding: FragmentAdminHomeBinding
    private lateinit var mContext: FragmentActivity
    private lateinit var mSharedViewModel: SharedViewModel
    private lateinit var cvListAdapter: CvListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = requireActivity()


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentAdminHomeBinding.bind(view)
        mSharedViewModel =
            ViewModelProvider(requireActivity(), defaultViewModelProviderFactory).get(
                SharedViewModel::class.java
            )


        mBinding.cvListRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)

        mSharedViewModel.dataRepo.cvData.observe(viewLifecycleOwner,{
            if (it != null && it.isNotEmpty()){
                cvListAdapter = CvListAdapter(mContext,it,mSharedViewModel)
                mBinding.cvListRecyclerView.adapter = cvListAdapter
            }
        })



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_home, container, false)
    }

    companion object {

    }
}