package com.career.guidance.activity.build_environment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.career.guidance.AppBaseActivity
import com.career.guidance.R
import com.career.guidance.activity.displayProgramInfoActivity
import com.career.guidance.base.BaseRecyclerAdapter
import com.career.guidance.databinding.ItemProgramsBinding
import com.career.guidance.model.FacultyData

import com.career.guidance.utils.extensions.loadImageFromUri
import com.career.guidance.utils.extensions.rvItemAnimation

class NaturalResources : AppBaseActivity() {
    private val adapter = getAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_stem_sub_category)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Natural Resources Programs"

        setToolbar(toolbar)
        val recyclerView = findViewById<RecyclerView>(R.id.facultyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.rvItemAnimation()
        adapter.addItems(programsList())
    }

    private fun programsList(): ArrayList<FacultyData> {
        val programsList = ArrayList<FacultyData>()
        programsList.add(
            FacultyData(
                getString(R.string.built_fishing_and_fisheries),
                getString(R.string.fishing_additional_info),
                "",
                getString(R.string.FishingandFisheriesSciencesandManagement)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_forestry),
                getString(R.string.forestry_additional_info),
                "",
                getString(R.string.FORESTRY)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_natural_resources_conservation),
                getString(R.string.natural_resources_conservation_additional_info),
                "",
                getString(R.string.NATURAlRESOURCESCONSERVATIONANDRESEARCH)
            )
        )

        programsList.add(
            FacultyData(
                getString(R.string.built_nature_resources_management),
                getString(R.string.nature_resources_managemen_additional_info),
                "",
                getString(R.string.NATURALRESOURCESMANAGEMENTANDPOLICY)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_widlife),
                getString(R.string.additional_info),
                "",
                getString(R.string.WILDLIFEANDWILDLANDSSCIENCEMANAGEMENT)
            )
        )



        return programsList
    }

    private fun getAdapter(): BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> {
        return object : BaseRecyclerAdapter<FacultyData, ItemProgramsBinding>() {
            override val layoutResId: Int
                get() = R.layout.item_programs

            override
            fun onBindData(model: FacultyData, position: Int, dataBinding: ItemProgramsBinding) {
                dataBinding.tvFacultyName.text = model.facultyName
                dataBinding.tvProductRate.text = model.facultyInfo
                dataBinding.ivFaculty.loadImageFromUri(model.facultyImage)
            }

            override
            fun onItemClick(
                view: View,
                model: FacultyData,
                position: Int,
                dataBinding: ItemProgramsBinding
            ) {
                opendisplayProgramInfoActivity(model)
            }

            override
            fun onItemLongClick(view: View, model: FacultyData, position: Int) {
            }
        }
    }

    fun opendisplayProgramInfoActivity(model: FacultyData) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("MySharedPref", MODE_PRIVATE)
        // Creating an Editor object to edit(write to the file)
        val myEdit = sharedPreferences.edit()
        // Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.facultyName)
        myEdit.putString("nameOfHtmlFile", model.page)
        myEdit.apply()
        val intent = Intent(this, displayProgramInfoActivity::class.java)
        startActivity(intent)
    }
}