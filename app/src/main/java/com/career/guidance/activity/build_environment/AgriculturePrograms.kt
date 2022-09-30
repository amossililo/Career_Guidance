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

class AgriculturePrograms : AppBaseActivity() {

    private val adapter = getAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_stem_sub_category)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Agriculture Programs"

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
                getString(R.string.built_agriculture_economics),
                getString(R.string.built_agriculture_economics_additional_info),
                "",
                getString(R.string.AGRICULTURECONOMICS)
            )
        )
        programsList.add(
            FacultyData(
                getString(R.string.built_animal_science),
                getString(R.string.animal_science_additional_info),
                "",
                getString(R.string.ANIMALSCIENCE)
            )
        )

        // add sub categories
        programsList.add(
            FacultyData(
                getString(R.string.built_agriculture_extension),
                getString(R.string.built_agriculture_extension_additional_info),
                "",
                getString(R.string.AGRICULTUREEXTENSION)
            )
        )
        programsList.add(
            FacultyData(
                getString(R.string.built_plant_science),
                getString(R.string.built_plant_science_additional_info),
                "",
                getString(R.string.PLANTSCIENCES)
            )
        )

        programsList.add(
            FacultyData(
                getString(R.string.built_soil_science),
                getString(R.string.soil_scienceadditional_info),
                "",
                getString(R.string.SOILSCIENCES)
            )
        )

        programsList.add(
            FacultyData(
                getString(R.string.built_food_science),
                getString(R.string.food_science_additional_info),
                "",
                getString(R.string.PLANTSCIENCES)
            )
        )

        programsList.add(
            FacultyData(
                getString(R.string.built_agriculture_public_services),
                getString(R.string.built_agriculture_public_services_additional_info),
                "",
                getString(R.string.AGRICULTURALPUBLICSERVICES)
            )
        )
        programsList.add(
            FacultyData(
                getString(R.string.built_agriculture_business),
                getString(R.string.built_agriculture_business_additional_info),
                "",
                getString(R.string.AGRICULTUREBUSINESSANDMANAGEMENT)
            )
        )
        programsList.add(
            FacultyData(
                getString(R.string.built_agriculture_support),
                getString(R.string.agriculture_support_additional_info),
                "",
                getString(R.string.AGRICUTURALSUPPORTSERVICESANDTECHNICIANS)
            )
        )
        programsList.add(
            FacultyData(
                getString(R.string.built_agriculture_mechanization),
                getString(R.string.built_agriculture_mechanization_additional_info),
                "",
                getString(R.string.AGRICULTUREMECHANIZATION)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_applied_horticultre),
                getString(R.string.applied_horticultre_additional_info),
                "",
                getString(R.string.APPLIEDHORTICULTUREHORTICULTURALBUSINESSSERVICES)
            )
        )



        programsList.add(
            FacultyData(
                getString(R.string.built_agriculture_production_operation),
                getString(R.string.built_agriculture_production_operation_additional_info),
                "",
                getString(R.string.AGRICULTURALPRODUCTIONOPERATIONS)
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