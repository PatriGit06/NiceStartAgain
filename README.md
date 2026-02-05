
# Nice Start Again 

**Nice Start Again** es una aplicación móvil desarrollada en **Android Studio (Java)** que permite a los usuarios **registrarse, iniciar sesión y crear su propio perfil personal** dentro de la app.  

El proyecto busca ofrecer una **interfaz moderna e intuitiva**, diseñada para que cualquier usuario pueda utilizarla fácilmente.

---

##  1. Características Principales

###  1.1 Diseño UI/UX
- Material Design 3  
- Layouts responsivos con Edge-to-Edge  
- Pantalla de inicio animada (fadeIn + Glide)  
- Gradientes personalizados e iconos vectoriales  
- Soporte para tema claro/oscuro  

###  1.2 Autenticación y Navegación
- Login y Signup con navegación directa  
- Campos de usuario, contraseña y email  
- Botones con colores y estilos personalizados  
- Toolbar en perfil con flecha atrás  

---

##  2. Pantallas de la Aplicación

| Pantalla | Imagen | Descripción |
|----------|-------|------------|
| Splash / Principal | ![Splash](https://github.com/user-attachments/assets/c7a7c577-4f15-4e42-be4f-e9affc8c525b) |
 Animación de logo y fondo, abre Login tras 5s, se encuentra implementada en la RamaLottie |
| Icono app |<img width="58" height="63" alt="Captura de pantalla 2026-02-05 123708" src="https://github.com/user-attachments/assets/4683c84b-d759-4a88-8ac8-4cc39d7fc2ce" />
| Login | <img width="298" height="653" alt="Captura de pantalla 2026-02-05 123759" src="https://github.com/user-attachments/assets/1e44d367-1b0a-4ee6-b5fd-923681ce323b" /> | Login con campos y botones de navegación |
| Registro (Signup) |<img width="363" height="658" alt="Captura de pantalla 2026-02-05 124125" src="https://github.com/user-attachments/assets/a5b9813f-696e-405e-b5d7-3fbb0c1a2056" /> | Registro de usuario con Username, Password y Email |
| Perfil de Usuario |<img width="306" height="545" alt="Captura de pantalla 2026-02-05 124147" src="https://github.com/user-attachments/assets/e47ae7c7-19ae-4175-a2b2-233a473705e9" /> | Visualización de avatar, nombre y descripción |
| MainActivity |<img width="336" height="716" alt="Captura de pantalla 2026-02-05 124422" src="https://github.com/user-attachments/assets/ddc47ae8-5d9b-49eb-93d5-e10ed99aa817" /> | WebView con SwipeRefreshLayout y menú contextual |

---

## 3. Funcionalidades por Pantalla

### 3.1 Splash / Principal
- Logo animado
- Fondo cargado con Glide  
- Tras 5 segundos, abre Login  

### 3.2 Login
- Campos de Usuario y Contraseña con iconos  
- Botón **LOGIN** → MainActivity  
- Botón **SIGN UP** → Signup  
- Diseño moderno y responsivo  

### 3.3 Registro (Signup)
- Campos: Usuario, Contraseña y Email  
- Botón **CREATE ACCOUNT** → Login  
- Botón **LOGIN** → vuelve al Login  
- Interfaz Material y adaptable  

### 3.4 MainActivity
- WebView con imagen aleatoria  
- SwipeRefreshLayout con mensaje de actualización  
- AppBar y menú con opciones:  
  - Copiar ítem (Toast)  
  - Descargar ítem (Toast)  
  - Salir / volver a Login  
  - Abrir Perfil  
  - AlertDialog con navegación  

### 3.5 Perfil
- Avatar circular editable  
- Nombre y descripción  
- Toolbar con flecha atrás  
- Diseño limpio y colores consistentes  

### 3.6 Locales
- Cambio de idioma según preferencia  

### 3.7 Modo Claro / Oscuro
- Alternancia entre tema claro y oscuro  

### 3.8 BottomAppBar
- FAB centrado  
- Menú de opciones y navegación  
- Interacción con contenido  

### 3.9 Funcionalidades Adicionales
- Persistencia de sesión con SharedPreferences  
- Usuario autenticado entra directo a la pantalla principal hasta cerrar sesión manualmente


##  4. Estructura del Proyecto

```
NiceStart/
├── AndroidManifest.xml
├── java/com.example.nicestart/
│ ├── MainActivity.java
│ ├── Login.java
│ ├── Signup.java
│ ├── Principal.java
│ ├── Profile.java
│ ├── MainBab.java
│ └── MainBn.java
├── res/
│ ├── layout/
│ ├── menu/
│ ├── drawable/
│ ├── anim/
│ ├── color/
│ └── values/
└── Gradle Scripts/


```

---

## Tecnologías Utilizadas

- **Lenguaje de programación:** Java
- **Entorno de desarrollo:** Android Studio
- **Plataforma:** Android
- **Interfaz de usuario:** XML

---

##  6. Licencia
<div align="center">

[![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)  
[![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)](https://developer.android.com/studio)  
[![Material Design](https://img.shields.io/badge/Material--Design-0081CB?style=for-the-badge&logo=material-design&logoColor=white)](https://material.io/)  
[![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)  
[![Licencia](https://img.shields.io/badge/Licencia-CC%20BY--SA%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-sa/4.0/)  

</div>
