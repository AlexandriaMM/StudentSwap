package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateListingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment

        val createListingView = inflater.inflate(R.layout.fragment_create_listing, container, false)
        val receivedData = arguments?.getString("username")
        val bundle = Bundle()
        bundle.putString("username", receivedData)

        createListingView.findViewById<Button>(R.id.createNewListingButton).setOnClickListener(View.OnClickListener {
            if(createListingView.findViewById<EditText>(R.id.listingNameText).text.toString() != "" &&
                createListingView.findViewById<EditText>(R.id.listingDescriptionText).text.toString() != "" &&
                createListingView.findViewById<EditText>(R.id.listingPriceText).text.toString() != "") {

                Navigation.findNavController(createListingView).navigate(R.id.mainMenuFragment, bundle)


            }
            else {
                Toast.makeText(context, "Please enter values into all fields", Toast.LENGTH_SHORT).show()
            }
        })
        return createListingView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateListingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateListingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}