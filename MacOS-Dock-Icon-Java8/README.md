#
#
<br>

# Set The Dock Icon Of Your Client In Java 8
### (Minecraft 1.8.9, Java 8, Forge, Tested on MacOS 14 & osX 10.11)

So the defualt Minecraft set icon function does not set a Dock icon for MacOS users,<br>
this could be an issue for showing your brand when your Client is run on Mac.<br>

### Issues with this code:
- This code will not set an icon for Windows or Linux users (Minecraft already does this)
- This code WILL NOT work on java 9+ however there is a native way on java 9+
- Apple only has their offical icon template in a dmg [(Which can be found here)](https://developer.apple.com/design/resources/)
### Using this snippet:
I would love if you were to credit if you use it however you dont have to.

### For Mixins
#### Put this in your MixinMinecraft class
```java
    /**
     * Mixin setGameIcon
     * @reason change the game icon to a custom one
     */
    @Inject(method = "setWindowIcon", at = @At("HEAD"), cancellable = true)
    private void setGameIcon(CallbackInfo c) {
        if(Util.getOSType() == Util.EnumOS.OSX) {
            MacOSUtils.setDockIcon();
            c.cancel();
        } else {
            // windows impl
            c.cancel();
        }
    }
```
<br>

#
#