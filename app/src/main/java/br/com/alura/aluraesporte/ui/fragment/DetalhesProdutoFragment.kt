package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.extensions.formatParaMoedaBrasileira
import br.com.alura.aluraesporte.ui.viewmodel.DetalhesProdutoViewModel
import kotlinx.android.synthetic.main.detalhes_produto.detalhes_produto_botao_comprar
import kotlinx.android.synthetic.main.detalhes_produto.detalhes_produto_nome
import kotlinx.android.synthetic.main.detalhes_produto.detalhes_produto_preco
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 *
 */
internal class DetalhesProdutoFragment : BaseFragment() {

    private val argumento by navArgs<DetalhesProdutoFragmentArgs>()
    private val produtoId by lazy { argumento.produtoId }
    private val controlador by lazy { findNavController() }

    private val viewModel: DetalhesProdutoViewModel by viewModel { parametersOf(produtoId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(
            R.layout.detalhes_produto,
            container,
            false
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buscaProduto()
        configuraBotaoComprar()
    }

    private fun configuraBotaoComprar() {
        detalhes_produto_botao_comprar.setOnClickListener {
            viewModel.produtoEncontrado.value?.let { produto -> vaiParaListaPagamentos() }
        }
    }

    private fun vaiParaListaPagamentos() {
        val direcao = DetalhesProdutoFragmentDirections.acaoDetalhesDoProdutoParaPagamento(produtoId)
        controlador.navigate(direcao)
    }

    private fun buscaProduto() {
        viewModel.produtoEncontrado.observe(this, Observer {
            it?.let { produto ->
                detalhes_produto_nome.text = produto.nome
                detalhes_produto_preco.text = produto.preco.formatParaMoedaBrasileira()
            }
        })
    }
}