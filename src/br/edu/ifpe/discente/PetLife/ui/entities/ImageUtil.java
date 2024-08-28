package br.edu.ifpe.discente.PetLife.ui.entities;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

public class ImageUtil {
    public static ImageIcon convertToImageIcon(byte[] imageBytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        ImageIcon imageIcon = new ImageIcon(imageBytes);
        return imageIcon;
    }
}