package com.englishplus.app

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.CompositionLocalProvider

private val Navy = Color(0xFF123B70)
private val FlagRed = Color(0xFFE63946)
private val PaleBlue = Color(0xFFEAF2FC)
private val Ink = Color(0xFF172B4D)
private val Page = Color(0xFFF7F9FC)
private val Green = Color(0xFF16834A)

private data class Exercise(
    val word: String,
    val pronunciation: String,
    val question: String,
    val choices: List<String>,
    val answer: String,
    val example: String
)

private val beginnerExercises = listOf(
    Exercise("HELLO", "heh-LOH", "ماذا تعني هذه الكلمة؟", listOf("شكراً", "مرحباً", "إلى اللقاء"), "مرحباً", "Hello, Ali!"),
    Exercise("BOOK", "book", "ماذا تعني هذه الكلمة؟", listOf("قلم", "باب", "كتاب"), "كتاب", "This is my book."),
    Exercise("WATER", "WAW-ter", "ماذا تعني هذه الكلمة؟", listOf("ماء", "طعام", "منزل"), "ماء", "I drink water."),
    Exercise("THANK YOU", "THANK yoo", "اختر الترجمة الصحيحة", listOf("من فضلك", "شكراً لك", "صباح الخير"), "شكراً لك", "Thank you, my friend."),
    Exercise("GOOD MORNING", "good MOR-ning", "ماذا تعني العبارة؟", listOf("تصبح على خير", "مساء الخير", "صباح الخير"), "صباح الخير", "Good morning, everyone."),
    Exercise("PLEASE", "pleez", "ماذا تعني هذه الكلمة؟", listOf("من فضلك", "عفواً", "وداعاً"), "من فضلك", "Please sit here."),
    Exercise("HOUSE", "hows", "ماذا تعني هذه الكلمة؟", listOf("مدرسة", "منزل", "شارع"), "منزل", "This is my house."),
    Exercise("FAMILY", "FAM-uh-lee", "ماذا تعني هذه الكلمة؟", listOf("صديق", "عائلة", "مدينة"), "عائلة", "I love my family."),
    Exercise("FRIEND", "frend", "ماذا تعني هذه الكلمة؟", listOf("معلم", "جار", "صديق"), "صديق", "He is my friend."),
    Exercise("SCHOOL", "skool", "ماذا تعني هذه الكلمة؟", listOf("مدرسة", "مكتبة", "حديقة"), "مدرسة", "My school is big."),
    Exercise("PEN", "pen", "ماذا تعني هذه الكلمة؟", listOf("حقيبة", "قلم", "كتاب"), "قلم", "This is a pen."),
    Exercise("APPLE", "AP-uhl", "ماذا تعني هذه الكلمة؟", listOf("تفاحة", "برتقالة", "موزة"), "تفاحة", "I eat an apple."),
    Exercise("CAT", "kat", "ماذا تعني هذه الكلمة؟", listOf("كلب", "طائر", "قطة"), "قطة", "The cat is small."),
    Exercise("WATER", "WAW-ter", "اختر معنى الكلمة", listOf("ماء", "حليب", "عصير"), "ماء", "I drink water."),
    Exercise("GOODBYE", "good-BYE", "ماذا تعني هذه الكلمة؟", listOf("مرحباً", "إلى اللقاء", "شكراً"), "إلى اللقاء", "Goodbye, see you soon.")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Surface(modifier = Modifier.fillMaxSize(), color = Page) {
                        EnglishPlusApp()
                    }
                }
            }
        }
    }
}

@Composable
private fun EnglishPlusApp() {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("english_plus_progress", Context.MODE_PRIVATE) }
    var xp by remember { mutableStateOf(prefs.getInt("xp", 0)) }
    var completed by remember { mutableStateOf(prefs.getInt("completed_lessons", 0)) }
    var a0ExamPassed by remember { mutableStateOf(prefs.getBoolean("a0_exam_passed", false)) }
    var screen by remember { mutableStateOf("home") }
    var selectedLesson by remember { mutableStateOf(1) }

    fun saveProgress(newXp: Int, newCompleted: Int) {
        xp = newXp
        completed = newCompleted
        prefs.edit()
            .putInt("xp", newXp)
            .putInt("completed_lessons", newCompleted)
            .apply()
    }

    when (screen) {
        "lesson" -> LessonScreen(
            lessonNumber = selectedLesson,
            onBack = { screen = "home" },
            onLessonComplete = { earned ->
                if (selectedLesson > completed) saveProgress(xp + earned, selectedLesson)
                screen = "result"
            }
        )
        "exam" -> FinalExamScreen(
            onBack = { screen = "home" },
            onComplete = { passed ->
                if (passed && !a0ExamPassed) {
                    a0ExamPassed = true
                    prefs.edit().putBoolean("a0_exam_passed", true).apply()
                }
                screen = "home"
            }
        )
        "result" -> ResultScreen(
            xp = xp,
            completed = completed,
            onContinue = { screen = "home" }
        )
        else -> HomeScreen(
            xp = xp,
            completed = completed,
            examPassed = a0ExamPassed,
            onStartLesson = { lesson -> selectedLesson = lesson; screen = "lesson" },
            onStartExam = { screen = "exam" }
        )
    }
}

@Composable
private fun HomeScreen(xp: Int, completed: Int, examPassed: Boolean, onStartLesson: (Int) -> Unit, onStartExam: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .background(Page).padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("⭐ $xp XP", color = FlagRed, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Column(horizontalAlignment = Alignment.End) {
                Text("English Plus", color = Navy, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                Text("رحلتك لتعلّم الإنجليزية تبدأ هنا", color = Ink, fontSize = 13.sp)
            }
        }
        Spacer(Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Navy)
        ) {
            Column(Modifier.padding(22.dp), horizontalAlignment = Alignment.End) {
                Text("مرحباً بك!", color = Color.White, fontSize = 23.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Text(
                    "تعلّم الإنجليزية خطوة بخطوة،\nواحرز تقدماً كل يوم.",
                    color = Color.White.copy(alpha = 0.92f),
                    fontSize = 15.sp,
                    textAlign = TextAlign.End,
                    lineHeight = 24.sp
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { onStartLesson((completed + 1).coerceIn(1, 3)) },
                    colors = ButtonDefaults.buttonColors(containerColor = FlagRed),
                    shape = RoundedCornerShape(14.dp)
                ) { Text("تابع التعلّم", fontWeight = FontWeight.Bold) }
            }
        }
        Spacer(Modifier.height(22.dp))
        Text("تقدمك", color = Ink, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.End) {
                Text("$completed دروس مكتملة", color = Ink, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = { (completed.coerceAtMost(3) / 3f) },
                    modifier = Modifier.fillMaxWidth(),
                    color = Green,
                    trackColor = PaleBlue
                )
                Spacer(Modifier.height(5.dp))
                Text("هدف البداية: إكمال 3 دروس", color = Color(0xFF64748B), fontSize = 12.sp)
            }
        }
        if (completed >= 3) {
            Spacer(Modifier.height(18.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = if (examPassed) Color(0xFFE8F5EC) else Color(0xFFFFF4E5))
            ) {
                Column(Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.End) {
                    Text(if (examPassed) "اختبار A0 مكتمل ✓" else "حان وقت الاختبار النهائي A0", color = Navy, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Spacer(Modifier.height(6.dp))
                    Text(
                        if (examPassed) "اجتزت الاختبار بنجاح. المستوى A1 هو خطوتك التالية وسيُضاف محتواه في التحديث القادم." else "أجب عن 5 أسئلة. تحتاج إلى 4 إجابات صحيحة على الأقل لاجتياز الاختبار.",
                        color = Ink, fontSize = 13.sp, textAlign = TextAlign.End
                    )
                    if (!examPassed) {
                        Spacer(Modifier.height(10.dp))
                        Button(onClick = onStartExam, colors = ButtonDefaults.buttonColors(containerColor = FlagRed), shape = RoundedCornerShape(12.dp)) {
                            Text("ابدأ الاختبار النهائي")
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(22.dp))
        Text("مسار التعلّم", color = Ink, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("ابدأ من الأسفل وتقدّم درساً بعد درس", color = Color(0xFF64748B), fontSize = 12.sp)
        Spacer(Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(Modifier.fillMaxWidth().padding(vertical = 18.dp, horizontal = 12.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text("الوحدة الأولى • الكلمات الأولى", color = Navy, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
                Spacer(Modifier.height(16.dp))
                (1..3).forEach { lessonNumber ->
                    val isDone = lessonNumber <= completed
                    val isUnlocked = lessonNumber == completed + 1
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                        horizontalArrangement = when (lessonNumber % 3) {
                            0 -> Arrangement.Start
                            1 -> Arrangement.Center
                            else -> Arrangement.End
                        },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(
                                onClick = { onStartLesson(lessonNumber) },
                                enabled = isUnlocked || isDone,
                                modifier = Modifier.size(76.dp),
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isDone) Green else if (isUnlocked) FlagRed else Color(0xFFE1E7EF),
                                    disabledContainerColor = Color(0xFFE1E7EF),
                                    contentColor = Color.White,
                                    disabledContentColor = Color(0xFF8290A3)
                                ),
                                elevation = ButtonDefaults.buttonElevation(defaultElevation = if (isUnlocked) 5.dp else 0.dp),
                                contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                            ) {
                                Text(
                                    when {
                                        isDone -> "★"
                                        isUnlocked -> "▶"
                                        else -> "🔒"
                                    },
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                            Text(
                                when {
                                    isDone -> "الدرس $lessonNumber ✓"
                                    isUnlocked -> "ابدأ الآن"
                                    else -> "الدرس $lessonNumber"
                                },
                                color = if (isUnlocked) FlagRed else Color(0xFF64748B),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text(if (examPassed) "أكملت A0 بنجاح • المستوى A1 قيد الإعداد" else "أكمل الدروس الثلاثة ثم اجتز الاختبار النهائي", color = Color(0xFF64748B), fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(
            "تُحفظ نقاطك وتقدّمك على هذا الجهاز",
            color = Navy, fontSize = 13.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun LessonScreen(lessonNumber: Int, onBack: () -> Unit, onLessonComplete: (Int) -> Unit) {
    var questionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var correctCount by remember { mutableStateOf(0) }
    var checked by remember { mutableStateOf(false) }
    val lessonExercises = beginnerExercises.drop((lessonNumber - 1) * 5).take(5)
    val exercise = lessonExercises[questionIndex]
    val isCorrect = selectedAnswer == exercise.answer

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = Navy)) {
                Text("خروج")
            }
            Text("الدرس $lessonNumber • A0", color = FlagRed, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(18.dp))
        LinearProgressIndicator(
            progress = { (questionIndex + if (checked) 1 else 0).toFloat() / lessonExercises.size },
            modifier = Modifier.fillMaxWidth(),
            color = FlagRed,
            trackColor = PaleBlue
        )
        Spacer(Modifier.height(22.dp))
        Text("السؤال ${questionIndex + 1} من ${lessonExercises.size}", color = Color(0xFF64748B), fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))
        Text(exercise.question, color = Ink, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(18.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = PaleBlue)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("📘", fontSize = 42.sp)
                Spacer(Modifier.height(8.dp))
                Text(exercise.word, color = Navy, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
                Text(exercise.pronunciation, color = Color(0xFF64748B), fontSize = 15.sp)
                Spacer(Modifier.height(10.dp))
                Text("مثال: ${exercise.example}", color = Ink, fontSize = 14.sp, textAlign = TextAlign.Center)
            }
        }
        Spacer(Modifier.height(18.dp))
        exercise.choices.forEach { answer ->
            val chosen = selectedAnswer == answer
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
                    .clickable(enabled = !checked) { selectedAnswer = answer },
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (chosen) PaleBlue else Color.White
                ),
                border = androidx.compose.foundation.BorderStroke(
                    width = if (chosen) 2.dp else 1.dp,
                    color = if (chosen) Navy else Color(0xFFE6EAF0)
                )
            ) {
                Text(
                    answer,
                    modifier = Modifier.fillMaxWidth().padding(17.dp),
                    color = Ink,
                    fontSize = 17.sp,
                    fontWeight = if (chosen) FontWeight.Bold else FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }
        }
        if (checked) {
            Spacer(Modifier.height(12.dp))
            Text(
                if (isCorrect) "أحسنت! إجابة صحيحة ⭐" else "الإجابة الصحيحة: ${exercise.answer}",
                color = if (isCorrect) Green else FlagRed,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.height(18.dp))
        Button(
            onClick = {
                if (!checked) {
                    checked = true
                    if (isCorrect) correctCount += 1
                } else if (questionIndex < lessonExercises.lastIndex) {
                    questionIndex += 1
                    selectedAnswer = null
                    checked = false
                } else {
                    onLessonComplete(correctCount * 10)
                }
            },
            enabled = checked || selectedAnswer != null,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = FlagRed,
                disabledContainerColor = Color(0xFFE6EAF0)
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                when {
                    !checked -> "تحقق من الإجابة"
                    questionIndex == lessonExercises.lastIndex -> "إنهاء الدرس"
                    else -> "السؤال التالي"
                },
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
private fun FinalExamScreen(onBack: () -> Unit, onComplete: (Boolean) -> Unit) {
    val questions = beginnerExercises.take(5)
    var index = remember { mutableStateOf(0) }
    var answer = remember { mutableStateOf<String?>(null) }
    var score = remember { mutableStateOf(0) }
    var checked = remember { mutableStateOf(false) }
    var finished = remember { mutableStateOf(false) }
    val item = questions[index.value]
    val correct = answer.value == item.answer

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp), horizontalAlignment = Alignment.End) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = Navy)) { Text("خروج") }
            Text("الاختبار النهائي • A0", color = FlagRed, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(18.dp))
        LinearProgressIndicator(progress = { (index.value + if (checked.value) 1 else 0).toFloat() / questions.size }, modifier = Modifier.fillMaxWidth(), color = FlagRed, trackColor = PaleBlue)
        Spacer(Modifier.height(22.dp))
        if (!finished.value) {
            Text("السؤال \${index.value + 1} من 5", color = Color(0xFF64748B), fontSize = 13.sp)
            Spacer(Modifier.height(10.dp))
            Text(item.word, color = Navy, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            Text(item.question, color = Ink, fontSize = 19.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(18.dp))
            item.choices.forEach { choice ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp).clickable(enabled = !checked.value) { answer.value = choice },
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = if (answer.value == choice) PaleBlue else Color.White),
                    border = androidx.compose.foundation.BorderStroke(if (answer.value == choice) 2.dp else 1.dp, if (answer.value == choice) Navy else Color(0xFFE6EAF0))
                ) { Text(choice, modifier = Modifier.fillMaxWidth().padding(17.dp), color = Ink, textAlign = TextAlign.Center, fontSize = 17.sp) }
            }
            if (checked.value) {
                Spacer(Modifier.height(10.dp))
                Text(if (correct) "إجابة صحيحة" else "الإجابة الصحيحة: \${item.answer}", color = if (correct) Green else FlagRed, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(18.dp))
            Button(
                onClick = {
                    if (!checked.value) {
                        checked.value = true
                        if (correct) score.value += 1
                    } else if (index.value < questions.lastIndex) {
                        index.value += 1
                        answer.value = null
                        checked.value = false
                    } else finished.value = true
                },
                enabled = checked.value || answer.value != null,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FlagRed, disabledContainerColor = Color(0xFFE6EAF0)),
                shape = RoundedCornerShape(15.dp)
            ) { Text(if (!checked.value) "تحقق من الإجابة" else if (index.value == questions.lastIndex) "عرض النتيجة" else "السؤال التالي", fontWeight = FontWeight.Bold) }
        } else {
            val passed = score.value >= 4
            Spacer(Modifier.height(42.dp))
            Text(if (passed) "ممتاز! اجتزت الاختبار" else "واصل التدريب وحاول مرة أخرى", color = Navy, fontSize = 23.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Spacer(Modifier.height(12.dp))
            Text("\${score.value} من 5 إجابات صحيحة", color = if (passed) Green else FlagRed, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(if (passed) "تم تسجيل نجاحك في اختبار A0 على هذا الجهاز." else "تحتاج إلى 4 إجابات صحيحة على الأقل. يمكنك إعادة الاختبار.", color = Ink, fontSize = 14.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            Button(onClick = { onComplete(passed) }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Navy), shape = RoundedCornerShape(15.dp)) { Text("العودة إلى المسار") }
        }
    }
}

@Composable
private fun ResultScreen(xp: Int, completed: Int, onContinue: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🎉", fontSize = 64.sp)
        Spacer(Modifier.height(16.dp))
        Text("أحسنت! أكملت الدرس", color = Navy, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(10.dp))
        Text("حصلت على نقاط مقابل إجاباتك الصحيحة.", color = Ink, fontSize = 15.sp, textAlign = TextAlign.Center)
        Spacer(Modifier.height(18.dp))
        Text("⭐ $xp XP", color = FlagRed, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text("$completed دروس مكتملة", color = Color(0xFF64748B), fontSize = 14.sp)
        Spacer(Modifier.height(28.dp))
        Button(
            onClick = onContinue,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Navy),
            shape = RoundedCornerShape(15.dp)
        ) { Text("العودة إلى المسار") }
    }
}

@Composable
private fun LevelCard(
    level: String,
    title: String,
    subtitle: String,
    active: Boolean,
    onClick: (() -> Unit)?
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
            .clickable(enabled = active && onClick != null) { onClick?.invoke() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = if (active) PaleBlue else Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                level,
                modifier = Modifier.background(
                    if (active) FlagRed else Color(0xFFE6EAF0),
                    RoundedCornerShape(12.dp)
                ).padding(horizontal = 13.dp, vertical = 9.dp),
                color = if (active) Color.White else Navy,
                fontWeight = FontWeight.ExtraBold
            )
            Column(
                modifier = Modifier.weight(1f).padding(end = 14.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(title, color = Ink, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(subtitle, color = Color(0xFF64748B), fontSize = 12.sp)
            }
        }
    }
}
