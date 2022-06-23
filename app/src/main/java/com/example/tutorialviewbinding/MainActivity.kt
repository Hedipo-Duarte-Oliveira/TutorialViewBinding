package com.example.tutorialviewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorialviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Configurando o ViewBinding criando variavel privada
    // Pra cada atividade ou fragmento precisamos configurar o binding
    // A variável binding está recebendo nosso layout Xml activivitymain
    // Depois da configuração consigo recuperar todos ids, que est]ao nestas atividades consigo recuperar

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater) // Inflando layout através do layout inflate
        setContentView(binding.root) // Passando para minha view o layout, através do binding.

        // Podemos criar uma função no oncreat, para chamar ao startar a aolicação, por boas práticas
        setupBinding()
    }

    private fun setupBinding() {
        // Aqui esta setando os ids dos componentes do layout
        binding.txtMensagem.text = "Hédipo Duarte de Oliveira"
        binding.btnCadastar
    }
}
