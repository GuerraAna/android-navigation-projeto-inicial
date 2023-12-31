package br.com.alura.aluraesporte.ui.fragment

import org.koin.android.viewmodel.ext.android.viewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.ComponentesVisuais
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.login_botao_cadastrar_usuario
import kotlinx.android.synthetic.main.fragment_login.login_botao_logar
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 *
 */
internal class LoginFragment : Fragment() {

    private val controlador by lazy { findNavController() }

    private val viewModel: LoginViewModel by viewModel()
    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        estadoAppViewModel.temComponentes = ComponentesVisuais()
        login_botao_logar.setOnClickListener {
            viewModel.loga()
            vaiParaListaProdutos()
        }

        login_botao_cadastrar_usuario.setOnClickListener {
            val direcao = LoginFragmentDirections.acaoLoginParaCadastroUsuario()
            controlador.navigate(direcao)
        }
    }

    private fun vaiParaListaProdutos() {
        val direcao = LoginFragmentDirections.acaoLoginParaListaProdutos()
        controlador.navigate(direcao)
    }
}