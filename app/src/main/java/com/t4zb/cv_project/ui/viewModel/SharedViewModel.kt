package com.t4zb.cv_project.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.t4zb.cv_project.modelLayer.rest.service.event.Cv
import com.t4zb.cv_project.modelLayer.rest.service.repo.CvRepositorty

class SharedViewModel(app: Application): AndroidViewModel(app) {

    val dataRepo = CvRepositorty(app)

   // var selectedItemId: Int? = null
    var selectedCV: Cv? = null


    // val selectedCV = MutableLiveData<Cv>()
}