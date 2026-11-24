package com.englishplus.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF123B70)
private val FlagRed = Color(0xFFE63946)
private val PaleBlue = Color(0xFFEAF2FC)
private val Ink = Color(0xFF172B4D)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF7F9FC)
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
private fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🔥 0", color = FlagRed, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Column(horizontalAlignment = Alignment.End) {
                Text("English Plus", color = Navy, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                Text("رحلتك لتعلّم الإنجليزية تبدأ هنا", color = Ink, fontSize = 13.sp)
            }
        }

        Spacer(Modifier.height(28.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Navy)
        ) {
            Column(
                modifier = Modifier.padding(22.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text("مرحباً بك! 👋", color = Color.White, fontSize = 23.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Text(
                    "تعلّم الإنجليزية خطوة بخطوة
ابدأ من المستوى المناسب لك.",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 15.sp,
                    textAlign = TextAlign.End,
                    lineHeight = 24.sp
                )
                Spacer(Modifier.height(18.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = FlagRed),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("ابدأ التعلّم", fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        Text("مسار التعلّم", color = Ink, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))

        LevelCard("A0", "البداية من الصفر", "الحروف والكلمات الأولى", true)
        LevelCard("A1", "المبتدئ", "عبارات يومية بسيطة", false)
        LevelCard("A2", "ما قبل المتوسط", "محادثات ومفردات أكثر", false)

        Spacer(Modifier.height(16.dp))
        Text(
            "الدروس الأساسية ستعمل دون إنترنت",
            color = Navy,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun LevelCard(level: String, title: String, subtitle: String, active: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (active) PaleBlue else Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(if (active) FlagRed else Color(0xFFE6EAF0), RoundedCornerShape(12.dp))
                    .padding(horizontal = 13.dp, vertical = 9.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(level, color = if (active) Color.White else Navy, fontWeight = FontWeight.ExtraBold)
            }
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
