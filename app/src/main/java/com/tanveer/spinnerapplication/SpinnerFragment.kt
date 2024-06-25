package com.tanveer.spinnerapplication

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tanveer.spinnerapplication.databinding.FragmentSpinnerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpinnerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
 var binding: FragmentSpinnerBinding? = null
var array = arrayListOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpinnerBinding.inflate(inflater)
        return binding?.root
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_spinner, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.StaticValueSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
          override fun onItemSelected(
              parent: AdapterView<*>?,
              view: View?,position: Int,id: Long)
          {
              var selectedItem = binding?.StaticValueSpinner?.selectedItem as String
              Toast.makeText(requireContext(),"selected gender is ${position}$selectedItem",
              Toast.LENGTH_LONG).show()
          }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        binding?.btnFab?.setOnClickListener{
            Dialog(requireContext()).apply {
                setContentView(R.layout.custom_layout_dialog)
                show()
                val etEnterCity= this.findViewById<EditText>(R.id.etEnterCity)
                val btnAdd = this.findViewById<Button>(R.id.btnAdd)
                btnAdd.setOnClickListener{
                    if (etEnterCity?.text?.toString().isNullOrEmpty()){
                        etEnterCity.error = resources.getString((R.string.enter_your_city))
                    } else{

                    }
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SpinnerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpinnerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}