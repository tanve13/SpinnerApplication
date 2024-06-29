package com.tanveer.spinnerapplication

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.tanveer.spinnerapplication.databinding.CustomLayoutDialogBinding
import com.tanveer.spinnerapplication.databinding.Customdialog2Binding
import com.tanveer.spinnerapplication.databinding.FragmentStudentDataClassBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDataClassFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDataClassFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var studentArray = arrayListOf<StudentDataClass>()
    var binding: FragmentStudentDataClassBinding? = null
    var adapter = StudentClass(studentArray)
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        studentArray.add(StudentDataClass(1,"Ram","c language"))
        studentArray.add(StudentDataClass(2,"Rohan","c++ language"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding = FragmentStudentDataClassBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.baseListView?.adapter = adapter
        binding?.btnFabButton?.setOnClickListener{
            val dialogBinding = Customdialog2Binding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                getWindow()?.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT
                )
                show()
            }
            dialogBinding.btnSubmit.setOnClickListener{
                if (dialogBinding.etEnterName.text.toString().trim().isNullOrEmpty()) {
                    dialogBinding.etEnterName.error = "Enter Name"
                } else if(dialogBinding.etEnterRollNo.text.toString().trim().isNullOrEmpty()) {
                    dialogBinding.etEnterRollNo.error = "Enter Roll No"
                } else if(dialogBinding.etEnterCourseName.text.toString().trim().isNullOrEmpty()) {
                    dialogBinding.etEnterCourseName.error ="Enter Course Name"
                }else{
                    studentArray.add(StudentDataClass(
                        dialogBinding.etEnterRollNo.text.toString().toInt(),
                        dialogBinding.etEnterName.text.toString(),
                        dialogBinding.etEnterCourseName.text.toString()))
                    dialog.dismiss()
                }
            }
        }
        binding?.baseListView?.setOnClickListener{ p0 ->
            val dialogBinding = Customdialog2Binding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                getWindow()?.setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT
                )
                show()
            }
            dialogBinding.btnSubmit.setOnClickListener{
                if (dialogBinding.etEnterName.text.toString().trim().isNullOrEmpty()) {
                    dialogBinding.etEnterName.error = "Enter Name"
                } else if(dialogBinding.etEnterRollNo.text.toString().trim().isNullOrEmpty()) {
                    dialogBinding.etEnterRollNo.error = "Enter Roll NO"
                } else if(dialogBinding.etEnterCourseName.text.toString().trim().isNullOrEmpty()) {
                    dialogBinding.etEnterCourseName.error ="Enter Course Name"
                }else{
                    studentArray.add(StudentDataClass(
                        dialogBinding.etEnterRollNo.text.toString().toInt(),
                        dialogBinding.etEnterName.text.toString(),
                        dialogBinding.etEnterCourseName.text.toString()))
                    dialog.dismiss()
                }
            }
        }
        binding?.baseListView?.setOnItemLongClickListener{ _,_,i,Long ->
        var alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(resources.getString(R.string.Do_you_want_to_delete_this_list))
        alertDialog.setPositiveButton("Yes"){ _,_ ->
            studentArray.removeAt(i)
            adapter.notifyDataSetChanged()
        }
        alertDialog.setNegativeButton("no"){_,_ ->
        }
         alertDialog.show()
         return@setOnItemLongClickListener true
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StudentDataClassFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentDataClassFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}