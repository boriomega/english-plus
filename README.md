# English Plus

An Android English-learning app for Arabic-speaking beginners.

## Product goals
- Arabic right-to-left interface and explanations.
- Complete Arabic-supported CEFR A1 course: 12 units, 60 lessons, and 300 vocabulary exercises.
- Five lessons per unit followed by a five-question unit checkpoint; at least 3 correct answers unlock the next unit.
- Structured Arabic JSON course source at `app/src/main/assets/a1_course_ar.json` and native Kotlin course data used by the app.
- Core lessons designed to work offline.
- Free core learning experience, with optional paid features considered later.
- Original, consistent educational illustrations and a friendly, colorful learning experience.
- English pronunciation using Android text-to-speech in lesson cards.
- Unit progress, XP, and passed checkpoints are stored locally on the device.

## Visual identity
- Deep green: #16834A
- Navy blue: #123B70
- White: #FFFFFF
- Pale green: #E8F5EC
- No red accents and no star decorations or star-shaped progress markers.

## Content and illustration standards
All lessons, examples, and illustrations must be reviewed against the project's Islamic-content requirements. Use original artwork rather than copying assets from other apps. Avoid crosses, inappropriate imagery, and immodest clothing; women shown in illustrations must have their hair covered.

## Technology
- Kotlin
- Jetpack Compose
- Android Gradle Plugin

## Build
Open this repository in Android Studio with JDK 17 and allow Gradle sync. The app foundation is version 0.1.0. Android text-to-speech uses the device's installed English voice; availability and voice quality depend on Android speech services.
