package com.example.a30daysoftech.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysoftech.R

data class Tip(
    @StringRes val text: Int,
    @DrawableRes val imageRes: Int
)

object TipRepo {
    val tips = listOf(
        Tip(text = R.string.tip_001, imageRes = R.drawable.tip_001_ai_intro),
        Tip(text = R.string.tip_002, imageRes = R.drawable.tip_002_ai_protection),
        Tip(text = R.string.tip_003, imageRes = R.drawable.tip_003_cloud_computing),
        Tip(text = R.string.tip_004, imageRes = R.drawable.tip_004_understanding_blockchain),
        Tip(text = R.string.tip_005, imageRes = R.drawable.tip_005_how_5g_works),
        Tip(text = R.string.tip_006, imageRes = R.drawable.tip_006_key_programming_languages),
        Tip(text = R.string.tip_007, imageRes = R.drawable.tip_007_devops),
        Tip(text = R.string.tip_008, imageRes = R.drawable.tip_008_iot),
        Tip(text = R.string.tip_009, imageRes = R.drawable.tip_009_data_encryption),
        Tip(text = R.string.tip_010, imageRes = R.drawable.tip_010_quantum_computing),
        Tip(text = R.string.tip_011, imageRes = R.drawable.tip_011_cibersecurity_business),
        Tip(text = R.string.tip_013, imageRes = R.drawable.tip_013_vr),
        Tip(text = R.string.tip_014, imageRes = R.drawable.tip_014_network_how_to_setup),
        Tip(text = R.string.tip_015, imageRes = R.drawable.tip_015_autonomus_vehicle)
    )
}