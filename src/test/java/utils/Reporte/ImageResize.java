package utils.Reporte;

import net.coobird.thumbnailator.Thumbnails;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageResize {

    public static String FixTamano(File file_in){
        String pathToFile = "";
//        pathToFile = AjustarTamano(file_in);
//        pathToFile = resizeImage(pathToFile);
        pathToFile = redimensionaImagen(file_in);
        return pathToFile;
    }

    public static String AjustarTamano(File file_in){
        String nuevaImagen = file_in.getAbsolutePath();
        try {
            File input = file_in;
            BufferedImage image = ImageIO.read(input);
            nuevaImagen = nuevaImagen.replace(".png", "_2.png");
            File output = new File(nuevaImagen);
            OutputStream out = new FileOutputStream(output);

            ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
            ImageOutputStream ios = ImageIO.createImageOutputStream(out);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();
            if (param.canWriteCompressed()) {
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.0f);
            }

            writer.write(null, new IIOImage(image, null, null), param);

            out.close();
            ios.close();
            writer.dispose();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return nuevaImagen;
    }

    private static String resizeImage(String pathToFile){
        BufferedImage resizedImage;
        BufferedImage originalImage;
        int IMG_WIDTH = 1260;
        int IMG_HEIGHT = 500;
        String location = pathToFile;
        try {
            originalImage = ImageIO.read(new File(pathToFile));
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();

            BufferedImage resizeImagePng = resizedImage;
            location = location.replace("_2.png", "_3");
            ImageIO.write(resizeImagePng, "png", new File(location));

        }catch(Exception ex){

        }

        return location;
    }

    private static String redimensionaImagen(File fileScreenshot) {

        String location = fileScreenshot.getAbsolutePath();
        try {
            location = location.replace(".png", "_2.png");
            Thumbnails.of(fileScreenshot.getAbsolutePath())
                    .size(970, 500)
                    .toFile(location);
        }catch (IOException e){
            PdfQaNovaReports.addReport("compresionImagen", "Ocurrio un error al comprimir la Imagen. "+e.getMessage(), EstadoPrueba.FAILED, true);
        }
        return location;
    }
}