package br.com.alura.aluraesporte.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import kotlinx.android.synthetic.main.main_activity.main_activity_bottom_navigation
import org.koin.android.viewmodel.ext.android.viewModel

/**
 *
 */
internal class MainActivity : AppCompatActivity() {

    private val controlador by lazy { findNavController(R.id.main_activity_nav_host) }
    private val viewModel: EstadoAppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        controlador.addOnDestinationChangedListener { controller, navDestination, arguments ->
            title = navDestination.label

            viewModel.components.observe(this, Observer {
                it?.let { temComponentes ->
                    when (temComponentes.appBar) {
                        true -> supportActionBar?.show()
                        else -> supportActionBar?.show()
                    }

                    when (temComponentes.bottomNavigation) {
                        true -> main_activity_bottom_navigation.isVisible = true
                        else -> main_activity_bottom_navigation.isVisible = false
                    }
                }
            })
        }

        main_activity_bottom_navigation.setupWithNavController(controlador)
    }
}