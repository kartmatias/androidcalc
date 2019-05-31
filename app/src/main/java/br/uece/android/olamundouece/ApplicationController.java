package br.uece.android.olamundouece;

import java.util.HashMap;

public class ApplicationController {

    private static HashMap<String, Handler> controlHash = new HashMap<String, Handler>();
    static{
        String numKey = "numKey";

        //Quando você quiser executar o código para somar, chame o hashmap com a chave '+',
        //Para adicionar uma nova operação ao programa, crie uma nova classe, adicione essa classe ao hashmap do manipulador e pronto!

        //Crie uma nova instância do AdditionHandler e adicione-o ao hashmap com key = '+'
        AddHandler theAddHandler = new AddHandler();
        controlHash.put("+", theAddHandler);
        //Crie uma nova instância do SubHandler e adicione-o ao hashmap com key = '-'
        SubHandler theSubHandler = new SubHandler();
        controlHash.put("-", theSubHandler);

        MultiHandler theMultiHandler = new MultiHandler();
        controlHash.put("x", theMultiHandler);

        DivideHandler theDivideHandler = new DivideHandler();
        controlHash.put("/", theDivideHandler);

        EqualHandler theEqualHandler = new EqualHandler();
        controlHash.put("=", theEqualHandler);

        NumberValueHandler theNumValueHandler = new NumberValueHandler();
        controlHash.put(numKey, theNumValueHandler);

    }

    public static void handleRequest(String command, Object ... parameters) {
        // em vez de configurar para o manipulador podemos usar a reflexão para definir o tipo de uma operação
        // para o tipo do resultado do controle Bash.get (comando); dando-nos flexibilidade
        Handler anOperation = controlHash.get(command);
        anOperation.handleIt(parameters);
    }

}
