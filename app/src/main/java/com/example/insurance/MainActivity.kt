package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            var basic: Int = 0
            var extra: Int = 0
            var total: Int = 0
            val age: Int = binding.spinnerAge.selectedItemPosition
            if(age == 0) {
                //calculate basic premium
                basic = 60
            }
            else if(age == 1) {
                basic = 70
            }
            else if(age == 2) {
                basic = 90
            }
            else if(age == 3) {
                basic = 120
            }
            else if(age == 4) {
                basic = 150
            }
            else if(age == 5) {
                basic = 150
            }

            val gender = binding.radioGroupGender.checkedRadioButtonId
            if(gender == binding.radioButtonMale.id){
                //calculate extra premium for male
                if(age == 0) {
                    extra = 0
                }
                else if(age == 1) {
                    extra = 50
                }
                else if(age == 2) {
                    extra = 100
                }
                else if(age == 3) {
                    extra = 150
                }
                else if(age == 4) {
                    extra = 200
                }
                else if(age == 5) {
                    extra = 200
                }
            }

            val smoker = binding.checkBoxSmoker.isChecked
            if(smoker) {
                //calculate extra premium for smoker
                if(age == 0) {
                    extra = 0
                }
                else if(age == 1) {
                    extra = 100
                }
                else if(age == 2) {
                    extra = 150
                }
                else if(age == 3) {
                    extra = 200
                }
                else if(age == 4) {
                    extra = 250
                }
                else if(age == 5) {
                    extra = 300
                }
            }

            val premium = Premium(basic, extra, basic + extra)
            binding.myPremium = premium
        }

        binding.buttonReset.setOnClickListener {
            val premium = Premium(0,0,0)
            binding.myPremium = premium

            binding.spinnerAge.setSelection(0) //spinner
            binding.radioGroupGender.clearCheck() //radio
            binding.checkBoxSmoker.isChecked = false //checkbox


        }
    }
}