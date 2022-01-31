package com.t4zb.cv_project.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.t4zb.cv_project.R
import com.t4zb.cv_project.modelLayer.rest.service.event.Cv
import com.t4zb.cv_project.ui.view.fragment.AdminHomeFragment
import com.t4zb.cv_project.ui.viewModel.SharedViewModel
import com.t4zb.cv_project.util.showLogDebug
import androidx.navigation.fragment.findNavController
import com.t4zb.cv_project.ui.view.fragment.AdminHomeFragmentDirections
import com.t4zb.cv_project.ui.view.fragment.CvDeatilFragment

class CvListAdapter(context: Context, cvList: List<Cv>, viewModel: SharedViewModel): RecyclerView.Adapter<CvListAdapter.ViewHolder>() {


    private val mContext = context
    private val mCvList = cvList
    private val mViewModel = viewModel

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        val cv_name_text: TextView = itemView.findViewById(R.id.cv_name_text)
        val cv_surname_text: TextView = itemView.findViewById(R.id.cv_surname_text);

        val cv_email_text: TextView = itemView.findViewById(R.id.cv_email_text);
        val cv_number_text: TextView = itemView.findViewById(R.id.cv_number_text);


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CvListAdapter.ViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        var view= layoutInflater.inflate(R.layout.cv_item_card,parent,false)



        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CvListAdapter.ViewHolder, position: Int) {

        var cv = mCvList.get(position);

        holder.cv_name_text.text = cv.cv_name
        holder.cv_surname_text.text = cv.cv_surname
        holder.cv_email_text.text = cv.cv_email
        holder.cv_number_text.text = cv.cv_number

        holder.itemView.setOnClickListener {
         //   showLogDebug(TAG, position.toString())
            showLogDebug(TAG,cv.id.toString())

            mViewModel.selectedCV = cv;

            var directions =  AdminHomeFragmentDirections.actionAdminHomeFragmentToCvDeatilFragment2()

            holder.itemView.findNavController().navigate(directions)

        }



    }

    override fun getItemCount(): Int {
        return mCvList.size
    }

    companion object{
        const val TAG = "CV adapter list :"
    }
}