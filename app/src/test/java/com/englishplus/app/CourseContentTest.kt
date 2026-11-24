package com.englishplus.app

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CourseContentTest {
    @Test
    fun courseHasTwelveUnitsAndSixtyLessons() {
        assertEquals(12, CourseContent.units.size)
        assertEquals(60, CourseContent.units.sumOf { it.lessons.size })
        assertEquals((1..12).toList(), CourseContent.units.map { it.number })
        assertEquals((1..60).toList(), CourseContent.units.flatMap { it.lessons }.map { it.number })
    }

    @Test
    fun everyLessonHasFiveUsableExercises() {
        CourseContent.units.flatMap { it.lessons }.forEach { lesson ->
            assertEquals("Lesson ${lesson.number} must contain five exercises", 5, lesson.exercises.size)
            lesson.exercises.forEach { exercise ->
                assertFalse(exercise.word.isBlank())
                assertFalse(exercise.example.isBlank())
                assertEquals(3, exercise.choices.size)
                assertEquals(3, exercise.choices.distinct().size)
                assertTrue("Answer missing for ${exercise.word}", exercise.answer in exercise.choices)
            }
        }
    }
}
