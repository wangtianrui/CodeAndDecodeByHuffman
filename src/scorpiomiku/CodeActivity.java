package scorpiomiku;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class CodeActivity {

    private Stage main = new Stage();
    private Button start = new Button("开始");
    private Button input = new Button("...");
    private Button output = new Button("...");
    private Button Exit = new Button("退出");
    private Button Back = new Button("返回首页");
    private Text inputfile;
    private Text outputpath;
    private TextField inputField = new TextField();
    private TextField outputFeild = new TextField();


    CodeActivity(int selection, Stage begin) throws IOException {


        output.setOnAction(event -> {
            //JFileChooser可以用来浏览文件夹
            JFileChooser fileChooser = new JFileChooser();
            //只能选择一个
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int flag = fileChooser.showOpenDialog(fileChooser);
            if (flag == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                //getAbsolutePath()返回的是user.dir+getPath()的内容,如：D:\\test\\test.txt
                outputFeild.setText(file.getAbsolutePath());
            }
        });


        Exit.setOnAction(event -> {
            main.close();
            begin.close();
        });

        Back.setOnAction(event -> {
            main.close();
            begin.show();
        });


        if (selection == 2) {
            this.inputfile = new Text("请选择要压缩的文件");
            this.outputpath = new Text("请选择输出目录");
            start.setOnAction(event -> {
                System.out.println("压缩1" + this.outputFeild.getText().toString());
            });
            input.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                int flag = fileChooser.showOpenDialog(fileChooser);
                if (flag == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    inputField.setText(file.getAbsolutePath());
                }
            });
        } else if (selection == 1) {
            this.inputfile = new Text("请选择要解压的文件");
            this.outputpath = new Text("请选择输出目录");
            start.setOnAction(event -> {
                System.out.println("解压");

            });
            input.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                int flag = fileChooser.showOpenDialog(fileChooser);
                if (flag == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    inputField.setText(file.getAbsolutePath());
                }
            });
        } else if (selection == 0) {
            this.inputfile = new Text("请选择要压缩的文件");
            this.outputpath = new Text("请选择输出目录");
            start.setOnAction(event -> {
                System.out.println("压缩");
            });
            input.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int flag = fileChooser.showOpenDialog(fileChooser);
                if (flag == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    inputField.setText(file.getAbsolutePath());
                }
            });
        }
        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        inputField.setPrefSize(200, 20);
        outputFeild.setPrefSize(200, 20);
        first.getChildren().addAll(inputfile, inputField, input);
        first.setAlignment(Pos.CENTER);
        first.setSpacing(30);
        second.getChildren().addAll(outputpath, outputFeild, output);
        second.setAlignment(Pos.CENTER);
        second.setSpacing(30);
        third.getChildren().addAll(start, Exit, Back);
        third.setAlignment(Pos.CENTER);
        third.setSpacing(100);
        Exit.setPrefSize(80, 30);
        start.setPrefSize(80, 30);
        Back.setPrefSize(80, 30);
        VBox all = new VBox();
        all.getChildren().addAll(first, second, third);
        all.setSpacing(100);
        all.setAlignment(Pos.CENTER);
        all.setPrefSize(600, 400);
        Scene scene = new Scene(all, 600, 400);
        main.setScene(scene);
        main.setTitle("基于HuffMan编码的压缩");
        main.show();
    }
}
