package com.englishplus.app

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import java.util.Calendar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF142B55)
private val Red = Color(0xFFE34250)
private val Blue = Color(0xFF3977D5)
private val PaleBlue = Color(0xFFEAF1FC)
private val Ink = Color(0xFF18243A)
private val Green = Color(0xFF269B68)

private fun recordLearningDay(prefs: android.content.SharedPreferences): Int {
    val calendar = Calendar.getInstance()
    val today = calendar.get(Calendar.YEAR) * 1000 + calendar.get(Calendar.DAY_OF_YEAR)
    val lastDay = prefs.getInt("last_learning_day", 0)
    var streak = prefs.getInt("streak", 0)
    val yesterdayCalendar = calendar.clone() as Calendar
    yesterdayCalendar.add(Calendar.DAY_OF_YEAR, -1)
    val yesterday = yesterdayCalendar.get(Calendar.YEAR) * 1000 + yesterdayCalendar.get(Calendar.DAY_OF_YEAR)
    if (lastDay != today) streak = if (lastDay == yesterday) streak + 1 else 1
    prefs.edit().putInt("last_learning_day", today).putInt("streak", streak).apply()
    return streak
}

data class Question(val prompt: String, val answer: String, val choices: List<String>, val hint: String)
data class Lesson(val id: Int, val title: String, val subtitle: String, val questions: List<Question>)

private val lessons = listOf(
    Lesson(1, "التحيات", "Greetings", listOf(
        Question("كيف نقول «مرحباً» بالإنجليزية؟", "Hello", listOf("Hello", "Goodbye", "Please"), "تُستخدم عند لقاء شخص."),
        Question("ما معنى Good morning؟", "صباح الخير", listOf("مساء الخير", "صباح الخير", "تصبح على خير"), "تُقال في بداية اليوم."),
        Question("اختر معنى Goodbye", "إلى اللقاء", listOf("شكراً", "من فضلك", "إلى اللقاء"), "تُقال عند المغادرة.")
    )),
    Lesson(2, "التعريف بالنفس", "Introducing yourself", listOf(
        Question("ما معنى My name is Ali؟", "اسمي علي", listOf("أنا من علي", "اسمي علي", "أين علي؟"), "تخبر بها شخصاً باسمك."),
        Question("كيف نقول «أنا من المغرب»؟", "I am from Morocco", listOf("I am fine", "I am from Morocco", "My friend"), "تبدأ بعبارة I am from."),
        Question("ما معنى Nice to meet you؟", "سعيد بلقائك", listOf("أراك غداً", "سعيد بلقائك", "كيف حالك؟"), "تُقال عند التعارف.")
    )),
    Lesson(3, "العائلة", "Family", listOf(
        Question("ما معنى Father؟", "أب", listOf("أم", "أخ", "أب"), "هو الوالد."),
        Question("كيف نقول «أم»؟", "Mother", listOf("Mother", "Sister", "Father"), "تبدأ بحرف M."),
        Question("ما معنى Brother؟", "أخ", listOf("أخت", "أخ", "ابن"), "هو الأخ الذكر.")
    )),
    Lesson(4, "الأرقام", "Numbers", listOf(
        Question("ما معنى One؟", "واحد", listOf("ثلاثة", "اثنان", "واحد"), "أول رقم."),
        Question("كيف نقول «اثنان»؟", "Two", listOf("Two", "Ten", "Three"), "تبدأ بحرف T."),
        Question("ما معنى Three؟", "ثلاثة", listOf("واحد", "ثلاثة", "أربعة"), "تبدأ بحرف T أيضاً.")
    )),
    Lesson(5, "الأشياء اليومية", "Everyday objects", listOf(
        Question("ما معنى Book؟", "كتاب", listOf("باب", "ماء", "كتاب"), "نقرأه."),
        Question("كيف نقول «ماء»؟", "Water", listOf("Water", "Window", "Wall"), "نشربه."),
        Question("ما معنى Door؟", "باب", listOf("كرسي", "باب", "طاولة"), "ندخل ونخرج منه.")
    ))
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { EnglishPlusApp(this) }
    }
}

@Composable
private fun EnglishPlusApp(context: Context) {
    val prefs = remember { context.getSharedPreferences("english_plus", Context.MODE_PRIVATE) }
    var completed by remember { mutableIntStateOf(prefs.getInt("completed", 0)) }
    var xp by remember { mutableIntStateOf(prefs.getInt("xp", 0)) }
    var streak by remember { mutableIntStateOf(prefs.getInt("streak", 0)) }
    var selected by remember { mutableStateOf<Lesson?>(null) }
    MaterialTheme(colorScheme = lightColorScheme(primary = Navy, secondary = Red, background = Color(0xFFF7F8FC))) {
        Surface(Modifier.fillMaxSize(), color = Color(0xFFF7F8FC)) {
            val lesson = selected
            if (lesson == null) LearningPath(completed, xp, streak) { selected = it }
            else QuizScreen(lesson, completed >= lesson.id, onExit = { selected = null }) {
                if (completed < lesson.id) {
                    completed = lesson.id
                    prefs.edit().putInt("completed", completed).apply()
                }
                if (completed < lesson.id) {
                    xp += 30
                    prefs.edit().putInt("xp", xp).apply()
                }
                streak = recordLearningDay(prefs)
                selected = null
            }
        }
    }
}

@Composable
private fun LearningPath(completed: Int, xp: Int, streak: Int, onOpen: (Lesson) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text("مرحباً بك في", color = Ink.copy(alpha = .65f), fontSize = 14.sp)
                    Text("English Plus", color = Navy, fontSize = 29.sp, fontWeight = FontWeight.ExtraBold)
                }
                Image(painter = painterResource(R.drawable.mascot), contentDescription = "رفيق التعلّم", modifier = Modifier.size(52.dp))
                Spacer(Modifier.width(6.dp))
                StatPill("🔥", streak.toString())
                Spacer(Modifier.width(8.dp))
                StatPill("💎", xp.toString())
            }
        }
        item {
            Card(shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Navy)) {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("الوحدة الأولى", color = Color(0xFFFFD166), fontWeight = FontWeight.Bold)
                    Text("أساسيات اللغة الإنجليزية", color = Color.White, fontSize = 21.sp, fontWeight = FontWeight.ExtraBold)
                    Text("تعلّم كلمات وعبارات تستخدمها كل يوم.", color = Color.White.copy(alpha = .85f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("$completed / ${lessons.size} دروس", color = Color.White, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.weight(1f))
                        Text("$xp XP", color = Color(0xFFFFD166), fontWeight = FontWeight.ExtraBold)
                    }
                    LinearProgressIndicator(
                        progress = { completed.toFloat() / lessons.size },
                        modifier = Modifier.fillMaxWidth().height(9.dp),
                        color = Color(0xFFFFD166),
                        trackColor = Color.White.copy(alpha = .2f)
                    )
                }
            }
        }
        item {
            Text("مسار التعلّم", color = Ink, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
            Text("أكمل الدروس بالترتيب لفتح الدرس التالي.", color = Color(0xFF748096), fontSize = 13.sp)
        }
        items(lessons.size) { index ->
            val lesson = lessons[index]
            val unlocked = lesson.id <= completed + 1
            PathLessonNode(lesson, completed >= lesson.id, unlocked, onClick = { if (unlocked) onOpen(lesson) })
        }
        item {
            Surface(color = PaleBlue, shape = RoundedCornerShape(16.dp)) {
                Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.WifiOff, contentDescription = null, tint = Navy)
                    Spacer(Modifier.width(10.dp))
                    Text("يمكنك تعلّم هذه الدروس دون اتصال بالإنترنت.", color = Navy, fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
private fun StatPill(symbol: String, value: String) {
    Surface(color = Color.White, shape = RoundedCornerShape(20.dp)) {
        Text("$symbol $value", modifier = Modifier.padding(horizontal = 11.dp, vertical = 8.dp), color = Ink, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun PathLessonNode(lesson: Lesson, done: Boolean, unlocked: Boolean, onClick: () -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(62.dp)) {
            Surface(
                modifier = Modifier.size(54.dp).clickable(enabled = unlocked, onClick = onClick),
                shape = CircleShape,
                color = when { done -> Green; unlocked -> Blue; else -> Color(0xFFD5DCE8) },
                shadowElevation = if (unlocked) 5.dp else 0.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = when { done -> Icons.Default.Check; unlocked -> Icons.Default.PlayArrow; else -> Icons.Default.Lock },
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
        Spacer(Modifier.width(12.dp))
        Card(
            modifier = Modifier.weight(1f).clickable(enabled = unlocked, onClick = onClick),
            shape = RoundedCornerShape(17.dp),
            colors = CardDefaults.cardColors(containerColor = if (unlocked) Color.White else Color(0xFFF0F2F6))
        ) {
            Row(Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(lesson.title, color = if (unlocked) Ink else Color.Gray, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Text(lesson.subtitle, color = Color(0xFF748096), fontSize = 12.sp)
                }
                Text(if (done) "مكتمل" else if (unlocked) "+30 XP" else "مغلق", color = if (done) Green else Red, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun QuizScreen(lesson: Lesson, alreadyDone: Boolean, onExit: () -> Unit, onFinish: () -> Unit) {
    var questionIndex by remember(lesson.id) { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var correctCount by remember { mutableIntStateOf(0) }
    var finished by remember { mutableStateOf(false) }
    val question = lesson.questions[questionIndex]
    val answered = selectedAnswer != null
    val isCorrect = selectedAnswer == question.answer

    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onExit) { Icon(Icons.Default.Close, contentDescription = "إغلاق") }
            LinearProgressIndicator(
                progress = { (questionIndex + if (answered) 1 else 0).toFloat() / lesson.questions.size },
                modifier = Modifier.weight(1f).height(10.dp),
                color = Green,
                trackColor = Color(0xFFE2E7EF)
            )
            Spacer(Modifier.width(12.dp))
            Text("♥ 5", color = Red, fontWeight = FontWeight.Bold)
        }
        if (finished) {
            Spacer(Modifier.height(50.dp))
            Icon(Icons.Default.EmojiEvents, contentDescription = null, tint = Color(0xFFFFB52E), modifier = Modifier.size(76.dp).align(Alignment.CenterHorizontally))
            Text("أحسنت! 🎉", color = Navy, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text("أنهيت درس ${lesson.title}", color = Ink, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text("إجابات صحيحة: $correctCount من ${lesson.questions.size}", color = Green, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(Modifier.weight(1f))
            Button(onClick = onFinish, modifier = Modifier.fillMaxWidth().height(54.dp), colors = ButtonDefaults.buttonColors(containerColor = Red)) {
                Text(if (alreadyDone) "العودة إلى المسار" else "احصل على 30 XP")
            }
        } else {
            Text("اختر الإجابة الصحيحة", color = Ink, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
            Text("السؤال ${questionIndex + 1} من ${lesson.questions.size}", color = Color(0xFF748096))
            Spacer(Modifier.height(8.dp))
            Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = PaleBlue)) {
                Column(Modifier.fillMaxWidth().padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("ترجم واختر", color = Blue, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Text(question.prompt, color = Navy, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                }
            }
            question.choices.forEach { choice ->
                val chosen = selectedAnswer == choice
                val optionColor = when {
                    !answered -> Color.White
                    chosen && isCorrect -> Color(0xFFE5F5EC)
                    chosen -> Color(0xFFFFE9E9)
                    choice == question.answer -> Color(0xFFE5F5EC)
                    else -> Color.White
                }
                OutlinedButton(
                    onClick = { if (!answered) { selectedAnswer = choice; if (choice == question.answer) correctCount++ } },
                    modifier = Modifier.fillMaxWidth().heightIn(min = 58.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = optionColor, contentColor = Ink),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (chosen) Blue else Color(0xFFDCE2EC))
                ) {
                    Text(choice, modifier = Modifier.fillMaxWidth(), fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(Modifier.weight(1f))
            if (answered) {
                Surface(color = if (isCorrect) Color(0xFFE5F5EC) else Color(0xFFFFE9E9), shape = RoundedCornerShape(14.dp)) {
                    Column(Modifier.fillMaxWidth().padding(13.dp)) {
                        Text(if (isCorrect) "إجابة صحيحة! ممتاز 👏" else "ليست صحيحة، لا بأس!", color = if (isCorrect) Green else Red, fontWeight = FontWeight.Bold)
                        Text(question.hint, color = Ink, fontSize = 13.sp)
                    }
                }
            }
            Button(
                onClick = {
                    if (questionIndex == lesson.questions.lastIndex) finished = true
                    else { questionIndex++; selectedAnswer = null }
                },
                enabled = answered,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Red)
            ) { Text(if (questionIndex == lesson.questions.lastIndex) "إنهاء الدرس" else "متابعة", fontWeight = FontWeight.Bold) }
        }
    }
}
