# Appium Android test for a ToDo app

This project contains tests written with the help of Gherkin + Cucumber, which run on Appium server on an Android device.

---

### Prerequisites

In order to successfully run these tests, you should have the following Plugins

```
Gherkin
Cucumber for Java
```

Android SDK has to be installed on your machine and environment variable set
```
ANDROID_HOME
```

---

## Running the tests

First things first make sure that you have an Appium server running.\
You can run Appium server by downloading the [Appium Server GUI application](https://github.com/appium/appium-desktop)

Or by executing the following command in command-line: `appium -p 4723` which runs an appium server using port: **4723**.

Tests can be ran directly from .feature files located in folder: *src -> test -> resources -> features.* \
The Appium server will run on any available port automatically.

---

## Setting up device

On your test device, make sure that Developer options are enabled ([Configure on-device developer options](https://developer.android.com/studio/debug/dev-options)) \
as well as USB debugging is enabled under the "DEBUGGING" section.

---

## Adding device device capabilities
Device properties should be added in the *configuration.properties* file located: *src -> test -> resources -> configuration.properties*.

```
android.device.name has to set to deviceId, that can be checked by
running command: adb devices in Terminal while your device is connected to
your machine via USB.
```

---

## Important
#### <span style="color:orange">The property *android.app.path* has to be set to the Absolute Path of the *src -> main -> java -> app -> ToDo.apk* file!</span>.

---

## APK file
There's already a .apk file located in this project so there's no need to install anything manually. \
The app file is located in the *src -> main -> java -> app directory*

---

### Adding new steps

Adding new custom steps is really straight forward, and can be done with the following steps:
1. write the desired step in .feature file,
2. "Undefined step reference" should be displayed for step,
3. use shortcut: ALT + ENTER (option + return for Mac)
4. select "Create step definition"
5. choose definition file
6. write desired logic for generated step

---

## Author

### **Artis Mocans** -  [GitHub](https://github.com/artisMocans)