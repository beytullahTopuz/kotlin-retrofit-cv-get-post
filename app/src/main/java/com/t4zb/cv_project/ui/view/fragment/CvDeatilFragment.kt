package com.t4zb.cv_project.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.t4zb.cv_project.R
import com.t4zb.cv_project.databinding.FragmentCvDeatilBinding
import com.t4zb.cv_project.ui.viewModel.CvDetailViewModel
import com.t4zb.cv_project.ui.viewModel.SharedViewModel
import com.t4zb.cv_project.util.showToast


class CvDeatilFragment : Fragment() {
    private lateinit var mBinding: FragmentCvDeatilBinding
    private lateinit var mContext: FragmentActivity
    private lateinit var mSharedViewModel: SharedViewModel
    private val mViewModel: CvDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentCvDeatilBinding.bind(view)

        var cv = mSharedViewModel.selectedCV!!

        mBinding.lotimg.playAnimation()
        mBinding.userProfileName.text = cv.cv_name
        mBinding.userProfileSurname.text = cv.cv_surname
        mBinding.detailMail.text = cv.cv_email
        mBinding.detailNumber.text = cv.cv_number
        mBinding.detailEducation.text = cv.cv_education.toString()
        mBinding.detailWorkexperience.text = cv.cv_work_experience.toString()
        mBinding.detailPorfessionalexperience.text = cv.cv_professional_experience.toString()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = requireActivity()

        mSharedViewModel =
            ViewModelProvider(requireActivity(), defaultViewModelProviderFactory).get(
                SharedViewModel::class.java
            )



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cv_deatil, container, false)
    }

    companion object {
        const val TAG = "CV detail fragment"
    }
}