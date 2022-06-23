# Tutorial ViewBinding
 Tutorial basico do ViewBinding

A vinculação de visualizações é um recurso que facilita a programação de códigos que interagem com visualizações. Quando a vinculação de visualizações é ativada em um módulo, ela gera uma classe de vinculação para cada arquivo de layout XML presente nesse módulo. A instância de uma classe de vinculação contém referências diretas a todas as visualizações que têm um código no layout correspondente.

Na maioria dos casos, a vinculação de visualizações substitui findViewById.

Instruções de configuração
Observação: a vinculação de visualizações está disponível no Android Studio 3.6 Canary 11 +.
A vinculação de visualizações é ativada em um módulo por base de módulo. Para ativar a vinculação de visualizações em um módulo, adicione o elemento viewBinding ao arquivo build.gradle dele, conforme mostrado no exemplo a seguir:


                android {
                               ...
                    viewBinding {
                             enabled = true
                                }
                           }
    
Caso você queira que um arquivo de layout seja ignorado ao gerar classes de vinculação, adicione o atributo tools:viewBindingIgnore="true" à visualização raiz do arquivo de layout:



                       <LinearLayout
                                    ...
                                tools:viewBindingIgnore="true" >
                                                      ...
                                    </LinearLayout>
 Uso
Se a vinculação de visualizações estiver ativada para um módulo, uma classe de vinculação será gerada para cada arquivo de layout XML que ele contiver. Cada classe de vinculação contém referências à visualização raiz e a todas as visualizações que têm um código. O nome da classe de vinculação é gerado por meio da conversão do nome do arquivo XML em minúsculas concatenadas e da adição da palavra "Binding" ao final.

Por exemplo, considerando um arquivo de layout denominado result_profile.xml:


            <LinearLayout ... >
                    <TextView android:id="@+id/name" />
                    <ImageView android:cropToPadding="true" />
                     <Button android:id="@+id/button"
                      android:background="@drawable/rounded_button" />
             </LinearLayout>
    
    
A classe de vinculação gerada terá o nome ResultProfileBinding. Essa classe tem dois campos: um TextView denominado name e um Button denominado button. A ImageView no layout não tem código. Portanto, não há referência a ela na classe de vinculação.

Toda classe de vinculação também inclui um método getRoot(), que disponibiliza uma referência direta para a visualização raiz do arquivo de layout correspondente. Nesse exemplo, o método getRoot() na classe ResultProfileBinding retorna a visualização raiz de LinearLayout.

As seções a seguir demonstram o uso de classes de vinculação geradas em atividades e fragmentos.

Usar a vinculação de visualizações em atividades
Para configurar uma instância da classe de vinculação para ser usada com uma atividade, siga as seguintes etapas no método onCreate() da atividade:

Chame o método estático inflate() incluído na classe de vinculação gerada. Isso cria uma instância da classe de vinculação para a atividade usar.
Receba uma referência para a visualização raiz chamando o método getRoot() ou usando a sintaxe da propriedade Kotlin (link em inglês).
Transmita a visualização raiz para setContentView() a fim de torná-la a visualização ativa na tela.

Kotlin

    private lateinit var binding: ResultProfileBinding

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        binding = ResultProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    
