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

        //Paes 
        choiceBox1.getItems().add("Pao Italiano"); 
        choiceBox1.getItems().add("Pao Integral");
        choiceBox1.getItems().addAll("Pao Frances", "Pao 9 Graos", "Pao Parmesao com Oregano", "Pao Tres queijos"); 
        
        //Recheio
        choiceBox2.getItems().add("Frango");
        choiceBox2.getItems().add("Carne de soja");
        choiceBox2.getItems().add("Cheddar Cremoso");
        choiceBox2.getItems().add("Frango Defumado");
        choiceBox2.getItems().add("Frango Teryak");
        choiceBox2.getItems().add("Churrasco");
        choiceBox2.getItems().add("Presunto");
        
        //Queijo
        choiceBox3.getItems().add("Queijo Cheddar");
        choiceBox3.getItems().add("Queijo Prado");
        choiceBox3.getItems().add("Queijo Suico");
        
        //Bebida
        choiceBox4.getItems().add("Agua Mineral 500ml");
        choiceBox4.getItems().add("Agua gaseficada 500ml");
        choiceBox4.getItems().add("Bebida Pequena");
        choiceBox4.getItems().add("Bebida Media");
        choiceBox4.getItems().add("Bebida Grande");
        
       
        //Set a default value
        choiceBox1.setValue("Pao Italiano");

        //set a default value
        choiceBox2.setValue("Frango");
        
        //set a default value
        choiceBox3.setValue("Queijo Cheddar");
        
        //set a default value
        choiceBox4.setValue("Bebida Media");
        
        //Dobrar o recheio ou adicionar Bacon
        CheckBox box1 = new CheckBox("Dobro do Recheio");
        CheckBox box2 = new CheckBox("Adicionado Bacon");
        CheckBox box3 = new CheckBox("Dobro do Queijo");
        CheckBox box4 = new CheckBox("Apenas o Lanche");
        box4.setSelected(true);
        

        
      
        
        button.setOnAction(e -> getChoices(choiceBox1, choiceBox2, choiceBox3, choiceBox4, box1, box2, box3, box4));
        clear.setOnAction(e->getClear(valor));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox1, choiceBox2, choiceBox3, choiceBox4, box1, box2, box3, box4, button, clear);

        scene = new Scene(layout, 300, 350);
        window.setScene(scene);
        window.show();
    }

    //To get the value of the selected item
    private void getChoices(ChoiceBox<String> choiceBox1, ChoiceBox<String> choiceBox2, ChoiceBox<String> choiceBox3, ChoiceBox<String> choiceBox4, CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){
         
        
        String preco, printar;
        int absValor;
        String food = choiceBox1.getValue() +" "+choiceBox2.getValue()+" "+choiceBox3.getValue()+" "+choiceBox4.getValue()+" "+handleOptions(box1, box2, box3, box4);
        if(box4.isSelected()){
            valor = 10;
            if(box1.isSelected() && box2.isSelected() && box3.isSelected()){
                valor = 12;
                food = "Apenas o lanche com todos bonus";
                printar = food +"\n Valor da Compra: 16";
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
                                e.printStackTrace();   
                                fw.close();
                            }               
                
            }
            else{
                if((box1.isSelected() && box2.isSelected()) || (box1.isSelected() && box3.isSelected()) || (box2.isSelected() && box3.isSelected())){
                    valor = 14;
                food = "Apenas o lanche com dois bonus";
                printar = food +"\n Valor da Compra: 14";
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
                                e.printStackTrace();   
                                fw.close();
                            }                      
                    
            }
                else{
                        if(box1.isSelected() || box2.isSelected()){
                            valor = 12;
                            food = "Apenas o lanche com todos os bonus";
                            printar = food +"\n Valor da Compra: 16";
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
                                e.printStackTrace();   
                                fw.close();
                            }   
                        }
                        else{
                            food = "Apenas o lanche";
                            printar = food +"\n Valor da Compra: 10";
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
                                e.printStackTrace();   
                                fw.close();
                            }
                            
                            
                        }
                        
            }
            

        } 
        }
        
        else{
            
            System.out.println(food);
            //int preco = valor + 10;
            System.out.println(valor);
            preco = Integer.toString(valor);
            printar = food +"\n [Valor da Compra: "+valor+"]\n";
                PrintWriter fw = null;
                try {
                    fw = new PrintWriter("users.txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(printar);
                    bw.newLine();
                    //bw.write(tfPassword.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                    fw.close();
                }          
    }
    }
    
    private String handleOptions(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){
        String message = "Bonus:\n";
        valor = 20;

        if(box1.isSelected()){
            message += "Dobro do Recheio\n";
            valor = (valor + 2);
            
        }

        if(box2.isSelected()){
            message += "com Bacon\n";
            valor = (valor + 2);
        }
        
        if(box3.isSelected()){
            message += "dobro de queijo\n";
            valor = (valor + 2);
        }
        return message;
    }
    
    private void getClear(int valor){
        int newValor = 0;
        valor = newValor; 
          
    }

    
}
