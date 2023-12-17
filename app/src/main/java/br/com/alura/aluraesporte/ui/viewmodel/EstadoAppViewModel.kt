package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

internal class EstadoAppViewModel : ViewModel() {

    var temComponentes: ComponentesVisuais = ComponentesVisuais()
        set(value) {
            field = value
            _components.value = value
        }

    private var _components: MutableLiveData<ComponentesVisuais> =
        MutableLiveData<ComponentesVisuais>().also { it.value = temComponentes }

    val components: LiveData<ComponentesVisuais> get() = _components
}

internal class ComponentesVisuais(
    val appBar: Boolean = false,
    val bottomNavigation: Boolean = false
)