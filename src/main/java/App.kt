import java.io.File
import javax.imageio.ImageIO

/**
 * @author Leolin
 */
fun main(args: Array<String>) {

    File("images-r").mkdirs()
    File("images").listFiles().forEach {
        ImageIO.read(File(it.absolutePath)).apply {
            val tempData = Array(width, { Array(height, { 0 }) })

            for (i in 0..width - 1) {
                for (j in 0..height - 1) {
                    tempData[width - i - 1][j] = getRGB(i, j)
                }
            }

            for (i in 0..width - 1) {
                for (j in 0..height - 1) {
                    setRGB(i, j, tempData[i][j])
                }
            }

            ImageIO.write(this, "PNG", File("images-r", it.name));
        }

    }


}