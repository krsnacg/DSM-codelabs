package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.ui.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = DessertUiState()
    }

    fun updateDessert() {
        val currentIndex = _uiState.value.currentDessertIndex
        val nextIndex = if (currentIndex + 1 == dessertList.size) currentIndex else currentIndex + 1
        val dessert = _uiState.value.currentDessert
        if (_uiState.value.dessertsSold < dessertList.get(nextIndex).startProductionAmount) {
            _uiState.update { currentState ->
                currentState.copy(
                    revenue = currentState.revenue.plus(dessert.price),
                    dessertsSold = currentState.dessertsSold.inc()
                )
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    revenue = currentState.revenue.plus(dessertList.get(nextIndex).price),
                    dessertsSold = currentState.dessertsSold.inc(),
                    currentDessertIndex = currentState.currentDessertIndex.inc(),
                    currentDessert = dessertList.get(nextIndex)
                )
            }
        }
    }

}