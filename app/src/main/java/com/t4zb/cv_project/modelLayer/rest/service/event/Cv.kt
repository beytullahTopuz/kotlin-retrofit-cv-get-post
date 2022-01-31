package com.t4zb.cv_project.modelLayer.rest.service.event

data class Cv(
    val id: Int,
    val cv_name: String,
    var cv_surname: String,
    var cv_number: String,
    var cv_email: String,
    var cv_education: List<String>,
    var cv_work_experience: List<String>,
    var cv_professional_experience: List<String>
)
