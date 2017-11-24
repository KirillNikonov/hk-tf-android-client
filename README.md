# hk-tf-android-client

## Related repositories

- [game server](https://github.com/knikitin/hk-game-server)
- [mic-transfer](https://github.com/AlexandrShur/mic-transfer)

## Build

Put your model and label files into `assets` folder, e.g.
```
assets/
    conv_actions_frozen.pb
    conv_actions_labels.txt
```

Make sure the model type and model file names in `PowerVoiceClientActivity` class correspond to the ones you put in.

Build using
```
gradlew.bat build
```

This should create `*.apk` files that you can use to install the app on yor Android device.