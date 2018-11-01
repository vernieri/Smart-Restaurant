package smartrestaurant;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SmartRestaurant extends Application {

    Stage window;
    Scene scene;
    Button button;
    int valor;
    Button clear;

    public static void main(String[] args) {
        launch(args);
    }

  @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("CARDAPIO");
        button = new Button("Gerar Pedido");
        clear = new Button("Limpar");
        //TextField media = new TextField();


        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        ChoiceBox<String> choiceBox3 = new ChoiceBox<>();
        ChoiceBox<String> choiceBox4 = new ChoiceBox<>();
        ChoiceBox<String> choiceBox5 = new ChoiceBox<>();

        //Entrada 
        choiceBox1.getItems().add("Entrada 1"); 
        choiceBox1.getItems().add("Entrada 2");
        choiceBox1.getItems().addAll("Entrada 3", "Entrada 4", "Entrada 5", "Entrada 6"); 
        
        //Prato Principal
        choiceBox2.getItems().add("Prato 1");
        choiceBox2.getItems().add("Prato 2");
        choiceBox2.getItems().add("Prato 3");
        choiceBox2.getItems().add("Prato 4");
        choiceBox2.getItems().add("Prato 5");
        choiceBox2.getItems().add("Prato 6");
        choiceBox2.getItems().add("Prato 7");
        
        //Guarnição
        choiceBox3.getItems().add("Acompanhamento 1");
        choiceBox3.getItems().add("Acompanhamento 2");
        choiceBox3.getItems().add("Acompanhamento 3");
        
        //Bebidas
        choiceBox4.getItems().add("Agua Mineral 500ml");
        choiceBox4.getItems().add("Agua gaseficada 500ml");
        choiceBox4.getItems().add("Refrigerante Cola 350ml");
        choiceBox4.getItems().add("Suco de Laranja 350ml");
        choiceBox4.getItems().add("Suco de Uva 350ml");
        
       
        //Set a default value
        choiceBox1.setValue("Entrada 1");

        //set a default value
        choiceBox2.setValue("Prato 1");
        
        //set a default value
        choiceBox3.setValue("Acompanhamento 1");
        
        //set a default value
        choiceBox4.setValue("Agua Mineral 500ml");
        
        //Dobrar o recheio ou adicionar Bacon
        choiceBox5.getItems().add("Pagamento no Debito");
        choiceBox5.getItems().add("Pagamento no Credito");
        choiceBox5.getItems().add("Pagamento em Dinheiro");
        
        choiceBox5.setValue("Pagamento no Credito");
        //CheckBox box1 = new CheckBox("Chamar Gerente");
              
        Button gerente = new Button("Chamar Gerente");
            
        button.setOnAction(e -> getChoices(choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5));
        gerente.setOnAction(e -> System.out.println("Gerente sendo requisitado no saguao!"));
        
        

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5, gerente, button, clear);

        scene = new Scene(layout, 300, 350);
        window.setScene(scene);
        window.show();
    }
    private void getChoices(ChoiceBox<String> choiceBox1, ChoiceBox<String> choiceBox2, ChoiceBox<String> choiceBox3, ChoiceBox<String> choiceBox4, ChoiceBox<String> choiceBox5){
        String preco, printar;
        valor = 30; //TODO
        String food = choiceBox1.getValue() +" "+choiceBox2.getValue()+" "+choiceBox3.getValue()+" "+choiceBox4.getValue()+" "+choiceBox5.getValue();
            printar = food +"\n Valor da Compra: "+ valor;
            System.out.println(printar);

                        PrintWriter fw = null;

                        try {
                            fw = new PrintWriter("users.txt");
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(printar);
                            bw.newLine();
                            //bw.write(tfPassword.getText());
                            fw.close();
                        } catch (IOException e) {
                            fw.close();
                                    
    }
    }
}    


//TODO METHODS
