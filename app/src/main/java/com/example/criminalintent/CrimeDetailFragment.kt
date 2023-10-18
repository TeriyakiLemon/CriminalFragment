package com.example.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.criminalintent.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID


class CrimeDetailFragment :Fragment(){
    private lateinit var binding: FragmentCrimeDetailBinding
    private lateinit var crime: Crime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCrimeDetailBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // wire up edit text
        binding.apply {
            crimeTitle.doOnTextChanged { text, start, before, count ->
                crime = crime.copy(title = text.toString())
            }
            // wire up the button
            crimeDate.apply{
                text = crime.date.toString()
                isEnabled = false
        }
            //wire up the checkbox
            crimeSolved.setOnCheckedChangeListener{_, ischecked ->
                crime = crime.copy(isSolved = ischecked)

            }

        }
    }
}