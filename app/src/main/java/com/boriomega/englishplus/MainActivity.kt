package com.boriomega.englishplus

import android.os.Bundle
import android.media.AudioManager
import android.media.ToneGenerator
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
private val Success = Color(0xFF269B68)
private val Cream = Color(0xFFF7F9FC)
private val Ink = Color(0xFF34445B)

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null
    private var tones: ToneGenerator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tones = ToneGenerator(AudioManager.STREAM_MUSIC, 65)
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
        val prefs = getSharedPreferences("english_plus_progress", MODE_PRIVATE)
        val initial = prefs.getStringSet("completed_lessons", emptySet())!!
            .mapNotNull { it.toIntOrNull() }.toSet()
        setContent {
            EnglishPlusApp(
                onSpeak = { speak(it) },
                onAnswerFeedback = { correct -> tones?.startTone(if (correct) ToneGenerator.TONE_PROP_ACK else ToneGenerator.TONE_PROP_NACK, 150) },
                initialCompleted = initial,
                onCompletedChange = { completed ->
                    prefs.edit().putStringSet("completed_lessons", completed.map { it.toString() }.toSet()).apply()
                }
            )
        }
    }
    private fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "english_plus")
    }
    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        tones?.release()
        tones = null
        super.onDestroy()
    }
}

private data class Word(val english: String, val arabic: String)
private data class Lesson(val title: String, val subtitle: String, val icon: String, val words: List<Word>)

private val courseLessons = listOf(
    Lesson("التحية والوداع", "Hello & goodbye", "👋", listOf(Word("Hello", "مرحباً"), Word("Good morning", "صباح الخير"), Word("Good evening", "مساء الخير"), Word("Goodbye", "إلى اللقاء"))),
    Lesson("التعريف بالنفس", "Introducing yourself", "🙂", listOf(Word("Name", "اسم"), Word("I", "أنا"), Word("You", "أنت"), Word("Nice to meet you", "سعيد بلقائك"))),
    Lesson("البلدان واللغات", "Countries & languages", "📘", listOf(Word("Country", "بلد"), Word("Language", "لغة"), Word("English", "الإنجليزية"), Word("Arabic", "العربية"))),
    Lesson("عبارات مهذبة", "Polite expressions", "🙂", listOf(Word("Please", "من فضلك"), Word("Thank you", "شكراً"), Word("Sorry", "آسف"), Word("Excuse me", "عذراً"))),
    Lesson("معلومات شخصية", "Personal details", "📘", listOf(Word("Age", "عمر"), Word("Address", "عنوان"), Word("Phone", "هاتف"), Word("Email", "بريد إلكتروني"))),
    Lesson("أفراد العائلة", "Family members", "👩‍👧", listOf(Word("Mother", "أم"), Word("Father", "أب"), Word("Sister", "أخت"), Word("Brother", "أخ"))),
    Lesson("الأقارب", "Relatives", "🏠", listOf(Word("Grandmother", "جدة"), Word("Grandfather", "جد"), Word("Aunt", "عمة أو خالة"), Word("Uncle", "عم أو خال"))),
    Lesson("الأصدقاء", "Friends", "🙂", listOf(Word("Friend", "صديق"), Word("Best friend", "أفضل صديق"), Word("Neighbor", "جار"), Word("Guest", "ضيف"))),
    Lesson("الصفات الشخصية", "Personal qualities", "🙂", listOf(Word("Kind", "لطيف"), Word("Funny", "مرح"), Word("Quiet", "هادئ"), Word("Helpful", "متعاون"))),
    Lesson("العلاقات", "Relationships", "💚", listOf(Word("Family", "عائلة"), Word("Parent", "والد"), Word("Child", "طفل"), Word("People", "ناس"))),
    Lesson("غرف المنزل", "Rooms", "🏠", listOf(Word("Bedroom", "غرفة النوم"), Word("Kitchen", "مطبخ"), Word("Bathroom", "حمام"), Word("Living room", "غرفة الجلوس"))),
    Lesson("الأثاث", "Furniture", "🪑", listOf(Word("Chair", "كرسي"), Word("Table", "طاولة"), Word("Bed", "سرير"), Word("Sofa", "أريكة"))),
    Lesson("أجزاء المنزل", "Parts of a home", "🚪", listOf(Word("Door", "باب"), Word("Window", "نافذة"), Word("Wall", "جدار"), Word("Floor", "أرضية"))),
    Lesson("أدوات المنزل", "Household items", "📘", listOf(Word("Key", "مفتاح"), Word("Lamp", "مصباح"), Word("Mirror", "مرآة"), Word("Clock", "ساعة"))),
    Lesson("الأعمال المنزلية", "Housework", "🏠", listOf(Word("Clean", "ينظف"), Word("Cook", "يطبخ"), Word("Wash", "يغسل"), Word("Open", "يفتح"))),
    Lesson("الفواكه", "Fruit", "🍎", listOf(Word("Apple", "تفاحة"), Word("Banana", "موزة"), Word("Orange", "برتقالة"), Word("Grapes", "عنب"))),
    Lesson("الخضروات", "Vegetables", "🍎", listOf(Word("Carrot", "جزر"), Word("Potato", "بطاطس"), Word("Tomato", "طماطم"), Word("Onion", "بصل"))),
    Lesson("الوجبات", "Meals", "🍞", listOf(Word("Breakfast", "فطور"), Word("Lunch", "غداء"), Word("Dinner", "عشاء"), Word("Meal", "وجبة"))),
    Lesson("المشروبات", "Drinks", "💧", listOf(Word("Water", "ماء"), Word("Milk", "حليب"), Word("Juice", "عصير"), Word("Tea", "شاي"))),
    Lesson("أطعمة أساسية", "Basic foods", "🍚", listOf(Word("Bread", "خبز"), Word("Rice", "أرز"), Word("Egg", "بيضة"), Word("Cheese", "جبن"))),
    Lesson("أيام الأسبوع", "Days of the week", "🕒", listOf(Word("Monday", "الاثنين"), Word("Tuesday", "الثلاثاء"), Word("Friday", "الجمعة"), Word("Sunday", "الأحد"))),
    Lesson("أجزاء اليوم", "Parts of the day", "🌤️", listOf(Word("Morning", "الصباح"), Word("Afternoon", "بعد الظهر"), Word("Evening", "المساء"), Word("Night", "الليل"))),
    Lesson("الساعة", "Telling the time", "🕒", listOf(Word("Hour", "ساعة"), Word("Minute", "دقيقة"), Word("Today", "اليوم"), Word("Tomorrow", "غداً"))),
    Lesson("الروتين الصباحي", "Morning routine", "🌤️", listOf(Word("Wake up", "يستيقظ"), Word("Get dressed", "يرتدي ملابسه"), Word("Have breakfast", "يتناول الفطور"), Word("Go out", "يخرج"))),
    Lesson("الروتين المسائي", "Evening routine", "🕒", listOf(Word("Come home", "يعود إلى المنزل"), Word("Study", "يدرس"), Word("Read", "يقرأ"), Word("Sleep", "ينام"))),
    Lesson("أدوات الدراسة", "School supplies", "📘", listOf(Word("Book", "كتاب"), Word("Pen", "قلم"), Word("Pencil", "قلم رصاص"), Word("Bag", "حقيبة"))),
    Lesson("في الفصل", "In the classroom", "📘", listOf(Word("Teacher", "معلم"), Word("Student", "طالب"), Word("Desk", "مكتب"), Word("Board", "سبورة"))),
    Lesson("مواد دراسية", "School subjects", "📘", listOf(Word("Maths", "رياضيات"), Word("Science", "علوم"), Word("History", "تاريخ"), Word("English", "الإنجليزية"))),
    Lesson("أفعال التعلم", "Learning verbs", "📘", listOf(Word("Read", "يقرأ"), Word("Write", "يكتب"), Word("Listen", "يستمع"), Word("Speak", "يتحدث"))),
    Lesson("تعليمات الفصل", "Classroom instructions", "👋", listOf(Word("Open your book", "افتح كتابك"), Word("Listen", "استمع"), Word("Repeat", "كرر"), Word("Answer", "أجب"))),
    Lesson("أماكن في المدينة", "Places in town", "🏠", listOf(Word("School", "مدرسة"), Word("Park", "حديقة"), Word("Shop", "متجر"), Word("Hospital", "مستشفى"))),
    Lesson("وسائل النقل", "Transport", "🎒", listOf(Word("Bus", "حافلة"), Word("Car", "سيارة"), Word("Train", "قطار"), Word("Bicycle", "دراجة"))),
    Lesson("الاتجاهات", "Directions", "👋", listOf(Word("Left", "يسار"), Word("Right", "يمين"), Word("Straight", "مستقيم"), Word("Near", "قريب"))),
    Lesson("المواقع", "Locations", "🏠", listOf(Word("Here", "هنا"), Word("There", "هناك"), Word("Inside", "في الداخل"), Word("Outside", "في الخارج"))),
    Lesson("السؤال عن المكان", "Asking for places", "👋", listOf(Word("Where", "أين"), Word("Street", "شارع"), Word("Map", "خريطة"), Word("Address", "عنوان"))),
    Lesson("الملابس الأساسية", "Basic clothes", "🎒", listOf(Word("Shirt", "قميص"), Word("Trousers", "سروال"), Word("Dress", "فستان"), Word("Jacket", "سترة"))),
    Lesson("الأحذية والإكسسوارات", "Shoes & accessories", "🎒", listOf(Word("Shoes", "حذاء"), Word("Socks", "جوارب"), Word("Hat", "قبعة"), Word("Watch", "ساعة يد"))),
    Lesson("الألوان الأساسية", "Basic colors", "🎨", listOf(Word("Red", "أحمر"), Word("Blue", "أزرق"), Word("Green", "أخضر"), Word("Yellow", "أصفر"))),
    Lesson("الألوان والدرجات", "More colors", "🎨", listOf(Word("Black", "أسود"), Word("White", "أبيض"), Word("Brown", "بني"), Word("Pink", "وردي"))),
    Lesson("وصف الملابس", "Describing clothes", "🎒", listOf(Word("New", "جديد"), Word("Old", "قديم"), Word("Big", "كبير"), Word("Small", "صغير"))),
    Lesson("حالة الطقس", "Weather", "🌤️", listOf(Word("Sunny", "مشمس"), Word("Rainy", "ممطر"), Word("Cloudy", "غائم"), Word("Windy", "عاصف"))),
    Lesson("الفصول", "Seasons", "🌤️", listOf(Word("Spring", "الربيع"), Word("Summer", "الصيف"), Word("Autumn", "الخريف"), Word("Winter", "الشتاء"))),
    Lesson("الطبيعة", "Nature", "🏠", listOf(Word("Tree", "شجرة"), Word("Flower", "زهرة"), Word("River", "نهر"), Word("Mountain", "جبل"))),
    Lesson("الحيوانات", "Animals", "🙂", listOf(Word("Cat", "قطة"), Word("Dog", "كلب"), Word("Bird", "طائر"), Word("Horse", "حصان"))),
    Lesson("وصف الطقس", "Talking about weather", "🌤️", listOf(Word("Hot", "حار"), Word("Cold", "بارد"), Word("Warm", "دافئ"), Word("Cool", "مائل للبرودة"))),
    Lesson("أجزاء الجسم", "Body parts", "🙂", listOf(Word("Head", "رأس"), Word("Hand", "يد"), Word("Eye", "عين"), Word("Foot", "قدم"))),
    Lesson("الحواس", "The senses", "🙂", listOf(Word("See", "يرى"), Word("Hear", "يسمع"), Word("Smell", "يشم"), Word("Taste", "يتذوق"))),
    Lesson("الصحة اليومية", "Everyday health", "💧", listOf(Word("Healthy", "صحي"), Word("Tired", "متعب"), Word("Hungry", "جائع"), Word("Thirsty", "عطشان"))),
    Lesson("عند الطبيب", "At the doctor", "🏠", listOf(Word("Doctor", "طبيب"), Word("Nurse", "ممرض"), Word("Medicine", "دواء"), Word("Pain", "ألم"))),
    Lesson("عادات صحية", "Healthy habits", "💧", listOf(Word("Exercise", "تمرين"), Word("Walk", "يمشي"), Word("Rest", "يرتاح"), Word("Drink water", "يشرب الماء"))),
    Lesson("وقت الفراغ", "Free time", "🙂", listOf(Word("Hobby", "هواية"), Word("Game", "لعبة"), Word("Music", "موسيقى"), Word("Drawing", "رسم"))),
    Lesson("الرياضة", "Sports", "👋", listOf(Word("Football", "كرة القدم"), Word("Swimming", "سباحة"), Word("Running", "جري"), Word("Tennis", "تنس"))),
    Lesson("أنشطة يومية", "Activities", "📘", listOf(Word("Walk", "يمشي"), Word("Read", "يقرأ"), Word("Cook", "يطبخ"), Word("Travel", "يسافر"))),
    Lesson("التفضيلات", "Likes & dislikes", "🙂", listOf(Word("Like", "يحب"), Word("Love", "يعشق"), Word("Prefer", "يفضل"), Word("Enjoy", "يستمتع"))),
    Lesson("خطط بسيطة", "Simple plans", "🕒", listOf(Word("Today", "اليوم"), Word("This weekend", "نهاية هذا الأسبوع"), Word("Visit", "يزور"), Word("Meet", "يلتقي"))),
    Lesson("في المتجر", "At the shop", "🎒", listOf(Word("Shop", "متجر"), Word("Market", "سوق"), Word("Price", "سعر"), Word("Money", "مال"))),
    Lesson("الكميات والأرقام", "Numbers & quantities", "📘", listOf(Word("One", "واحد"), Word("Two", "اثنان"), Word("Many", "كثير"), Word("Few", "قليل"))),
    Lesson("الشراء والدفع", "Buying & paying", "🎒", listOf(Word("Buy", "يشتري"), Word("Pay", "يدفع"), Word("Cash", "نقداً"), Word("Card", "بطاقة"))),
    Lesson("وصف الأشياء", "Describing things", "🎨", listOf(Word("Cheap", "رخيص"), Word("Expensive", "غالي"), Word("Beautiful", "جميل"), Word("Useful", "مفيد"))),
    Lesson("مراجعة ومحادثة", "Review & conversation", "👋", listOf(Word("Can I help you?", "هل يمكنني مساعدتك؟"), Word("How much?", "بكم؟"), Word("I would like", "أودّ"), Word("Thank you", "شكراً")))
)

@Composable
fun EnglishPlusApp(
    onSpeak: (String) -> Unit,
    onAnswerFeedback: (Boolean) -> Unit,
    initialCompleted: Set<Int>,
    onCompletedChange: (Set<Int>) -> Unit
) {
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var completed by remember { mutableStateOf(initialCompleted) }
    MaterialTheme(colorScheme = lightColorScheme(primary = Navy, secondary = Green, background = Cream)) {
        Surface(Modifier.fillMaxSize(), color = Cream) {
            if (selectedIndex == null) {
                Column(Modifier.fillMaxSize()) {
                    Row(
                        Modifier.fillMaxWidth().background(Navy).padding(horizontal = 22.dp, vertical = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text("ENGLISH PLUS", color = Color.White, fontWeight = FontWeight.Black, fontSize = 20.sp, letterSpacing = 1.sp)
                            Text("خطوتك اليومية نحو الإنجليزية", color = Color.White.copy(alpha = .9f), fontSize = 13.sp)
                        }
                        Text("${completed.size * 10} XP", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Column(Modifier.padding(20.dp)) {
                        Text("مرحباً بك! 👋", color = Ink, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                        Text("تعلّم قليلاً كل يوم، وتقدّم بثبات.", color = Ink.copy(alpha = .7f), fontSize = 14.sp)
                        Spacer(Modifier.height(16.dp))
                        Row(
                            Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(18.dp)).padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(Modifier.weight(1f)) {
                                Text("المستوى A1", color = Navy, fontWeight = FontWeight.Bold)
                                Text("المبتدئ • أساسيات الإنجليزية", color = Ink.copy(alpha = .7f), fontSize = 12.sp)
                            }
                            Text("${completed.size}/${courseLessons.size}", color = Green, fontWeight = FontWeight.Bold)
                        }
                    }
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(courseLessons.size) { index ->
                            val lesson = courseLessons[index]
                            val unlocked = index == 0 || (index - 1) in completed
                            Row(
                                Modifier.fillMaxWidth()
                                    .background(Color.White, RoundedCornerShape(20.dp))
                                    .clickable(enabled = unlocked) { selectedIndex = index }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    Modifier.size(54.dp).background(if (unlocked) Color(0xFFF0F5FA) else Color(0xFFE9EDF4), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) { Text(if (unlocked) lesson.icon else "🔒", fontSize = 25.sp) }
                                Spacer(Modifier.width(14.dp))
                                Column(Modifier.weight(1f)) {
                                    Text(lesson.title, color = Ink, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                    Text(lesson.subtitle, color = Ink.copy(alpha = .6f), fontSize = 12.sp)
                                    Text(
                                        when { index in completed -> "✓ مكتمل"; unlocked -> "3 كلمات • اختبار قصير"; else -> "أكمل الدرس السابق لفتح هذا الدرس" },
                                        color = if (index in completed) Success else Ink.copy(alpha = .55f),
                                        fontSize = 11.sp
                                    )
                                }
                                if (!unlocked) Icon(Icons.Default.Lock, contentDescription = "مقفل", tint = Color.Gray)
                                else Text(if (index in completed) "✓" else "ابدأ", color = if (index in completed) Success else Green, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            } else {
                val index = selectedIndex!!
                LessonScreen(
                    lesson = courseLessons[index],
                    onSpeak = onSpeak,
                    onAnswerFeedback = onAnswerFeedback,
                    onBack = { selectedIndex = null },
                    onPass = {
                        completed = completed + index
                        onCompletedChange(completed)
                        selectedIndex = null
                    }
                )
            }
        }
    }
}

@Composable
private fun LessonScreen(
    lesson: Lesson,
    onSpeak: (String) -> Unit,
    onAnswerFeedback: (Boolean) -> Unit,
    onBack: () -> Unit,
    onPass: () -> Unit
) {
    var questionIndex by remember(lesson) { mutableIntStateOf(0) }
    var correctAnswers by remember(lesson) { mutableIntStateOf(0) }
    var selectedAnswer by remember(lesson) { mutableStateOf<String?>(null) }
    var finished by remember(lesson) { mutableStateOf(false) }
    var passed by remember(lesson) { mutableStateOf(false) }
    val word = lesson.words[questionIndex]
    val options = remember(lesson, questionIndex) {
        val distractors = listOf("كتاب", "قلم", "كرسي", "سيارة", "مدرسة", "نافذة", "ماء", "طعام")
            .filter { it !in lesson.words.map(Word::arabic) && it != word.arabic }
            .shuffled().take(3)
        (distractors + word.arabic).shuffled()
    }
    val isCorrect = selectedAnswer == word.arabic

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("‹  رجوع", color = Navy, fontWeight = FontWeight.Bold, modifier = Modifier.clickable { onBack() }.padding(8.dp))
        Spacer(Modifier.height(12.dp))
        LinearProgressIndicator(
            progress = { (questionIndex + if (selectedAnswer != null) 1 else 0).toFloat() / lesson.words.size },
            modifier = Modifier.fillMaxWidth().height(8.dp),
            color = Green,
            trackColor = Color(0xFFE7EDF3)
        )
        Spacer(Modifier.height(22.dp))
        Text(lesson.icon, fontSize = 54.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(lesson.title, color = Ink, fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(Modifier.height(10.dp))
        if (!finished) {
            Text("السؤال ${questionIndex + 1} من ${lesson.words.size}", color = Ink.copy(alpha = .6f), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(Modifier.height(20.dp))
            Text("ما معنى هذه الكلمة؟", color = Ink, fontSize = 19.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(Modifier.height(12.dp))
            Row(
                Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(18.dp)).padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(word.english, color = Navy, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                IconButton(onClick = { onSpeak(word.english) }) {
                    Icon(Icons.Default.VolumeUp, contentDescription = "استمع إلى النطق", tint = Green)
                }
            }
            Spacer(Modifier.height(18.dp))
            options.forEach { option ->
                val chosen = selectedAnswer == option
                val correctOption = selectedAnswer != null && option == word.arabic
                val bg = when {
                    chosen && isCorrect -> Color(0xFFEAF7F0)
                    chosen && !isCorrect -> Color(0xFFF5F1ED)
                    correctOption -> Color(0xFFEAF7F0)
                    else -> Color.White
                }
                val fg = when {
                    correctOption -> Success
                    chosen && !isCorrect -> Color(0xFF806B5B)
                    else -> Ink
                }
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 5.dp)
                        .background(bg, RoundedCornerShape(14.dp))
                        .clickable(enabled = selectedAnswer == null) { selectedAnswer = option; onAnswerFeedback(option == word.arabic) }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(option, color = fg, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    if (correctOption) Text("✓", color = Success, fontSize = 22.sp, fontWeight = FontWeight.Black)
                }
            }
            if (selectedAnswer != null) {
                Spacer(Modifier.height(10.dp))
                Text(
                    if (isCorrect) "✓ أحسنت! إجابة صحيحة" else "الإجابة الصحيحة: ${word.arabic}",
                    color = if (isCorrect) Success else Color(0xFF806B5B),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = {
                        if (isCorrect) correctAnswers++
                        if (questionIndex == lesson.words.lastIndex) {
                            passed = correctAnswers >= 2
                            finished = true
                        } else {
                            questionIndex++
                            selectedAnswer = null
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Green)
                ) { Text(if (questionIndex == lesson.words.lastIndex) "عرض النتيجة" else "السؤال التالي", color = Ink, fontWeight = FontWeight.Bold) }
            }
        } else {
            Spacer(Modifier.height(28.dp))
            Text(if (passed) "✓" else "↻", color = if (passed) Success else Navy, fontSize = 64.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Black)
            Text(
                if (passed) "أحسنت! اجتزت الدرس" else "تحتاج إلى مراجعة بسيطة",
                color = Ink, fontSize = 22.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
            )
            Text(
                "$correctAnswers من ${lesson.words.size} إجابات صحيحة — تحتاج إلى إجابتين صحيحتين على الأقل.",
                color = Ink.copy(alpha = .7f), modifier = Modifier.fillMaxWidth().padding(top = 10.dp), textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(24.dp))
            if (passed) {
                Button(onClick = onPass, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Green)) {
                    Text("إكمال الدرس وفتح التالي", color = Ink, fontWeight = FontWeight.Bold)
                }
            } else {
                Button(
                    onClick = {
                        questionIndex = 0
                        correctAnswers = 0
                        selectedAnswer = null
                        finished = false
                        passed = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Navy)
                ) { Text("إعادة الاختبار", color = Color.White, fontWeight = FontWeight.Bold) }
            }
        }
    }
}
