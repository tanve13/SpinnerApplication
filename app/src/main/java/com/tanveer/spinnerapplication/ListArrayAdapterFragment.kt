package com.tanveer.spinnerapplication

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.tanveer.spinnerapplication.databinding.CustomLayoutDialogBinding
import com.tanveer.spinnerapplication.databinding.FragmentListArrayAdapterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListArrayAdapterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListArrayAdapterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentListArrayAdapterBinding? = null
    var array = arrayListOf("")
    lateinit var arrayAdapter: ArrayAdapter<String>
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
        binding = FragmentListArrayAdapterBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayAdapter = ArrayAdapter(requireContext(),
        android.R.layout.simple_list_item_1,array)
        binding?.lvListArrayAdapter?.adapter = arrayAdapter
        binding?.btnListFab?.setOnClickListener{
            val dialogBinding = CustomLayoutDialogBinding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                show()
            }
            dialogBinding.btnAdd.setOnClickListener{
                if (dialogBinding.etEnterCity?.text?.toString().isNullOrEmpty()){
                    dialogBinding.etEnterCity.error = resources.getString((R.string.enter_your_city))
                } else{
                    array.add(dialogBinding.etEnterCity?.text?.toString()?:"")
                    dialog.dismiss()
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
         * @return A new instance of fragment ListArrayAdapterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListArrayAdapterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}