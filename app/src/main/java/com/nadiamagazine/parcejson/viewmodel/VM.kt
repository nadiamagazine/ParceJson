package com.nadiamagazine.parcejson.viewmodel

import androidx.lifecycle.ViewModel
import com.nadiamagazine.parcejson.InstitutionName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VM: ViewModel() {
   suspend fun getInstitutionName(): InstitutionName {
       val name = withContext(Dispatchers.IO) {
           com.nadiamagazine.parcejson.getInstitutionName()
       }
       return name
   }


}