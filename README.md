# Android Navigation
Projeto para o curso de Architecture Components Navigation
![image](https://github.com/GuerraAna/android-navigation-projeto-inicial/assets/78937585/e4019376-2ab2-42a8-9055-c5785e05caa4)
![image](https://github.com/GuerraAna/android-navigation-projeto-inicial/assets/78937585/d12756ea-1a28-48f0-ab37-30e230aabb80)
![image](https://github.com/GuerraAna/android-navigation-projeto-inicial/assets/78937585/3e82e30d-008e-42a8-98ae-2766244ce2b7)
![image](https://github.com/GuerraAna/android-navigation-projeto-inicial/assets/78937585/f475e6c8-fa37-4988-8016-ade77d17bab8)

## Tecnologias

- Kotlin + Coroutines
- **Navigation Component** (`navigation-fragment-ktx`, `navigation-ui-ktx`) — foco do curso
- Room, ViewModel, LiveData
- Koin (injeção de dependência)
- AppCompat, Material, RecyclerView
- AGP 3.4.1 / Gradle 5.1.1

## Pré-requisitos

- **JDK 11**
- Android SDK

> **Nota de build (2026):** `jcenter()` foi descontinuado — mirror do JCenter (Aliyun) adicionado para resolver `koin-android` 2.x.

## Como rodar

```bash
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties   # macOS
./gradlew assembleDebug
```
