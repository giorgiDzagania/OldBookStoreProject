package com.madeit.oldbookstore.activity.ui.sell

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.FreeActivity
import com.madeit.oldbookstore.activity.PriceActivity
import com.madeit.oldbookstore.databinding.FragmentSellBinding

class SellFragment : Fragment() {
    private var category = "school"
    private var type = "Price"
    private var binding: FragmentSellBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        binding!!.next.setOnClickListener {
            if (type == "Price") {
                val intent = Intent(requireActivity().applicationContext, PriceActivity::class.java)
                intent.putExtra("category", category)
                startActivity(intent)
            } else if (type == "Donation") {
                val intent = Intent(requireActivity().applicationContext, FreeActivity::class.java)
                intent.putExtra("category", category)
                startActivity(intent)
            }
        }

        binding!!.radio.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
            Toast.makeText(requireContext(), radioButton.text.toString(), Toast.LENGTH_SHORT).show()
            type = radioButton.text.toString()
        }

        binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
        binding!!.school.setTextColor(resources.getColor(R.color.white))

        binding!!.school.setOnClickListener {
            category = "school"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.school.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.matric.setOnClickListener {
            category = "matric"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.matric.setTextColor(resources.getColor(R.color.white))

            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.school.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.inter.setOnClickListener {
            category = "inter"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.inter.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.school.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.bachelor.setOnClickListener {
            category = "bachelor"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.bachelor.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.school.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.Islamic.setOnClickListener {
            category = "islamic"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.Islamic.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.school.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.Novels.setOnClickListener {
            category = "novels"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.Novels.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.school.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.master.setOnClickListener {
            category = "master"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.master.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.school.setTextColor(resources.getColor(R.color.red))
            binding!!.other.setTextColor(resources.getColor(R.color.red))
        }

        binding!!.other.setOnClickListener {
            category = "other"
            Toast.makeText(requireContext(), "Category Selected", Toast.LENGTH_SHORT).show()
            binding!!.other.setBackgroundResource(R.drawable.circular_shaped_otp_selected)
            binding!!.other.setTextColor(resources.getColor(R.color.white))

            binding!!.matric.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.inter.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.bachelor.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Islamic.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.Novels.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.master.setBackgroundResource(R.drawable.circular_shaped_otp)
            binding!!.school.setBackgroundResource(R.drawable.circular_shaped_otp)

            binding!!.matric.setTextColor(resources.getColor(R.color.red))
            binding!!.inter.setTextColor(resources.getColor(R.color.red))
            binding!!.bachelor.setTextColor(resources.getColor(R.color.red))
            binding!!.Islamic.setTextColor(resources.getColor(R.color.red))
            binding!!.Novels.setTextColor(resources.getColor(R.color.red))
            binding!!.master.setTextColor(resources.getColor(R.color.red))
            binding!!.school.setTextColor(resources.getColor(R.color.red))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}