package scorpiomiku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainActivity {

    private Frame main_activity_frame;
    private Panel panel;
    private Button button_encode;
    private Button button_decode;

    public void init() {
        main_activity_frame = new Frame("哈夫曼树编码解码");
        main_activity_frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));


        button_encode = new Button("encode");
        button_encode.setPreferredSize(new Dimension(150, 100));
        button_encode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点了encode");
            }
        });
        button_decode = new Button("decode");
        button_decode.setPreferredSize(new Dimension(150, 100));
        button_decode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点了decode");
            }
        });


        main_activity_frame.add(button_encode);
        main_activity_frame.add(button_decode);
        main_activity_frame.setBounds(800, 400, 400, 200);
        //main_activity_frame.pack();
        main_activity_frame.setVisible(true);


    }


}
