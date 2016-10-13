package com.wmeat.actciclovida;
/**
 * Exemplo da Classe actMain para exemplificar o cliclo de vida
 * de um Activity
 * @author Glaucio F. Schultz
 * @since 2016-10-12
 */

//Aqui importamos a classe Activity que contêm os métodos para gerenciar
//as mudanças de cada estado do ciclo de vida do activity
import android.support.v7.app.AppCompatActivity;

//Importamos a classe Bundle que permite mapear pacotes com chaves string e valores
import android.os.Bundle;
//Conjunto de classes onde iremos utilizar o Listener onClick para implementação de eventos click
import android.view.*;
//Conjunto de classes para podermos referenciar os elementos da view dentro do Activity
import android.widget.*;

//Iremo apresentar as mensagens na tela em cada mudança de estado do ciclo de vida do Activity
//para isso iremos consumir a classe AlertDialog do android
import android.support.v7.app.AlertDialog;

//Abaixo implementamos a classe actMain responsável pelo activity.
//Percebe-se que nesta classe herdamos a classe AppCompactActivity.
//Onde sobrecarregaremos algums métodos do cliclo de vida como:
// onCreate(), onStart(), onResume(),onRestart(), onPause(), onStop() e
// onDestroy(). Utilizamos eles para satisfazer necessidade da aplicação precisa resolver
//implementamos a interface onClickListener para podermos trabalhar com o método onClick
//sobrecarregado na classe actMain
public class actMain extends AppCompatActivity implements View.OnClickListener{
    //Vamos instanciar o Diálogo como um atributo do actMain
    private AlertDialog.Builder dlg;
    //Declaramos o atributo strLogCicVid para receber o histórigo do ciclo de vida do Activity
    private String strLogCicVid;
    //Atributo para armazenar a sequencia de cada estado do ciclo de vida do Activity
    private int seq;
    //Botão de ação para exibir os estados na qual o Activity já passou
    private Button btnOpnEst;


    /**
     * Método onCreate(), equivalente a um método construtor
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Aqui definimos o estado inical de nosso Activity
        //Então vamos implementar os registros importantes para que a Activity funcione
        //1º Construção do Activity, passando como parâmetro o Bundle recuperado
        super.onCreate(savedInstanceState);
        //2º Associar a referência do arquivo do layout ao Activity
        setContentView(R.layout.act_main);
        //3º Vamos instanciar o AlertDialog no atributo dlg para podermos utilizar em outros
        dlg = new AlertDialog.Builder(actMain.this);
        //4º Setamos o botão OK para fechar a caixa de diálogo
        dlg.setNeutralButton("OK",null);
        //5º Sequencia de estados do Activity inicia com 1
        seq = 1;
        //6º Armazenamos no atributo strLogCicVid  que passamos pelo estado onCreate() do Activity
        strLogCicVid =   Integer.toString(seq)+"º passamos pelo onCreate()";
        //7º Recuperamos a referência do elemento btnOpnEst que se encontra no layout para o
        //   atributo btnOpnEst
        btnOpnEst = (Button)findViewById(R.id.btnOpnEst);
        //8º Também setamos o método onClick passando o objeto do activity no parâmetro
        //Neste formato, poderemos implementar o método onClick como um método da classe
        //ActMain. Isso é possível porque temos apenas um elemento com Listener onClick
        btnOpnEst.setOnClickListener(this);
    }

    /**
     *  Sobrecarregamos o método onClick da interface OnClickListener no Activity
     * @param v
     */
    public void onClick(View v){
       //Setamos a mensagem do diálogo
        dlg.setMessage(strLogCicVid);
        //Exibimos a caixa de diálogo
        dlg.show();
    }

    /**
     * Antes da Activity ficar viível na tela
     */
    @Override
    protected void onStart(){
        super.onStart();
        seq++;//Incrementa-se o seq
        //Armazenamos no atributo strLogCicVid que passsamos pelo estado onStart()
        strLogCicVid+= "\n"+Integer.toString(seq)+"º passamos pelo onStart()";
    }
    /**
     * Quando o Activity fica visível na tela
     */
    @Override
    protected void onResume(){
        super.onResume();
        seq++;//Incrementa-se o seq
        //Armazenamos no atributo strLogCicVid que passsamos pelo estado onResume()
        strLogCicVid+= "\n"+Integer.toString(seq)+"º estamos no onResume()";
        dlg.setMessage(strLogCicVid);
        dlg.show();
    }
    /**
     * Método é chamado quando uma outra Activity está sobrepondo o Activity actMain
     */
    @Override
    protected void onPause(){
        super.onPause();
        seq++;//Incrementa-se o seq
        //Armazenamos no atributo strLogCicVid que passsamos pelo estado onPause()
        strLogCicVid+= "\n"+Integer.toString(seq)+"º passamos pelo onPause()";
    }
    /**
     * Este método é chamado quando o Activity actMain não está mais visível
     */
    @Override
    protected void onStop(){
        super.onStop();
        seq++;//Incrementa-se o seq
        //Armazenamos no atributo strLogCicVid que passsamos pelo estado onStop()
        strLogCicVid+= "\n"+Integer.toString(seq)+"º passamos pelo onStop()";
    }
    /**
     * Método equivalente ao Destrutor, será carregado antes do actMain ser liberado da memória
     */
    @Override
    protected void onDestroy(){
        seq++;//Incrementa-se o seq
        //Armazenamos no atributo strLogCicVid que nossa Activity será liberada da memória
        strLogCicVid+= "\n"+Integer.toString(seq)+"º estamos no onDestroy()\nSeremos liberados da memória!";
        dlg.setMessage(strLogCicVid);
        dlg.show();
        super.onDestroy();
    }
}
