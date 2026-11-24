package com.boriomega.englishplus

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

private val Navy = Color(0xFF7895B8)
private val Green = Color(0xFF83C7A8)
private val Cream = Color(0xFFF7F9FC)
private val Ink = Color(0xFF34445B)

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.US
                tts?.setSpeechRate(0.9f)
                val narrativeVoice = tts?.voices?.firstOrNull {
                    it.name.contains("narrative", ignoreCase = true) && it.locale.language == "en"
                }
                if (narrativeVoice != null) tts?.voice = narrativeVoice
            }
        }
        setContent { EnglishPlusApp(onSpeak = { speak(it) }) }
    }
    private fun speak(text: String) { tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "english_plus") }
    override fun onDestroy() { tts?.stop(); tts?.shutdown(); super.onDestroy() }
}

private data class Lesson(val title: String, val subtitle: String, val icon: String, val words: List<Pair<String,String>>, val locked: Boolean = false)

@Composable
fun EnglishPlusApp(onSpeak: (String) -> Unit) {
    var selected by remember { mutableStateOf<Lesson?>(null) }
    var completed by remember { mutableStateOf(setOf<Int>()) }
    val lessons = listOf(
        Lesson("التحيات والتعارف", "Greetings & introductions", "👋", listOf("Hello" to "مرحباً", "Good morning" to "صباح الخير", "My name is…" to "اسمي…")),
        Lesson("العائلة", "Family", "👨‍👩‍👧", listOf("Father" to "أب", "Mother" to "أم", "Brother" to "أخ")),
        Lesson("المنزل", "At home", "🏡", listOf("House" to "منزل", "Door" to "باب", "Window" to "نافذة"), true),
        Lesson("الطعام الصحي", "Healthy food", "🍎", listOf("Apple" to "تفاحة", "Bread" to "خبز", "Water" to "ماء"), true),
        Lesson("الألوان", "Colors", "🎨", listOf("Red" to "أحمر", "Blue" to "أزرق", "Green" to "أخضر"), true)
    )
    MaterialTheme(colorScheme = lightColorScheme(primary = Navy, secondary = Green, background = Cream)) {
        Surface(Modifier.fillMaxSize(), color = Cream) {
            if (selected == null) {
                Column(Modifier.fillMaxSize()) {
                    Row(Modifier.fillMaxWidth().background(Navy).padding(horizontal = 22.dp, vertical = 20.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text("ENGLISH PLUS", color = Color.White, fontWeight = FontWeight.Black, fontSize = 20.sp, letterSpacing = 1.sp)
                            Text("خطوتك اليومية نحو الإنجليزية", color = Color.White.copy(alpha=.85f), fontSize = 13.sp)
                        }
                        Text("${completed.size * 10} XP", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Column(Modifier.padding(20.dp)) {
                        Text("مرحباً بك! 👋", color = Ink, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                        Text("تعلّم قليلاً كل يوم، وتقدّم بثبات.", color = Ink.copy(alpha=.7f), fontSize = 14.sp)
                        Spacer(Modifier.height(16.dp))
                        Row(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(18.dp)).padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Column(Modifier.weight(1f)) {
                                Text("المستوى الأول", color = Navy, fontWeight = FontWeight.Bold)
                                Text("المبتدئ A1 • أساسيات الإنجليزية", color = Ink.copy(alpha=.7f), fontSize = 12.sp)
                            }
                            Text("${completed.size}/${lessons.size}", color = Green, fontWeight = FontWeight.Bold)
                        }
                    }
                    LazyColumn(contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(lessons.size) { index ->
                            val lesson = lessons[index]
                            val locked = index > 0 && index - 1 !in completed
                            Row(
                                Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(20.dp))
                                    .clickable(enabled = !locked) { selected = lesson }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(Modifier.size(54.dp).background(if (locked) Color(0xFFE9EDF4) else Color(0xFFEAF1FB), CircleShape), contentAlignment = Alignment.Center) {
                                    Text(if (locked) "🔒" else lesson.icon, fontSize = 25.sp)
                                }
                                Spacer(Modifier.width(14.dp))
                                Column(Modifier.weight(1f)) {
                                    Text(lesson.title, color = Ink, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                    Text(lesson.subtitle, color = Ink.copy(alpha=.6f), fontSize = 12.sp)
                                }
                                if (locked) Icon(Icons.Default.Lock, contentDescription = "مقفل", tint = Color.Gray)
                                else Text(if (index in completed) "✓" else "ابدأ", color = if(index in completed) Color(0xFF168653) else Green, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                }
            } else {
                LessonScreen(lesson = selected!!, onSpeak = onSpeak, onBack = { selected = null }, onComplete = {
                    val index = lessons.indexOf(selected)
                    if (index >= 0) completed = completed + index
                    selected = null
                })
            }
        }
    }
}

@Composable
private fun LessonScreen(lesson: Lesson, onSpeak: (String) -> Unit, onBack: () -> Unit, onComplete: () -> Unit) {
    var revealed by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("‹  رجوع", color = Navy, fontWeight = FontWeight.Bold, modifier = Modifier.clickable { onBack() }.padding(8.dp))
        Spacer(Modifier.height(16.dp))
        Text(lesson.icon, fontSize = 58.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(lesson.title, color = Ink, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text("استمع إلى الكلمات وكرر نطقها", color = Ink.copy(alpha=.65f), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(Modifier.height(24.dp))
        lesson.words.forEach { (english, arabic) ->
            Row(Modifier.fillMaxWidth().padding(vertical = 6.dp).background(Color.White, RoundedCornerShape(16.dp)).padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(english, color = Navy, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                    Text(arabic, color = Ink.copy(alpha=.7f))
                }
                IconButton(onClick = { onSpeak(english) }) { Icon(Icons.Default.VolumeUp, contentDescription = "استمع", tint = Green) }
            }
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = { revealed = !revealed }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Navy)) {
            Text(if (revealed) "إخفاء المراجعة" else "اختبر نفسك")
        }
        if (revealed) Text("أحسنت! اقرأ الكلمات الإنجليزية بصوت واضح، ثم اضغط إكمال الدرس.", color = Ink, modifier = Modifier.padding(12.dp))
        Spacer(Modifier.weight(1f))
        Button(onClick = onComplete, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Green)) { Text("إكمال الدرس وفتح التالي") }
    }
}
