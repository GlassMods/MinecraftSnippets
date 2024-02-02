package skid.glassmods.snippets;

import net.minecraft.util.Util;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MacOSUtils {

    public static void setDockIcon(){
        if(Util.getOSType() != Util.EnumOS.OSX) { return; } // Probably not needed if called correctly but yeah

        InputStream icon = MacOSUtils.class.getResourceAsStream("/assets/minecraft/modid/icon/iconname.png"); // you could probably use resource location but users can then change it with a TexturePack
        if (icon != null) {
            try {
                Class<?> Application = Class.forName("com.apple.eawt.Application");
                Application.getMethod("setDockIconImage", Image.class).invoke(Application.getMethod("getApplication").invoke(null), ImageIO.read(icon));
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | IOException e) { System.err.println("[ MacOS Utils ] Error setting dock icon: " + e.getMessage()); }
        } else { System.err.println("[ MacOS Utils ] Icon file could not be found"); }
    }

}
