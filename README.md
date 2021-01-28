# FirestorePagination - Clean Architecture with MVVM.

It's an aplication build with Kotlin as an example on how to paginate a [Cloud Firestore](https://firebase.google.com/docs/firestore) database, using [Paging library v3](https://developer.android.com/topic/libraries/architecture/paging/v3-paged-data).

To keep things simple, the app uses a very simple database schema that look like in the image below:

![alt text](https://i.ibb.co/rkmLvqY/Db.jpg)

For getting the data, the app uses [Flow](https://developer.android.com/kotlin/flow) and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) together with [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) in a MVVM Architecture Pattern. For dependency injection the app uses [Hilt for Android](https://developer.android.com/training/dependency-injection/hilt-android). Besides that, the app also uses data binding to bind UI components in the layouts.

To make this app work, follow the instructions given in the official documentation regarding [how to add Firebase to your project](https://firebase.google.com/docs/android/setup). Add the JSON file in your app folder, add some dummy products and see it working.

This repo is the source code of the this article: [How to paginate Firestore using Paging 3 on Android?](https://medium.com/firebase-tips-tricks/how-to-paginate-firestore-using-paging-3-on-android-c485acb0a2df)

See it also on youtube: https://youtu.be/4JOzozH5eOQ
