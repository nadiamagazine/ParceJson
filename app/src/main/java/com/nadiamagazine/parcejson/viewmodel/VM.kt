package com.nadiamagazine.parcejson.viewmodel

import androidx.lifecycle.ViewModel
import com.nadiamagazine.parcejson.FishResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VM: ViewModel() {
   suspend fun getSpeciesName(): FishResponse {
       val name = withContext(Dispatchers.IO) {
           com.nadiamagazine.parcejson.getSpeciesName()
       }
       return name
   }


}