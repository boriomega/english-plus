package com.englishplus.app

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF142B55)
private val Red = Color(0xFFE34250)
private val PaleBlue = Color(0xFFEAF1FC)
private val Ink = Color(0xFF18243A)

data class Lesson(val id: Int, val title: String, val subtitle: String, val words: List<Pair<String, String>>)

private val lessons = listOf(
    Lesson(1, "التحيات", "Greetings", listOf("Hello" to "مرحباً", "Good morning" to "صباح الخير", "Goodbye" to "إلى اللقاء")),
    Lesson(2, "التعريف بالنفس", "Introducing yourself", listOf("My name is..." to "اسمي...", "I am from..." to "أنا من...", "Nice to meet you" to "سعيد بلقائك")),
    Lesson(3, "العائلة", "Family", listOf("Father" to "أب", "Mother" to "أم", "Brother" to "أخ")),
    Lesson(4, "الأرقام", "Numbers", listOf("One" to "واحد", "Two" to "اثنان", "Three" to "ثلاثة")),
    Lesson(5, "الأشياء اليومية", "Everyday objects", listOf("Book" to "كتاب", "Door" to "باب", "Water" to "ماء"))
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
    var selectedLesson by remember { mutableStateOf<Lesson?>(null) }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        MaterialTheme(colorScheme = lightColorScheme(primary = Navy, secondary = Red, background = Color(0xFFF7F8FC))) {
            Surface(Modifier.fillMaxSize(), color = Color(0xFFF7F8FC)) {
                val activeLesson = selectedLesson
                if (activeLesson == null) HomeScreen(completed) { selectedLesson = it }
                else LessonScreen(activeLesson, completed >= activeLesson.id, { selectedLesson = null }) {
                    if (completed < activeLesson.id) {
                        completed = activeLesson.id
                        prefs.edit().putInt("completed", completed).apply()
                    }
                    selectedLesson = null
                }
            }
        }
    }
}

@Composable
private fun HomeScreen(completed: Int, onOpen: (Lesson) -> Unit) {
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.weight(1f)) {
                    Text("أهلاً بك في", color = Ink.copy(alpha = .65f), fontSize = 15.sp)
                    Text("English Plus", color = Navy, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                }
                Surface(color = PaleBlue, shape = RoundedCornerShape(16.dp)) {
                    Icon(Icons.Default.MenuBook, contentDescription = null, tint = Navy, modifier = Modifier.padding(14.dp).size(28.dp))
                }
            }
        }
        item {
            Card(colors = CardDefaults.cardColors(containerColor = Navy), shape = RoundedCornerShape(24.dp)) {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("خطوة صغيرة كل يوم تصنع فرقاً كبيراً", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                    Text("ابدأ من الأساسيات وتعلّم الإنجليزية بسهولة.", color = Color.White.copy(alpha = .85f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD166))
                        Text("  تقدمك: $completed من ${lessons.size} دروس", color = Color.White, fontWeight = FontWeight.SemiBold)
                    }
                    LinearProgressIndicator(progress = { completed.toFloat() / lessons.size }, modifier = Modifier.fillMaxWidth().height(8.dp), color = Color(0xFFFFD166), trackColor = Color.White.copy(alpha = .2f))
                }
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("مسار التعلّم", color = Ink, fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("المستوى الأول", color = Red, fontWeight = FontWeight.Bold)
            }
        }
        items(lessons) { lesson -> LessonCard(lesson, completed >= lesson.id) { onOpen(lesson) } }
        item { Text("الدروس الأساسية متاحة دون إنترنت على جهازك.", color = Color(0xFF68758A), fontSize = 13.sp, modifier = Modifier.padding(top = 4.dp)) }
    }
}

@Composable
private fun LessonCard(lesson: Lesson, done: Boolean, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(color = if (done) Color(0xFFE5F5EC) else PaleBlue, shape = RoundedCornerShape(14.dp)) {
                if (done) Icon(Icons.Default.CheckCircle, contentDescription = "مكتمل", tint = Color(0xFF248653), modifier = Modifier.padding(13.dp))
                else Text("%02d".format(lesson.id), color = Navy, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 15.dp, vertical = 13.dp))
            }
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(lesson.title, color = Ink, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Text(lesson.subtitle, color = Color(0xFF748096), fontSize = 13.sp)
            }
            Text(if (done) "مكتمل" else "ابدأ", color = if (done) Color(0xFF248653) else Red, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun LessonScreen(lesson: Lesson, isCompleted: Boolean, onBack: () -> Unit, onComplete: () -> Unit) {
    var reviewed by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, contentDescription = "رجوع") }
            Text("الدرس ${lesson.id}", color = Navy, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Text(lesson.title, color = Ink, fontSize = 27.sp, fontWeight = FontWeight.ExtraBold)
        Text("تعلّم الكلمات التالية، وحاول نطقها بصوت واضح.", color = Color(0xFF68758A))
        lesson.words.forEach { (english, arabic) ->
            Card(shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Row(Modifier.fillMaxWidth().padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(english, color = Navy, fontWeight = FontWeight.Bold, fontSize = 19.sp, modifier = Modifier.weight(1f))
                    Text(arabic, color = Ink, fontSize = 16.sp)
                }
            }
        }
        Spacer(Modifier.weight(1f))
        if (!reviewed && !isCompleted) OutlinedButton(onClick = { reviewed = true }, modifier = Modifier.fillMaxWidth()) { Text("أنهيت مراجعة الكلمات") }
        Button(onClick = onComplete, enabled = isCompleted || reviewed, modifier = Modifier.fillMaxWidth().height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Red)) {
            Icon(Icons.Default.EmojiEvents, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(if (isCompleted) "تم إكمال هذا الدرس" else "إكمال الدرس", fontWeight = FontWeight.Bold)
        }
    }
}
