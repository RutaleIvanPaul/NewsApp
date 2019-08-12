# NewsApp

NewsApp is an application that brings you the latest news updates from various news sources. It provides you with the ability to view news updates in five locations by default Kampala, Kigali, Nairobi, NewYork, and Lagos.
In addition, one can view international headlines, news based on other locals, share and save news reports within the application and ability to operate while offline.

### [Get the app on Amazon](https://www.amazon.com/gp/product/B07WCNQBMW)
  

## Screenshots
![Screenshot_1565290590](https://user-images.githubusercontent.com/30496434/62730451-a3bc5e00-ba28-11e9-82c9-62630831c4f9.png)

![Screenshot_1565291157](https://user-images.githubusercontent.com/30496434/62730502-be8ed280-ba28-11e9-9e67-699cf1242265.png)

![Screenshot_1565291245](https://user-images.githubusercontent.com/30496434/62730590-f3028e80-ba28-11e9-8fad-cd6e8bc14e42.png)

![Screenshot_1565291325](https://user-images.githubusercontent.com/30496434/62730670-1e857900-ba29-11e9-809c-af432d6b3858.png)




## Getting Started and Installation

1. Clone this repository onto your local machine.
`https://github.com/RutaleIvanPaul/NewsApp.git`

2. Locate the project on your machine. 

3. In Android Studio, under the file menu select open, then select an existing project.

4. Build the project.
`./gradlew build`

5. Select an emulator and run the application.

6. In addition, you can run the application using an Android device.

### Prerequisites

1. [Set up Android Studio](https://developer.android.com/studio/install) 

2. [Enable Kotlin in Android Studio](https://medium.com/@elye.project/setup-kotlin-for-android-studio-1bffdf1362e8)

3. [Run application on emulator](https://developer.android.com/studio/run/emulator)

4. [Run application on android device](https://developer.android.com/studio/run/device)


## Running the tests

1. In order to run tests from the terminal, run the following commands
`./gradlew test`

2. In order to be able to run tests using Android Studio itself, navigate to either androidTest or test folder and select a file then right click the file and select run test

NB: In order to be able to run instrumentation tests, you must have either a device or an emulator running.

### Break down into the end to end tests

androidTest folder holds instrumentation tests and these test components/views specific to Android (UI)

test folder holds the unit tests that test the logic and algorithms being used within the application. (Backend)

### Coding Styles/ Conventions
- Google Java Style
- Kotlin Style
- XML Naming Conventions

## Architecture
* MVVM

## Consumed API Endpoints

```
    https://newsapi.org/v2/everything?q={query}&apiKey={key}
```

## Built With

* [Kotlin](https://kotlinlang.org/) - Programming language
* [Android](https://www.android.com/) - Operating System
* [Fuel](https://github.com/kittinunf/fuel) - Networking
* [Picasso](http://square.github.io/picasso/) - Image processing
* [Anko](https://github.com/Kotlin/anko/wiki/Anko-SQLite) - Database management

## Versioning
1.0 

## Authors
[Rutale Ivan Paul](https://github.com/RutaleIvanPaul)


## Credits
All this has been possible thanks to the services provided by:.
[powered by NewsAPI.org](https://newsapi.org)
