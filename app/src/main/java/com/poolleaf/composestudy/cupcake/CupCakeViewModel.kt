package com.poolleaf.composestudy.cupcake

import androidx.lifecycle.ViewModel
import com.poolleaf.composestudy.cupcake.model.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CupCakeViewModel : ViewModel() {
    private val _entree = MutableStateFlow(MenuItem.EntreeItem("", "", 0.0))
    var entree = _entree.asStateFlow()

    private val _sideDish = MutableStateFlow(MenuItem.SideDishItem("", "", 0.0))
    var sideDish = _sideDish.asStateFlow()

    private val _accompaniment = MutableStateFlow(MenuItem.AccompanimentItem("", "", 0.0))
    var accompaniment = _accompaniment.asStateFlow()
}
