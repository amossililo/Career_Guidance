package com.career.guidance.activity.build_environment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.career.guidance.AppBaseActivity
import com.career.guidance.R
import com.career.guidance.base.BaseRecyclerAdapter
import com.career.guidance.databinding.StemItemBinding
import com.career.guidance.model.StemData
import com.career.guidance.utils.extensions.launchActivity
import com.career.guidance.utils.extensions.rvItemAnimation

class SelectProgramActivity : AppBaseActivity() {
    private val adapter: BaseRecyclerAdapter<StemData, StemItemBinding> = getAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_program)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Programs"
        setToolbar(toolbar)
        val recyclerView = findViewById<RecyclerView>(R.id.facultyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.rvItemAnimation()
        adapter.addItems(stemData())


    }


    private fun stemData(): ArrayList<StemData> {
        val stemDataArrayList = ArrayList<StemData>()
        stemDataArrayList.add(
            StemData(
                "Agriculture Programs",
                getString(R.string.additional_info),
                R.drawable.placeholder,
                "Agriculture Programs"
            )
        )
        stemDataArrayList.add(
            StemData(
                "Natural Resource Programs",
                getString(R.string.additional_info),
                R.drawable.placeholder,
                "Natural Resource Programs"
            )
        )
        stemDataArrayList.add(
            StemData(
                "Built Environment Programs",
                getString(R.string.additional_info),
                R.drawable.placeholder,
                "Built Environment Programs"
            )
        )
        return stemDataArrayList
    }

    private fun getAdapter(): BaseRecyclerAdapter<StemData, StemItemBinding> {
        return object : BaseRecyclerAdapter<StemData, StemItemBinding>() {
            override val layoutResId: Int
                get() = R.layout.stem_item

            override fun onBindData(model: StemData, position: Int, dataBinding: StemItemBinding) {

                dataBinding.stemName.text = model.stemName
                dataBinding.stemInfo.text = model.stemInfo
            }

            override fun onItemClick(
                view: View,
                model: StemData,
                position: Int,
                dataBinding: StemItemBinding
            ) {
                when (model.page) {
                    "Built Environment Programs" -> {

                        launchActivity<BuiltEnvironment>()

                    }
                    "Natural Resource Programs" -> {
                        launchActivity<NaturalResources>()
                    }
                    "Agriculture Programs" -> {
                        launchActivity<AgriculturePrograms> ()

                    }
                }
            }

            override fun onItemLongClick(view: View, model: StemData, position: Int) {
              //gg
            }

        }
    }
}