# Digikala Clone – Modern Android E-commerce App 🛍️

A high-fidelity clone of **Digikala**, Iran’s largest e-commerce platform, built to demonstrate advanced Android development skills including modern UI, clean architecture, API integration, and scalability. Developed using **Kotlin**, **Jetpack Compose**, and **Hilt**, this project simulates real-world app complexity with a clean, testable, and modular structure.

## 🌟 Key Highlights

- ✅ 100% built with **Jetpack Compose** (No XML)
- 🧱 Scalable **MVVM Architecture** with separation of concerns
- 🔌 RESTful API consumption via **Retrofit** & **Coroutines**
- 📦 DI setup using **Hilt** for testability and modularity
- 🧭 Declarative Navigation using **Navigation Compose**
- 🌈 Custom theming with dynamic light/dark mode
- ⚙️ Proper error handling, loading states, and retry mechanisms

## 🔧 Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Kotlin |
| UI Toolkit | Jetpack Compose |
| Architecture | MVVM |
| Dependency Injection | Hilt (Dagger) |
| Networking | Retrofit + Coroutines |
| Image Loading | Coil |
| State Management | State Hoisting + ViewModels |
| Navigation | Jetpack Navigation (Compose) |
| Testing (optional) | JUnit + Mockito / Compose UI Tests |

## 📱 Features Implemented

- 🏠 Home Screen with dynamic product listings
- 📄 Product Details with image gallery & attributes
- 🛒 Shopping Cart (Add/Remove products)
- 🔍 Category-based navigation
- ⚠️ Full error/loading/empty state handling
- 🔄 API error retries + fallback scenarios

## 📁 Project Structure
DigikalaClone/
├── data/
│ ├── api/ # Retrofit service interfaces
│ ├── model/ # DTOs and data classes
│ └── repository/ # Repository pattern for data handling
│
├── di/ # Hilt modules for dependency injection
│
├── ui/
│ ├── screens/ # Feature-based screens (Home, Detail, Cart, etc.)
│ ├── components/ # Reusable Composable components
│ └── theme/ # App theming setup (colors, typography)
│
├── utils/ # Constants, helper functions, etc.
 └── MainActivity.kt # Main entry point with NavHost

## 🧰 Getting Started

```bash
git clone https://github.com/amirhr8/DigikalaClone.git
cd DigikalaClone

