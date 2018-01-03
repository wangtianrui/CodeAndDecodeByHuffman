package scorpiomiku;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class SceneWarning {
    Stage warning = new Stage();
    Text content = new Text();
    Button back = new Button("取消");
    Pane pane = new Pane();
    VBox vBox = new VBox();

    SceneWarning(String Type) {
        content = new Text(Type);
        vBox.getChildren().addAll(content, back);
        back.setOnAction(event -> {
            warning.close();
        });
        pane.getChildren().add(vBox);
        vBox.setPrefSize(200, 100);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        Scene scene = new Scene(pane, 200, 100);
        warning.setScene(scene);
        warning.setTitle("基于HuffMan编码的压缩");
        warning.show();
    }

}
