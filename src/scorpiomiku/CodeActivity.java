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

    private Stage main_layout = new Stage();
    private Button startButton = new Button("开始");
    private Button firstFileButton = new Button("...");
    private Button secondFileButton = new Button("...");
    private Button exitButton = new Button("退出");
    private Button backButton = new Button("返回首页");
    private Text firstFileText;
    private Text secondFileText;
    private TextField firstTextField = new TextField();
    private TextField secondTextField = new TextField();


    CodeActivity(int selection, Stage begin) throws IOException {


        secondFileButton.setOnAction(event -> {
            //JFileChooser可以用来浏览文件夹
            JFileChooser fileChooser = new JFileChooser();
            //只能选择一个
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int flag = fileChooser.showOpenDialog(fileChooser);
            if (flag == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                //getAbsolutePath()返回的是user.dir+getPath()的内容,如：D:\\test\\test.txt
                secondTextField.setText(file.getAbsolutePath());
            }
        });


        exitButton.setOnAction(event -> {
            main_layout.close();
            begin.close();
        });

        backButton.setOnAction(event -> {
            main_layout.close();
            begin.show();
        });


        if (selection == 2) {
            //selection==2时为encode界面
            //文字
            this.firstFileText = new Text("请选择要压缩的文件");
            this.secondFileText = new Text("请选择输出目录");
            //开始按钮点击事件
            startButton.setOnAction(event -> {
                System.out.println("压缩1" + this.secondTextField.getText().toString());
            });
            //浏览文件夹的按钮
            firstFileButton.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                int flag = fileChooser.showOpenDialog(fileChooser);
                if (flag == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    firstTextField.setText(file.getAbsolutePath());
                }
            });
        } else if (selection == 1) {
            //selection==1时为decode界面
            //设置文字
            this.firstFileText = new Text("请选择要解压的文件");
            this.secondFileText = new Text("请选择输出目录");

            //start按钮
            startButton.setOnAction(event -> {
                System.out.println("解压");
            });

            //文件浏览按钮
            firstFileButton.setOnAction(event -> {
                JFileChooser fileChooser = new JFileChooser();
                int flag = fileChooser.showOpenDialog(fileChooser);
                if (flag == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    firstTextField.setText(file.getAbsolutePath());
                }
            });
        }

        HBox firstHBox = new HBox();
        HBox secondHBox = new HBox();
        HBox thirdHBox = new HBox();
        firstTextField.setPrefSize(200, 20);
        secondTextField.setPrefSize(200, 20);
        firstHBox.getChildren().addAll(firstFileText, firstTextField, firstFileButton);
        firstHBox.setAlignment(Pos.CENTER);
        firstHBox.setSpacing(25);

        secondHBox.getChildren().addAll(secondFileText, secondTextField, secondFileButton);
        secondHBox.setAlignment(Pos.CENTER);
        secondHBox.setSpacing(30);

        thirdHBox.getChildren().addAll(startButton, exitButton, backButton);
        thirdHBox.setAlignment(Pos.CENTER);
        thirdHBox.setSpacing(100);

        exitButton.setPrefSize(80, 30);
        startButton.setPrefSize(80, 30);
        backButton.setPrefSize(80, 30);

        VBox all = new VBox();
        all.getChildren().addAll(firstHBox, secondHBox, thirdHBox);
        all.setSpacing(100);
        all.setAlignment(Pos.CENTER);
        all.setPrefSize(600, 400);
        Scene scene = new Scene(all, 600, 400);

        main_layout.setScene(scene);
        main_layout.setTitle("基于HuffMan编码的压缩");
        main_layout.show();
    }
}
